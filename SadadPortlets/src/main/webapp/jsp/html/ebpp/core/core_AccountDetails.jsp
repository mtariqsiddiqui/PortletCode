<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<!-- Main Table -->
	<table style="width: 100%">
		<tbody>
			<tr>
				<td>
					<table style="width: 100%">
						<tbody>
							<tr>
								<td class="myCaption"><fmt:message key="ebpp.portlet.label.account-details" bundle="${bndlLang}" /></td>
							</tr>
							<tr>
								<td>
										<table  style="width: 100%">
											<!-- Begin: Data display fields -->
											<tbody>
												<tr class="NewsColumnWrapper">
													<td 
														class="NewsColumnCell" style="width: 33%" valign="top">
														<!-- Begin: Data display fields -->													
													<table class="tableclass">
															<tbody>
																<tr >
																	<th style="width: 25%">
																	<fmt:message key="ebpp.portlet.label.biller-name" bundle="${bndlLang}" /></th>
																	<td style="width: 25%">${BillerList[psb.partnerKey].partnerName}</td>
																</tr>

																<tr >
																	<th style="width: 25%"><fmt:message key="ebpp.portlet.label.biller" bundle="${bndlLang}" /></th>
																	<td style="width: 25%">${psb.partnerKey}</td>
																</tr>

																<tr >
																<th style="width: 25%"><fmt:message key="ebpp.portlet.label.status" bundle="${bndlLang}" /></th>
																	<td style="width: 25%">${psb.account.lifecycle}</td>																	
																</tr>
																<!-- End: Data display fields -->
															</tbody>
														</table></td>
													<td class="NewsColumnCell" style="width: 33%" valign="top">
													<!-- Begin: Data display fields -->
													<table class="tableclass">
															<tbody>
																<tr >
																	<th style="width: 25%"><fmt:message key="ebpp.portlet.label.service-type" bundle="${bndlLang}" /></th>
																	<td style="width: 25%">${psb.account.serviceType}</td>
																</tr>

																<tr >
																	<th style="width: 25%"><fmt:message key="ebpp.portlet.label.account-number" bundle="${bndlLang}" /></th>
																	<td style="width: 25%">${psb.account.accountNumber}</td>
																</tr>
																<!-- End: Data display fields -->
															</tbody>
														</table></td>
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
									
									<input type="button" class="button" onclick="doPostUrl('<portlet:resourceURL id="core_BillerSummary"/>', 2);" value="<fmt:message key="ebpp.portlet.label.biller" bundle="${bndlLang}"/>" />
									<input type="button" class="button" onclick="doPostUrl('<portlet:resourceURL id="core_AssociationsSummary"/>', 2);" value="<fmt:message key="ebpp.portlet.button.list-associations" bundle="${bndlLang}"/>"/>
									<portlet:resourceURL var="listBillByAccount" id="core_BillsSummary">
										<portlet:param name="txtPartnerKey" value="${psb.partnerKey}"/>
										<portlet:param name="txtAccountKey" value="${psb.account.accountNumber}"/>
									</portlet:resourceURL>
									<input type="button" class="button" onclick="doPostUrl('${listBillByAccount}', 2);" value="<fmt:message key="ebpp.portlet.button.bills" bundle="${bndlLang}"/>"/>

									<portlet:resourceURL var="listPaymentsByAccount" id="core_PaymentsSummary">
										<portlet:param name="txtPartnerKey" value="${psb.partnerKey}"/>
										<portlet:param name="txtAccountKey" value="${psb.account.accountNumber}"/>
									</portlet:resourceURL>									
									<input type="button" class="button" onclick="doPostUrl('${listPaymentsByAccount}', 2);" value="<fmt:message key="ebpp.portlet.button.payments" bundle="${bndlLang}"/>"/>
									<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.audit" bundle="${bndlLang}"/>" onclick='doPostUrl("<portlet:resourceURL id="core_AuditSummary"/>", 2);'/>
									<form method="post" action="<portlet:actionURL/>">
										<input type="hidden" name="fpWhereTo" id="fpWhereTo" value="" />
										<input type="submit" class="button" onclick="navigate(this);" name="back" value="<fmt:message key="ebpp.portlet.button.back" bundle="${bndlLang}"/>"/>
										<input type="submit" class="button" onclick="navigate(this);" name="finish" value="<fmt:message key="ebpp.portlet.button.finish" bundle="${bndlLang}"/>"/>
									</form>									
								</td>
							</tr>
							<!-- END Buttons Group -->
						</tbody>
					</table>
					<!-- END Details Segment --></td>
			</tr>
			<!-- End Form/Details container -->			
		</tbody>
	</table>
	<!-- END Main Table -->