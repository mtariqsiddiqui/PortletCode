<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox">
					<fmt:message key="iban.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" />
				</p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend>
						<fmt:message key="iban.portlet.label.approve-reject-iban" bundle="${bndlLang}" />
					</legend>
					<form name="frmApproveRejectIban" id="frmApproveRejectIban" method="post" action='<portlet:resourceURL id="ApproveIbanDetails_go_back"/>'>
						<table style="width: 100%">
							<tbody>
								<tr>
									<td>
										<table class="dataEntryPageTable" style="border: 0; width: 100%; padding: 0;">
											<tbody>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label id="lbl4Org" class="label" for="cmbBillerId">
															<fmt:message key="iban.portlet.label.biller" bundle="${bndlLang}" /> </label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<input value="${BillerList[psb.ibans[psb.ibanKey].billerId].partnerName}" id="cmbBillerId"  readonly
														 autocomplete="off" type="text" />
													</td>
												</tr>
												
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label class="label" for="txtIbanReadOnly">
															<fmt:message key="iban.portlet.label.iban" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input value="${psb.ibans[psb.ibanKey].pendingRecord.iban}" id="txtIbanReadOnly" readonly
														 autocomplete="off" maxlength="24" type="text" style="text-transform:uppercase;"/>
													</td>
												</tr>
												
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label class="label" for="txtSettlementId">
															<fmt:message key="iban.portlet.label.settlement-id" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input value="${psb.ibans[psb.ibanKey].pendingRecord.settlementId}" name="param_settlementId" id="txtSettlementId"  readonly
														 autocomplete="off" maxlength="32" type="text" />
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label class="label" for="txtCustomerId">
															<fmt:message key="iban.portlet.label.customer-id" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input value="${psb.ibans[psb.ibanKey].pendingRecord.customerIdType}_${psb.ibans[psb.ibanKey].pendingRecord.customerId}" id="txtCustomerId" autocomplete="off" maxlength="15" readonly type="text" />
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label class="label" for="txtAction">
															<fmt:message key="iban.portlet.label.action" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input value="${psb.action}" name="param_action" id="txtAction" autocomplete="off" maxlength="25" readonly type="text" />
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label class="label" for="txtJustification">
															<fmt:message key="iban.portlet.label.justification" bundle="${bndlLang}" /><c:if test="${psb.action == 'REJECT'}">*</c:if>
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input value="${psb.ibans[psb.ibanKey].pendingRecord.justification}" id="txtJustification" autocomplete="off" maxlength="250" type="text"
														<c:if test="${psb.action == 'REJECT'}">class="rqf"</c:if> name="param_justification" />
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td>
										<input type="hidden" value="APPROVE_REJECT_FORM" id="hdnPageId" />
										<input type="hidden" name="param_operation" value="callProcessIban" />
										<input class='button' value='<fmt:message key="iban.portlet.button.save" bundle="${bndlLang}"/>' onclick='doQueryFormSubmission("frmApproveRejectIban", 1)' type='submit' />
										<input class='button' value='<fmt:message key="iban.portlet.button.cancel" bundle="${bndlLang}"/>' onclick="doPostUrl('<portlet:resourceURL id="ApproveIbanDetails_go_back"><portlet:param name="param_action" value=" "/></portlet:resourceURL>', 1);" type='button' />
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