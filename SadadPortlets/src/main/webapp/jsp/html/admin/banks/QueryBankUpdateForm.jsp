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
					<legend><fmt:message key="bank.portlet.label.update-bank" bundle="${bndlLang}" /></legend>
					<form id="frmUpdateBank" method="post" action="<portlet:resourceURL id="QueryBankDetails"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBankId"><fmt:message key="bank.portlet.label.bank-id" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" id="txtBankId" value="${psb.selectedBank.bankId}" maxlength="25" autocomplete="off" disabled="disabled">
													<input type="hidden" name="param_bankId" value="${psb.selectedBank.bankId}" />
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBankName"><fmt:message key="bank.portlet.label.bank-name" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_bankName" id="txtBankName" class="rqf" value="${psb.selectedBank.bankName}" maxlength="60" autocomplete="off">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtDescription"><fmt:message key="bank.portlet.label.description" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_description" id="txtDescription" value="${psb.selectedBank.description}" maxlength="250" autocomplete="off">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtSuspenceAccount"><fmt:message key="bank.portlet.label.sadad-account-number" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_suspenceAccount" id="txtSuspenceAccount" class="rqf" value="${psb.selectedBank.suspenceAccount}" maxlength="32" autocomplete="off">												
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtRefundAccount"><fmt:message key="bank.portlet.label.sadad-refund-account" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_refundAccount" id="txtRefundAccount" value="${psb.selectedBank.refundAccount}" maxlength="32" autocomplete="off">												
												</td>
											</tr>											
											<!-- End: Data entry fields -->
										</tbody>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<input type="hidden" name="param_operation" id="param_operation" value="callUpdatePartner"/>
									<input class="button" value="<fmt:message key="bank.portlet.button.save" bundle="${bndlLang}" />" onclick="doQueryFormSubmission('frmUpdateBank', 1);" type="submit"/>
									<input class="button" value="<fmt:message key="bank.portlet.button.cancel" bundle="${bndlLang}" />" onclick="doPostUrl('<portlet:resourceURL id="QueryBankDetails" />', 1);" type="button"/>
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