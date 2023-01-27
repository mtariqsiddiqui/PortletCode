<jsp:directive.include file="../../common/JspDeclarations.jspf" />

<table style="width: 100%">
	<tbody>
		<tr>
			<td class="myCaption"><fmt:message key="ebpp.portlet.label.payments-details" bundle="${bndlLang}"/></td>
		</tr>
		<tr>
			<td>
				<table style="width: 100%">
					<!-- Begin: Data display fields -->
					<tbody>
						<tr>
							<td colspan="4" height="25"><fmt:message key="ebpp.portlet.label.transaction-information" bundle="${bndlLang}"/></td>
						</tr>
						<tr class="NewsColumnWrapper">
							<td class="NewsColumnCell" style="width: 33%;" valign="top">
								<!-- Begin: Data display fields -->
								<table class="tableclass">
									<tbody>
										<tr>
											<th style="width: 25%">
											<fmt:message key="ebpp.portlet.label.sadad-number" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].sadadNumber}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.reversal-number" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].reversalNumber}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.biller-transaction-number" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].billerTransactionNumber}</td>
										</tr>
										<!-- End: Data display fields -->
									</tbody>
								</table>
							</td>
							<td class="NewsColumnCell" style="width: 33%;" valign="top">
								<!-- Begin: Data display fields -->
								<table class="tableclass">
									<tbody>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.bank-number" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].bankNumber}</td>
										</tr>
										<tr>
											<th style="width: 25%"> <fmt:message key="ebpp.portlet.label.group-number" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].groupNumber}</td>
										</tr>
										<!-- End: Data display fields -->
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="4" height="25"><fmt:message key="ebpp.portlet.label.bill-information" bundle="${bndlLang}"/></td>
						</tr>
						<tr class="NewsColumnWrapper">
							<td class="NewsColumnCell" style="width: 33%;" valign="top">
								<!-- Begin: Data display fields -->
								<table class="tableclass">
									<tbody>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.biller-name" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${BillerList[psb.payments[psb.paymentKey].billerId].partnerName}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.bill-number" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].billNumber}</td>
										</tr>
										<!-- End: Data display fields -->
									</tbody>
								</table>
							</td>
							<td class="NewsColumnCell" style="width: 33%;" valign="top">
								<!-- Begin: Data display fields -->
								<table class="tableclass">
									<tbody>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.account-number" bundle="${bndlLang}"/></th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].accountNumber}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.bill-cycle" bundle="${bndlLang}"/></th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].billCycle}</td>
										</tr>
										<!-- End: Data display fields -->
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="4" height="25"><fmt:message key="ebpp.portlet.label.payment-information" bundle="${bndlLang}"/></td>
						</tr>
						<tr class="NewsColumnWrapper">
							<td class="NewsColumnCell" style="width: 33%;" valign="top">
								<!-- Begin: Data display fields -->
								<table class="tableclass">
									<tbody>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.bank-name" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${BankList[psb.payments[psb.paymentKey].bankId].partnerName}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.amount" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].amount}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.branch-code" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].branchCode}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.payment-method" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].paymentMethod}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.processing-date" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].processingDate}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.district-code" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].districtCode}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.payment-status" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].paymentStatus}</td>
										</tr>
										<!-- End: Data display fields -->
									</tbody>
								</table>
							</td>
							<td class="NewsColumnCell" style="width: 33%;" valign="top">
								<!-- Begin: Data display fields -->

								<table class="tableclass">
									<tbody>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.access-channel" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].accessChannel}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.check-digit" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].checkDigit}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.payment-type" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].paymentType}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.service-id" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].serviceId}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.beneficiary-id" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].beneficiaryId}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.customer-id" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].customerId}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="ebpp.portlet.label.refund-id" bundle="${bndlLang}"/>
											</th>
											<td style="width: 25%">${psb.payments[psb.paymentKey].refundId}</td>
										</tr>
										<!-- End: Data display fields -->
									</tbody>
								</table>
							</td>
						</tr>
						<!-- End: Data display fields -->
						<!-- End: PageContentsContainer -->
					</tbody>
				</table>
			</td>
		</tr>
		<!-- Buttons Group -->
		<tr>
			<td>
				<portlet:resourceURL id="core_BillsSummary" var="billSummaryUrl">
					<portlet:param name="param_paymentId" value="${psb.paymentKey}"/>
					<portlet:param name="param_billerId" value="${psb.payments[psb.paymentKey].billerId}"/>
					<portlet:param name="param_operation" value="callBillService_ListByPayment"/>
				</portlet:resourceURL>
				<input type="button" class="button" value='<fmt:message key="ebpp.portlet.button.bills" bundle="${bndlLang}"/>' onclick='doPostUrl("${billSummaryUrl}", 2);' />

				<portlet:resourceURL id="core_AccountSummary" var="accountSummaryUrl">
					<portlet:param name="param_accountNumber" value="${psb.payments[psb.paymentKey].accountNumber}"/>
					<c:if test="${empty psb.payments[psb.paymentKey].accountNumber}">
						<portlet:param name="param_accountNumber" value="ACCOUNT_KEY_NONE"/>
					</c:if>
					<portlet:param name="param_billerId" value="${psb.payments[psb.paymentKey].billerId}"/>
					<portlet:param name="param_operation" value="callAccountService_ListByKeys"/>
				</portlet:resourceURL>								 
				<input type="button" class="button" value='<fmt:message key="ebpp.portlet.button.account" bundle="${bndlLang}"/>' onclick='doPostUrl("${accountSummaryUrl}", 2);' />
				
				<input type="button" class="button" value='<fmt:message key="ebpp.portlet.button.list-business-rules" bundle="${bndlLang}"/>' onclick='doPostUrl("<portlet:resourceURL id="core_BusinessRulesSummary"/>", 2);' />
				
				<portlet:resourceURL id="core_SplSummary" var="splSummaryUrl">
					<portlet:param name="param_paymentId" value="${psb.payments[psb.paymentKey].sadadNumber}"/>
					<portlet:param name="param_operation" value="callPaymentService_ListSPLPayments"/>
				</portlet:resourceURL>
				<input type="button" class="button" value='<fmt:message key="ebpp.portlet.button.list-spl-payments" bundle="${bndlLang}"/>' onclick='doPostUrl("${splSummaryUrl}", 2);'/>
				
				<portlet:resourceURL id="core_AuditSummary" var="audit4Payment">
					<portlet:param name="param_auditEntity" value="PAYMENT"/>
					<portlet:param name="param_auditSadadKey" value="${psb.payments[psb.paymentKey].sadadNumber}"/>
					<portlet:param name="param_operation" value="callAuditService_ListAudit"/>
				</portlet:resourceURL>
				<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.audit" bundle="${bndlLang}"/>" onclick='doPostUrl("${audit4Payment}", 2);'/>				
				
				<form method="post" action="<portlet:actionURL/>">
					<input type="hidden" name="fpWhereTo" id="fpWhereTo" value=""/>
					<input type="submit" class="button" onclick="navigate(this);" name="back" value="<fmt:message key="ebpp.portlet.button.back" bundle="${bndlLang}"/>"/>
					<input type="submit" class="button" onclick="navigate(this);" name="finish" value="<fmt:message key="ebpp.portlet.button.finish" bundle="${bndlLang}"/>"/>
				</form>								
			</td>
		</tr>
	</tbody>
</table>