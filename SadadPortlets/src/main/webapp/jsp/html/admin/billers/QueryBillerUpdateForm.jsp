<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="biller.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="biller.portlet.label.update-biller" bundle="${bndlLang}" /></legend>
					<form id="frmUpdateBiller" method="post" action="<portlet:resourceURL id="QueryBillerDetails"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
									<!-- Begin: Data entry fields -->
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerId"><fmt:message key="biller.portlet.label.biller-id" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input class="rqf" name="txtBillerId" value="${psb.selectedBiller.billerId}" maxlength="25" autocomplete="off" disabled="disabled">
													<input type="hidden" value="${psb.selectedBiller.billerId}" name="param_billerId">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerName"><fmt:message key="biller.portlet.label.biller-name" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="param_billerName" id="txtBillerName" class="rqf" value="${psb.selectedBiller.billerName}" maxlength="60" autocomplete="off">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerArabicName"><fmt:message key="biller.portlet.label.biller-arabic-name" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="param_billerArabicName" id="txtBillerArabicName" class="rqf" value="${psb.selectedBiller.billerArabicName}" maxlength="60" autocomplete="off">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtDescription"><fmt:message key="biller.portlet.label.description" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="param_description" id="txtDescription" class="outputData" value="${psb.selectedBiller.description}" maxlength="250" autocomplete="off">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBankName"><fmt:message key="biller.portlet.label.bank-name" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<select name="param_billingAccountBankId" id="txtBankName" class="rqf">
														<option value="">
															<fmt:message key="biller.portlet.label.please-select" bundle="${bndlLang}"/>
														</option>														
														<c:forEach items="${BankList}" var="bank">
															<option <c:if test="${psb.selectedBiller.billingAccountBankId == bank.value.partnerKey}">selected</c:if>
																value="<c:out value="${bank.value.partnerKey}" />">
																<c:out value="${bank.value.partnerName}" />
															</option>
														</c:forEach>
													</select>
													<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('txtBankName', '32c7fcd2cd9c32b19841d743dc09d56f');">
														<img src="/static/images/search.png" height="12px" width="12px">
													</button>
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtSadadAccountNumber"><fmt:message key="biller.portlet.label.sadad-account-number" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="param_billingAccountNumber" id="txtSadadAccountNumber" class="rqf" value="${psb.selectedBiller.billingAccountNumber}" maxlength="24" autocomplete="off">												
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtRefundBankId"><fmt:message key="biller.portlet.label.biller-refund-bank-id" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<select name="param_refundAccountBankId" id="txtRefundBankId">
														<option value="">
															<fmt:message key="biller.portlet.label.please-select" bundle="${bndlLang}"/>
														</option>														
														<c:forEach items="${BankList}" var="bank">
															<option <c:if test="${psb.selectedBiller.refundAccountBankId == bank.value.partnerKey}">selected</c:if>
																value="<c:out value="${bank.value.partnerKey}" />">
																<c:out value="${bank.value.partnerName}" />
															</option>
														</c:forEach>
													</select>
													<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('txtRefundBankId', '32c7fcd2cd9c32b19841d743dc09d56f');">
														<img src="/static/images/search.png" height="12px" width="12px">
													</button>											
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtSadadRefundAccount"><fmt:message key="biller.portlet.label.sadad-refund-account" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="param_refundAccountNumber" id="txtSadadRefundAccount" value="${psb.selectedBiller.refundAccountNumber}" maxlength="24" autocomplete="off">
												</td>
											</tr>
											
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtDefalutSettlementId"><fmt:message key="biller.portlet.label.default-settlement-settlement-id" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="param_defaultSettlementSettlementId" id="txtDefaultSettlementSettlementId" value="${psb.selectedBiller.defaultSettlementSettlementId}" maxlength="24" readonly autocomplete="off">
												</td>
											</tr>
											<c:if test="${psb.selectedBiller.generateSettlementId}">
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="chkGenSettlementId"><fmt:message key="biller.portlet.label.generate-settlement-id" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="checkbox" checked name="param_generateSettlementId" id="chkGenSettlementId" value="${psb.selectedBiller.generateSettlementId}" autocomplete="off">
												</td>
											</tr>
											</c:if>
											<!-- End: Data entry fields -->
										</tbody>
									</table>
								</td>
							</tr>
							<!-- Buttons Group -->
							<tr>
								<td>
									<input type="hidden" name="param_billerType"  value="${psb.selectedBiller.billerType}" />
									<input type="hidden" name="param_operation" id="param_operation" value="callUpdatePartner" />
									<input class="button" value="<fmt:message key="biller.portlet.button.save" bundle="${bndlLang}" />" onclick="doQueryFormSubmission('frmUpdateBiller', 1);" type="submit" />
									<input class="button" value="<fmt:message key="biller.portlet.button.cancel" bundle="${bndlLang}" />" onclick="doPostUrl('<portlet:resourceURL id="QueryBillerDetails" />', 1);" type="button" />
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