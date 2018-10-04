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
								<fmt:message key="ebpp.portlet.label.customer-details" bundle="${bndlLang}"/>
							</td>
						</tr>
						<tr>
							<td><table style="width: 100%">
									<tbody>
										<tr class="NewsColumnWrapper">
											<td class="NewsColumnCell" style="width:33%; valign:top;">
												<!-- Begin: Data display fields -->
												<table class="tableclass">
													<tbody>
														<tr>
															<th style="width: 25%"><fmt:message key="ebpp.portlet.label.official-id-number" bundle="${bndlLang}"/></th>
															<td style="width: 25%">${psb.customer.officialIdNumber}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="ebpp.portlet.label.official-id-type" bundle="${bndlLang}"/></th>
															<td style="width: 25%">${psb.customer.officialIdType}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="ebpp.portlet.label.status" bundle="${bndlLang}"/></th>
															<td style="width: 25%">${psb.customer.customerStatus}</td>
														</tr>
														<!-- End: Data display fields -->
													</tbody>
												</table>
											</td>
										</tr>
										<!-- End: PageContentsContainer -->
									</tbody>
								</table></td>
						</tr>
						<!-- Buttons Group -->
						<tr>
							<td>
								<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.list-associations" bundle="${bndlLang}"/>"  onclick='doPostUrl("<portlet:resourceURL id="core_AssociationsSummary"/>", 2);'/>
								<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.list-active-bills" bundle="${bndlLang}"/>" onclick='doPostUrl("<portlet:resourceURL id="core_BillsSummary"/>", 2);'/>
								<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.list-inactive-bills" bundle="${bndlLang}"/>" onclick='doPostUrl("<portlet:resourceURL id="core_BillsSummary"/>", 2);'/>
								<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.list-moi-payments" bundle="${bndlLang}"/>" onclick='doPostUrl("<portlet:resourceURL id="core_PaymentsSummary"/>", 2);'/><br>
								<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.list-refunds" bundle="${bndlLang}"/>" onclick='#' />
								<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.list-incomplete-payments" bundle="${bndlLang}"/>" onclick='doPostUrl("<portlet:resourceURL id="core_PaymentsSummary"/>", 2);'/>
								<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.deactivate" bundle="${bndlLang}"/>" onclick="doPost" />
								<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.audit" bundle="${bndlLang}"/>" onclick='doPostUrl("<portlet:resourceURL id="core_AuditSummary"/>", 2);'/>
								<form method="post" action="<portlet:actionURL/>">
									<input type="hidden" name="fpWhereTo" id="fpWhereTo" value=""/>
									<input type="submit" class="button" onclick="navigate(this);" name="back" value="<fmt:message key="ebpp.portlet.button.back" bundle="${bndlLang}"/>"/>
									<input type="submit" class="button" onclick="navigate(this);" name="finish" value="<fmt:message key="ebpp.portlet.button.finish" bundle="${bndlLang}"/>"/>
								</form>
							</td>
						</tr>
						<!-- END Buttons Group -->
					</tbody>
				</table> <!-- END Details Segment --></td>
		</tr>
		<!-- End Form/Details container -->
	</tbody>
</table>