<%@ page import="com.sadad.scm.common._1.PartyIdTypeType"%>
<% pageContext.setAttribute("partyIdTypeType", PartyIdTypeType.values()); %>

<jsp:directive.include file="../../common/JspDeclarations.jspf" />

<form name="frmQueryCustomer" id="frmQueryCustomer" method="post" action="<portlet:resourceURL id="core_CustomerSummary"/>">
	<table style="width: 100%">
		<!-- Form or Details container -->
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
							<tr>
								<td>
									<p class="attnbox"><fmt:message key="ebpp.portlet.marked-fields-are-mandatory" bundle="${bndlLang}"/></p>
								</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td>
				<!-- Query Segment -->
					<fieldset>
						<legend>
							<fmt:message key="ebpp.portlet.label.search-for-customer" bundle="${bndlLang}"/>
							
						</legend>
						<table>
							<tbody>
								<tr>
									<td class="myCaption"></td>
								</tr>
								<tr>
									<td>
										<table  style="width: 100%">
											<!-- Begin: Data entry fields -->
											<tbody>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="cmbOfficialIdType">
															<fmt:message key="ebpp.portlet.label.official-id-type" bundle="${bndlLang}"/>&nbsp;:&nbsp;*
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<select name="txtOfficialIdType" class="outputData" required="true" id="cmbOfficialIdType">
															<option value="">
																<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
															</option>
															<c:forEach items="${partyIdTypeType}" var="idType">
																<option <c:if test="${psb.customer.officialIdType == idType}">selected</c:if> 
																	value="${idType}">${idType}</option>
															</c:forEach>
														</select>
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtAccountNumber">
															<fmt:message key="ebpp.portlet.label.official-id-number" bundle="${bndlLang}"/>&nbsp;:&nbsp;*
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input name="txtAccountNumber" class="outputData" value="${psb.customer.officialIdNumber}" required="true" id="txtAccountNumber" autocomplete="off" maxlength="256" type="text">
													</td>
												</tr>
												<!-- End: Data entry fields -->
											</tbody>
										</table>										
									</td>
								</tr>
								<!-- Buttons Group -->
								<tr>
									<td>
										<input type="submit" class="button" value="<fmt:message key="ebpp.portlet.button.submit" bundle="${bndlLang}"/>" onclick="doQueryFormSubmission('frmQueryCustomer');" />
										<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.clear" bundle="${bndlLang}"/>" onclick="doQueryFormReset();" />
									</td>
								</tr>
							</tbody>
						</table>
					</fieldset>
					<!-- END Query Segment --></td>
			</tr>
			<!-- End Form/Details container -->
			<!-- List Container -->
			<tr>
				<td></td>
			</tr>
			<!-- END List Container -->
		</tbody>
	</table>
	<!-- END Main Table -->
</form>