/**
 * filesPortlet = Files releated portlet (Query File and Download Files etc) 
 * This javascript file will be used for custom javascripts function written for this applicaiton.
 * 
 */

/**
 * Function to be called on page load via onContainerLoad1
 */
function onContainer1LoadsFromModule() {
	$('#filesTable').hide();
	onChangePartnerType($('#cmbOrgType').val());
}

/**
 * Function to be called on onchange event of Select / Combobox
 * @param srcObjValue - select or combobox object's current value
 */
function onChangePartnerType(srcObjValue) {
	if(srcObjValue === "bank") { // show bank objects and hide biller objects
		$('#cmbBankId').show();
		$('#cmbBankId').addClass('rqf');
		$('#lbl4Org').attr('for', 'cmbBankId');
		$('#cmbBankFileType').show();
		$('#cmbBankFileType').addClass('rqf');
		$('#lbl4FileType').attr('for', 'cmbBankFileType');

		$('#cmbBillerId').hide();
		$('#cmbBillerId').removeClass('rqf');
		$('#cmbBillerFileType').hide();
		$('#cmbBillerFileType').removeClass('rqf');

		$("#callSrchEngnBtn").attr("onclick", "callSearchEngine('cmbBankId', '32c7fcd2cd9c32b19841d743dc09d56f');");
		$('#txtPartnerId').val($('#cmbBankId').val());
		$('#txtFileType').val($('#cmbBankFileType').val());
	} else if(srcObjValue === "aggregator" || srcObjValue === "biller") { // show biller objects and hide bank objects
		$('#cmbBillerId').show();
		$('#cmbBillerId').addClass('rqf');
		$('#lbl4Org').attr('for', 'cmbBillerId');
		$('#cmbBillerFileType').show();
		$('#cmbBillerFileType').addClass('rqf');
		$('#lbl4FileType').attr('for', 'cmbBillerFileType');

		$('#cmbBankId').hide();
		$('#cmbBankId').removeClass('rqf');
		$('#cmbBankFileType').hide();
		$('#cmbBankFileType').removeClass('rqf');
		
		$("#callSrchEngnBtn").attr("onclick", "callSearchEngine('cmbBillerId', 'e13b5b1608ad566f94ba9fe7849aca38');");
		if(srcObjValue === "aggregator")
			$("#callSrchEngnBtn").attr("onclick", "callSearchEngine('cmbBillerId'," +  'a5e383e5e7a87a6844dd02fa04944c35&q1='+_objKV['AGGREGATOR_HASHED_KEY'] + ");");
		$('#txtPartnerId').val($('#cmbBillerId').val());
		$('#txtFileType').val($('#cmbBillerFileType').val());
	}
}

/**
 * Function to be called to set arrival and processing date before form submission
 */
function submitFileSearchByRQUID(doQueryFormSubmission) {
	if($('#cmbBillerId.rqf').val() !== undefined)
		$('#txtPartnerId').val($('#cmbBillerId.rqf').val());
	if($('#cmbBankId.rqf').val() !== undefined)
		$('#txtPartnerId').val($('#cmbBankId.rqf').val());

	doQueryFormSubmission("frmQueryFileByRQUID");
}

/**
 * Function to be called to set arrival and processing date before form submission
 */
function submitFileSearchByDate(doQueryFormSubmission) {
	if($('#cmbBillerId.rqf').val() !== undefined)
		$('#txtPartnerId').val($('#cmbBillerId.rqf').val());
	if($('#cmbBankId.rqf').val() !== undefined)
		$('#txtPartnerId').val($('#cmbBankId.rqf').val());

	doQueryFormSubmission("frmQueryFileByDate");
}


/**
 * Function to be called on Partner Key update (regardless of partner type)
 * funtion will reflect the change in hidden partner key
 * @param srcObjValue - select or combobox object's current value
 */
function partnerKeyChange(srcObjValue) {
	$('#txtPartnerId').val(srcObjValue);
}

/**
 * Function to be called on File Type update (regardless of partner type)
 * funtion will reflect the change in hidden field carrying file type for submission.
 * @param srcObjValue - select or combobox object's current value
 */
function fileTypeChange(srcObjValue) {
	$('#txtFileType').val(srcObjValue);
}


/**
 * Download file from the server
 */
function fileDownload(fileDownloadUrl) {
	displayErrorOrMessage();
//	let url = _objKV['FILE_DOWNLOAD_URL'] + fileDownloadUrl;
	$.ajax({
		type: 'HEAD',
		url: fileDownloadUrl, 
		cache: false,
		success: function (response, status, xhr) {
			const dlnk = document.createElement('a');
			dlnk.style.display = 'none';
			let fileName = fileDownloadUrl.substring(fileDownloadUrl.lastIndexOf('/')+1, fileDownloadUrl.lastIndexOf('?'))
			dlnk.download = fileName;
			dlnk.href = fileDownloadUrl;
			document.body.appendChild(dlnk);
			dlnk.click();
			document.body.removeChild(dlnk);
		},
		error: function (xhr, textStatus, errorThrown){
			displayErrorOrMessage(_objKV['error_file_archive']);
		},
	});
}

/**
 * Post serveResource URL to server to get associated file details
 * 
 * @param pUrl - URL to Post to server
 */
function getAssociatedFileDetails(pUrl) {
    makePageBusy();
    displayErrorOrMessage(); // clearing any previous message
    
    $.ajax({
        type: 'post',
        url: pUrl,
        cache: false,
        success: function (response, status, xhr) {
        	var ct = xhr.getResponseHeader('content-type') || '';
            if (ct.indexOf('html') > -1) {
            	if(response.substring(0, 41).indexOf('LOGIN_PAGE_RENDER') > -1) { // Session Timeout
            		window.location.reload();
            		return;
            	}
            } else {
            	$('#response_rquid').html(response.rquid);
            	$('#response_fileStatus').html(response.fileStatus);
            	$('#response_fileSize').html(response.fileSize);
            	$('#response_fileName').html(response.fileName);
            	$('#response_fileName').html(response.fileName);
            	$('#response_fileArrivalDate').html(response.fileArrivalDate);
            	$('#response_fileProcessedDate').html(response.fileProcessedDate);
            }
            makePageUnBusy();
        }, 
        error: function (xhr, textStatus, errorThrown) {
        	// _objKV is defined in JspIncludeStaticFiles.jspf file, getting its keys and values from Language resource bundles
        	var strErr = _objKV['sadad-generic-error'];
            displayErrorOrMessage(strErr);
			$("#container_2").html('');
            makePageUnBusy();
        }
    });	
}

/**
 * The global array variable, used for deleted or already uploaded files
 * ignored_files variable check in the upload loop, and if index is present in ignored_files then
 * file is not uploaded, which means either the file is deleted by user or uploaded as single file. 
 */

var upload_files = [];

function deleteFile(index, fileName) {
	makePageBusy();
	$('#tr_'+index).remove();
	makePageUnBusy();
	upload_files = upload_files.filter(function(elem, _index){
		return elem.name !== fileName;
	});
}

/**
 * Function to be called on onchange event of Input File
 * @param element - htlm file input element it self
 */
function prepareUpload(element) {
	makePageBusy();
	displayErrorOrMessage(); // clearing any previous message
	upload_files = Array.from(element.files);
	var htm = '';
	for (var i = 0, f; f = upload_files[i] ; i++) {
		if(i+1 > _objKV['MAX_FILES_UPLOAD']) {
			displayErrorOrMessage(_objKV['max_file_error']);
			break;
		}
			
		let fName = f.name.replace(/ /g, "_").replace(/\./g, '_');
		htm = htm + '<tr id="tr_'+i+'">';
		htm = htm + '<td style="width: 20%; vertical-align: middle; text-align: left;">' + f.name + '</td>';
		htm = htm + '<td style="width: 10%; vertical-align: middle; text-align: right;">' + f.size + '</td>';
		htm = htm + '<td style="width: 55%; vertical-align: middle; text-align: left;" id="status_' + fName  
					+ '">Pending Upload... <progress id="prgs_' + fName + '" value="0" max="100"/></td>';
		htm = htm + '<td style="width: 10%; vertical-align: middle; text-align: center;"><span id="btns_'+i+'"><input class="button" type="button" value="'+_objKV.upload_label+'" onclick="doFileUploadSubmission('+i+',\''+f.name+'\');"/><br>';
		htm = htm + '<input class="button" type="button" value="'+_objKV.delete_label+'" onclick="deleteFile('+i+',\''+f.name+'\')"/></span></td></tr>';
	}
	document.getElementById('tbody2B_append').innerHTML = htm;
	$('#filesTable').show();
	$('#btnUploadAll').attr('disabled', false);
	makePageUnBusy();
}

/**
 * Upload file to the server
 * @param - index to be uploaded, leave blank for all or pass -1 for all 
 *
 */
function doFileUploadSubmission(index, fileName) {	
	if($('#cmbBillerId.rqf').val() !== undefined)
		$('#txtPartnerId').val($('#cmbBillerId.rqf').val());
	if($('#cmbBankId.rqf').val() !== undefined)
		$('#txtPartnerId').val($('#cmbBankId.rqf').val());

	var url = _objKV['FILE_UPLOAD_URL']; // reading value from Portlet Preference and setting it in _objKV
	var fileSizeMB = _objKV['MAX_FILE_SIZE'];
	var partnerId = $('#txtPartnerId').val();
	var fileCategory = $('#txtFileType').val();
	
	displayErrorOrMessage(); // clearing any previous message
	
	if (! isDataValid()) { return }
	
	// Simple Client Side Validation
	if(typeof url === "undefined" || typeof partnerId === "undefined" || typeof fileCategory === "undefined") {
		displayErrorOrMessage(_objKV['sadad-missing-data-error']);
		return;
	}

	if(typeof partnerId === "string" || typeof fileCategory === "string") {
		if(partnerId.trim().length === 0 || fileCategory.trim().length === 0 || document.getElementById('txtFiles').files.length === 0 ) {
			displayErrorOrMessage(_objKV['sadad-missing-data-error']);
			return;
		}
	}

	// file and i are variables defined for controlling the for loop
	let file;
	let i = 0;
	// if index is -1 or undefined then i=0 otherwise i=index
	if(typeof index === "undefined" || index === -1) {
		index = -1;
		$('#filesTable span[id^="btns_"]').remove();
	} else if (index >= 0) // recalculating index because of deletion
		i = upload_files.findIndex(function (elem) {
			  return elem.name === fileName;
			});
	
	for (i, file; file = upload_files[i]; ++i) {
		let status_i = '#status_' + file.name.replace(/ /g, "_").replace(/\./g, '_');
		let prgs_i = '#prgs_' + file.name.replace(/ /g, "_").replace(/\./g, '_');

		if ((/\.(xml|gz)$/i).test(file.name) && (file.size <= (fileSizeMB * 1024 * 1024))) {
			let _headers = {
					'PartnerId': partnerId,
					'FileCategory': fileCategory,
					'Content-Type': 'text/xml'
			};
			
			if ((/\.(gz)$/i).test(file.name))
				_headers['Content-Encoding'] = 'gzip';
			else
				delete _headers['Content-Encoding'];

			let reader = new FileReader();
			reader.readAsText(file, 'UTF-8');
			reader.onload = function() {
				$.ajax({
					 xhr : function() {
						var xhr = new window.XMLHttpRequest();
						// Upload progress
						xhr.upload.addEventListener("progress", function(evt) {
							if (evt.lengthComputable) {
								let percentComplete = Math.round((evt.loaded / evt.total) * 100);
								$(prgs_i).val(percentComplete);
							};
						}, false);
						return xhr;
					},
					type: 'post',
					url: url, 
					headers: _headers,
					data: reader.result,
					cache: false,
					processData: false,
					success: function (response, status, xhr) {
						var ct = xhr.getResponseHeader('content-type') || '';
						if (ct.indexOf('xml') > -1) {
							$(status_i).html(_objKV['sadad-file-upload-success']);
						};
						upload_files = upload_files.filter(function(elem, _index) {
							return elem.name !== fileName;
						});
					},
					error: function (xhr, textStatus, errorThrown) {
						var res = xhr.responseText;
						if(res.length > 0) {
							strErr = res.substring(res.indexOf("<StatusCode>") + 12, res.indexOf("</StatusCode>")) +
								' - ' + res.substring(res.indexOf("<ShortDesc>") + 11, res.indexOf("</ShortDesc>"));
							$(status_i).html(_objKV['sadad-file-upload-failed'] + strErr);
						}
						displayErrorOrMessage(_objKV['error_while_upload']);
						upload_files = upload_files.filter(function(elem, _index){
							return elem.name !== fileName;
						});
					}
				});
			}
		} else {
			if (! (/\.(xml|gz)$/i).test(file.name))
				$(status_i).html(_objKV['sadad-file-not-supported']);

			if (file.size > (fileSizeMB * 1024 * 1024))
				$(status_i).html(_objKV['sadad-file-size-error']);
		};
		
		$('#btns_'+index).remove();

		if(index !== -1)
			break;
		else
			$('#btnUploadAll').attr('disabled', true);
	}
};

function switchQueryForms(pUrl, container){
	let jParams = {};
	jParams['param_orgType'] = document.getElementById('cmbOrgType').value;
	jParams['param_orgId'] = document.getElementById('txtPartnerId').value;
	jParams['param_fileType'] = document.getElementById('txtFileType').value;
	doPostUrl(pUrl, container, jParams);
}