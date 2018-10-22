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
														<td style="width: 25%">${BillerList[psb.billerId].partnerName}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.account-number" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.bills[psb.billKey].accountNumber}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.bill-number" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.bills[psb.billKey].billNumber}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.bill-type" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.bills[psb.billKey].billType}</td>
													</tr>
													<!-- Begin: Data display fields -->
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.original-amount" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.bills[psb.billKey].origianlAmount}</td>
													</tr>
													<!-- End: Data display fields -->
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.due-date" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.bills[psb.billKey].dueDate}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.bill-generated-date" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.bills[psb.billKey].billGeneratedDate}</td>
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
														<td style="width: 25%">${psb.bills[psb.billKey].billCycle}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.status" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.bills[psb.billKey].billCycle}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.bill-category" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.bills[psb.billKey].billCategory}</td>
													</tr>
													<!-- Begin: Data display fields -->
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.net-amount" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.bills[psb.billKey].netAmount}</td>
													</tr>
													<!-- End: Data display fields -->
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.expiry-date" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.bills[psb.billKey].expiryDate}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.bill-creation-date" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.bills[psb.billKey].billCreateionDate}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="ebpp.portlet.label.no-of-payments" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.bills[psb.billKey].paymentCount}</td>
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
							<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.account" bundle="${bndlLang}"/>" onclick='doPostUrl("<portlet:resourceURL id="core_AccountSummary"/>", 2);'/>
							<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.payments" bundle="${bndlLang}"/>" onclick='doPostUrl("<portlet:resourceURL id="core_PaymentsSummary"/>", 2);'/>
							<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.list-business-rules" bundle="${bndlLang}"/>" onclick='doPostUrl("<portlet:resourceURL id="core_BusinessRulesSummary"/>", 2);' />
							<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.audit" bundle="${bndlLang}"/>" onclick='doPostUrl("<portlet:resourceURL id="core_AuditSummary"/>", 2);'/>
							<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.show-counter-part" bundle="${bndlLang}"/>" onclick='' />
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