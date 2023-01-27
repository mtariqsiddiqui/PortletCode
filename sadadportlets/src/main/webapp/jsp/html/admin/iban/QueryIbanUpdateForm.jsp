<%@ page import="com.sadad.scm.common._1.PartyIdTypeType"%>
<% pageContext.setAttribute("partyIdTypeType", PartyIdTypeType.values()); %>
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
						<fmt:message key="iban.portlet.label.update-iban" bundle="${bndlLang}" />
					</legend>
					<form name="frmUpdateIban" id="frmUpdateIban" method="post" action='<portlet:resourceURL id="QueryIbanDetails_go_back"/>'>
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
														<label class="label" for="txtIban">
															<fmt:message key="iban.portlet.label.iban" bundle="${bndlLang}" /> *
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input class="rqf" value="${psb.ibans[psb.ibanKey].currentRecord.iban}" name="param_iban" id="txtIban"
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
														<input class="rqf" value="${psb.ibans[psb.ibanKey].currentRecord.settlementId}" name="param_settlementId" id="txtSettlementId"  readonly
														 autocomplete="off" maxlength="32" type="text" />
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="cmbCustomerIdType">
															<fmt:message key="iban.portlet.label.customer-id-type" bundle="${bndlLang}"/>&nbsp;*
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<select name="param_customerIdType" class="rqf" id="cmbCustomerIdType">
															<option value="">
																<fmt:message key="iban.portlet.label.please-select" bundle="${bndlLang}"/>
															</option>
															<c:forEach items="${partyIdTypeType}" var="idType">
																<option <c:if test="${psb.ibans[psb.ibanKey].currentRecord.customerIdType == idType}">selected</c:if> 
																	value="${idType}">${idType}</option>
															</c:forEach>
														</select>
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtCustomerId">
															<fmt:message key="iban.portlet.label.customer-id" bundle="${bndlLang}"/>&nbsp;*
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input name="param_customerId" class="rqf" value="${psb.ibans[psb.ibanKey].currentRecord.customerId}" id="txtCustomerId" autocomplete="off" maxlength="20" type="text">
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td>
										<input type="hidden" value="UPDATE_FORM" id="hdnPageId" />
										<input type="hidden" name="param_operation" value="callUpdateIban" />
										<input class='button' value='<fmt:message key="iban.portlet.button.save" bundle="${bndlLang}"/>' onclick='updateIban(doQueryFormSubmission);' type='submit' />
										<input class='button' value='<fmt:message key="iban.portlet.button.cancel" bundle="${bndlLang}"/>' onclick="doPostUrl('<portlet:resourceURL id="QueryIbanDetails_go_back"/>', 1);" type='button' />
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