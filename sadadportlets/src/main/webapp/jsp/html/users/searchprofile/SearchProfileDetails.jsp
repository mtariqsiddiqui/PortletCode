<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
	<tr>
		<td>
			<table style="width: 100%">
				<tbody>
					<tr>
						<td class="myCaption"><fmt:message key="user.portlet.label.user-details" bundle="${bndlLang}"/></td>
					</tr>
					<tr>
						<td>
							<table style="width: 100%">
								<tbody>
									<tr class="NewsColumnWrapper">
										<td class="NewsColumnCell" style="width: 33%; valign: top;">
											<!-- Begin: Data display fields -->
											<table class="tableclass">
												<tbody>
													<tr>
														<th style="width: 25%"><fmt:message key="user.portlet.label.user-id" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.users[psb.userKey].userId}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="user.portlet.label.first-name" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.users[psb.userKey].firstName}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="user.portlet.label.last-name" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.users[psb.userKey].lastName}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="user.portlet.label.organisation-name" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.users[psb.userKey].organisationName}</td>
													</tr>
													<!-- Begin: Data display fields -->
													<tr>
														<th style="width: 25%"><fmt:message key="user.portlet.label.mobile-number" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.users[psb.userKey].mobileNumber}</td>
													</tr>
													<!-- End: Data display fields -->
													<tr>
														<th style="width: 25%"><fmt:message key="user.portlet.label.fax-number" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.users[psb.userKey].faxNumber}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="user.portlet.label.email-address" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.users[psb.userKey].emailAddress}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="user.portlet.label.alternate-email-address" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.users[psb.userKey].alternateEmailAddress}</td>
													</tr>
													<!-- End: Data display fields -->
												</tbody>
											</table>
										</td>
										<td class="NewsColumnCell" style="width: 33%; valign: top;">
											<!-- Begin: Data display fields -->
											<table class="tableclass">
												<tbody>
													<tr>
														<th style="width: 25%"><fmt:message key="user.portlet.label.status" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.users[psb.userKey].userStatus}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="user.portlet.label.middle-name" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.users[psb.userKey].middleName}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="user.portlet.label.job-title" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.users[psb.userKey].jobTitle}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="user.portlet.label.organisation-type" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.users[psb.userKey].organisationType}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="user.portlet.label.phone-number" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.users[psb.userKey].phoneNumber}</td>
													</tr>

													<tr>
														<th style="width: 25%"><fmt:message key="user.portlet.label.preferred-language" bundle="${bndlLang}"/></th>
														<td style="width: 25%">
															<c:if test="${psb.users[psb.userKey].preferredLanguage == 'ar'}">Arabic</c:if>
															<c:if test="${psb.users[psb.userKey].preferredLanguage == 'en'}">English</c:if>
														</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="user.portlet.label.country" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.users[psb.userKey].country}</td>
													</tr>
													<tr>
														<th style="width: 25%"><fmt:message key="user.portlet.label.group-membership" bundle="${bndlLang}"/></th>
														<td style="width: 25%">${psb.users[psb.userKey].assignedGroups}</td>
													</tr>
												</tbody>
											</table>
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<portlet:actionURL var="searchProfileDetailsUrl">
								<portlet:param name="param_userKey" value="${psb.userKey}"/>
								<portlet:param name="param_request" value="yes"/>
								<portlet:param name="param_operation" value="changeUserStatus"/>
							</portlet:actionURL>
							<form id="frmChangeUserStatus" action="${searchProfileDetailsUrl}"></form>
							<fmt:message var="btnStatusLabel" key="user.portlet.button.deactivate" bundle="${bndlLang}" />
							<c:if test="${psb.users[psb.userKey].userStatus == 'INACTIVE'}">
								<fmt:message var="btnStatusLabel" key="user.portlet.button.activate" bundle="${bndlLang}" />
							</c:if>
							<input type="button" class="button" value="${btnStatusLabel}" onclick="$('#frmChangeUserStatus').submit()" />

							<portlet:resourceURL id="SearchProfileUpdateForm" var="searchProfileUpdateFormUrl">
								<portlet:param name="param_userKey" value="${psb.userKey}"/>
							</portlet:resourceURL>
							<input type="button" class="button" value="<fmt:message key="user.portlet.button.update" bundle="${bndlLang}"/>" onclick="doPostUrl('${searchProfileUpdateFormUrl}', 1)" />

							<portlet:resourceURL id="SearchProfileChangePasswordForm" var="searchProfileChangePasswordFormUrl">
								<portlet:param name="param_userKey" value="${psb.userKey}"/>
							</portlet:resourceURL>

							<input type="button" class="button" value="<fmt:message key="user.portlet.button.change-password" bundle="${bndlLang}"/>" onclick="doPostUrl('${searchProfileChangePasswordFormUrl}', 1)" />

							<portlet:resourceURL id="SearchProfileAssignPermissionForm" var="searchProfileAssignPermissionFormUrl">
								<portlet:param name="param_userKey" value="${psb.userKey}"/>
							</portlet:resourceURL>
							<input type="button" class="button" value="<fmt:message key="user.portlet.button.assign-permission" bundle="${bndlLang}"/>" onclick="doPostUrl('${searchProfileAssignPermissionFormUrl}', 1)" />
							<form method="post" action="<portlet:actionURL/>">
								<input type="hidden" name="fpWhereTo" id="fpWhereTo" value=""/>
								<input type="submit" class="button" onclick="navigate(this);" name="back" value="<fmt:message key="user.portlet.button.back" bundle="${bndlLang}"/>"/>
								<input type="submit" class="button" onclick="navigate(this);" name="finish" value="<fmt:message key="user.portlet.button.finish" bundle="${bndlLang}"/>"/>
							</form>
						</td>
					</tr>
				</tbody>
			</table>
		</td>
	</tr>
	</tbody>
</table>