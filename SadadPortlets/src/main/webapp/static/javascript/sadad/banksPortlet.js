/**
 * banksPortlet = Banks releated portlet (Query Bank and Create Bank etc) 
 * This javascript file will be used for custom javascripts function written for this applicaiton.
 * 
 */

/**
 * Function to be called on onchange event of Select / Combobox
 * @param srcObj - select or combobox object it self
 * @param pUrl - Url to be called in ajax call
 */
function onChangePartnerKey(srcObj) 
{
	console.log('>> onChangePartnerKey');

	if(srcObj.value === "")
		$('#txtBankStatus').prop('disabled', false);
	else
		$('#txtBankStatus').prop('disabled', true);			

	console.log('<< onChangePartnerKey');
}

/**
 * 
 */
function onContainer1LoadsFromModule()
{ return; }

function onContainer2LoadsFromModule()
{ return; }