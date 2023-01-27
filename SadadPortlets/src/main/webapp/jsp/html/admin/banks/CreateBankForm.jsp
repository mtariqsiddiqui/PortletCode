<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="bank.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="bank.portlet.label.create-bank" bundle="${bndlLang}" /></legend>
					<form id="frmCreateBank" method="post" action="<portlet:resourceURL id="CreateBankForm"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBankId"><fmt:message key="bank.portlet.label.bank-id" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_bankId" id="txtBankId" class="rqf" value="${psb.bankId}" autocomplete="off" maxlength="8">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBankName"><fmt:message key="bank.portlet.label.bank-name" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_bankName" id="txtBankName" class="rqf" value="${psb.bankName}" maxlength="60" autocomplete="off" onblur="chop(this);">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtDescription"><fmt:message key="bank.portlet.label.description" bundle="${bndlLang}" /> </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_description" id="txtDescription" value="${psb.description}" maxlength="250" autocomplete="off">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtSuspenceAccount"><fmt:message key="bank.portlet.label.sadad-account-number" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_suspenceAccount" id="txtSuspenceAccount" class="rqf" value="${psb.suspenceAccount}" maxlength="32" autocomplete="off">												
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtRefundAccount"><fmt:message key="bank.portlet.label.sadad-refund-account" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_refundAccount" id="txtRefundAccount" value="${psb.refundAccount}" maxlength="32" autocomplete="off">												
												</td>
											</tr>											
										</tbody>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<input type="hidden" value="INACTIVE" name="param_status" />
									<input type="hidden" value="callCreatePartner" name="param_operation" />
									<input class="button" value="<fmt:message key="bank.portlet.button.save" bundle="${bndlLang}" />" onclick="doQueryFormSubmission('frmCreateBank', 1);" type="submit" name="btnSave"/>
									<input class="button" value="<fmt:message key="bank.portlet.button.cancel" bundle="${bndlLang}" />" type="button" onclick="displayErrorOrMessage();$('#frmCreateBank').trigger('reset');" name="btnCancel"/>
								</td>
							</tr>
						</tbody>
					</table>
					</form>
				</fieldset>
			</td>
		</tr>
	</tbody>
</table>