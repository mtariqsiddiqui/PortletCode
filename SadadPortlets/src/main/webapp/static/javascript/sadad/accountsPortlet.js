/**
 * accountsPortlet = Accounts releated portlet (Query Account, Create Account, Rejected Accounts etc) 
 * This javascript file will be used for custom javascripts function written for this applicaiton.
 * 
 */

/**
 * Called on the change of Partner list combo box 
 */
function onChangePartnerKey(obj)
{
	return;
}

function doQueryFormReset(formName)
{
	console.log("doQueryFormReset >>  " + formName);
    makePageBusy();
    $('#cmbPartnerKey').val('');
    $('#txtAccountNumber').val('');
	$("#container_2").html('');
    makePageUnBusy();
}
