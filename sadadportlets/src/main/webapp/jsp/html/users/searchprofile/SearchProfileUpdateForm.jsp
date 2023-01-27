<%@ page import="com.sadad.portal.common.utils.PrefferedLanguage"%>
<%@ page import="com.sadad.portal.common.utils.SaudiArabiaRegions"%>
<% pageContext.setAttribute("prefLang", PrefferedLanguage.values());%>
<% pageContext.setAttribute("states", SaudiArabiaRegions.values());%>

<jsp:directive.include file="../../common/JspDeclarations.jspf" />

<form name="frm_EditUserProfile" id="frm_EditUserProfile" method="post" action='<portlet:actionURL/>'>
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
							<fmt:message key="user.portlet.label.edit-my-profile" bundle="${bndlLang}"/>							
						</legend>
						<table>
							<tbody>
								<tr>
									<td>
										<table  style="width: 100%">
											<!-- Begin: Data entry fields -->
											<tbody>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtUserId">
															<fmt:message key="user.portlet.label.user-id" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input type="text" value="${psb.users[psb.userKey].userId}" readonly id="txtUserId" class="rqf cnr" maxlength="15">
													</td>
													<td style="padding: 30px;" rowspan="11"></td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap></td>
													<td></td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtFirstName">
															<fmt:message key="user.portlet.label.first-name" bundle="${bndlLang}" /> *
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input type="text" name="param_firstName" value="${psb.users[psb.userKey].firstName}" id="txtFirstName" class="rqf chr" maxlength="20">
													</td>
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtMiddleName">
															<fmt:message key="user.portlet.label.middle-name" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input type="text" name="param_middleName" value="${psb.users[psb.userKey].middleName}" id="txtMiddleName" class="chr" maxlength="20">
													</td>
												</tr>
													<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtLastName"><fmt:message key="user.portlet.label.last-name" bundle="${bndlLang}" /> *</label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input type="text" name="param_lastName" value="${psb.users[psb.userKey].lastName}" id="txtLastName" class="rqf chr" maxlength="20">
													</td>
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtUserStatus"><fmt:message key="user.portlet.label.status" bundle="${bndlLang}" /> </label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input type="text" name="param_userStatus" value="${psb.users[psb.userKey].userStatus}" id="txtUserStatus" readonly />
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtOrganisationType"><fmt:message key="user.portlet.label.organisation-type" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input type="text" name="param_organisationType" value="${psb.users[psb.userKey].organisationType}" readonly id="txtOrganisationType">
													</td>
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtOrganisationName"><fmt:message key="user.portlet.label.organisation-name" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input type="text" value="${psb.users[psb.userKey].organisationName}" readonly id="txtOrganisationName">
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtJobTitle"><fmt:message key="user.portlet.label.job-title" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input type="text" name="param_jobTitle" value="${psb.users[psb.userKey].jobTitle}" id="txtJobTitle" class="chs" maxlength="35">
													</td>
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtMobileNumber"><fmt:message key="user.portlet.label.mobile-number" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input type="text" name="param_mobileNumber" value="${psb.users[psb.userKey].mobileNumber}" id="txtMobileNumber" class="mbp" maxlength="15">
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtPhoneNumber"><fmt:message key="user.portlet.label.phone-number" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input type="text" name="param_phoneNumber" value="${psb.users[psb.userKey].phoneNumber}" id="txtPhoneNumber" placeholder="011ddddddd" class="nbr" maxlength="15">
														
													</td>
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtFaxNumber"><fmt:message key="user.portlet.label.fax-number" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input type="text" name="param_faxNumber" value="${psb.users[psb.userKey].faxNumber}" id="txtFaxNumber" placeholder="011ddddddd" class="nbr" maxlength="15">
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtEmailAddress"><fmt:message key="user.portlet.label.email-address" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input type="text" name="param_emailAddress" value="${psb.users[psb.userKey].emailAddress}" id="txtEmailAddress" class="eml" maxlength="65">
													</td>
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtAlternateEmailAddress"><fmt:message key="user.portlet.label.alternate-email-address" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input type="text" name="param_alternateEmailAddress" value="${psb.users[psb.userKey].alternateEmailAddress}" id="txtAlternateEmailAddress" class="eml" maxlength="65">

													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtOfficeAddress"><fmt:message key="user.portlet.label.office-address" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input type="text" name="param_officeAddress" value="${psb.users[psb.userKey].officeAddress}" id="txtOfficeAddress" maxlength="200">
													</td>
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtCity"><fmt:message key="user.portlet.label.city" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input type="text" name="param_city" value="${psb.users[psb.userKey].city}" id="txtCity" class="chr" maxlength="25">
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtZipCode"><fmt:message key="user.portlet.label.zip-code" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input  type="text" name="param_zipCode" value="${psb.users[psb.userKey].zipCode}"id="txtZipCode" class="nbr" maxlength="10">
													</td>
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtDistrict"><fmt:message key="user.portlet.label.district" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input  type="text" name="param_district" value="${psb.users[psb.userKey].district}" id="txtDistrict" class="chs" maxlength="10">
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtState"><fmt:message key="user.portlet.label.state" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<select id="cmbState" name="param_state" style="display: inline;">
															<option value=""><fmt:message key="user.portlet.label.please-select" bundle="${bndlLang}" /></option>
															<c:forEach items="${states}" var="state">
																<option value="${state.value}" <c:if test="${state.value == psb.users[psb.userKey].state}">selected</c:if>>
																	${state.name}
																</option>
															</c:forEach>
														</select>
													</td>
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtCountry"><fmt:message key="user.portlet.label.country" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input type="text" name="param_country" value="${psb.users[psb.userKey].country}" id="txtCountry" readonly>
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtPreferredLanguage"><fmt:message key="user.portlet.label.preferred-language" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<select class="outputData" id="cmbPreferredLanguage" name="param_preferredLanguage" style="display: inline;" required>
															<c:forEach items="${prefLang}" var="pLang">
																<option value="${pLang.value}" <c:if test="${pLang.value == psb.users[psb.userKey].preferredLanguage}">selected</c:if>>
																	${pLang.name}
																</option>
															</c:forEach>
														</select>
													</td>
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtBillNumber"><fmt:message key="user.portlet.label.group-membership" bundle="${bndlLang}" /></label>
													</td>
													<td style="width: 100%; vertical-align:top" nowrap>
														<textarea rows="2" cols="23" readonly style="font: 13px/1.231 verdana,arial,clean,sans-serif; height: 30px; width: 200px;">${psb.users[psb.userKey].assignedGroups}</textarea>
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
										<input type="hidden" name="param_request" value="yes" />
										<input type="hidden" name="param_operation" value="saveSearchUserProfile" />
										<input type="button" class="button" value='<fmt:message key="user.portlet.button.save" bundle="${bndlLang}"/>' onclick="editProfile();" />
										<input type="button" class="button" value='<fmt:message key="user.portlet.button.cancel" bundle="${bndlLang}"/>' onclick="doPostUrl('<portlet:resourceURL id="SearchProfileDetails_go_back"/>',1);" />
									</td>
								</tr>
							</tbody>
						</table>
					</fieldset>
					<!-- END Query Segment --></td>
			</tr>
		</tbody>
	</table>
	<!-- END Main Table -->
</form>