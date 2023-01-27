<jsp:directive.include file="../../common/JspDeclarations.jspf" />

<form name="frmQueryUpdateAccessChannel" id="frmQueryUpdateAccessChannel" method="post" action="<portlet:resourceURL id="QueryAccessChannelDetails"/>">
<table style="width: 100%;">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="access-channel.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="access-channel.portlet.label.update-access-channel" bundle="${bndlLang}" /></legend>
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%;">
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<fmt:message key="access-channel.portlet.label.access-channel" bundle="${bndlLang}" />
												</td>
												<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
													<input type="text" name="param_accessChannel" value="${psb.selectedAccessChannel.accessChannel}" autocomplete="off" maxlength="32" disabled/>
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label for="txtDescription">
														<fmt:message key="access-channel.portlet.label.description" bundle="${bndlLang}" /> *
													</label>
												</td>
												<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
													<input type="text" id="txtDescription" class="rqf" name="param_description" value="${psb.selectedAccessChannel.description}" autocomplete="off" maxlength="128" />
												</td>
											</tr>											
										</tbody>
									</table>
								</td>
							</tr>
							<!-- Buttons Group -->
							<tr>
								<td>
									<input type="hidden" id="param_operation" name="param_operation" value="callUpdateAccessChannel" />
									<input type="submit" id="btnSave" class="button" value="<fmt:message key="access-channel.portlet.button.save" bundle="${bndlLang}" />"
										onclick="doQueryFormSubmission('frmQueryUpdateAccessChannel', 1);" />
									<input type="button" id="btnCancel" class="button" value="<fmt:message key="access-channel.portlet.button.cancel" bundle="${bndlLang}" />" 
										onclick="doPostUrl('<portlet:resourceURL id="QueryAccessChannelDetails" />', 1);" />
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