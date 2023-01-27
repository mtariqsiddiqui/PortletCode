/**
 * ibanPortlet = IBAN releated portlet (Approve IBAN, Query IBAN, Create IBAN, Rejected IBAN etc) 
 * This javascript file will be used for custom javascripts function written for this applicaiton.
 * 
 */

var txtFromDate, txtToDate;

function onContainer1LoadsFromModule() {
	if($('#hdnPageId').val() == 'CREATE_FORM') {
		if($('#txtSettlementId').val().length > 0)
			$('#spnCrtScs').show();
		else
			$('#spnCrtScs').hide();
	}

	$('input[type=text][id$=Date]').datepicker("destroy"); 

	txtFromDate = $('#txtFromDate').datepicker({
		minDate : "-5Y",
		maxDate : "0",
		dateFormat: 'yy-mm-dd',
		showOtherMonths : true,
		selectOtherMonths : true,
		changeMonth : true,
		changeYear : true,
		showWeek : true,
		firstDay : 1,
		onSelect: function( dateText, instance ){
			let _2dt = new Date(dateText);
			let _mx2dt = new Date(dateText);
			let _today = new Date();
			txtToDate.datepicker('option', 'minDate', _2dt);
			_mx2dt = new Date(_mx2dt.setMonth(_mx2dt.getMonth()+6));
			if(_mx2dt > _today)
				txtToDate.datepicker('option', 'maxDate', _today);
			else
				txtToDate.datepicker('option', 'maxDate', _mx2dt);

			if(txtToDate.val().length == 0)
				txtToDate.val(txtFromDate.val());
	    }
	});
	
	txtToDate = $('#txtToDate').datepicker({
		maxDate : "0",
		dateFormat: 'yy-mm-dd',
		showOtherMonths : true,
		selectOtherMonths : true,
		changeMonth : true,
		changeYear : true,
		showWeek : true,
		firstDay : 1,
		onSelect: function( dateText, instance ){
			if(txtFromDate.val().length == 0)
				txtFromDate.val(txtToDate.val());
	    }
	});
}

function createIban(doQueryFormSubmission) {
	$('#txtIban').val($('#txtIban').val().toUpperCase());
	doQueryFormSubmission("frmCreateIban", 1);
	if($('#txtSettlementId').val().length > 0)
		$('#btnSave').prop("disabled",true);
	else
		$('#btnSave').prop("disabled",false);
}

function updateIban(doQueryFormSubmission) {
	$('#txtCustomerTypeId').val($('#cmbCustomerType').val()+$('#txtCustomerId').val());
	$('#txtIban').val($('#txtIban').val().toUpperCase());
	doQueryFormSubmission("frmUpdateIban", 1);
}

function setupOptionalQueryIbanFields() {	
	if($('#cmbCustomerIdType').val().trim().length > 0 && $('#txtCustomerId').val().trim().length === 0) {
		document.getElementById('txtCustomerId').setAttribute('class', 'rqf');
	} else {
		document.getElementById('txtCustomerId').removeAttribute('class');
	}
	
	if($('#cmbCustomerIdType').val().trim().length === 0 && $('#txtCustomerId').val().trim().length > 0) {
		document.getElementById('cmbCustomerIdType').setAttribute('class', 'rqf');
	} else {
		document.getElementById('cmbCustomerIdType').removeAttribute('class');
	}
}

function customDataValidationFromModule() { 
	if($('#txtIban').length > 0){
		if($('#txtIban').val().length > 0){
			if(! isValidIBANNumber($('#txtIban').val())) {
				displayErrorOrMessage(_objKV['error_invalid_iban']);
				return false;
			}
		}
	}
	
	if($('#hdnPageId').val() == 'CREATE_FORM' || $('#hdnPageId').val() == 'UPDATE_FORM' || $('#hdnPageId').val() == 'QUERY_FORM') {
		if( ($('#cmbCustomerIdType').val() == 'NAT' || $('#cmbCustomerIdType').val() == 'IQA') && $('#txtCustomerId').val().length != 10 ) {
			displayErrorOrMessage(_objKV['error_length_10']);
			return false;
		}
		if($('#cmbCustomerIdType').val() == 'NAT') {
			if (! $('#txtCustomerId').val().startsWith('1')) {
				displayErrorOrMessage(_objKV['error_NAT_1']);
				return false;
			}
		} else if($('#cmbCustomerIdType').val() == 'IQA') {
			if (! $('#txtCustomerId').val().startsWith('2')) {
				displayErrorOrMessage(_objKV['error_IQA_2']);
				return false;
			}
		}		
	} else if ($('#hdnPageId').val() == 'QUERY_FORM') {
		if($('#txtIban').val().trim().length === 0 && 
			$('#txtSettlementId').val().trim().length === 0 && 
			$('#txtFromDate').val().trim().length === 0 && 
			$('#txtToDate').val().trim().length === 0 && 
			$('#cmbIbanStatus').val().trim().length === 0) {
				return false;
		} else {
			document.getElementById('txtIban').removeAttribute('class');
			document.getElementById('txtSettlementId').removeAttribute('class');
			document.getElementById('txtFromDate').removeAttribute('class');
			document.getElementById('txtToDate').removeAttribute('class');
			document.getElementById('cmbIbanStatus').removeAttribute('class');
		}
	}
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