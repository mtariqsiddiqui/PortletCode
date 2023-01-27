/**
 * regenerateBatchFilesPortlet 
 * This javascript file will be used for custom javascripts function written for this applicaiton.
 * 
 */

/**
 * Function to be called on page load via onContainerLoad1
 */
function onContainer1LoadsFromModule() {
	onChangePartnerType($('#cmbOrgType').val());	
	$(".readonly").on('keydown paste', function(e){ e.preventDefault();	});	
	if($('#txtRangeFromDate').val().trim().length === 0)
		$('#txtRangeFromDate').val(formatDateYMD(new Date()));
}

/**
 * Function to be called on onchange event of Select / Combobox
 * @param srcObjValue - select or combobox object's current value
 */
function onChangePartnerType(srcObjValue){
	if(srcObjValue === "bank") { // show bank objects and hide biller objects
		$('#cmbBankId').show();
		$('#cmbBankId').attr('required',true);
		
		$('#cmbBankFileType').show();
		$('#cmbBankFileType').attr('required',true);
		
		$('#cmbBillerId').hide();
		$('#cmbBillerId').attr('required',false);
		$('#cmbBillerFileType').hide();
		$('#cmbBillerFileType').attr('required',false);
		
		$("#callSrchEngnBtn").attr("onclick", "callSearchEngine('cmbBankId', '32c7fcd2cd9c32b19841d743dc09d56f');");		
		$('#txtPartnerId').val($('#cmbBankId').val());
		$('#txtFileType').val($('#cmbBankFileType').val());
	} 
	else if(srcObjValue === "biller") { // show biller objects and hide bank objects
		$('#cmbBillerId').show();
		$('#cmbBillerId').attr('required',true);
		$('#cmbBillerFileType').show();
		$('#cmbBillerFileType').attr('required',true);
		
		$('#cmbBankId').hide();
		$('#cmbBankId').attr('required',false);
		$('#cmbBankFileType').hide();
		$('#cmbBankFileType').attr('required',false);
		
		$("#callSrchEngnBtn").attr("onclick", "callSearchEngine('cmbBillerId', 'e13b5b1608ad566f94ba9fe7849aca38');");
		$('#txtPartnerId').val($('#cmbBillerId').val());
		$('#txtFileType').val($('#cmbBillerFileType').val());
	}
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
	if ($('#txtFileType').val() == 'BCUTRQ'
		|| $('#txtFileType').val() == 'RCUTRQ'
			|| $('#txtFileType').val() == 'BKRRRQ'
			|| $('#txtFileType').val() == 'BKRCRQ'
			|| $('#txtFileType').val() == 'BLRCRQ'
			|| $('#txtFileType').val() == 'BSPLRQ'
			|| $('#txtFileType').val() == 'BLRRRQ'
			|| $('#txtFileType').val() == 'XADRRQ'
			|| $('#txtFileType').val() == 'XACRRQ'
			|| $('#txtFileType').val() == 'XADDRQ') {
		$("#txtRangeToDate").val($("#txtRangeFromDate").val());
		$("#txtRangeToDate").datepicker("destroy");
	} else {
		$("#txtRangeToDate").datepicker({
			minDate : -190,
			maxDate : "0",
			dateFormat : 'yy-mm-dd',
			showOtherMonths : true,
			selectOtherMonths : true,
			changeMonth : true,
			changeYear : true,
			showWeek : true,
			firstDay : 1 });
	}
	
	if ($('#txtFileType').val() == 'ACONRQ'
		|| $('#txtFileType').val() == 'BCONRQ'
		|| $('#txtFileType').val() == 'PCONRQ'
		|| $('#txtFileType').val() == 'RCONRQ') {
		 $('#txtAsyncRquid').prop("readonly", false);
		 $('#txtFileName').prop("readonly", false);
	} else {
		 $('#txtAsyncRquid').prop("readonly", true);
		 $('#txtFileName').prop("readonly", true);
	}
}

function updateDateSelection() {
	if($('#cmbBillerId[required]').val() !== undefined)
		fileTypeChange($('#cmbBillerFileType').val());
	if($('#cmbBankId[required]').val() !== undefined)
		fileTypeChange($('#cmbBankFileType').val());
}

function selectAllFiles() {
	$('input[type=checkbox][id$=chkFile_]').prop('checked', $('input[type=checkbox][id=chkSelectAll]').prop('checked'));
}

/**
 * Function to be called to set arrival and processing date before form submission
 */
function setDatesForSubmission(doQueryFormSubmission) {	
	let dateRangeFrom = new Date($('#txtRangeFromDate').val());
	let dateRangeTo = new Date($('#txtRangeToDate').val());
	
	$('#txtDateRangeFrom').val(formatDateYMD(dateRangeFrom));
	$('#txtDateRangeTo').val(formatDateYMD(dateRangeTo));
	
	if(dateRangeFrom > dateRangeTo) {
		dateRangeTo = dateRangeFrom;
		$('#txtRangeToDate').val(formatDateYMD(dateRangeTo));
	}

	if($('#cmbBillerId[required]').val() !== undefined)
		$('#txtPartnerId').val($('#cmbBillerId[required]').val());
	if($('#cmbBankId[required]').val() !== undefined)
		$('#txtPartnerId').val($('#cmbBankId[required]').val());

	doQueryFormSubmission("frmSendBatchFile");
}

/**
 * Post serveResource URL to server to get associated file details
 * 
 * @param pUrl - URL to Post to server
 */
function regenerateBatchFile(pUrl) {
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
            	};
            } else {
            	console.log(response);
            }
            makePageUnBusy();
        },
        error: function (xhr, textStatus, errorThrown){
        	// _objKV is defined in JspIncludeStaticFiles.jspf file, getting its keys and values from Language resource bundles
        	var strErr = _objKV['sadad-generic-error'];
            displayErrorOrMessage(strErr);
            makePageUnBusy();
        }
    });	
}