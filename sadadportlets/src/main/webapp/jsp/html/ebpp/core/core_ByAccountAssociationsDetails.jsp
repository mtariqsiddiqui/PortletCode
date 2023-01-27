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
								<fmt:message key="ebpp.portlet.label.association-details" bundle="${bndlLang}" />
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
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.official-id-type" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.association[psb.associationKey].officialIdType}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.official-id-number" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.association[psb.associationKey].officialIdNumber}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.customer-status" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.association[psb.associationKey].customerStatus}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.association" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.association[psb.associationKey].associationType}</td>
														</tr>
														<!-- End: Data display fields -->
													</tbody>
												</table>
											</td>
											<td class="NewsColumnCell" style="width:33%; valign:top;">
												<table class="tableclass">
													<tbody>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.account-number" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.association[psb.associationKey].accountNumber}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.biller-name" bundle="${bndlLang}" /></th>
															<c:set var="billerId" value="${psb.association[psb.associationKey].billerId}"/>
															<td style="width: 25%;">${BillerList[billerId].partnerName}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.biller" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${psb.association[psb.associationKey].billerId}</td>
														</tr>
														<tr>
															<th style="width: 25%;"><fmt:message key="ebpp.portlet.label.assigning-organization" bundle="${bndlLang}" /></th>
															<td style="width: 25%;">${BillerList[psb.association[psb.associationKey].assigningOrganization].partnerName} ${BankList[psb.association[psb.associationKey].assigningOrganization].partnerName}</td>
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
								<portlet:resourceURL var="customerSummaryUrl" id="core_CustomerSummary">
									<portlet:param name="param_customerId" value="${psb.association[psb.associationKey].officialIdNumber}"/>
									<portlet:param name="param_customerIdType" value="${psb.association[psb.associationKey].officialIdType}"/>
									<portlet:param name="param_operation" value="callCustomerService_GetByKey"/>
								</portlet:resourceURL>
								<input type="button" class="button" onclick="doPostUrl('${customerSummaryUrl}', 2)" value="<fmt:message key="ebpp.portlet.button.customer" bundle="${bndlLang}" />" />
								
								<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.audit" bundle="${bndlLang}"/>" onclick='doPostUrl("<portlet:resourceURL id="core_AuditSummary"/>", 2);'/>
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