/**
 * paymentsPortlet = payments releated portlet (Query Payment, Create Payment, Rejected Payments etc) 
 * This javascript file will be used for custom javascripts function written for this applicaiton.
 * 
 */

function onTransactionTypeChange(v) {
	if(v === 'SPTN')
		$('#txtPaymentId').addClass('nbr');
	else
		$('#txtPaymentId').removeClass('nbr');
}