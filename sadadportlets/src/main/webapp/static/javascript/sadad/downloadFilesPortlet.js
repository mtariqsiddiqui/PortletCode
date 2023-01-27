/**
 * sendBatchFilesPortlet 
 * This javascript file will be used for custom javascripts function written for this applicaiton.
 * 
 */

/**
 * Function to be called on page load via onContainerLoad1
 */
function onContainer1LoadsFromModule() {
	onChangePartnerType($('#cmbOrgType').val());	
	$(".readonly").on('keydown paste', function(e){ e.preventDefault();	});
	$('#txtRangeFromDate').val(formatDateYMD(new Date));
}

/**
 * Function to be called on onchange event of Select / Combobox
 * @param srcObjValue - select or combobox object's current value
 */
function onChangePartnerType(srcObjValue) {
	if(srcObjValue === "bank") { // show bank objects and hide biller objects
		$('#cmbBankId').show();
		$('#cmbBankId').attr('required',true);
		
		$('#cmbBankFileType').show();
		$('#cmbBankFileType').attr('required',true);
		
		$('#cmbBillerId').hide();
		$('#cmbBillerId').attr('required',false);
		$('#cmbBillerFileType').hide();
		$('#cmbBillerFileType').attr('required',false);

		$("#callSrchEngnBtn").attr("onclick", "callSearchEngine('cmbBankId', '32c7fcd2cd9c32b19841d743dc09d56f');");
		$('#txtPartnerId').val($('#cmbBankId').val());
		$('#txtFileType').val($('#cmbBankFileType').val());
	} 
	else if(srcObjValue === "biller") { // show biller objects and hide bank objects
		$('#cmbBillerId').show();
		$('#cmbBillerId').attr('required',true);
		$('#cmbBillerFileType').show();
		$('#cmbBillerFileType').attr('required',true);
		
		$('#cmbBankId').hide();
		$('#cmbBankId').attr('required',false);
		$('#cmbBankFileType').hide();
		$('#cmbBankFileType').attr('required',false);
		
		$("#callSrchEngnBtn").attr("onclick", "callSearchEngine('cmbBillerId', 'e13b5b1608ad566f94ba9fe7849aca38');");
		$('#txtPartnerId').val($('#cmbBillerId').val());
		$('#txtFileType').val($('#cmbBillerFileType').val());
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

/**
 * Function to be called on File Type update (regardless of partner type)
 * funtion will reflect the change in hidden field carrying file type for submission.
 * @param srcObjValue - select or combobox object's current value
 */
function fileTypeChange(srcObjValue) {
	$('#txtFileType').val(srcObjValue);
	if ($('#txtFileType').val() == 'BCUTRQ'
			|| $('#txtFileType').val() == 'BKRCRQ'
			|| $('#txtFileType').val() == 'XADRRQ'
			|| $('#txtFileType').val() == 'XACRRQ') {
		$("#txtRangeToDate").val($("#txtRangeFromDate").val());
		$("#txtRangeToDate").datepicker("destroy");
	} else {
		$("#txtRangeToDate").datepicker({
			minDate : -190,
			maxDate : "0",
			dateFormat : 'yy-mm-dd',
			showOtherMonths : true,
			selectOtherMonths : true,
			changeMonth : true,
			changeYear : true,
			showWeek : true,
			firstDay : 1 });
	}
	
	if ($('#txtFileType').val() == 'PCONRQ'
		|| $('#txtFileType').val() == 'ACONRQ'
		|| $('#txtFileType').val() == 'BCONRQ'
		|| $('#txtFileType').val() == 'RCONRQ') {
		 $('#txtAsyncRquid').prop("disabled", false);
		 $('#txtFileName').prop("disabled", false);
	} else {
		 $('#txtAsyncRquid').prop("disabled", true);
		 $('#txtFileName').prop("disabled", true);
	}
}


function selectAllFiles() {
	$('input[type=checkbox][id$=chkFile_]').prop('checked', $('input[type=checkbox][id=chkSelectAll]').prop('checked'));
}


/**
 * Function to be called to set arrival and processing date before form submission
 */
function setDatesForSubmission(doQueryFormSubmission) {
	let arrivalDateFrom = new Date($('#txtArrivalFromDate').val());
	let arrivalDateTo = new Date($('#txtArrivalToDate').val());
	console.log(arrivalDateFrom, arrivalDateRange, arrivalDateTo);
	$('#txtArrivalFromDate').val(formatDateYMD(arrivalDateFrom));
	$('#txtArrivalToDate').val(formatDateYM(DarrivalDateTo));
	
	if($('#txtProcessFromDate').val().length > 0) {
		let processDateFrom = new Date($('#txtProcessFromDate').val());
		let processDateTo = new Date($('#txtProcessFromDate').val());
		let processDateRange = processDateTo.getDate() + parseInt($('#cmbProcessDateRange').val());
		processDateTo.setDate(processDateRange);

		console.log(processDateFrom, processDateRange, processDateTo);
		
		$('#txtProcessFromDate').val(formatDateYMD(processDateFrom));
		$('#txtProcessToDate').val(formatDateYMD(processDateTo));
	}

	if($('#cmbBillerId[required]').val() !== undefined)
		$('#txtPartnerId').val($('#cmbBillerId[required]').val());
	if($('#cmbBankId[required]').val() !== undefined)
		$('#txtPartnerId').val($('#cmbBankId[required]').val());

	doQueryFormSubmission("frmQueryFileByDate");
}