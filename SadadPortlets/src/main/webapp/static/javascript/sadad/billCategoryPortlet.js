/**
 * billCategoryPortlet = Branch Code releated portlet (Query Bill Category and
 * Create Bill Category etc) This javascript file will be used for custom
 * javascripts function written for this applicaiton.
 * 
 */

/**
 * Function to be called on onchange event of Select / Combobox
 * @param srcObj - select or combobox object it self
 * @param pUrl - Url to be called in ajax call
 */
function onChangePartnerKey(srcObj, pUrl) {
	makePageBusy();
	if(srcObj.value !== "")	{
		$.ajax({
			type : 'post',
			url : pUrl,
			data : { 'param_billerId': srcObj.value, 'param_operation': 'callListBillCategory' },
			cache : false,
			success : function(response, status, xhr) {
				var ct = xhr.getResponseHeader('content-type') || '';
				if (ct.indexOf('html') > -1) {
					$("#container_1").html(response);
					$("#container_2").html('');
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
		makePageUnBusy();
	}
}