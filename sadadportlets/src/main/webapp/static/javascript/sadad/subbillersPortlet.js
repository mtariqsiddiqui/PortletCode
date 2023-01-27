/**
 * subbillersPortlet = SubBillers portlets  
 * This javascript file will be used for custom javascript function written for this application.
 * 
 */

function onChangeOwnerKey(srcObj, pUrl) {
	makePageBusy();
//	if(srcObj.value !== "") {
		$.ajax({
			type : 'post',
			url : pUrl,
			data : { 'param_aggregatorId': srcObj.value, 'param_operation': 'setAggregatorId' },			
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
//	} else {
//		$("#container_2").html('');
//		$('#btnSearch').prop('disabled', true);
//		makePageUnBusy();
//	}
}

/**
 * Function to be called on onchange event of Select / Combobox
 * @param srcObj - select or combobox object it self
 * @param pUrl - Url to be called in ajax call
 */
function onChangePartnerKey(srcObj) {
	if(srcObj.value === "")
		$('#txtBillerStatus').prop('disabled', false);
	else
		$('#txtBillerStatus').prop('disabled', true);
}

/**
 * Customized data and format validation form module
 *   
 * @returns Boolean - True in case of valid format and data otherwise False
 */
function customDataValidationFromModule() {
	// IBAN Validation and Format Checking
	if($('#txtIbanNumber').length > 0){
		if($('#txtIbanNumber').val().length > 0){
			if(! isValidIBANNumber($('#txtIbanNumber').val())) {
				displayErrorOrMessage(_objKV['error_invalid_iban']);
				return false;
			}
		}
	}
	
/*
	// fieldValidation switch variable declaration
	let fieldValidationFailed = false;
	
	// Name Format Checking
	let errorMessage = _objKV['sadad-invalid-name'] + "<ul>";
	let hElem = document.getElementById("txtBillerNameEng");
	if(hElem !== null &&  hElem.value.trim().length > 0) {
		if(! /^[a-zA-Z0-9\W]{4,50}$/.test(hElem.value.trim())) {
			fieldValidationFailed = true;
			let lblText = document.querySelector('label[for="txtBillerNameEng"]').innerHTML.trim();
			lblText = lblText.replace('*', '').replace('*', '').trim();
			errorMessage = errorMessage + "<ol>" + lblText + "</ol>";
		}
	}
	
	hElem = document.getElementById("txtBillerNameArb");
	if(hElem !== null &&  hElem.value.trim().length > 0) {
		if(! /^[a-zA-Z0-9\W]{4,50}$/.test(hElem.value.trim())) {
			fieldValidationFailed = true;
			let lblText = document.querySelector('label[for="txtBillerNameArb"]').innerHTML.trim();
			lblText = lblText.replace('*', '').replace('*', '').trim();
			errorMessage = errorMessage + "<ol>" + lblText + "</ol>";
		}
	}
	errorMessage = errorMessage + "</ul>";
	if(fieldValidationFailed) {
		displayErrorOrMessage(errorMessage);
		return false;
	}
	
	// Hijri Date Format Checking
	errorMessage = _objKV['sadad-invalid-hijri'] + "<ul>";
	hElem = document.getElementById("txtTradeLicenseExpiry");
	if(hElem !== null &&  hElem.value.trim().length > 0) {
		if(! /^(14[0-9]{2})\/(0[1-9]|1[012])\/([0-2][1-9]|[123]0)$/.test(document.getElementById("txtTradeLicenseExpiry").value.trim())) {
			fieldValidationFailed = true;
			let lblText = document.querySelector('label[for="txtTradeLicenseExpiryDate"]').innerHTML.trim();
			lblText = lblText.replace('*', '').replace('*', '').trim();
			errorMessage = errorMessage + "<ol>" + lblText + "</ol>";
		}
	}
	errorMessage = errorMessage + "</ul>";
	if(fieldValidationFailed) {
		displayErrorOrMessage(errorMessage);
		return false;
	}
	// Address Format Checking
	errorMessage = _objKV['sadad-invalid-addr'] + "<ul>";
	hElem = document.getElementById("txtAddress");
	if(hElem !== null &&  hElem.value.trim().length > 0) {
		if(! /^[a-zA-Z0-9\W]{4,150}$/.test(document.getElementById("txtAddress").value.trim())) {
			fieldValidationFailed = true;
			let lblText = document.querySelector('label[for="txtAddress"]').innerHTML.trim();
			lblText = lblText.replace('*', '').replace('*', '').trim();
			errorMessage = errorMessage + "<ol>" + lblText + "</ol>";
		}
	}
	errorMessage = errorMessage + "</ul>";
	if(fieldValidationFailed) {
		displayErrorOrMessage(errorMessage);
		return false;
	}
	// Landline Format Checking
	errorMessage = _objKV['sadad-invalid-lln'] + "<ul>";
	hElem = document.getElementById("txtLandline");
	if(hElem !== null &&  hElem.value.trim().length > 0) {
		if(! /^(0[1-9]{2})([\d]{7})$/.test(document.getElementById("txtLandline").value.trim())) {
			fieldValidationFailed = true;
			let lblText = document.querySelector('label[for="txtLandline"]').innerHTML.trim();
			lblText = lblText.replace('*', '').replace('*', '').trim();
			errorMessage = errorMessage + "<ol>" + lblText + "</ol>";
		}
	}
	errorMessage = errorMessage + "</ul>";
	if(fieldValidationFailed) {
		displayErrorOrMessage(errorMessage);
		return false;
	}
	// Mobile Format Checking
	errorMessage = _objKV['sadad-invalid-mobile'] + "<ul>";
	hElem = document.getElementById("txtMobile");
	if(hElem !== null &&  hElem.value.trim().length > 0) {
		if(! /^(00|\+)(966[\d]{9})$/.test(document.getElementById("txtMobile").value.trim())) {
			fieldValidationFailed = true;
			let lblText = document.querySelector('label[for="txtMobile"]').innerHTML.trim();
			lblText = lblText.replace('*', '').replace('*', '').trim();
			errorMessage = errorMessage + "<ol>" + lblText + "</ol>";
		}
	}
	errorMessage = errorMessage + "</ul>";
	if(fieldValidationFailed) {
		displayErrorOrMessage(errorMessage);
		return false;
	}
	// Email Format Checking - regex validation from Standard W3C email validation regular expression
	errorMessage = _objKV['sadad-invalid-email'] + "<ul>";
	hElem = document.getElementById("txtEmail");
	if(hElem !== null &&  hElem.value.trim().length > 0) {
		if(! /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(document.getElementById("txtEmail").value.trim())) {
			fieldValidationFailed = true;
			let lblText = document.querySelector('label[for="txtEmail"]').innerHTML.trim();
			lblText = lblText.replace('*', '').replace('*', '').trim();
			errorMessage = errorMessage + "<ol>" + lblText + "</ol>";
		}
	}
	errorMessage = errorMessage + "</ul>";
	if(fieldValidationFailed) {
		displayErrorOrMessage(errorMessage);
		return false;
	}*/
	return true;
}

/**
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