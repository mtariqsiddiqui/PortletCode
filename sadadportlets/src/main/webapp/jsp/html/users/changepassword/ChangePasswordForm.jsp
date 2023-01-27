<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frm_ChangePassword" id="frm_ChangePassword" method="post" action="<portlet:actionURL/>">
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
											<tbody>
											
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtUserId">
															<fmt:message key="user.portlet.label.user-id" bundle="${bndlLang}"/>
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<input type="text" id="txtUserId" name="param_userId" value="${psb.userId}" readonly>													
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txt_CurrentPassword">
															<fmt:message key="user.portlet.label.current-password" bundle="${bndlLang}"/>&nbsp;*
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<input type="password" id="txt_CurrentPassword" name="param_password" autocomplete="off" autofocus="autofocus" class="rqf pwdfmt"/>													
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txt_NewPassword">
															<fmt:message key="user.portlet.label.new-password" bundle="${bndlLang}"/>&nbsp;*
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<input type="password" id="txt_NewPassword" autocomplete="off" autofocus="autofocus" class="rqf pwdfmt"/>													
													</td>
												</tr>
												
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txt_ConfirmPassword">
															<fmt:message key="user.portlet.label.confirm-password" bundle="${bndlLang}"/>&nbsp;*
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<input type="password" id="txt_ConfirmPassword" name="param_newPassword" autocomplete="off" class="rqf pwdfmt"/>
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td>
										<input type="hidden" name="param_request" value="yes" />
										<input type="hidden" id="txtOperation" name="txtOperation" value="changePwd" />
										<input type="button" class="button" value='<fmt:message key="user.portlet.button.save" bundle="${bndlLang}"/>' onclick="changeCurrentPassword();" />
										<input type="button" class="button" value='<fmt:message key="user.portlet.button.cancel" bundle="${bndlLang}"/>' onclick="cancelChangePassword();" />
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