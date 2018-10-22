<%@ page import="com.sadad.scm.common._1.PaymentIdTypeEnum"%>
<% pageContext.setAttribute("paymentIdTypeEnum", PaymentIdTypeEnum.values()); %>

<jsp:directive.include file="../../common/JspDeclarations.jspf" />

<form name="frmQueryPayment" id="frmQueryPayment" method="post" action="<portlet:resourceURL id="core_PaymentsSummary"/>">
	<table style="width: 100%">
		<!-- Form or Details container -->
		<tbody>
			<tr>
				<td>
					<p class="attnbox"><fmt:message key="ebpp.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
				</td>
			</tr>
			<tr>
				<td>
					<fieldset>
						<legend>
							<fmt:message key="ebpp.portlet.label.search-for-payment" bundle="${bndlLang}" />
						</legend>
						<table>
							<tbody>
								<tr>
									<td>
										<table class="dataEntryPageTable" style="width: 100%" cellspacing="0" cellpadding="0" border="0">
											<!-- Begin: Data entry fields -->
											<tbody>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" style="width: 200px; valign: top; height: 27;">
														<label class="label" for="fpBankKey">
															<fmt:message key="ebpp.portlet.label.bank-name" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell"
														style="width: 100%; valign: top;">
														<select name="param_bankId" class="outputData" id="fpBankKey" onchange="onChangePartnerKey(this);">
															<option value="">
																<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
															</option>
															<c:forEach items="${BankList}" var="bank">
																<option <c:if test="${psb.bankId == bank.value.partnerKey}">selected</c:if>
																	value="<c:out value="${bank.value.partnerKey}" />">
																	<c:out value="${bank.value.partnerName}" />
																</option>
															</c:forEach>
														</select>
													</td>
												</tr>

												<tr class="DataEntryFieldRow">
													<td class="labelCell" style="width: 200px; valign: top; height: 27;">
														<label class="label" for="BillerId_field">
															<fmt:message key="ebpp.portlet.label.biller-name" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell"
														style="width: 100%; valign: top;">
														<select name="param_billerId" class="outputData" id="cmbPartnerKey" onchange="onChangePartnerKey(this);">
															<option value="">
																<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
															</option>
															<c:forEach items="${BillerList}" var="biller">
																<option <c:if test="${psb.billerId == biller.value.partnerKey}">selected</c:if>
																	value="<c:out value="${biller.value.partnerKey}" />">
																	<c:out value="${biller.value.partnerName}" />
																</option>
															</c:forEach>
														</select>
													</td>
												</tr>
												<!-- Begin: Data entry fields -->
												<tr class="DataEntryFieldRow">
													<td class="labelCell" style="width: 200px; valign: top; height: 27;">
														<label class="label" for="PmtIdType_field">
														<fmt:message key="ebpp.portlet.label.transaction-type"bundle="${bndlLang}" />*</label>
													</td>
													<td class="outputDataCell" style="width: 100%; valign: top;">
														<select class="outputData" name="param_paymentIdType"  id="cmbPaymentIdType">
														<c:forEach items="${paymentIdTypeEnum}" var="idType">
																<option value="${idType}">${idType}</option>
														</c:forEach>
													</select>
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" style="width: 200px; valign: top; height: 27;">
														<label class="label" for="PmtId_field">
														<fmt:message key="ebpp.portlet.label.transaction-number" bundle="${bndlLang}" />*</label></td>
													<td class="outputDataCell" style="width: 100%; valign: top;">
														<input class="outputData" name="param_paymentId" id="txtPaymentId" value="${psb.payments[psb.paymentKey].sadadNumber}" required autocomplete="off" maxlength="256" type="text"/>
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
										<input type="submit" class="button" value='<fmt:message key="ebpp.portlet.button.search" bundle="${bndlLang}"/>' onclick="doQueryFormSubmission('frmQueryPayment');" /> 
										<input type="button" class="button" value='<fmt:message key="ebpp.portlet.button.clear" bundle="${bndlLang}"/>' onclick=";" />
									</td>
								</tr>
							</tbody>
						</table>
					</fieldset>
					<!-- END Query Segment -->

				</td>
			</tr>
			<!-- End Form/Details container -->

		</tbody>
	</table>
	<!-- END Main Table -->
</form>
