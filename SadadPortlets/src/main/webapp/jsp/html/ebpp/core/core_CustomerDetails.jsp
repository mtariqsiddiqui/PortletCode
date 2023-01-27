<%@ page import="com.sadad.portal.constant.SadadDynamicDataConfiguration"%>
<% pageContext.setAttribute("moi_billers", SadadDynamicDataConfiguration.MOI_BILLERS); %>
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
								<portlet:resourceURL id="core_ByAccountsAssociationsSummaryList" var="associationsSummaryListAccountsUrl">
									<portlet:param name="param_customerId" value="${psb.customer.officialIdNumber}"/>
									<portlet:param name="param_customerIdType" value="${psb.customer.officialIdType}"/>
									<portlet:param name="param_operation" value="callAccountService_ListByCustomer"/>
								</portlet:resourceURL>
								<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.list-associations" bundle="${bndlLang}"/>" onclick='doPostUrl("${associationsSummaryListAccountsUrl}", 2);'/>
								
								<portlet:resourceURL id="core_BillsSummary" var="activeBillsSummaryUrl">
									<portlet:param name="param_customerId" value="${psb.customer.officialIdNumber}"/>
									<portlet:param name="param_customerIdType" value="${psb.customer.officialIdType}"/>
									<portlet:param name="param_status" value="ACTIVE"/>
									<portlet:param name="param_operation" value="callBillService_ListByCustomer"/>
								</portlet:resourceURL>
								<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.list-active-bills" bundle="${bndlLang}"/>" onclick='doPostUrl("${activeBillsSummaryUrl}", 2);'/>
								
								<portlet:resourceURL id="core_BillsSummary" var="inActiveBillsSummaryUrl">
									<portlet:param name="param_customerId" value="${psb.customer.officialIdNumber}"/>
									<portlet:param name="param_customerIdType" value="${psb.customer.officialIdType}"/>
									<portlet:param name="param_status" value="INACTIVE"/>
									<portlet:param name="param_operation" value="callBillService_ListByCustomer"/>
								</portlet:resourceURL>
								<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.list-inactive-bills" bundle="${bndlLang}"/>" onclick='doPostUrl("${inActiveBillsSummaryUrl}", 2);'/>

								<c:set var="blrMatch" value="0" scope="page"/>
								<c:if test="${psb.partnerType == 'bank' || psb.partnerType == 'sadad'}">
									<c:set var="blrMatch" value="${blrMatch + 1}" scope="page"/>
								</c:if>

								<c:if test="${psb.partnerType == 'biller'}">
									<c:forEach items="${moi_billers}" var="mblr">
										<c:if test="${psb.partnerKey == mblr}">
											<c:set var="blrMatch" value="${blrMatch + 1}" scope="page"/>
										</c:if>
									</c:forEach>
								</c:if>
								<c:if test="${blrMatch > 0}">
									<portlet:resourceURL var="moiPayments" id="core_PaymentsSummary">
										<portlet:param name="param_pageNumber" value="0"/>
										<portlet:param name="param_operation" value="callPaymentService_ListByPayor"/>
									</portlet:resourceURL>
									<input type='button' class='button' value='<fmt:message key="ebpp.portlet.button.list-moi-payments" bundle="${bndlLang}"/>' onclick='doPostUrl("${moiPayments}", 2);'/>
								</c:if>
								<br>
								<portlet:resourceURL var="customerRefunds" id="core_RefundSummary">
									<portlet:param name="param_customerId" value="${psb.customer.officialIdNumber}"/>
									<portlet:param name="param_customerIdType" value="${psb.customer.officialIdType}"/>
									<portlet:param name="param_operation" value="callRefundService_ListRefundPortal"/>
								</portlet:resourceURL>
								<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.list-refunds" bundle="${bndlLang}"/>" onclick='doPostUrl("${customerRefunds}", 2);' />
								<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.list-incomplete-payments" bundle="${bndlLang}"/>" onclick='doPostUrl("<portlet:resourceURL id="core_PaymentsSummary"/>", 2);'/>
								
								<c:if test="${psb.partnerType == 'sadad' && psb.userType == 'admin'}">
									<fmt:message var="btnStatusLabel" key="ebpp.portlet.button.deactivate" bundle="${bndlLang}" />
									<c:if test="${psb.customer.customerStatus == 'INACTIVE'}">
										<fmt:message var="btnStatusLabel" key="ebpp.portlet.button.activate" bundle="${bndlLang}" />
									</c:if>
									<portlet:resourceURL id="core_CustomerDetails" var="customerDetailsUrl">
										<portlet:param name="param_customerId" value="${psb.customer.officialIdNumber}"/>
										<portlet:param name="param_customerIdType" value="${psb.customer.officialIdType}"/>
										<portlet:param name="param_operation" value="callCustomerService_ActivateOrDeActivateCustomer"/>
									</portlet:resourceURL>
									<input type="button" class="button" value="${btnStatusLabel}" onclick="doPostUrl('${customerDetailsUrl}', 1);" />
								</c:if>
								
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