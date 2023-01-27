<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<!-- Main Table -->
<table style="width: 100%">
	<tbody>
		<!--  Details container -->
		<tr>
			<td>
				<!-- Details Segment -->
				<table style="width: 100%">
					<tbody>
						<tr>
							<td class="myCaption">
								<fmt:message key="biller.portlet.label.biller-details" bundle="${bndlLang}" />
							</td>
						</tr>
						<tr>
							<td>
								<table style="width: 100%">
									<!-- Begin: Data display fields -->
									<tbody>
										<tr class="NewsColumnWrapper">
											<td class="NewsColumnCell" width="33%" valign="top">
												<table class="tableclass">
													<tbody>
														<tr>
															<th style="width: 25%"><fmt:message key="biller.portlet.label.biller-id" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${psb.partnerKey}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="biller.portlet.label.description" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${psb.selectedBiller.description}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="biller.portlet.label.account-bank-id" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${psb.selectedBiller.billingAccountBankId}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="biller.portlet.label.account-bank-name" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${BankList[psb.selectedBiller.billingAccountBankId].partnerName}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="biller.portlet.label.sadad-biller-account-number" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${psb.selectedBiller.billingAccountNumber}</td>
														</tr>														
														<!-- End: Data display fields -->
													</tbody>
												</table>
											</td>
											<td class="NewsColumnCell" width="33%" valign="top">
												<table class="tableclass">
													<tbody>
														<tr>
															<th style="width: 25%"><fmt:message key="biller.portlet.label.biller" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${BillerList[psb.partnerKey].partnerName}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="biller.portlet.label.status" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${psb.selectedBiller.status}</td>
															
														</tr>
														
														<tr>
															<th style="width: 25%"><fmt:message key="biller.portlet.label.biller-refund-bank-id" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${psb.selectedBiller.refundAccountBankId}</td>
														</tr>
														
														<tr>
															<th style="width: 25%"><fmt:message key="biller.portlet.label.biller-refund-bank-name" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${psb.selectedBiller.refundAccountBankId}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="biller.portlet.label.biller-refund-account" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${psb.selectedBiller.refundAccountNumber}</td>
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
								<input type="button" class="button"
									value="<fmt:message key="biller.portlet.button.update" bundle="${bndlLang}" />"
									onclick="doPostUrl('<portlet:resourceURL id="QueryBillerUpdateForm"/>', 1);" />
								<fmt:message var="btnStatusLabel" key="biller.portlet.button.deactivate" bundle="${bndlLang}" />
								<c:if test="${psb.selectedBiller.status == 'INACTIVE'}">
									<fmt:message var="btnStatusLabel" key="biller.portlet.button.activate" bundle="${bndlLang}" />								
								</c:if>
								<portlet:resourceURL id="QueryBillerDetails" var="toggleStatusUrl">
									<portlet:param name="reqAction" value="toggleStatus"/>
								</portlet:resourceURL>
								<input type="button" class="button" value="${btnStatusLabel}"
									onclick="doPostUrl('${toggleStatusUrl}', 1);" /> 
								<input type="button" class="button" 
									value="<fmt:message key="biller.portlet.button.audit" bundle="${bndlLang}" />" onclick="" />
								<form method="post" action='<portlet:actionURL/>'>
									<input type="hidden" name="fpWhereTo" id="fpWhereTo" value=""/>
									<input type="submit" class="button" onclick="navigate(this);" name="finish" value="<fmt:message key="biller.portlet.button.finish" bundle="${bndlLang}"/>" />
								</form>
							</td>
						</tr>
						<!-- END Buttons Group -->
					</tbody>
				</table> <!-- END Details Segment -->
			</td>
		</tr>
		<!-- End Details container -->
	</tbody>
</table>
<!-- END Main Table -->