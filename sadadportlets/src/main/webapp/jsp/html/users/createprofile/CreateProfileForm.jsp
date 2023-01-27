<%@ page import="com.sadad.portal.common.utils.SadadOrganisationType4"%>
<% pageContext.setAttribute("organisationTypes", SadadOrganisationType4.values()); %>
<%@ page import="com.sadad.portal.common.utils.PrefferedLanguage"%>
<% pageContext.setAttribute("prefLang", PrefferedLanguage.values());%>
<%@ page import="com.sadad.portal.common.utils.SaudiArabiaRegions"%>
<% pageContext.setAttribute("states", SaudiArabiaRegions.values());%>

<jsp:directive.include file="../../common/JspDeclarations.jspf" />

<script type="text/javascript">
	var _assignableGroups_Banks = ${psb.assignableGroups("bank")};
	var _assignableGroups_Billers = ${psb.assignableGroups("biller")};
	var _assignableGroups_Sadad = ${psb.assignableGroups("sadad")};
	var _assignableGroups_Aggregator = ${psb.assignableGroups("aggregator")};
</script>

<form name="frm_CreateUserProfile" id="frm_CreateUserProfile" method="post" action='<portlet:actionURL/>'>
	<table style="width: 100%">
		<!-- Form or Details container -->
		<tbody>
			<tr>
				<td><p class="attnbox"><fmt:message key="user.portlet.marked-fields-are-mandatory" bundle="${bndlLang}"/></p></td>
			</tr>
			<tr>
				<td>
					<fieldset>
						<legend>
							<fmt:message key="user.portlet.label.create-new-profile" bundle="${bndlLang}"/>							
						</legend>
						<table>
							<tbody>
								<tr>
									<td>
										<table  style="width: 100%">
											<!-- Begin: Data entry fields -->
											<tbody>
											<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="cmbOrgType"><fmt:message key="user.portlet.label.organisation-type" bundle="${bndlLang}" /> *</label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<select name="param_organisationType" class="rqf" id="cmbOrgType" onchange="onChangePartnerType(this.value);"
															<c:out value="${psb.partnerType != 'sadad' ? 'disabled' : ''}" />>
															<c:forEach items="${organisationTypes}" var="org">
																<option <c:if test="${ psb.partnerType == org.value || org.value == psb.partnerKey }">selected</c:if>
																	value="${org.value}">${org.name}</option>
															</c:forEach>
														</select>
													</td>
													<td style="padding: 30px;" rowspan=12></td>
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label id='lbl4Org' class="label" for="txtSadadId"><fmt:message key="user.portlet.label.organisation-name" bundle="${bndlLang}" /> *</label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input type="hidden" id="txtPartnerId" name="param_organisationId"/>
														<input type="hidden" id="txtPartnerName" name="param_organisationName"/>
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
																		<c:forEach items="${BillerOnlyList}" var="biller">
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
															<button id="callSrchEngnBtn" type="button" onclick="">
																<img src="/static/images/search.png" height="12px" width="12px">
															</button>
														</c:if>														
													</td>
												</tr>											
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtUserId">
															<fmt:message key="user.portlet.label.user-id" bundle="${bndlLang}" /> *
														</label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input type="text" value="${psb.userId}" name="param_userId" id="txtUserId" class="rqf cnr" maxlength="15" >
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<label class="label" for="cmbUserStatus">
															<fmt:message key="user.portlet.label.initial-status" bundle="${bndlLang}" /> *
														</label>													
													</td>
													<td>
														<select name="param_userStatus" id="cmbUserStatus" onchange="userStatusChange(this.value);">
															<option value="ACTIVE">ACTIVE</option>
															<option value="INACTIVE">INACTIVE</option>
														</select>
													</td>
												</tr>
												<tr class="DataEntryFieldRow" id="pswrd_Row">
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtInitPassword">
															<fmt:message key="user.portlet.label.initial-password" bundle="${bndlLang}" /> *
														</label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input type="password" value="" id="txtInitPassword"maxlength="50" name="param_password" class="rqf">														
													</td>
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtInitConfPassword">
															<fmt:message key="user.portlet.label.confirm-initial-password" bundle="${bndlLang}" /> *
														</label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input type="password" value="" id="txtInitConfPassword" maxlength="50" class="rqf">
														<input type="hidden" name="param_password"/>
													</td>
												</tr>												
												
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtFirstName">
															<fmt:message key="user.portlet.label.first-name" bundle="${bndlLang}" /> *</label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input name="param_firstName" value="${psb.firstName}" class="rqf chr" id="txtFirstName" maxlength="20" type="text">
													</td>
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtMiddleName">
															<fmt:message key="user.portlet.label.middle-name" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input type="text" class="chr" name="param_middleName" value="${psb.middleName}" id="txtMiddleName" class="chr" maxlength="20" >
													</td>
												</tr>
													<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtLastName"><fmt:message key="user.portlet.label.last-name" bundle="${bndlLang}" /> *</label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input type="text" name="param_lastName" value="${psb.lastName}" class="rqf chr" id="txtLastName" maxlength="20" >
													</td>
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap></td>
												</tr>												
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtJobTitle"><fmt:message key="user.portlet.label.job-title" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input type="text" name="param_jobTitle" value="${psb.jobTitle}" id="txtJobTitle" class="chs" maxlength="35">
													</td>
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtMobileNumber"><fmt:message key="user.portlet.label.mobile-number" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input type="text" class="mbp" name="param_mobileNumber" value="${psb.mobileNumber}" id="txtMobileNumber" maxlength="15">
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtPhoneNumber"><fmt:message key="user.portlet.label.phone-number" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input type="text" name="param_phoneNumber" value="${psb.phoneNumber}" id="txtPhoneNumber" placeholder="011ddddddd" class="nbr" maxlength="15">
														
													</td>
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtFaxNumber"><fmt:message key="user.portlet.label.fax-number" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input type="text" name="param_faxNumber" value="${psb.faxNumber}" id="txtFaxNumber" placeholder="011ddddddd" class="nbr" maxlength="15">
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtEmailAddress"><fmt:message key="user.portlet.label.email-address" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input type="text" name="param_emailAddress" value="${psb.emailAddress}" id="txtEmailAddress" class="eml" maxlength="65">
													</td>
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtAlternateEmailAddress"><fmt:message key="user.portlet.label.alternate-email-address" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input type="text" name="param_alternateEmailAddress" value="${psb.alternateEmailAddress}" id="txtAlternateEmailAddress" class="eml" maxlength="65">
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtOfficeAddress"><fmt:message key="user.portlet.label.office-address" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input type="text" name="param_officeAddress" value="${psb.officeAddress}" id="txtOfficeAddress" maxlength="200">
													</td>
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtCity"><fmt:message key="user.portlet.label.city" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input type="text" name="param_city" value="${psb.city}" id="txtCity" class="chr" maxlength="25">
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtZipCode"><fmt:message key="user.portlet.label.zip-code" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input type="text" name="param_zipCode" value="${psb.zipCode}"id="txtZipCode" class="nbr" maxlength="10">
													</td>
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtDistrict"><fmt:message key="user.portlet.label.district" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input type="text" name="param_district" value="${psb.district}" id="txtDistrict" class="chs" maxlength="10">
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtState"><fmt:message key="user.portlet.label.state" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<select id="cmbState" name="param_state" style="display: inline;">
															<option value=""><fmt:message key="user.portlet.label.please-select" bundle="${bndlLang}" /></option>
															<c:forEach items="${states}" var="state">
																<option value="${state.value}" <c:if test="${state.value == psb.state}">selected</c:if>>
																	${state.name}
																</option>
															</c:forEach>
														</select>
													</td>
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="txtCountry"><fmt:message key="user.portlet.label.country" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<input type="text" name="param_country" value="Saudi Arabia" id="txtCountry" readonly>
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="cmbPreferredLanguage"><fmt:message key="user.portlet.label.preferred-language" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<select class="outputData" id="cmbPreferredLanguage" name="param_preferredLanguage" style="display: inline;">
															<c:forEach items="${prefLang}" var="pLang">
																<option value="${pLang.value}" <c:if test="${pLang.value == psb.preferredLanguage}">selected</c:if>>
																	${pLang.name}
																</option>
															</c:forEach>
														</select>
													</td>
													<td class="labelCell" nowrap style="width:170px; vertical-align:top; height: 27;">
														<label class="label" for="slct_NewGroups"><fmt:message key="user.portlet.label.group-membership" bundle="${bndlLang}" /> *</label>
													</td>
													<td class="outputDataCell" style="width: auto; vertical-align:top" nowrap>
														<select class="rqf" id="slct_NewGroups" multiple style="font: 13px/1.231 verdana, arial, clean, sans-serif; height: auto; width: 200px;"
														required></select>
													</td>
												</tr>
											</tbody>
										</table>										
									</td>
								</tr>
								<!-- Buttons Group -->
								<tr>
									<td>
										<input type="hidden" name="param_request" value="yes" />
										<input type="hidden" name="param_newGroups" id="txtNewGroups" value="" />
										<%-- <c:if test="${psb.partnerType == 'bank'}"><input type="hidden" name="param_organisationType" value="32c7fcd2cd9c32b19841d743dc09d56f" /></c:if>
										<c:if test="${psb.partnerType == 'biller'}"><input type="hidden" name="param_organisationType" value="e13b5b1608ad566f94ba9fe7849aca38" /></c:if>
										<c:if test="${psb.partnerType == 'aggregator'}"><input type="hidden" name="param_organisationType" value="43e028dfdaab976ddd27cc17c457542f" /></c:if> --%>
										<input type="hidden" name="param_operation" value="createUserProfile" />
										<input type="button" class="button" value='<fmt:message key="user.portlet.button.save" bundle="${bndlLang}"/>' onclick='createUserProfile();' />
										<portlet:resourceURL id="CreateProfileForm" var="clearURL"><portlet:param name="param_operation" value="clearSessionBeanObject"/></portlet:resourceURL>
										<input type="button" class="button" value='<fmt:message key="user.portlet.button.cancel" bundle="${bndlLang}"/>' onclick="doQueryFormReset('${clearURL}');" />
									</td>
								</tr>
							</tbody>
						</table>
					</fieldset>
				</td>
			</tr>
		</tbody>
	</table>
</form>