<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<!-- Main Table -->
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<table style="width: 100%">
					<tbody>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td></td>
						</tr>

					</tbody>
				</table>
			</td>
		</tr>
		<!--  Details container -->
		<tr>
			<td>
				<!-- Details Segment -->
				<table style="width: 100%">
					<tbody>
						<tr>
							<td class="myCaption">
								<fmt:message key="payment-type.portlet.label.payment-type-details" bundle="${bndlLang}" />
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
															<th style="width: 25%"><fmt:message key="payment-type.portlet.label.is-prepaid" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${psb.selectedPaymentType.prepaid}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="payment-type.portlet.label.can-reverse" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${psb.selectedPaymentType.canReverse}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="payment-type.portlet.label.status" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${psb.selectedPaymentType.status}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="payment-type.portlet.label.biller-name" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${BillerList[psb.partnerKey].partnerName}</td>
														</tr>
														<!-- End: Data display fields -->
													</tbody>
												</table>
											</td>
											<td class="NewsColumnCell" width="33%" valign="top">
												<table class="tableclass">
													<tbody>
														<tr>
															<th style="width: 25%"><fmt:message key="payment-type.portlet.label.payment-type" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${psb.selectedPaymentType.paymentType}</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="payment-type.portlet.label.is-default" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${psb.selectedPaymentType.asDefault}</td>
															
														</tr>
														
														<tr>
															<th style="width: 25%"><fmt:message key="payment-type.portlet.label.time-limit" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${psb.selectedPaymentType.timeLimit}</td>
														</tr>
														
														<tr>
															<th style="width: 25%"><fmt:message key="payment-type.portlet.label.access-channel" bundle="${bndlLang}" />:</th>
															<td style="width: 25%">${psb.selectedPaymentType.accessChannel}</td>
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
									value="<fmt:message key="payment-type.portlet.button.update" bundle="${bndlLang}" />"
									onclick="doPostUrl('<portlet:resourceURL id="QueryPaymentTypeUpdateForm"/>', 1);" />
								<fmt:message var="btnStatusLabel" key="payment-type.portlet.button.deactivate" bundle="${bndlLang}" />
								<c:if test="${psb.selectedPaymentType.status == 'INACTIVE'}">
									<fmt:message var="btnStatusLabel" key="payment-type.portlet.button.activate" bundle="${bndlLang}" />								
								</c:if>
								<portlet:resourceURL id="QueryPaymentTypeDetails" var="toggleStatusUrl">
									<portlet:param name="reqAction" value="toggleStatus"/>
								</portlet:resourceURL>
								<input type="button" class="button" value="${btnStatusLabel}"
									onclick="doPostUrl('${toggleStatusUrl}', 1);" /> 
								<input type="button" class="button" 
									value="<fmt:message key="payment-type.portlet.button.audit" bundle="${bndlLang}" />" onclick="" />
								<form method="post" action='<portlet:actionURL/>'>
									<input type="hidden" name="fpWhereTo" id="fpWhereTo" value=""/>
									<input type="submit" class="button" onclick="navigate(this);" name="finish" value="<fmt:message key="payment-type.portlet.button.finish" bundle="${bndlLang}"/>" />
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