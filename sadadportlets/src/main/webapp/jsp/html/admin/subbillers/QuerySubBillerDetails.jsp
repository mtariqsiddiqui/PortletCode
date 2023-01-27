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
								<fmt:message key="subbiller.portlet.label.subbiller-details" bundle="${bndlLang}" />
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
															<th style="width: 25%"><fmt:message key="subbiller.portlet.label.subbiller-id" bundle="${bndlLang}" /></th>
															<td style="width: 25%">${psb.selectedSubBiller.billerId}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="subbiller.portlet.label.legal-name-english" bundle="${bndlLang}" /></th>
															<td style="width: 25%">${psb.selectedSubBiller.billerNameEnglish}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="subbiller.portlet.label.legal-id-type" bundle="${bndlLang}" /></th>
															<td style="width: 25%">${psb.selectedSubBiller.legalIdType}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="subbiller.portlet.label.bank-name" bundle="${bndlLang}" /></th>
															<td style="width: 25%">${BankList[psb.selectedSubBiller.billingAccountBankId].partnerName}</td>
														</tr>														
														<tr>
															<th style="width: 25%"><fmt:message key="subbiller.portlet.label.address" bundle="${bndlLang}" /></th>
															<td style="width: 25%">${psb.selectedSubBiller.address}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="subbiller.portlet.label.landline" bundle="${bndlLang}" /></th>
															<td style="width: 25%">${psb.selectedSubBiller.landline}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="subbiller.portlet.label.trade-license-expiry-date" bundle="${bndlLang}" /></th>
															<td style="width: 25%">${psb.selectedSubBiller.tradeLicenseExpiryDate}</td>
														</tr>
														<!-- End: Data display fields -->
													</tbody>
												</table>
											</td>
											<td class="NewsColumnCell" width="33%" valign="top">
												<table class="tableclass">
													<tbody>
														
														<tr>
															<th style="width: 25%"><fmt:message key="subbiller.portlet.label.short-name" bundle="${bndlLang}" /></th>
															<td style="width: 25%">${psb.selectedSubBiller.shortName}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="subbiller.portlet.label.legal-name-arabic" bundle="${bndlLang}" /></th>
															<td style="width: 25%">${psb.selectedSubBiller.billerNameArabic}</td>
														</tr>
														
														<tr>
															<th style="width: 25%"><fmt:message key="subbiller.portlet.label.legal-id-number" bundle="${bndlLang}" /></th>
															<td style="width: 25%">${psb.selectedSubBiller.legalIdNumber}</td>
														</tr>
														
														<tr>
															<th style="width: 25%"><fmt:message key="subbiller.portlet.label.iban-number" bundle="${bndlLang}" /></th>
															<td style="width: 25%">${psb.selectedSubBiller.ibanNumber}</td>
														</tr>
														
														<tr>
															<th style="width: 25%"><fmt:message key="subbiller.portlet.label.email-address" bundle="${bndlLang}" /></th>
															<td style="width: 25%">${psb.selectedSubBiller.email}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="subbiller.portlet.label.mobile" bundle="${bndlLang}" /></th>
															<td style="width: 25%">${psb.selectedSubBiller.mobile}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="subbiller.portlet.label.vat-number" bundle="${bndlLang}" /></th>
															<td style="width: 25%">${psb.selectedSubBiller.vatNumber}</td>
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
								<%-- Only ACTIVE Aggregator's SubBiller can be updated and CLOSED SubBiller can not be updated --%>
								<c:if test="${AggregatorList[psb.aggregatorId].partnerStatus eq PortalConstant.STATUS_ACTIVE and psb.selectedSubBiller.status ne PortalConstant.STATUS_CLOSED}">
								<input type="button" class="button"
									value="<fmt:message key="subbiller.portlet.button.update" bundle="${bndlLang}" />"
									onclick="doPostUrl('<portlet:resourceURL id="QuerySubBillerUpdateForm"/>', 1);" />
								<fmt:message var="btnStatusLabel" key="subbiller.portlet.button.deactivate" bundle="${bndlLang}" />
								<c:if test="${psb.selectedSubBiller.status == 'INACTIVE'}">
									<fmt:message var="btnStatusLabel" key="subbiller.portlet.button.activate" bundle="${bndlLang}" />								
								</c:if>
								<input type="button" class="button" value="${btnStatusLabel}"
									onclick="doPostUrl('<portlet:resourceURL id="QuerySubBillerToggleStatusForm"/>', 1);" />
								<portlet:resourceURL id="QuerySubBillerClosureForm" var="closeUrl">
									<portlet:param name="param_operation" value=""/>
								</portlet:resourceURL> 
								<input type="button" class="button" 
									value="<fmt:message key="subbiller.portlet.button.close" bundle="${bndlLang}" />" onclick="doPostUrl('${closeUrl}', 1);" />
								</c:if>
								<input type="button" class="button" 
									value="<fmt:message key="subbiller.portlet.button.audit" bundle="${bndlLang}" />" onclick="" />
								<form method="post" action='<portlet:actionURL/>'>
									<input type="hidden" name="fpWhereTo" id="fpWhereTo" value=""/>
									<input type="submit" class="button" onclick="navigate(this);" name="finish" value="<fmt:message key="subbiller.portlet.button.finish" bundle="${bndlLang}"/>" />
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