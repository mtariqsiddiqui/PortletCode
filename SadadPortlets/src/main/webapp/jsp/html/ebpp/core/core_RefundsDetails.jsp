<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<!-- Form or Details container -->
		<tr>
			<td>
				<!-- Details Segment -->
				<table style="width: 100%">
					<tbody>
						<tr>
							<td class="myCaption">
								<fmt:message key="ebpp.portlet.label.refunds-details" bundle="${bndlLang}" />
							</td>
						</tr>
						<tr>
							<td>
								<table style="width: 100%">
									<tbody>
										<tr class="NewsColumnWrapper">
											<td class="NewsColumnCell" style="width: 33%;" valign="top">
												<!-- Begin: Data display fields -->
												<table class="tableclass">
													<tbody>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.refund-id" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.refunds[psb.refundKey].refundId}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.bank-id" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.refunds[psb.refundKey].bankId}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.biller-id" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.refunds[psb.refundKey].billerId}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.customer" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.refunds[psb.refundKey].customerId}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.refund-type" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.refunds[psb.refundKey].refundType}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.notification-status" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.refunds[psb.refundKey].notificationStatus}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.expiry-date" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.refunds[psb.refundKey].expiryDate}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.refund-transaction-number" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.refunds[psb.refundKey].refundTransactionNumber}</td>
														</tr>
														
														<!-- End: Data display fields -->
													</tbody>
												</table>
											</td>
											<td class="NewsColumnCell" style="width:33%; valign:top;">
												<table class="tableclass">
													<tbody>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.payment-sptn" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.refunds[psb.refundKey].paymentSptn}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.bank" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${BankList[psb.refunds[psb.refundKey].bankId].partnerName}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.biller" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${BillerList[psb.refunds[psb.refundKey].billerId].partnerName}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.customer-account-number" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.refunds[psb.refundKey].accountNumber}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.refund-status" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.refunds[psb.refundKey].refundStatus}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.amount" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.refunds[psb.refundKey].amount}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.reconciliation-status" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.refunds[psb.refundKey].reconStatus}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.service-id" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.refunds[psb.refundKey].serviceId}</td>
														</tr>
														
													</tbody>
												</table>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<!-- Buttons Group -->
						<tr>
							<td>
								<portlet:resourceURL id="core_PaymentsSummary" var="paymentSummaryUrl">
									<portlet:param name="param_paymentId" value="${psb.refunds[psb.refundKey].paymentSptn}"/>
									<portlet:param name="param_paymentIdType" value="SPTN"/>
									<portlet:param name="param_operation" value="callPaymentService_ListById"/>
								</portlet:resourceURL>
								<input type="button" class="button" onclick="doPostUrl('${paymentSummaryUrl}', 2)" value="<fmt:message key="ebpp.portlet.button.payments" bundle="${bndlLang}" />" <c:out value="${empty psb.refunds[psb.refundKey].paymentSptn ? 'disabled' : ''}" /> />
								
								<portlet:resourceURL id="core_AuditSummary" var="audit4Refund">
									<portlet:param name="param_auditEntity" value="REFUND"/>
									<portlet:param name="param_auditSadadKey" value="${psb.refunds[psb.refundKey].refundId}"/>
									<portlet:param name="param_operation" value="callAuditService_ListAudit"/>
								</portlet:resourceURL>
								<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.audit" bundle="${bndlLang}"/>" onclick='doPostUrl("${audit4Refund}", 2);'/>
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