<%@ page import="com.sadad.portal.common.utils.SadadOrganisationType1"%>
<% pageContext.setAttribute("organisationTypes1", SadadOrganisationType1.values()); %>
<%@ page import="com.sadad.portal.common.utils.SadadOrganisationType5"%>
<% pageContext.setAttribute("organisationTypes5", SadadOrganisationType5.values()); %>

<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<script type="text/javascript"> var clearSecondContainer = JSON.parse('${psb.clearSecondContainer}');</script>
<form name="frmQueryRules" id="frmQueryRules" method="post" action="<portlet:resourceURL id="RulesConfigurationSummary" />">
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox">
					<fmt:message key="ebpp.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" />
				</p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend>
						<fmt:message key="ebpp.portlet.label.query-configurations" bundle="${bndlLang}" />
					</legend>
					<table style="width: 100%;">
						<tr>
							<td>
								<table class="dataEntryPageTable" style="width: 100%;">
									<tbody>
										<tr class="DataEntryFieldRow">
											<td class="labelCell" width="200px" valign="top" nowrap height="27">
												<label class="label" for="cmbOrgType">
													<fmt:message key="ebpp.portlet.label.organisation-type" bundle="${bndlLang}" /> *
												</label>
											</td>
											<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
												<c:if test="${psb.partnerType == 'sadad'}">
												<select class="rqf" name="param_organisationType" id="cmbOrgType" onchange="onChangePartnerType(this.value);">
													<c:forEach items="${organisationTypes5}" var="org">
														<option <c:if test="${psb.organisationType == org.value}">selected</c:if> value="${org.value}">${org.name}</option>
													</c:forEach>
												</select>
												</c:if>
												<c:if test="${psb.partnerType == 'aggregator'}">
													<select class="rqf" name="param_organisationType" id="cmbOrgType" onchange="onChangePartnerType(this.value);">
														<c:forEach items="${organisationTypes1}" var="org">
															<option <c:if test="${psb.organisationType == org.value}">selected</c:if> value="${org.value}">${org.name}</option>
														</c:forEach>
													</select>
												</c:if>
											</td>
										</tr>
										<tr class="DataEntryFieldRow">
											<td class="labelCell" width="200px" valign="top" nowrap height="27">
												<label id='lbl4Org' class="label" for="txtSadadId">
													<fmt:message key="ebpp.portlet.label.organisation-name" bundle="${bndlLang}" /> *</label>
											</td>
											<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
												<input type="hidden" id="txtPartnerId" name="param_partnerId"/>
												<input type="text" id="txtSadadId" value="SADAD" readonly/>
												<c:if test="${psb.partnerType == 'sadad'}">
													<!-- BILLER DROPDOWN -->
													<select class="outputData" id="cmbBillerId" style="display: none;" onchange="partnerKeyChange(this.value);">
														<option value="">
															<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}" />
														</option>
														<c:forEach items="${BillerOnlyList}" var="biller">
															<option value="<c:out value="${biller.value.partnerKey}"/>" <c:if test="${biller.value.partnerKey == psb.partnerId}">selected</c:if>>
																<c:out value="${biller.value.partnerName}" />
															</option>
														</c:forEach>
													</select>
													<!-- SUB BILLER DROPDOWN -->
													<select class="outputData" id="cmbSubBillerId" style="display: none;" onchange="partnerKeyChange(this.value);">
														<option value="">
															<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}" />
														</option>
														<c:forEach items="${SubBillerList}" var="biller">
															<option value="<c:out value="${biller.value.partnerKey}"/>" <c:if test="${biller.value.partnerKey == psb.partnerId}">selected</c:if>>
																<c:out value="${biller.value.partnerName}" />
															</option>
														</c:forEach>
													</select>
													<!-- BANK DROPDOWN -->
													<select class="outputData" id="cmbBankId" style="display: none;" onchange="partnerKeyChange(this.value);">
														<option value="">
															<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}" />
														</option>
														<c:forEach items="${BankList}" var="bank">
															<option value="<c:out value="${bank.value.partnerKey}"/>" <c:if test="${bank.value.partnerKey == psb.partnerId}">selected</c:if>>
																<c:out value="${bank.value.partnerName}" />
															</option>
														</c:forEach>
													</select>
													<!-- AGGREGATOR DROPDOWN -->
													<select class="outputData" id="cmbAggregatorId" style="display: none;" onchange="partnerKeyChange(this.value);">
														<option value="">
															<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}" />
														</option>
														<c:forEach items="${AggregatorList}" var="agg">
															<option value="<c:out value="${agg.value.partnerKey}"/>" <c:if test="${agg.value.partnerKey == psb.partnerId}">selected</c:if>>
																<c:out value="${agg.value.partnerName}" />
															</option>
														</c:forEach>
													</select>
													<button id="callSrchEngnBtn" type="button" onclick="#">
														<img src="/static/images/search.png" height="12px" width="12px">
													</button>
												</c:if>
												<c:if test="${psb.partnerType == 'aggregator'}">
													<input type="hidden" id="e2ebea05a11dbbx24" value="${psb.hashedPartnerKey}" />
													<select class="outputData" id="cmbSubBillerId" style="display: none;" onchange="partnerKeyChange(this.value);">
														<option value="">
															<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}" />
														</option>
														<c:forEach items="${AggregatorBillerList[psb.partnerKey]}" var="biller">
															<option <c:if test="${psb.partnerId == biller.value.partnerKey}">selected</c:if>
																value="<c:out value="${biller.value.partnerKey}" />">
																<c:out value="${biller.value.partnerName}" />
															</option>
														</c:forEach>
													</select>
													<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('cmbSubBillerId', 'a5e383e5e7a87a6844dd02fa04944c35&q1=${psb.hashedPartnerKey}');">
														<img src="/static/images/search.png" height="12px" width="12px">
													</button>
												</c:if>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<input type="hidden" name="param_configuraitonName" value="" />
								<input type="hidden" name="param_operation" value="callGetPartnerConfiguration" />
								<input class='button' value='<fmt:message key="ebpp.portlet.button.search" bundle="${bndlLang}"/>' onclick="setValuesForSubmission(doQueryFormSubmission);" type="submit"/>
								<portlet:resourceURL id="RulesConfigurationForm" var="clearURL"><portlet:param name="param_operation" value="clearSessionBeanObject"/></portlet:resourceURL>
								<input class='button' value='<fmt:message key="ebpp.portlet.button.reset" bundle="${bndlLang}"/>' onclick="doQueryFormReset('${clearURL}');" type="button"/>
							</td>
						</tr>
					</table>
				</fieldset>
			</td>
		</tr>
	</tbody>
</table>
</form>