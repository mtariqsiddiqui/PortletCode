<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
	<tr>
		<td>
			<table style="width: 100%">
				<tbody>
					<tr>
						<td class="myCaption"><fmt:message key="ebpp.portlet.label.bills-details" bundle="${bndlLang}"/></td>
					</tr>
					<tr>
						<td>
							<table style="width: 100%">
								<tbody>
									<tr class="NewsColumnWrapper">
										<td class="NewsColumnCell" style="width: 33%; valign: top;">
											<!-- Begin: Data display fields -->
											<table class="tableclass">
												<tbody>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.biller-name" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${BillerList[psb.bills[psb.billKey].billerId].partnerName}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.account-number" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.bills[psb.billKey].accountNumber}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.bill-number" bundle="${bndlLang}"/></th>
														<td style="width: 25%"><span id="response_billNumber">${psb.bills[psb.billKey].billNumber}</span></td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.bill-type" bundle="${bndlLang}"/></th>
														<td style="width: 25%"><span id="response_billType">${psb.bills[psb.billKey].billType}</span></td>
													</tr>
													<!-- Begin: Data display fields -->
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.original-amount" bundle="${bndlLang}"/></th>
														<td style="width: 25%"><span id="response_origianlAmount">${psb.bills[psb.billKey].origianlAmount}</span></td>
													</tr>
													<!-- End: Data display fields -->
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.due-date" bundle="${bndlLang}"/></th>
														<td style="width: 25%"><span id="response_dueDate">${psb.bills[psb.billKey].dueDate}</span></td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.bill-generated-date" bundle="${bndlLang}"/></th>
														<td style="width: 25%"><span id="response_billGeneratedDate">${psb.bills[psb.billKey].billGeneratedDate}</span></td>
													</tr>
													<!-- End: Data display fields -->
												</tbody>
											</table>
										</td>
										<td class="NewsColumnCell" style="width: 33%; valign: top;">
											<!-- Begin: Data display fields -->
											<table class="tableclass">
												<tbody>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.service-type" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.bills[psb.billKey].serviceType}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.bill-cycle" bundle="${bndlLang}"/></th>
														<td style="width: 25%"><span id="response_billCycle">${psb.bills[psb.billKey].billCycle}</span></td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.status" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.bills[psb.billKey].billStatus}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.bill-category" bundle="${bndlLang}"/></th>
														<td style="width: 25%"><span id="response_billCategory">${psb.bills[psb.billKey].billCategory}</span></td>
													</tr>
													<!-- Begin: Data display fields -->
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.net-amount" bundle="${bndlLang}"/></th>
														<td style="width: 25%"><span id="response_netAmount">${psb.bills[psb.billKey].netAmount}</span></td>
													</tr>
													<!-- End: Data display fields -->
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.expiry-date" bundle="${bndlLang}"/></th>
														<td style="width: 25%"><span id="response_expiryDate">${psb.bills[psb.billKey].expiryDate}</span></td>
													</tr>
													<%--
													Bill Creation Date and Bill Generated Date are same, so I removed Bill Creation Date column.
 													<tr> 
 														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.bill-creation-date" bundle="${bndlLang}"/></th>
 														<td style="width: 25%">${psb.bills[psb.billKey].billGeneratedDate}</td>
 													</tr>
 													--%>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.no-of-payments" bundle="${bndlLang}"/></th>
														<td style="width: 25%"><span id="response_paymentCount">${psb.bills[psb.billKey].paymentCount}</span></td>
													</tr>
												</tbody>
											</table>
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<portlet:resourceURL id="core_AccountSummary" var="accountSummaryUrl">
								<portlet:param name="param_billerId" value="${psb.bills[psb.billKey].billerId}"/>
								<portlet:param name="param_accountNumber" value="${psb.bills[psb.billKey].accountNumber}"/>
								<portlet:param name="param_operation" value="callAccountService_ListByKeys"/>
							</portlet:resourceURL>
							<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.account" bundle="${bndlLang}"/>" onclick='doPostUrl("${accountSummaryUrl}", 2);'/>

							<portlet:resourceURL id="core_PaymentsSummary" var="paymentSummaryUrl">
								<portlet:param name="param_billKey" value="${psb.billKey}"/>
								<portlet:param name="param_billerId" value="${psb.bills[psb.billKey].billerId}"/>
								<portlet:param name="param_billNumber" value="${psb.bills[psb.billKey].billNumber}"/>
								<portlet:param name="param_accountNumber" value="${psb.bills[psb.billKey].accountNumber}"/>
								<portlet:param name="param_billCategory" value="${psb.bills[psb.billKey].billCategory}"/>
								<portlet:param name="param_billType" value="${psb.bills[psb.billKey].billType}"/>
								<portlet:param name="param_billGenerationDate" value="${psb.bills[psb.billKey].billGeneratedDate}"/>
								<portlet:param name="param_operation" value="callPaymentService_ListByBillId"/>
							</portlet:resourceURL>							
							<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.payments" bundle="${bndlLang}"/>" onclick='doPostUrl("${paymentSummaryUrl}", 2);'/>
							
							<portlet:resourceURL id="core_BusinessRulesSummary" var="businessRules">
								<portlet:param name="param_billerId" value="${psb.bills[psb.billKey].billerId}"/>
								<portlet:param name="param_billCategory" value="${psb.bills[psb.billKey].billCategory}"/>
								<portlet:param name="param_operation" value="callPartnerProfile_GetPartnerConfiguration"/>
							</portlet:resourceURL>
							<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.list-business-rules" bundle="${bndlLang}"/>" onclick='doPostUrl("${businessRules}", 2);' />
							
							<portlet:resourceURL id="core_AuditSummary" var="audit4Bill">
								<portlet:param name="param_auditEntity" value="BILL"/>
								<portlet:param name="param_auditSadadKey" value="${psb.billKey}"/>
								<portlet:param name="param_operation" value="callAuditService_ListAudit"/>
							</portlet:resourceURL>
							<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.audit" bundle="${bndlLang}"/>" onclick='doPostUrl("${audit4Bill}", 2);'/>
								
							<c:if test="${(psb.bills[psb.billKey].billType =='HIGHTOLL' || psb.bills[psb.billKey].billType =='RECURRING') && psb.bills[psb.billKey].billStatus == 'ACTIVE'}">							
							<portlet:resourceURL var="billCounerPartUrl">
								<portlet:param name="param_billerId" value="${psb.bills[psb.billKey].billerId}" />
								<portlet:param name="param_accountNumber" value="${psb.bills[psb.billKey].accountNumber}" />
								<portlet:param name="param_jsonObj" value="jsonObj" />
								<portlet:param name="param_showCounterFor" value="${psb.bills[psb.billKey].billType}"/>
								<portlet:param name="param_operation" value="callCustomised_ShowCounterPartBill" />
							</portlet:resourceURL>
							<input type="button" id="showCounterButton" class="button" value="<fmt:message key="ebpp.portlet.button.show-counter-part" bundle="${bndlLang}"/>" onclick="showCounterPartDetails('${billCounerPartUrl}');" />
							<input type="hidden" id="resetCounterPart" value="<portlet:resourceURL id="core_BillsDetails"/>"/>
							</c:if>
							<form method="post" action="<portlet:actionURL/>">
								<input type="hidden" name="fpWhereTo" id="fpWhereTo" value=""/>
								<input type="submit" class="button" onclick="navigate(this);" name="back" value="<fmt:message key="ebpp.portlet.button.back" bundle="${bndlLang}"/>"/>
								<input type="submit" class="button" onclick="navigate(this);" name="finish" value="<fmt:message key="ebpp.portlet.button.finish" bundle="${bndlLang}"/>"/>
							</form>
						</td>
					</tr>
				</tbody>
			</table>
		</td>
	</tr>
	</tbody>
</table>