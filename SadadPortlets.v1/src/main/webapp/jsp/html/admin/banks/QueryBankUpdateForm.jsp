<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<table style="width: 100%">
					<tbody>
						<tr><td><p class="attnbox"><fmt:message key="bank.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p></td></tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="bank.portlet.label.update-bank" bundle="${bndlLang}" /></legend>
					<form id="frmUpdateBank" method="post" action="<portlet:resourceURL id="QueryBankDetails"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
									<!-- Begin: Data entry fields -->
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBankId"><fmt:message key="bank.portlet.label.bank-id" bundle="${bndlLang}" />:</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input class="outputData" value="${psb.selectedBank.bankId}" maxlength="25" autocomplete="off" disabled="disabled">
													<input type="hidden" value="${psb.selectedBank.bankId}" name="txtBankId">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBankName"><fmt:message key="bank.portlet.label.bank-name" bundle="${bndlLang}" /> : </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="txtBankName" id="txtBankName" class="outputData" required value="${psb.selectedBank.bankName}" maxlength="256" autocomplete="off">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtDescription"><fmt:message key="bank.portlet.label.description" bundle="${bndlLang}" /> : </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="txtDescription" id="txtDescription" class="outputData" value="${psb.selectedBank.description}" maxlength="256" autocomplete="off">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtSuspenceAccount"><fmt:message key="bank.portlet.label.sadad-suspence-account" bundle="${bndlLang}" /> : </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="txtSuspenceAccount" id="txtSuspenceAccount" class="outputData" required value="${psb.selectedBank.suspenceAccount}" maxlength="50" autocomplete="off">												
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtRefundAccount"><fmt:message key="bank.portlet.label.sadad-refund-account" bundle="${bndlLang}" /> : </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="txtRefundAccount" id="txtRefundAccount" class="outputData" required value="${psb.selectedBank.refundAccount}" maxlength="50" autocomplete="off">												
												</td>
											</tr>											
											<!-- End: Data entry fields -->
										</tbody>
									</table>
								</td>
							</tr>
							<!-- Buttons Group -->
							<tr>
								<td>
									<input type="hidden" name="reqAction" id="reqAction"/>
									<input class="button" value="<fmt:message key="bank.portlet.button.save" bundle="${bndlLang}" />" onclick="$('#reqAction').val('Save');doQueryFormSubmission('frmUpdateBank', 1);" type="submit" name="btnSave"/>
									<input class="button" value="<fmt:message key="bank.portlet.button.cancel" bundle="${bndlLang}" />" onclick="$('#reqAction').val('Cancel');doQueryFormSubmission('frmUpdateBank', 1);" type="submit" name="btnCancel"/>
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