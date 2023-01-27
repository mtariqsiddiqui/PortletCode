<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="payment-type.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="payment-type.portlet.label.update-settlement-correlations" bundle="${bndlLang}" /></legend>
					<form id="frmCreateUpdateSettlement" method="post" action="<portlet:resourceURL id="QueryPaymentTypeDetails"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
									<!-- Begin: Data entry fields -->
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerId"><fmt:message key="payment-type.portlet.label.biller-id" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input id="txtBillerId" class="outputData" value="${psb.billerId}"  disabled="disabled"/>
													<input name="param_billerId" value="${psb.billerId}" type="hidden"/>
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtPaymentType"><fmt:message key="payment-type.portlet.label.payment-type" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input class="outputData" value="${psb.selectedPaymentType.paymentType}" id="txtPaymentType" disabled="disabled"/>
													<input name="param_paymentType" value="${psb.selectedPaymentType.paymentType}" type="hidden" />
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="chkIsPrepaid"><fmt:message key="payment-type.portlet.label.is-prepaid" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input id="chkIsPrepaid" class="outputData" type="checkbox" <c:if test="${psb.selectedPaymentType.prepaid}">checked</c:if>>
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="chkIsDefault"><fmt:message key="payment-type.portlet.label.is-default" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input id="chkIsDefault" class="outputData" type="checkbox" <c:if test="${psb.selectedPaymentType.deefault}">checked</c:if>>
												</td>
											</tr>
											<tr id="optIbanRow" class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtPaymentTypeIBAN"><fmt:message key="payment-type.portlet.label.payment-type-iban" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input id="txtPaymentTypeIBAN" name="param_iban" class="rqf" type="text" value="${psb.selectedPaymentType.iban}" />
												</td>
											</tr>
											<tr id="optIbanRow" class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtSettlementId"><fmt:message key="payment-type.portlet.label.settlement-id" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input id="txtSettlementId" class="outputData" type="text" value="${psb.selectedPaymentType.settlementId}" readonly />
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
									<input type="hidden" name="param_operation" id="param_operation" value="callCreateOrUpdateBillerSettlementCorrelation"/>
									<input class="button" value="<fmt:message key="payment-type.portlet.button.save" bundle="${bndlLang}" />" onclick="prepareFormSubmission(this); doQueryFormSubmission('frmCreateUpdateSettlement', 1);" type="submit" />
									<input class="button" value="<fmt:message key="payment-type.portlet.button.cancel" bundle="${bndlLang}" />" onclick="doPostUrl('<portlet:resourceURL id="QueryPaymentTypeDetails" />', 1);" type="button" />
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