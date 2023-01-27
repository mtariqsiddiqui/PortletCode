/**
 * billersPortlet = Billers releated portlet (Query Biller and Create Biller etc) 
 * This javascript file will be used for custom javascripts function written for this applicaiton.
 * 
 */

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
	
	document.getElementById("txtPartnerId").value = srcObj.value;
}


/**
 * Function to be called on onchange event of Select / Combobox
 * 
 * @param srcObjValue -
 *            select or combobox object's current value
 */
function onChangePartnerType(srcObjValue) {
	document.getElementById("txtPartnerId").value = '';
	if (srcObjValue === "AGGREGATOR") {
		document.getElementById("txtAggregatorId").style = "display : block";
		document.getElementById("srchAggregator").style = "display : block";
		document.getElementById("txtBillerId").style = "display : none";
		document.getElementById("srchBiller").style = "display : none";
		document.getElementById("txtPartnerId").value = document.getElementById("txtAggregatorId").value; 
	} else if (srcObjValue === "BILLER") {
		document.getElementById("txtAggregatorId").style = "display : none";
		document.getElementById("srchAggregator").style = "display : none";
		document.getElementById("txtBillerId").style = "display : block";
		document.getElementById("srchBiller").style = "display : block";
		document.getElementById("txtPartnerId").value = document.getElementById("txtBillerId").value; 
	}
}

function onContainer1LoadsFromModule() {
	if($("#chkGenSettlementId").length > 0) {
		$("#chkGenSettlementId").on("click", function(e) {
			let checkbox = $(this);
			if (! checkbox.is(":checked")) { // prevent user from unchecking this checkbox
				e.preventDefault();
				return false;
			}
		});
	}
	// Query Biller / Aggregator Searching
	if(document.getElementById('txtPartnerType') !== null) {
		onChangePartnerType(document.getElementById('txtPartnerType').value)
	}
}

function customDataValidationFromModule() { 
	if($('#chkGenSettlementId').length > 0)
		if(! isValidIBANNumber($('#txtSadadAccountNumber').val())) {
			displayErrorOrMessage(_objKV['error_invalid_iban']);
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