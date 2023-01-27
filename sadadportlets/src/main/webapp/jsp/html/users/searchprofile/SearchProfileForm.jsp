<%@ page import="com.sadad.portal.common.utils.SadadOrganisationType4"%>
<% pageContext.setAttribute("organisationTypes", SadadOrganisationType4.values()); %>

<%@ page import="com.sadad.portal.common.utils.ProfileSearchCriterion"%>
<% pageContext.setAttribute("searchCriterion", ProfileSearchCriterion.values()); %>

<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmQueryUser" id="frmQueryUser" method="post" action="<portlet:resourceURL id="SearchProfileList" />">
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox">
					<fmt:message key="user.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" />
				</p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend>
						<fmt:message key="user.portlet.label.query-users" bundle="${bndlLang}" />
					</legend>
					<table style="width: 100%;">
						<tr>
							<td>
								<table class="dataEntryPageTable" style="width: 100%;">
									<tbody>
										<tr class="DataEntryFieldRow">
											<td class="labelCell" width="200px" valign="top" nowrap height="27">
												<label class="label" for="cmbOrgType">
													<fmt:message key="user.portlet.label.organisation-type" bundle="${bndlLang}" /> *
												</label>
											</td>
											<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
												<select name="param_organisationType" class="rqf" id="cmbOrgType" onchange="onChangePartnerType(this.value);"
												<c:out value="${psb.partnerType != 'sadad' ? 'disabled' : ''}" />>
												<c:forEach items="${organisationTypes}" var="org">
													<option <c:if test="${ psb.partnerType == org.value || org.value == psb.partnerKey }">selected</c:if>
														value="${org.value}">${org.name}</option>
												</c:forEach>
												</select>
											</td>
										</tr>
										<tr class="DataEntryFieldRow">
											<td class="labelCell" width="200px" valign="top" nowrap height="27">
												<label id='lbl4Org' class="label" for="txtSadadId">
													<fmt:message key="user.portlet.label.organisation-name" bundle="${bndlLang}" /> *</label>
											</td>
											<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
												<input type="hidden" id="txtPartnerId" name="param_organisationId"/>
												<input type="text" id="txtSadadId" value="SADAD" readonly/>
												<c:if test="${psb.partnerType == 'biller' or psb.partnerType == 'sadad'}">
													<select class="outputData" id="cmbBillerId" style="display: none;" onchange="partnerKeyChange(this.value);">
														<c:choose>
															<c:when test="${psb.partnerType == 'biller'}">
																<option selected value="<c:out value='${psb.partnerKey}' />">
																	<c:out value="${BillerList[psb.partnerKey].partnerName}" />
																</option>
															</c:when>
															<c:otherwise>
																<option value="">
																	<fmt:message key="user.portlet.label.please-select" bundle="${bndlLang}" />
																</option>
																<c:forEach items="${BillerList}" var="biller">
																	<option value="<c:out value="${biller.value.partnerKey}"/>" <c:if test="${biller.value.partnerKey == psb.partnerKey}">selected</c:if>>
																		<c:out value="${biller.value.partnerName}" />
																	</option>
																</c:forEach>
															</c:otherwise>
														</c:choose>
													</select>
												</c:if>
												<c:if test="${psb.partnerType == 'bank' or psb.partnerType == 'sadad'}">
													<select class="outputData" id="cmbBankId" style="display: none;" onchange="partnerKeyChange(this.value);">
														<c:choose>
															<c:when test="${psb.partnerType == 'bank' }">
																<option selected value="<c:out value='${psb.partnerKey}' />">
																	<c:out value="${BankList[psb.partnerKey].partnerName}" />
																</option>
															</c:when>
															<c:otherwise>
																<option value="">
																	<fmt:message key="user.portlet.label.please-select" bundle="${bndlLang}" />
																</option>
																<c:forEach items="${BankList}" var="bank">
																	<option value="<c:out value="${bank.value.partnerKey}"/>" <c:if test="${bank.value.partnerKey == psb.partnerKey}">selected</c:if>>
																	<c:out value="${bank.value.partnerName}" />
																	</option>
																</c:forEach>
															</c:otherwise>
														</c:choose>
													</select>
												</c:if>
												<c:if test="${psb.partnerType == 'aggregator' or psb.partnerType == 'sadad'}">
													<select class="outputData" id="cmbAggregatorId" style="display: none;" onchange="partnerKeyChange(this.value);">
														<c:choose>
															<c:when test="${psb.partnerType == 'aggregator' }">
																<option selected value="<c:out value='${psb.partnerKey}' />">
																	<c:out value="${AggregatorList[psb.partnerKey].partnerName}" />
																</option>
															</c:when>
															<c:otherwise>
																<option value="">
																	<fmt:message key="user.portlet.label.please-select" bundle="${bndlLang}" />
																</option>
																<c:forEach items="${AggregatorList}" var="agg">
																	<option value="<c:out value="${agg.value.partnerKey}"/>" <c:if test="${agg.value.partnerKey == psb.partnerKey}">selected</c:if>>
																	<c:out value="${agg.value.partnerName}" />
																	</option>
																</c:forEach>
															</c:otherwise>
														</c:choose>
													</select>
												</c:if>
												<c:if test="${psb.partnerType == 'sadad'}">
													<button id="callSrchEngnBtn" type="button" onclick="#">
														<img src="/static/images/search.png" height="12px" width="12px">
													</button>
												</c:if>
											</td>
										</tr>
										<tr class="DataEntryFieldRow">
											<td class="labelCell" width="200px" valign="top" nowrap height="27">
												<label class="label" for="cmbSearchCriterion">
													<fmt:message key="user.portlet.label.search-by" bundle="${bndlLang}" /> *
												</label>
											</td>
											<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
												<select class="rqf" id="cmbSearchCriterion" name="param_searchCriteria" style="display: inline;">
													<%-- <option value="">
														<fmt:message key="user.portlet.label.please-select" bundle="${bndlLang}" />
													</option> --%>
													<c:forEach items="${searchCriterion}" var="criteria">
														<option value="${criteria.value}" <c:if test="${criteria.value == psb.searchCriteria}">selected</c:if>>
															${criteria.name}
														</option>
													</c:forEach>
												</select>
											</td>
										</tr>
										<tr class="DataEntryFieldRow">
											<td class="labelCell" width="200px" valign="top" nowrap height="27">
												<label class="label" for="txtSearchKeyword">
													<fmt:message key="user.portlet.label.search-keyword" bundle="${bndlLang}" /> *
												</label>
											</td>
											<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
												<input name="param_searchKeyword" class="rqf" value="*" id="txtSearchKeyword" type="text" autocomplete="off" maxlength="35" />
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<input type="hidden" name="param_request" value="yes" />
								<input type="hidden" name="param_operation" value="retrieveUsersList" />
								<input class='button' value='<fmt:message key="user.portlet.button.search" bundle="${bndlLang}"/>' onclick="setValuesForSubmission(doQueryFormSubmission);" type="submit"/>
								<portlet:resourceURL id="SearchProfileForm" var="clearURL"><portlet:param name="param_operation" value="clearSessionBeanObject"/></portlet:resourceURL>
								<input class='button' value='<fmt:message key="user.portlet.button.reset" bundle="${bndlLang}"/>' onclick="doQueryFormReset('${clearURL}');" type="button"/>
							</td>
						</tr>
					</table>
				</fieldset>
			</td>
		</tr>
	</tbody>
</table>
</form>