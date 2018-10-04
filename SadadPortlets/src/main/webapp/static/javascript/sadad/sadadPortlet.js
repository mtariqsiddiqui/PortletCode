///**
// * sadadPortlet = SADADAdmin and SADADConfiguration portlets  
// * This javascript file will be used for custom javascripts function written for this applicaiton.
// * 
// */
//
//function doConfigFormSubmission(formName)
//{
////	doQueryFormValidation();
//	console.log("doConfigFormSubmission >>  " + formName);
//
//    $('#' + formName).submit(function (e)
//    {
//        e.preventDefault(); // avoid to execute the actual submit of the form.
//        e.stopImmediatePropagation();
//
//        makePageBusy();
//        
//        $.ajax({
//            type: $(this).attr('method'),
//            url: $(this).attr('action'),
//            data: $(this).serialize(),
//            cache: false,
//            success: function (response, status, xhr)
//            {
//            	console.log("doConfigFormSubmission > ajax > success >> ");
//
//            	console.log(xhr.getResponseHeader('content-type'));
//                var ct = xhr.getResponseHeader('content-type') || '';
//                if (ct.indexOf('html') > -1)
//                {
//                	console.log("html found ");
//
////                    $("#summaryContainer").html(response);
//                }
//                makePageUnBusy();
//            },
//            error: function (xhr, textStatus, errorThrown)
//            {
//            	// _objKV is defined in _serverJS.jsp file, getting its keys and values from Language resource bundles
//            	var strErr = '<strong>Error!</strong> Error occured while submitting...' ;
//                displayErrorOrMessage(strErr, 'danger');
//                makePageUnBusy();
//            }
//        });
//    });
//}