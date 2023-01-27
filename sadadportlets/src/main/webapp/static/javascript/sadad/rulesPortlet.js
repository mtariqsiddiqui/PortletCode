/**
 * Function to be called on page load via onContainerLoad1
 */
function onContainer1LoadsFromModule() {
	makePageBusy();
	if ($('#cmbOrgType').val() !== undefined)
		onChangePartnerType($('#cmbOrgType').val());
	
	try {
		if (window.sConfig !== undefined)
			Object.keys(sConfig.attributes).forEach(function(a) { 
				$('#row_'+a).append(getAttributeLabel(a)).append(getAttributeField(a)).append(getDefaultValue(a));
			});
	} catch (error) { console.error(error);}
	
	try { // FIXME -- Don't remember the btnDeleteConfig button purpose
		if(document.getElementById('btnDeleteConfig') !== undefined && document.getElementById('btnDeleteConfig') !== null)
			document.getElementById('btnDeleteConfig').disabled = (window.pConfig === undefined);
	} catch (error) { console.error(error);}

	try {
		if (window.pConfig !== undefined)
			if (window.pConfig['identifierValues'] !== null)
				window.pConfig['identifierValues'].forEach(function(v) {
					$('#txtIdentifier').append($('<option>', {
				        value: v,
				        text : v
				    }));
				});
	} catch (error) { console.error(error);}

	try {
		// In case of SADAD-001 Configuration, there is NO pConfig > identifierValues
		if ($('#txtIdentifier > option').length === 1) {
			Object.keys(sConfig.attributes).forEach(function(k){
				if (sConfig.attributes[k].templateIdentifier) {
					sConfig.attributes[k]['possibleValues'].forEach(function(v) {
						$('#txtIdentifier').append($('<option>', {
							value: v,
							text : v
							}));
						});
				}
			});
		}
	} catch (error) { console.error(error);}
	makePageUnBusy();
}

/**
 * Function to be called on onchange event of Select / Combobox
 * 
 * @param srcObjValue -
 *            select or combobox object's current value
 */
function onChangePartnerType(srcObjValue) {
	makePageBusy();
	if (srcObjValue === "sadad") { // show SADAD objects only and hide others
		$('#txtSadadId').show();
		$('#txtSadadId').addClass('rqf');
		$('#lbl4Org').attr('for', 'txtSadadId');
		$('#cmbBankId').hide();
		$('#cmbBankId').removeClass('rqf');
		$('#cmbBillerId').hide();
		$('#cmbBillerId').removeClass('rqf');
		$('#cmbSubBillerId').hide();
		$('#cmbSubBillerId').removeClass('rqf');
        $('#cmbAggregatorId').hide();
		$('#cmbAggregatorId').removeClass('rqf');
		$('#callSrchEngnBtn').hide();
	} else if (srcObjValue === "bank") { // show bank objects and hide biller objects
		$('#txtSadadId').hide();
		$('#txtSadadId').removeClass('rqf');
		$('#cmbBankId').show();
		$('#cmbBankId').addClass('rqf');
		$('#lbl4Org').attr('for', 'cmbBankId');
		$('#cmbBillerId').hide();
		$('#cmbBillerId').removeClass('rqf');
		$('#cmbSubBillerId').hide();
		$('#cmbSubBillerId').removeClass('rqf');
        $('#cmbAggregatorId').hide();
		$('#cmbAggregatorId').removeClass('rqf');
		$("#callSrchEngnBtn").attr("onclick", "callSearchEngine('cmbBankId', '32c7fcd2cd9c32b19841d743dc09d56f', 'onChangePartnerType');");
		$('#callSrchEngnBtn').show();
		$('#txtPartnerId').val($('#cmbBankId').val());
	} else if (srcObjValue === "biller" /*|| srcObjValue === "subbiller"*/) { // show biller objects and hide bank objects
		$('#txtSadadId').hide();
		$('#txtSadadId').removeClass('rqf');
		$('#cmbBillerId').show();
		$('#cmbBillerId').addClass('rqf');
		$('#lbl4Org').attr('for', 'cmbBillerId');
		$('#cmbSubBillerId').hide();
		$('#cmbSubBillerId').removeClass('rqf');
		$('#cmbBankId').hide();
		$('#cmbBankId').removeClass('rqf');
        $('#cmbAggregatorId').hide();
		$('#cmbAggregatorId').removeClass('rqf');
		if(document.getElementById('e2ebea05a11dbbx24') === null){
			$("#callSrchEngnBtn").attr("onclick", "callSearchEngine('cmbBillerId', '76cff8fd2def7b0465d7f1979eb99cd0', 'onChangePartnerType');");
			$('#callSrchEngnBtn').show();
		}
		$('#txtPartnerId').val($('#cmbBillerId').val());
	} else if (srcObjValue === "subbiller") { // show biller objects and hide bank objects
		$('#txtSadadId').hide();
		$('#txtSadadId').removeClass('rqf');
		$('#cmbSubBillerId').show();
		$('#cmbSubBillerId').addClass('rqf');
		$('#lbl4Org').attr('for', 'cmbSubBillerId');
		$('#cmbBillerId').hide();
		$('#cmbBillerId').removeClass('rqf');
		$('#cmbBankId').hide();
		$('#cmbBankId').removeClass('rqf');
        $('#cmbAggregatorId').hide();
		$('#cmbAggregatorId').removeClass('rqf');
		$("#callSrchEngnBtn").attr("onclick", "callSearchEngine('cmbSubBillerId', 'c7993c30bbe57b9c54db07bdbb180e85', 'onChangePartnerType');");
		$('#callSrchEngnBtn').show();
		$('#txtPartnerId').val($('#cmbSubBillerId').val());
	} else if (srcObjValue === "aggregator") { // show biller objects and hide bank objects
		$('#txtSadadId').hide();
		$('#txtSadadId').removeClass('rqf');
		$('#cmbBillerId').hide();
		$('#cmbBillerId').removeClass('rqf');
		$('#cmbSubBillerId').hide();
		$('#cmbSubBillerId').removeClass('rqf');
		$('#cmbBankId').hide();
		$('#cmbBankId').removeClass('rqf');
        $('#cmbAggregatorId').show();
		$('#cmbAggregatorId').addClass('rqf');
		$('#lbl4Org').attr('for', 'cmbAggregatorId');		
		$("#callSrchEngnBtn").attr("onclick", "callSearchEngine('cmbAggregatorId', '43e028dfdaab976ddd27cc17c457542f', 'onChangePartnerType');");
		$('#callSrchEngnBtn').show();
		$('#txtPartnerId').val($('#cmbBillerId').val());
	}

	try {
	if(clearSecondContainer)
		$("#container_2").html('');
	if(! clearSecondContainer)
		clearSecondContainer = true; 
	} catch (error) {}
	makePageUnBusy();
}

/**
 * Function to be called on Partner Key update (regardless of partner type)
 * funtion will reflect the change in hidden partner key
 * 
 * @param srcObjValue -
 *            select or combobox object's current value
 */
function partnerKeyChange(srcObjValue) {
	makePageBusy();
	$('#txtPartnerId').val(srcObjValue);
	$("#container_2").html('');
	makePageUnBusy();
}

/**
 * Function to be called to set arrival and processing date before form
 * submission
 */
function setValuesForSubmission(doQueryFormSubmission) {
	if ($('#cmbBillerId.rqf').val() !== undefined)
		$('#txtPartnerId').val($('#cmbBillerId.rqf').val());
	if ($('#cmbBankId.rqf').val() !== undefined)
		$('#txtPartnerId').val($('#cmbBankId.rqf').val());
	if ($('#txtSadadId.rqf').val() !== undefined)
		$('#txtPartnerId').val('SADAD-001');
	if ($('#cmbAggregatorId.rqf').val() !== undefined)
		$('#txtPartnerId').val($('#cmbAggregatorId.rqf').val());
	if ($('#cmbSubBillerId.rqf').val() !== undefined)
		$('#txtPartnerId').val($('#cmbSubBillerId.rqf').val());

	doQueryFormSubmission("frmQueryRules");
}

/**
 * Get serveResource URL to server
 * 
 * @param pUrl - URL to Post to server
 * @param container - container to reneder the server resonse, possible values (1 or 2)
 */
function doGetUrl(pUrl, container) {
    makePageBusy();
    displayErrorOrMessage(); // clearing any previous message
    
    $.ajax({
        type: 'get',
        url: pUrl,
        cache: false,
        success: function (response, status, xhr) {
        	var ct = xhr.getResponseHeader('content-type') || '';
            if (ct.indexOf('html') > -1) {
				if(container === 1) {
					$("#container_1").html(response);
					$("#container_2").html('');
					onContainer1Loads();
				} else if(container === 2) {
					$("#container_2").html(response);
					onContainer2Loads();
				}
            } else {
            	displayErrorOrMessage(response.displayMessage, response.messageType);
				$("#container_2").html('');
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

function customDataValidationFromModule(){
	let errorMessage = _objKV['regex_initial'] + '<ul>';
	let dataValid = true;
	if(window.sConfig !== undefined){
		Object.keys(sConfig.attributes).forEach(function(aKey) {
			if(sConfig["attributes"][aKey]["validationExpression"]){
				let ptrn = new RegExp(sConfig["attributes"][aKey]["validationExpression"]);
				if(! ptrn.test($("#txt_" + aKey).val().trim())){ // Validation Failed
					errorMessage = errorMessage + '<li>' + sConfig['attributes'][aKey]['attribName'];
					errorMessage = errorMessage + _objKV[sConfig["attributes"][aKey]["validationExpression"]] + '</li>';
					dataValid = false;
				}
			}
		});
	}
	errorMessage = errorMessage + "</ul>";
	if(! dataValid)
		displayErrorOrMessage(errorMessage);
	
	return dataValid;
}

/**
 * Set values for partner configuration for create and update partner configuraiton
 * @param doQueryFormSubmission
 * @returns
 */
function setValuesForPartnerConfiguration(doQueryFormSubmission) {
	let pConfigValue = '';
	let configType = $('#txtConfigType').val();

	if(configType == 'ATTRIBUTE Based') { // ATTRIBUTE Based Form Submission
		Object.keys(sConfig.attributes).forEach(function(aKey) {
			pConfigValue = pConfigValue + sConfig['attributes'][aKey]['attribId'] + configFieldSeparator // AttributeId
				+ sConfig['attributes'][aKey]['attribName'] + configFieldSeparator // AttributeName
				+ $("#txt_" + aKey).val().trim() + configRecordSeparator; // AttributeValue
		});
		$('#param_partnerConfigValues').val(pConfigValue);
		if (window.pConfig === undefined)
			$('#txtOperation').val("callCreatePartnerConfiguration");
		else
			$('#txtOperation').val("callUpdatePartnerConfiguration");

	} else if (configType == 'TEMPLATE Based') { // TEMPLATE Based Form Submission
		// do nothing
	}
	
	doQueryFormSubmission("frmSubscribeRules", 1);
}

/**
 * Delete partner configuration for Template based configuration
 * @param doQueryFormSubmission
 * @returns
 */
function unsubscribePartnerConfiguration(doQueryFormSubmission) {
	$('#txtIdentifier').removeClass('rqf');
	doQueryFormSubmission("frmTmpltUnscribe", 1);
//	$('#txtIdentifier').addClass('rqf');
}

/**
 * 
 * @param doQueryFormSubmission
 * @returns
 */
function changeTemplateState(doQueryFormSubmission) {
	document.querySelectorAll('.rqf').forEach(function(i) {
		$('#'+i.id).removeClass('rqf');
	});
	
	doQueryFormSubmission("frmChangeRuleStatus", 1);
}

function setValueForTemplateCreation(doQueryFormSubmission) {
	let nConfigValue = '';
	Object.keys(sConfig.attributes).forEach(function(aKey) {
		if(! sConfig['attributes'][aKey]['templateIdentifier'])
			nConfigValue = nConfigValue + sConfig['attributes'][aKey]['attribId'] + configFieldSeparator // AttributeId
				+ sConfig['attributes'][aKey]['attribName'] + configFieldSeparator // AttributeName
				+ $("#txt_" + aKey).val().trim() + configRecordSeparator; // AttributeValue
	});
	$('#param_partnerConfigValues').val(nConfigValue);
	
	doQueryFormSubmission('frmNewTmplt', 1);
}

function isMandatory(attribKey) {
	if(sConfig["attributes"][attribKey]['mandatory'])
		return ' *';
	else
		return '';
}

function getAttributeLabel(attribKey) {
	let lbl = '<td valign="middle" nowrap="">'
	lbl = lbl + '<label class="label" for="txt_' + attribKey + '"';
	lbl = lbl + 'title="' + sConfig['attributes'][attribKey]['description'] + '">';
	lbl = lbl + sConfig['attributes'][attribKey]['attribName'] + isMandatory(attribKey);
	lbl = lbl + '</label></td>';
	return lbl;
}

function getAttributeField(attribKey) {
	let fld = '<td class="outputDataCell" valign="middle" nowrap="">';
	fld = fld + getAttributeTextFieldOrSelectionField(attribKey);
	fld = fld + '</td>';
	return fld;
}

function getAttributeTextFieldOrSelectionField(attribKey) {
	let fld = '';
	if(sConfig['attributes'][attribKey]['possibleValues'] !== null && sConfig['attributes'][attribKey]['possibleValues'].length > 1) { // Selection Field
		fld = '<select id="txt_'+ attribKey + '"';
		if(sConfig["attributes"][attribKey]['mandatory'])
			fld = fld + ' class="rqf"'
		fld = fld +'><option value="">Please Select</option>';
		
		sConfig['attributes'][attribKey]['possibleValues'].forEach(function(v) {
			fld = fld + '<option ';

			if(window.pConfig !== undefined) 
				if(pConfig['attributes'] !== undefined && pConfig["attributes"] !== null)
					if(pConfig['attributes'][attribKey] !== undefined)
						if(pConfig['attributes'][attribKey]['configuredValue'] == v)
							fld = fld + ' selected ';

			fld = fld + 'value="' + v + '">' + v + '</option>';
		});
		fld = fld + '</select>';
	} else { // Text Field
		fld = '<input type="text" id="txt_' + attribKey + '" ';
		if(window.pConfig !== undefined)
			if(pConfig['attributes'] !== undefined && pConfig["attributes"] !== null)
				if(pConfig['attributes'][attribKey] !== undefined)
					fld = fld + 'value="' + pConfig['attributes'][attribKey]['configuredValue'] + '" ';
		if($('#txtConfigType').val() === 'ATTRIBUTE Based')
			fld = fld + 'placeholder="' + (sConfig['attributes'][attribKey]['defaultValue'] == "null" || sConfig['attributes'][attribKey]['defaultValue'] == "N/A" ? "" : sConfig['attributes'][attribKey]['defaultValue']) + '"';
		if(sConfig["attributes"][attribKey]['mandatory'])
			fld = fld + ' class="rqf" />';
	}
	return fld;
}

function getDefaultValue(attribKey) {
	if(window.pConfig === undefined && $('#txtConfigType').val() === 'TEMPLATE Based')
		return '';
	
	let fld = '<td class="outputDataCell" style="width: 100%" valign="top" nowrap="">';
	if(sConfig["attributes"][attribKey]["defaultValue"] == "null" || sConfig["attributes"][attribKey]["defaultValue"] == null)
		fld = fld + "N/A";
	else
		fld = fld + sConfig["attributes"][attribKey]["defaultValue"];
	fld = fld + '</td>';
	return fld;
}

function setStatus(s) {
	$('#txtStatus').val(s);
}