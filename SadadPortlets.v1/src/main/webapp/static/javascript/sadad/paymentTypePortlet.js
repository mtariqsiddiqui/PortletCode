/**
 * paymentTypePortlet = Branch Code releated portlet (Query Payment Type and Create Payment Type etc) 
 * This javascript file will be used for custom javascripts function written for this applicaiton.
 * 
 */

/**
 * List of all access channels
 */
var selectedChannels = [];
var allChannels = [ 'ATM', 'BTELLER', 'CAM','CCC', 'CORP', 'INTERNET', 'IVR', 'KIOSK', 'MOBILE', 'PDA', 'POS', 'SMS', 'USSD' ];


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

/**
 * 
 */
function onContainer1LoadsFromModule()
{
	fillSourceAndTargetChannels();
	showHideReversalConfiguration();
}

function onContainer2LoadsFromModule()
{
	return;
}

/**
 * Fill Source Access Channel with Access Channel array values
 */
function fillSourceAndTargetChannels() 
{
	selectedChannels.sort();
	var sChannels = allChannels.filter(x => selectedChannels.indexOf(x) < 0 );
	
	for (var i = 0; i < sChannels.length; i++) 
	{
		var opt = "<option value='" + sChannels[i] +"'>" + sChannels[i] + "</option>";
		$('#srcChannels').append(opt);
	}
	
	for (var i = 0; i < selectedChannels.length; i++) 
	{
		var opt = "<option value='" + selectedChannels[i] +"'>" + selectedChannels[i] + "</option>";
		$('#trgChannels').append(opt);
	}
}

/**
 * Push will remove the selected value from source and add them to target access channels combo box
 * @param selectedValues
 */
function pushChannel(selectedValues) {
	$.each(selectedValues, function(index, value) {
		$("#srcChannels option[value='" + value + "']").remove();
		$('#trgChannels').append($("<option/>", {
			value: value,
			text: value,
			selected: true
		}));
	});  
}

/**
 * Pop will remove the selected value from target and add them to source access channels combo box again.
 * @param selectedValues
 */
function popChannel(selectedValues) {
	$.each(selectedValues, function(index, value) {
		$("#trgChannels option[value='" + value + "']").remove();
		$('#srcChannels').append($("<option/>", {
			value: value,
			text: value
		}));
	});  
}

/**
 * Shows and hides the payment reversal related configuration fiels.
 * @returns 
 */
function showHideReversalConfiguration()
{
	makePageBusy();
	var display = 'none';
	if($('#chkCanReverse').is(':checked') === true)
		display = '';
	
	$('tr [id=optRow]').css('display', display);
	makePageUnBusy();
};

function prepareFormSubmission(btn)
{
	$('#reqAction').val(btn.value);
	$('#txtPrepaid').val($('#chkIsPrepaid').is(':checked'));
	$('#txtDefault').val($('#chkIsDefault').is(':checked'));
	$('#txtReverse').val($('#chkCanReverse').is(':checked'));
	var targetChannels = new Array();
	$('#trgChannels > option').each(function () { targetChannels.push(this.value); });
	$('#txtTargetChannels').val(targetChannels);	
};