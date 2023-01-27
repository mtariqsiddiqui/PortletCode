/**
 * branchCodePortlet = Branch Code releated portlet (Query Branch Code and Create Branch Code etc) 
 * This javascript file will be used for custom javascripts function written for this applicaiton.
 * 
 */

/**
 * Function to be called on onchange event of Select / Combobox
 * @param srcObj - select or combobox object it self
 * @param pUrl - Url to be called in ajax call
 */
function onChangePartnerKey(srcObj, pUrl)
{
	console.log('>> onChangePartnerKey');
	
	makePageBusy();

	$.ajax({
		type : 'post',
		url : pUrl,
		data : { 'txtPartnerKey' : srcObj.value },
		cache : false,
		success : function(response, status, xhr) 
		{
			console.log("onChangePartnerKey > ajax > success >> ");
			console.log(xhr.getResponseHeader('content-type'));
			var ct = xhr.getResponseHeader('content-type') || '';
			if (ct.indexOf('html') > -1)
			{
				$("#container_1").html(response);
				$("#container_2").html('');

				if(srcObj.value === "")
					$('#btnSearch').prop('disabled', true);
				else
					$('#btnSearch').prop('disabled', false);				
			}
			makePageUnBusy();
		},
		error : function(xhr, textStatus, errorThrown) 
		{
        	// _objKV is defined in JspIncludeStaticFiles.jspf file, getting its keys and values from Language resource bundles
        	var strErr = _objKV['sadad-generic-error'];
            displayErrorOrMessage(strErr);
			makePageUnBusy();
		}
	});
	
	console.log('<< onChangePartnerKey');
}