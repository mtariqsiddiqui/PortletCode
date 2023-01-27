<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmAssignPermission" id="frmAssignPermission" method="post" action="<portlet:actionURL/>">
	<table style="width: 100%">
		<!-- Form or Details container -->
		<tbody>
			<tr>
				<td>
					<p class="attnbox"><fmt:message key="user.portlet.marked-fields-are-mandatory" bundle="${bndlLang}"/></p>				
				</td>
			</tr>
			<tr>
				<td>
					<fieldset>
						<legend>
							<fmt:message key="user.portlet.button.assign-permission" bundle="${bndlLang}"/>
						</legend>
						<table>
							<tbody>
								<tr>
									<td>
										<table  style="width: auto;">
											<!-- Begin: Data entry fields -->
											<tbody>
											
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtUserId">
															<fmt:message key="user.portlet.label.user-id" bundle="${bndlLang}"/>
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<input type="text" id="txtUserId" name="param_userId" value="${psb.users[psb.userKey].userId}" readonly>													
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtNewPassword">
															<fmt:message key="user.portlet.label.assign-group" bundle="${bndlLang}"/>&nbsp;*
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>																												
														<c:forEach var="group" items="${psb.users[psb.userKey].assignableGroups}" varStatus="stat">
															<label><input type="checkbox" id="chkGrp_${group}" style="width: auto; margin: 2px;" value="${group}"/>&nbsp;${group}</label>
															<c:set var="vAssignableGroups" value="${stat.first ? '' : vAssignableGroups}${stat.first ? '' : ','}${group}" />
														</c:forEach>
														<input type="hidden" id="hdnAssignableGroups" value="${vAssignableGroups}"/>
														<input type="hidden" id="hdnAssignedGroups" value="${psb.users[psb.userKey].assignedGroups}"/>
														<input type="hidden" id="hdnNewGroups" name="param_newGroups" value=""/>
													</td>
												</tr>											
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td>
										<input type="hidden" name="param_operation" value="assignGroupsPermissionsForSearchUsers" />
										<input type="hidden" name="param_request" value="yes" />
										<input type="button" class="button" value='<fmt:message key="user.portlet.button.save" bundle="${bndlLang}"/>' onclick="assignPermission();" />
										<input type="button" class="button" value='<fmt:message key="user.portlet.button.cancel" bundle="${bndlLang}"/>' onclick="doPostUrl('<portlet:resourceURL id="SearchProfileDetails_go_back"/>',1);" />
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