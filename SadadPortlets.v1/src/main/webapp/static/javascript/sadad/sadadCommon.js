/**
 * init() function call from Theme on every page.
 */
function init()
{
    initStringFunctions(); // for IE
}

/**
 * This function works as polyfills for IE String startsWith and endsWith function.
 */
function initStringFunctions()
{
    // IE doesn't have trim / startsWith / endsWith function
    if (!String.prototype.startsWith) {
        String.prototype.startsWith = function (searchString, position) {
            position = position || 0;
            return this.indexOf(searchString, position) === position;
        };
    }
    if (!String.prototype.endsWith) {
        String.prototype.endsWith = function (pattern) {
            var d = this.length - pattern.length;
            return d >= 0 && this.lastIndexOf(pattern) === d;
        };
    }
    if (!String.prototype.trim) {
        String.prototype.trim = function () {
            return this.replace(/^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g, '');
        };
    }
}

/**
 * Display Ajax loader gif (in-progress) image in Modal
 */
function makePageBusy()
{
    $('#ajaxLoader').fadeIn(250);
}

/**
 * Hides Ajax loader gif (in-progress) image
 */
function makePageUnBusy()
{
  $('#ajaxLoader').fadeOut(250);
}

/**
 * Display or Clear error or success messages on page (#msgContainer)
 * 
 * @param txt - message to display (optional if undefined then any previous message will be cleared)
 * @param cls - CSS class (optional if undefined then ERROR class will be applied)
 */
function displayErrorOrMessage(txt, cls)
{
	if(typeof txt === "undefined")
	{
		$('#msgContainer').html('');
		$('#msgContainer').removeClass();
	}
	else
	{
		$('#msgContainer').html(txt);
		$('#msgContainer').removeClass();
		if(typeof cls === "undefined")
			$('#msgContainer').addClass('ERROR_Message');
		else
			$('#msgContainer').addClass(cls+'_Message');
	}
}

/**
 * Submits the form to the server
 * 
 * @param formName
 * @param responseContainer - number if provided response will be rendered in to that specific container, otherwise container_2 is default
 * @param applyFilter - boolean if provided applies filter on detail table
 * @param filterValue - string if provided detail table will be filtered with this value
 */
function doQueryFormSubmission(formName, responseContainer, applyFilter, filterValue)
{
//	doQueryFormValidation();
	console.log("doQueryFormSubmission >>  " + formName, responseContainer, applyFilter, filterValue);

	$('#' + formName).submit(function (e)
    {
        e.preventDefault(); // avoid to execute the actual submit of the form.
        e.stopImmediatePropagation();

        makePageBusy();
        displayErrorOrMessage();

        $.ajax({
            type: $(this).attr('method'),
            url: $(this).attr('action'),
            data: $(this).serialize(),
            cache: false,
            success: function (response, status, xhr)
            {
                var ct = xhr.getResponseHeader('content-type') || '';
                if (ct.indexOf('html') > -1)
                {
                	if(typeof responseContainer === "undefined" || responseContainer === 2)
                	{
                		$("#container_2").html(response);
                		onContainer2Loads(applyFilter, filterValue);
                	}
                	else if(typeof responseContainer === "number")
                	{
                		if(responseContainer === 1)
                		{
                    		$("#container_1").html(response);
        					$("#container_2").html('');
        					onContainer1Loads();
                		}
                	}
                }
                else
                {
                	displayErrorOrMessage(response.displayMessage, response.messageType);
                }
                makePageUnBusy();
            },
            error: function (xhr, textStatus, errorThrown)
            {
            	// _objKV is defined in JspIncludeStaticFiles.jspf file, getting its keys and values from Language resource bundles
            	var strErr = _objKV['sadad-generic-error'];
                displayErrorOrMessage(strErr);
                makePageUnBusy();
            }
        });
    });
}

/**
 * Post serveResource URL to server
 * 
 * @param pUrl - URL to Post to server
 * @param container - container to reneder the server resonse, possible values (1 or 2)
 */
function doPostUrl(pUrl, container)
{
	console.log("doPostUrl >>  " + pUrl);

    makePageBusy();
    displayErrorOrMessage();
    
    $.ajax({
        type: 'post',
        url: pUrl,
        cache: false,
        success: function (response, status, xhr)
        {
        	console.log("displayAccountDetails > ajax > success >> ");
            var ct = xhr.getResponseHeader('content-type') || '';
            if (ct.indexOf('html') > -1)
            {
				if(container === 1)
				{
					$("#container_1").html(response);
					$("#container_2").html('');
					onContainer1Loads();
				}
				else if(container === 2)
				{						
					$("#container_2").html(response);
					onContainer2Loads();
				}
            }
            else
            {
            	displayErrorOrMessage(response.displayMessage, response.messageType);
            }
            makePageUnBusy();
        },
        error: function (xhr, textStatus, errorThrown)
        {
        	// _objKV is defined in JspIncludeStaticFiles.jspf file, getting its keys and values from Language resource bundles
        	var strErr = _objKV['sadad-generic-error'];
            displayErrorOrMessage(strErr);
            makePageUnBusy();
        }
    });	
}

/**
 * Executes after every container 1 loads
 */
function onContainer1Loads()
 {
	$('input[type=text][name$=Date]').datepicker({
		minDate : -190,
		maxDate : "0",
		showOtherMonths : true,
		selectOtherMonths : true,
		changeMonth : true,
		changeYear : true,
		showWeek : true,
		firstDay : 1
	});
	
	if (typeof onContainer1LoadsFromModule === "function") { 
		onContainer1LoadsFromModule();
	}
}

/**
 * Executes after every container 2 loads
 * 
 * @param applyFilter - boolean if true DataTable values will be filtered
 * @param filterValue - string if provided DataTable will be filtered with this value
 */
function onContainer2Loads(applyFilter, filterValue)
{
	$('#detailTable').DataTable({
		dom : 'lfrtBip',
		buttons : [ 'copy', 'csv', 'excel', 'pdf', 'print' ]
	});
	
	if(typeof applyFilter === "boolean" && typeof filterValue !== "undefined")
		if(applyFilter === true)
			$('#detailTable').DataTable().search(filterValue).draw();
	
	if (typeof onContainer2LoadsFromModule === "function") { 
		onContainer2LoadsFromModule();
	}
}

/**
 * Calls Portlet Action URL
 * 
 * @param srcObj - HTML Input type element, usually button with name "back" or "finish".
 */
function navigate(srcObj)
{
	makePageBusy();
	$('#fpWhereTo').val(srcObj.name);
}