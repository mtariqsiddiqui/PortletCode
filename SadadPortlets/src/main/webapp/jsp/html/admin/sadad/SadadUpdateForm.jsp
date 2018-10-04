<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<span class="${psb.messageToDisplay.messageType}_Message">${psb.messageToDisplay.displayMessage}</span>
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="sadad-admin.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="sadad-admin.portlet.label.update-sadad" bundle="${bndlLang}" /></legend>
					<form id="frmUpdateSadad" method="post" action="<portlet:resourceURL id="SadadDetails"/>">
						<table style="width: 100%">
						<!-- Begin: Data entry fields -->
							<tbody>
								<tr class="DataEntryFieldRow">
									<td class="labelCell" valign="top" nowrap height="27">
										<label class="label" for="txtCurrentAccount"><fmt:message key="sadad-admin.portlet.label.sadad-current-account-number" bundle="${bndlLang}" />:</label>
									</td>
									<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
										<input name="txtCurrentAccount" id="txtCurrentAccount" class="outputData" value="${psb.sadadCurrentAccount}" maxlength="25" autocomplete="off">
									</td>
								</tr>
								<tr class="DataEntryFieldRow">
									<td class="labelCell" valign="top" nowrap height="27">
										<label class="label" for="txtBankId"><fmt:message key="sadad-admin.portlet.label.account-bank-name" bundle="${bndlLang}" /> : </label>
									</td>
									<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
										<select name="txtBankId" id="txtBankId" class="outputData">
											<option value="">
												<fmt:message key="sadad-admin.portlet.label.please-select" bundle="${bndlLang}"/>
											</option>
											<c:forEach items="${BankList}" var="bank">
												<option <c:if test="${psb.accountBankId == bank.value.partnerKey}">selected</c:if>
													value="<c:out value="${bank.value.partnerKey}" />">
													<c:out value="${bank.value.partnerName}" />
												</option>
											</c:forEach>
										</select>													
									</td>
								</tr>
								<tr class="DataEntryFieldRow">
									<td class="labelCell" valign="top" nowrap height="27">
										<label class="label" for="txtRefundLimit"><fmt:message key="sadad-admin.portlet.label.refund-max-limit" bundle="${bndlLang}" /> : </label>
									</td>
									<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
										<input name="txtRefundLimit" id="txtRefundLimit" class="outputData" value="${psb.refundMaxLimit}" maxlength="256" autocomplete="off">
									</td>
								</tr>
								<tr><td colspan="2"></td></tr>
								<!-- End: Data entry fields -->
								<tr>
									<td colspan="2">
										<input type="hidden" name="reqAction" id="reqAction"/>
										<input class="button" value="<fmt:message key="sadad-admin.portlet.button.save" bundle="${bndlLang}" />" onclick="$('#reqAction').val('Save');doQueryFormSubmission('frmUpdateSadad', 1);" type="submit" name="btnSave"/>
										<input class="button" value="<fmt:message key="sadad-admin.portlet.button.cancel" bundle="${bndlLang}" />" onclick="$('#reqAction').val('Cancel');doQueryFormSubmission('frmUpdateSadad', 1);" type="submit" name="btnCancel"/>
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