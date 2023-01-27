/**
 * accessPartnersPortlet = Branch Code releated portlet (Query Access Partner and Create Access Partner etc) 
 * This javascript file will be used for custom javascripts function written for this applicaiton.
 * 
 */
/**
 * Function to be called on page load via onContainerLoad1
 */
function onContainer1LoadsFromModule() {
	onChangePartnerType($('#cmbOrgType').val());
}

/**
 * Function to be called on onchange event of Select / Combobox
 * @param srcObjValue - select or combobox object's current value
 */
function onChangePartnerType(srcObjValue) {
	if(srcObjValue === "bank") { // show bank objects and hide biller objects
		$('#cmbBankId').show();
		$('#cmbBankId').attr('required',true);
		$('#cmbBankCodes').show();

		$('#cmbBillerId').hide();
		$('#cmbBillerId').attr('required',false);
		$('#cmbBillerCodes').hide();

		$("#callSrchEngnBtn").attr("onclick", "callSearchEngine('cmbBankId', '32c7fcd2cd9c32b19841d743dc09d56f', 'partnerKeyChange');");
		$('#txtPartnerId').val($('#cmbBankId').val());
		$('#txtMsgCode').val($('#cmbBankCodes').val());
	} else if(srcObjValue === "biller") { // show biller objects and hide bank objects
		$('#cmbBillerId').show();
		$('#cmbBillerId').attr('required',true);
		$('#cmbBillerCodes').show();

		$('#cmbBankId').hide();
		$('#cmbBankId').attr('required',false);
		$('#cmbBankCodes').hide();

		$("#callSrchEngnBtn").attr("onclick", "callSearchEngine('cmbBillerId', 'e13b5b1608ad566f94ba9fe7849aca38', 'partnerKeyChange');");
		$('#txtPartnerId').val($('#cmbBillerId').val());
		$('#txtMsgCode').val($('#cmbBillerCodes').val());
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

function msgCodeChange(srcObjValue) {
	$('#txtMsgCode').val(srcObjValue);
}

function protocolChange(srcObjValue) {
	if(srcObjValue === 'PING') {
		$('#txtPortNumber').attr('required',false);
		$('#reqMark').hide();
	} else {
		$('#txtPortNumber').attr('required',true);
		$('#reqMark').show();
	}
}