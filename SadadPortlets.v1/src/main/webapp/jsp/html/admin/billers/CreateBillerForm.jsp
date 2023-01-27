<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<table style="width: 100%">
					<tbody>
						<tr><td><p class="attnbox"><fmt:message key="biller.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p></td></tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="biller.portlet.label.create-biller" bundle="${bndlLang}" /></legend>
					<form id="frmCreateBiller" method="post" action="<portlet:resourceURL id="CreateBillerForm"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
									<!-- Begin: Data entry fields -->
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerId"><fmt:message key="biller.portlet.label.biller-id" bundle="${bndlLang}" />:</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="txtBillerId" id="txtBillerId" class="outputData" required value="${psb.selectedBiller.billerId}" maxlength="25" autocomplete="off">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtPaymentType"><fmt:message key="biller.portlet.label.biller-name" bundle="${bndlLang}" /> : </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="txtBillerName" id="txtBillerName" class="outputData" required value="${psb.selectedBiller.billerName}" maxlength="256" autocomplete="off">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="chkIsPrepaid"><fmt:message key="biller.portlet.label.description" bundle="${bndlLang}" /> : </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="txtDescription" id="txtDescription" class="outputData" value="${psb.selectedBiller.description}" maxlength="256" autocomplete="off">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="chkIsDefault"><fmt:message key="biller.portlet.label.sadad-account-number" bundle="${bndlLang}" /> : </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="txtSadadAccountNumber" id="txtSadadAccountNumber" class="outputData" required value="${psb.selectedBiller.sadadAccountNumber}" maxlength="50" autocomplete="off">												
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="chkCanReverse"><fmt:message key="biller.portlet.label.bank-name" bundle="${bndlLang}" /> : </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<select name="txtBankName" id="txtBankName" class="outputData" required>
														<option value="">
															<fmt:message key="biller.portlet.label.please-select" bundle="${bndlLang}"/>
														</option>														
														<c:forEach items="${BankList}" var="bank">
															<option <c:if test="${psb.partnerKey == bank.value.partnerKey}">selected</c:if>
																value="<c:out value="${bank.value.partnerKey}" />">
																<c:out value="${bank.value.partnerName}" />
															</option>
														</c:forEach>
													</select>												
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="chkCanReverse"><fmt:message key="biller.portlet.label.biller-refund-bank-id" bundle="${bndlLang}" /> : </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<select name="txtRefundBankId" id="txtRefundBankId"  class="outputData" required>
														<option value="">
															<fmt:message key="biller.portlet.label.please-select" bundle="${bndlLang}"/>
														</option>														
														<c:forEach items="${BankList}" var="bank">
															<option <c:if test="${psb.partnerKey == bank.value.partnerKey}">selected</c:if>
																value="<c:out value="${bank.value.partnerKey}" />">
																<c:out value="${bank.value.partnerName}" />
															</option>
														</c:forEach>
													</select>												
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="chkCanReverse"><fmt:message key="biller.portlet.label.sadad-refund-account" bundle="${bndlLang}" /> : </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="txtSadadRefundAccount" id="txtSadadRefundAccount" class="outputData" required value="${psb.selectedBiller.sadadAccountNumber}" maxlength="50" autocomplete="off">												
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
									<input type="hidden" value="Save" name="reqAction" id="reqAction"/>
									<input class="button" value="<fmt:message key="biller.portlet.button.save" bundle="${bndlLang}" />" onclick="doQueryFormSubmission('frmCreateBiller', 1);" type="submit" name="btnSave"/>
									<input class="button" value="<fmt:message key="biller.portlet.button.cancel" bundle="${bndlLang}" />" type="reset" name="btnCancel"/>
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