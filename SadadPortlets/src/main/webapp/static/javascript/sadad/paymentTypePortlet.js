/**
 * paymentTypePortlet = Branch Code releated portlet (Query Payment Type and Create Payment Type etc) 
 * This javascript file will be used for custom javascripts function written for this applicaiton.
 * 
 */

/**
 * List of all access channels
 */
var selectedChannels = [];
var allChannels = [];
var allServiceTypes = [];
var selectedServiceTypes = [];

/**
 * Function to be called on onchange event of Select / Combobox
 * @param srcObj - select or combobox object it self
 * @param pUrl - Url to be called in ajax call
 */
function onChangePartnerKey(srcObj, pUrl) {
	makePageBusy();
	if(srcObj.value !== "") {
		$.ajax({
			type : 'post',
			url : pUrl,
			data : { 'param_billerId': srcObj.value, 'param_operation': 'callListPaymentType' },			
			cache : false,
			success : function(response, status, xhr) {
				var ct = xhr.getResponseHeader('content-type') || '';
				if (ct.indexOf('html') > -1) {
					$("#container_1").html(response);
					$("#container_2").html('');
					$('#btnSearch').prop('disabled', false);					
				} else {
					displayErrorOrMessage(response.displayMessage, response.messageType);
					$("#container_2").html('');
				}
				makePageUnBusy();
			},
			error : function(xhr, textStatus, errorThrown) {
	        	// _objKV is defined in JspIncludeStaticFiles.jspf file, getting its keys and values from Language resource bundles
	        	var strErr = _objKV['sadad-generic-error'];
	            displayErrorOrMessage(strErr);
				makePageUnBusy();
			}
		});
	} else {
		$("#container_2").html('');
		$('#btnSearch').prop('disabled', true);
		makePageUnBusy();
	}
}

/**
 * Customized onContainer1Loads
 */
function onContainer1LoadsFromModule() {
	fillSourceAndTargetChannels();
	fillSourceAndServiceTypes();
	showHideReversalConfiguration();
}

/**
 * Fill Source Access Channel with Access Channel array values
 */
function fillSourceAndTargetChannels() {
	selectedChannels.sort();
	var sChannels = allChannels.filter(function(x) { return selectedChannels.indexOf(x) < 0; }  );

	for (var i = 0; i < sChannels.length; i++) {
		var opt = "<option value='" + sChannels[i] +"'>" + sChannels[i] + "</option>";
		$('#srcChannels').append(opt);
	}
	
	for (var i = 0; i < selectedChannels.length; i++) {
		var opt = "<option value='" + selectedChannels[i] +"'>" + selectedChannels[i] + "</option>";
		$('#trgChannels').append(opt);
	}
}

/**
 * Push will remove the selected value from source and add them to target access channels combo box
 * @param selectedValues
 */
function pushChannel(selectedValues) {
	$.each(selectedValues, function(index, value) {
		$("#srcChannels option[value='" + value + "']").remove();
		$('#trgChannels').append($("<option/>", {
			value: value,
			text: value,
			selected: true
		}));
	});
}

/**
 * Pop will remove the selected value from target and add them to source access channels combo box again.
 * @param selectedValues
 */
function popChannel(selectedValues) {
	$.each(selectedValues, function(index, value) {
		$("#trgChannels option[value='" + value + "']").remove();
		$('#srcChannels').append($("<option/>", {
			value: value,
			text: value
		}));
	});  
}

/**
 * Fill Source and Target Service Types from Service Types array values
 */
function fillSourceAndServiceTypes() {
	selectedServiceTypes.sort();
	var sServiceTypes = allServiceTypes.filter(function(x) { return selectedServiceTypes.indexOf(x) < 0; }  );

	for (var i = 0; i < sServiceTypes.length; i++) {
		var opt = "<option value='" + sServiceTypes[i] +"'>" + sServiceTypes[i] + "</option>";
		$('#srcServiceType').append(opt);
	}
	
	for (var i = 0; i < selectedServiceTypes.length; i++) {
		var opt = "<option value='" + selectedServiceTypes[i] +"'>" + selectedServiceTypes[i] + "</option>";
		$('#trgServiceType').append(opt);
	}
}

/**
 * Push will remove the selected value from source and add them to target service type combo box
 * @param selectedValues
 */
function pushServiceType(selectedValues) {
	$.each(selectedValues, function(index, value) {
		$("#srcServiceType option[value='" + value + "']").remove();
		$('#trgServiceType').append($("<option/>", {
			value: value,
			text: value,
			selected: true
		}));
	});
}

/**
 * Pop will remove the selected value from target and add them to source service type combo box again.
 * @param selectedValues
 */
function popServiceType(selectedValues) {
	$.each(selectedValues, function(index, value) {
		$("#trgServiceType option[value='" + value + "']").remove();
		$('#srcServiceType').append($("<option/>", {
			value: value,
			text: value
		}));
	});  
}

/**
 * Shows and hides the payment reversal related configuration fiels.
 * @returns 
 */
function showHideReversalConfiguration() {
	makePageBusy();
	var display = 'none';
	if($('#chkCanReverse').is(':checked') === true)
		display = '';
		
	$("#trgChannels").prop('required',$('#chkCanReverse').is(':checked'));
	$('tr [id=optRow]').css('display', display);
	
	makePageUnBusy();
};

function prepareFormSubmission(btn) {
	$('#txtPrepaid').val($('#chkIsPrepaid').is(':checked'));
	$('#txtDefault').val($('#chkIsDefault').is(':checked'));
	$('#txtReverse').val($('#chkCanReverse').is(':checked'));
	$('#txtPostpaid').val($('#chkIsPostpaid').is(':checked'));
	var targetChannels = new Array();
	$('#trgChannels > option').each(function () { targetChannels.push(this.value); });
	$('#txtTargetChannels').val(targetChannels);
	$('#trgChannels option').prop('selected', true);
	var targetServiceTypes = new Array();
	$('#trgServiceType > option').each(function () { targetServiceTypes.push(this.value); });
	$('#txtTargetServiceTypes').val(targetServiceTypes);	
//	if($('#chkConfigIban').is(':checked') === false)
//		$('#txtPaymentTypeIBAN').removeAttr('name');
};


function customDataValidationFromModule() { 
	if($('#txtPaymentTypeIBAN').length > 0)
		if(! isValidIBANNumber($('#txtPaymentTypeIBAN').val())) {
			displayErrorOrMessage(_objKV['invalid_iban']);
			return false;
		}

	return true;
}


/*
 * https://stackoverflow.com/questions/21928083/iban-validation-check
 * 
 * Returns 1 if the IBAN is valid 
 * Returns FALSE if the IBAN's length is not as should be (for CY the IBAN Should be 28 chars long starting with CY )
 * Returns any other number (checksum) when the IBAN is invalid (check digits do not match)
 */
function isValidIBANNumber(input) {
    let CODE_LENGTHS = { SA: 24 };
    let iban = String(input).toUpperCase().replace(/[^A-Z0-9]/g, ''), // keep only alphanumeric characters
            code = iban.match(/^([A-Z]{2})(\d{2})([A-Z\d]+)$/), // match and capture (1) the country code, (2) the check digits, and (3) the rest
            digits;
    // check syntax and length
    if (!code || iban.length !== CODE_LENGTHS[code[1]]) {
        return false;
    }
    // rearrange country code and check digits, and convert chars to ints
    digits = (code[3] + code[1] + code[2]).replace(/[A-Z]/g, function (letter) {
        return letter.charCodeAt() - 55;
    });
    // final check    
    return mod97(digits) === 1;
}

function mod97(string) {
    let checksum = string.slice(0, 2), fragment;
    for (var offset = 2; offset < string.length; offset += 7) {
        fragment = String(checksum) + string.substring(offset, offset + 7);
        checksum = parseInt(fragment, 10) % 97;
    }
    return checksum;
}