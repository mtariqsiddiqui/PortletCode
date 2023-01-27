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
										<table class="dataEntryPageTable" style="width: 100%; padding: 1px">
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
														<select name="param_bankId" class="outputData" id="fpBankKey">
															<c:choose>
																<c:when test="${psb.partnerType == 'bank' }">
																	<option selected value="<c:out value='${psb.partnerKey}' />">
																		<c:out value="${BankList[psb.partnerKey].partnerName}" />
																	</option>
																</c:when>
																<c:otherwise>
																	<option value="">
																		<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
																	</option>
																	<c:forEach items="${BankList}" var="bank">
																		<option <c:if test="${psb.bankId == bank.value.partnerKey}">selected</c:if>
																			value="<c:out value="${bank.value.partnerKey}" />">
																			<c:out value="${bank.value.partnerName}" />
																		</option>
																	</c:forEach>
																</c:otherwise>
															</c:choose>
														</select>
														<%--Display Search Engine to SADAD & Biller users --%>
														<c:if test="${ psb.partnerType == 'aggregator' or psb.partnerType == 'biller' or psb.partnerType == 'sadad'}">
															<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('fpBankKey', '32c7fcd2cd9c32b19841d743dc09d56f');">
																<img src="/static/images/search.png" height="12px" width="12px">
															</button>
														</c:if>
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
														<select name="param_billerId" class="outputData" id="fpBillerKey">
															<c:choose>
																<c:when test="${psb.partnerType == 'biller' }">
																	<option selected value="<c:out value='${psb.partnerKey}' />">
																		<c:out value="${BillerList[psb.partnerKey].partnerName}" />
																	</option>
																</c:when>
																<c:when test="${psb.partnerType == 'aggregator' }">
																	<option value=""><fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/></option>
																	<c:forEach items="${AggregatorBillerList[psb.partnerKey]}" var="biller">
																		<option <c:if test="${psb.billerId == biller.value.partnerKey}">selected</c:if>
																			value="<c:out value="${biller.value.partnerKey}" />">
																			<c:out value="${biller.value.partnerName}" />
																		</option>
																	</c:forEach>
																</c:when>
																<c:otherwise>
																	<option value="">
																		<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
																	</option>
																	<c:forEach items="${BillerList}" var="biller">
																		<option <c:if test="${psb.billerId == biller.value.partnerKey}">selected</c:if>
																			value="<c:out value="${biller.value.partnerKey}" />">
																			<c:out value="${biller.value.partnerName}" />
																		</option>
																	</c:forEach>
																</c:otherwise>
															</c:choose>
														</select>
														<%--Display Search Engine to SADAD & Bank users --%>
														<c:if test="${psb.partnerType == 'bank' or psb.partnerType == 'sadad'}">
															<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('fpBillerKey', 'e13b5b1608ad566f94ba9fe7849aca38');">
																<img src="/static/images/search.png" height="12px" width="12px">
															</button>
														</c:if>
														<c:if test="${psb.partnerType == 'aggregator'}"> <%-- Or to Aggregator Users --%>
															<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('fpBillerKey', 'a5e383e5e7a87a6844dd02fa04944c35&q1=${psb.hashedPartnerKey}');">
																<img src="/static/images/search.png" height="12px" width="12px">
															</button>
														</c:if>
													</td>
												</tr>
												<!-- Begin: Data entry fields -->
												<tr class="DataEntryFieldRow">
													<td class="labelCell" style="width: 200px; valign: top; height: 27;">
														<label class="label" for="cmbPaymentIdType">
														<fmt:message key="ebpp.portlet.label.transaction-type"bundle="${bndlLang}" />*</label>
													</td>
													<td class="outputDataCell" style="width: 100%; valign: top;">
														<select class="rqf" name="param_paymentIdType"  id="cmbPaymentIdType" onchange="onTransactionTypeChange(this.value);">
														<c:forEach items="${paymentIdTypeEnum}" var="idType">
																<option value="${idType}">${idType}</option>
														</c:forEach>
													</select>
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" style="width: 200px; valign: top; height: 27;">
														<label class="label" for="txtPaymentId">
														<fmt:message key="ebpp.portlet.label.transaction-number" bundle="${bndlLang}" />*</label></td>
													<td class="outputDataCell" style="width: 100%; valign: top;">
														<input class="rqf nbr" name="param_paymentId" id="txtPaymentId" value="${psb.payments[psb.paymentKey].sadadNumber}" autocomplete="off" maxlength="25" type="text"/>
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
										<input type="hidden" name="param_operation" value="callPaymentService_ListById"/>
										<input type="submit" class="button" value='<fmt:message key="ebpp.portlet.button.search" bundle="${bndlLang}"/>' onclick="doQueryFormSubmission('frmQueryPayment');" /> 
										<portlet:resourceURL id="QueryPaymentForm" var="clearURL"><portlet:param name="param_operation" value="clearSessionBeanObject"/></portlet:resourceURL>
										<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.clear" bundle="${bndlLang}"/>" onclick="doQueryFormReset('${clearURL}');" />
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
