<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmChangePassword" id="frmChangePassword" method="post" action="<portlet:actionURL/>">
	<table style="width: 100%">
		<!-- Form or Details container -->
		<tbody>
			<tr>
				<td>
					<p class="attnbox"><fmt:message key="user.portlet.marked-fields-are-mandatory" bundle="${bndlLang}"/></p>
					<span class="INFO_Message"><fmt:message key="user.portlet.sadad-password-policy" bundle="${bndlLang}"/></span>
					
				</td>
			</tr>
			<tr>
				<td>
					<fieldset>
						<legend>
							<fmt:message key="user.portlet.label.change-password" bundle="${bndlLang}"/>
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
															<fmt:message key="user.portlet.label.new-password" bundle="${bndlLang}"/>&nbsp;*
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<input type="password" id="txtNewPassword" autocomplete="off" autofocus="autofocus" class="rqf pwdfmt"/>													
													</td>
												</tr>
												
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtConfirmPassword">
															<fmt:message key="user.portlet.label.confirm-password" bundle="${bndlLang}"/>&nbsp;*
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<input type="password" id="txtConfirmPassword" name="param_newPassword" autocomplete="off" class="rqf pwdfmt"/>
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
										<input type="hidden" name="param_operation" value="changeUserPasswordToActivate" />
										<input type="hidden" name="param_request" value="yes" />
										<input type="button" class="button" value='<fmt:message key="user.portlet.button.save" bundle="${bndlLang}"/>' onclick="setNewPassword();" />
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