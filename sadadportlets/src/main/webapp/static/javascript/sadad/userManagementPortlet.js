/**
 * Function to be called on page load via onContainerLoad1
 */
function onContainer1LoadsFromModule() {
	makePageBusy();
	if ($('#cmbOrgType').val() !== undefined)
		onChangePartnerType($('#cmbOrgType').val());

	if ($('#hdnAssignableGroups').val() !== undefined)
		markCheckedForAssignedGroups();
	makePageUnBusy();
}

/**
 * Function to be called on onchange event of Select / Combobox
 * 
 * @param srcObjValue -
 *            select or combobox object's current value
 */
function onChangePartnerType(srcObjValue) {
	if (srcObjValue === "sadad") { // show sadad objects only and hide others
		$('#txtSadadId').show();
		$('#txtSadadId').addClass('rqf');
		$('#lbl4Org').attr('for', 'txtSadadId');
		$('#cmbBankId').hide();
		$('#cmbBankId').removeClass('rqf');
		$('#cmbBillerId').hide();
		$('#cmbBillerId').removeClass('rqf');
        $('#cmbAggregatorId').hide();
		$('#cmbAggregatorId').removeClass('rqf');
		$('#callSrchEngnBtn').hide();
	} else if (srcObjValue === "bank") { // show bank objects and hide biller objects
		$('#txtSadadId').hide();
		$('#txtSadadId').removeClass('rqf');
		$('#cmbBankId').show();
		$('#cmbBankId').addClass('rqf');
		$('#lbl4Org').attr('for', 'cmbBankId');
		$('#cmbBillerId').hide();
		$('#cmbBillerId').removeClass('rqf');
        $('#cmbAggregatorId').hide();
		$('#cmbAggregatorId').removeClass('rqf');
		$("#callSrchEngnBtn").attr("onclick", "callSearchEngine('cmbBankId', '32c7fcd2cd9c32b19841d743dc09d56f');");
		$('#callSrchEngnBtn').show();
		$('#txtPartnerId').val($('#cmbBankId').val());
	} else if (srcObjValue === "biller") { // show biller objects and hide bank objects
		$('#txtSadadId').hide();
		$('#txtSadadId').removeClass('rqf');
		$('#cmbBillerId').show();
		$('#cmbBillerId').addClass('rqf');
		$('#lbl4Org').attr('for', 'cmbBillerId');
		$('#cmbBankId').hide();
		$('#cmbBankId').removeClass('rqf');
        $('#cmbAggregatorId').hide();
		$('#cmbAggregatorId').removeClass('rqf');
		$("#callSrchEngnBtn").attr("onclick", "callSearchEngine('cmbBillerId', '76cff8fd2def7b0465d7f1979eb99cd0');");
		$('#callSrchEngnBtn').show();
		$('#txtPartnerId').val($('#cmbBillerId').val());
	} else if (srcObjValue === "aggregator") { // show aggregator objects and hide bank objects
		$('#txtSadadId').hide();
		$('#txtSadadId').removeClass('rqf');
		$('#cmbBillerId').hide();
		$('#cmbBillerId').removeClass('rqf');
		$('#lbl4Org').attr('for', 'cmbAggregatorId');
		$('#cmbBankId').hide();
		$('#cmbBankId').removeClass('rqf');
        $('#cmbAggregatorId').show();
		$('#cmbAggregatorId').addClass('rqf');
		$("#callSrchEngnBtn").attr("onclick", "callSearchEngine('cmbAggregatorId', '43e028dfdaab976ddd27cc17c457542f');");
		$('#callSrchEngnBtn').show();
		$('#txtPartnerId').val($('#cmbAggregatorId').val());
	}

	if (document.getElementById('slct_NewGroups') !== null) {
		$('#slct_NewGroups').find('option').remove();
		if (srcObjValue === "sadad") { // show bank objects and hide biller objects
			$.each(_assignableGroups_Sadad, function(i, val) {
				$("#slct_NewGroups").append("<option value=" + val + ">" + val + "</option>");
			});
		} else if (srcObjValue === "bank") { // show bank objects and hide biller objects
			$.each(_assignableGroups_Banks, function(i, val) {
				$("#slct_NewGroups").append("<option value=" + val + ">" + val + "</option>");
			});
		} else if (srcObjValue === "biller") { // show biller objects and hide bank objects
			$.each(_assignableGroups_Billers, function(i, val) {
				$("#slct_NewGroups").append("<option value=" + val + ">" + val + "</option>");
			});
		} else if (srcObjValue === "aggregator") { // show biller objects and hide bank objects
			$.each(_assignableGroups_Aggregator, function(i, val) {
				$("#slct_NewGroups").append("<option value=" + val + ">" + val + "</option>");
			});
		}
	}
}

/**
 * Function to be called on Partner Key update (regardless of partner type)
 * funtion will reflect the change in hidden partner key
 * 
 * @param srcObjValue -
 *            select or combobox object's current value
 */
function partnerKeyChange(srcObjValue) {
	$('#txtPartnerId').val(srcObjValue);
}

function userStatusChange(srcObjValue) {
	makePageBusy();
	if (srcObjValue === 'INACTIVE') {
		$('#pswrd_Row').hide();
		$('#txtInitPassword').val('');
		$('#txtInitPassword').removeClass('rqf');
		$('#txtInitConfPassword').removeClass('rqf');
	} else if (srcObjValue === 'ACTIVE') {
		$('#pswrd_Row').show();
		$('#txtInitPassword').addClass('rqf');
		$('#txtInitConfPassword').addClass('rqf');
	}
	makePageUnBusy();
}

function createUserProfile() {
	if ($('#txtInitPassword').val() !== $('#txtInitConfPassword').val()) {
		displayErrorOrMessage(_objKV['err_password_mismatch']);
		return;
	} else {
		if ($('#cmbBillerId.rqf').val() !== undefined) {
			$('#txtPartnerId').val($('#cmbBillerId.rqf').val());
			$('#txtPartnerName').val($('#cmbBillerId option:selected').text().trim());
		} else if ($('#cmbBankId.rqf').val() !== undefined) {
			$('#txtPartnerId').val($('#cmbBankId.rqf').val());
			$('#txtPartnerName').val($('#cmbBankId option:selected').text().trim());
		} else if ($('#cmbAggregatorId.rqf').val() !== undefined) {
			$('#txtPartnerId').val($('#cmbAggregatorId.rqf').val());
			$('#txtPartnerName').val($('#cmbAggregatorId option:selected').text().trim());
		} else if ($('#txtSadadId.rqf').val() !== undefined) {
			$('#txtPartnerId').val('SADAD-001');
			$('#txtPartnerName').val('SADAD');
		}
		$('#txtNewGroups').val($('#slct_NewGroups').val());
		
		if (isDataValid()){
			$('#frm_CreateUserProfile').submit();	
		}
	}
}


function resetCreateProfileForm() {
	$('#frm_CreateUserProfile').trigger('reset');
	setTimeout(function() {
		onChangePartnerType($('#cmbOrgType').val());
		userStatusChange($('#cmbUserStatus').val());
	}, 100);
}

/**
 * Function to be called to set arrival and processing date before form
 * submission
 */
function setValuesForSubmission(doQueryFormSubmission) {
	if ($('#cmbBillerId.rqf').val() !== undefined)
		$('#txtPartnerId').val($('#cmbBillerId.rqf').val());
	if ($('#cmbBankId.rqf').val() !== undefined)
		$('#txtPartnerId').val($('#cmbBankId.rqf').val());
	if ($('#cmbAggregatorId.rqf').val() !== undefined)
	    $('#txtPartnerId').val($('#cmbAggregatorId.rqf').val());
	if ($('#txtSadadId.rqf').val() !== undefined)
		$('#txtPartnerId').val('SADAD-001');

	doQueryFormSubmission("frmQueryUser");
}

function setNewPassword() {
	if(isDataValid()) {
		if ($('#txtNewPassword').val() === $('#txtConfirmPassword').val())
			$('#frmChangePassword').submit();
		else
			displayErrorOrMessage(_objKV['err_password_mismatch']);
	}
}

function prepareGroupAssignment() {
	let newGroups = '';
	$('#frmAssignPermission').find('input[type=checkbox]').each(function() {
		if ($(this).prop('checked') === true)
			newGroups = newGroups + $(this).val() + ',';
	});
	if (newGroups.length > 0)
		newGroups = newGroups.substring(0, newGroups.lastIndexOf(','))
	$('#hdnNewGroups').val(newGroups);
}

function assignPermission() {
	makePageBusy();
	$.when(prepareGroupAssignment()).done($('#frmAssignPermission').submit());
	makePageUnBusy();
}

function markCheckedForAssignedGroups() {
	let aag = $('#hdnAssignedGroups').val().split(',').map(
			Function.prototype.call, String.prototype.trim).sort();
	let abg = $('#hdnAssignableGroups').val().split(',').sort();
	let mkg = aag.filter(function(x) {
		return abg.indexOf(x) >= 0;
	});
	mkg.forEach(function(group) {
		$('#chkGrp_' + group).attr('checked', 'checked');
		;
	});
}

function cancelChangePassword() {
	makePageBusy();
	$.when($('#txtOperation').val('cancel'),
			$('#frm_ChangePassword').attr('action', $('#txtActionUrl').val()),
			setTimeout(function() {
				console.log('wait...');
			}, 100)).done($('#frm_ChangePassword').submit());
	makePageUnBusy();
}

function changeCurrentPassword() {
	displayErrorOrMessage();
	if (isDataValid()){
		if ($('#txt_CurrentPassword').val() === $('#txt_NewPassword').val()) {
			displayErrorOrMessage(_objKV['err_new_password_same']);
			return;
		}

		if ($('#txt_NewPassword').val() === $('#txt_ConfirmPassword').val()) {
			$('#txtOperation').val('changePwd');
			$('#frm_ChangePassword').submit();
		} else {
			displayErrorOrMessage(_objKV['err_password_mismatch']);
			return;
		}
	}
}

function acceptOrDeclineTermsConditions(act) {
	makePageBusy();
	$('#txtOperation').val(act);
	$('#frmAcceptTerm').submit();
	makePageUnBusy();
}

function editProfile(){
	if (isDataValid()){
		$('#frm_EditUserProfile').submit();	
	}
}