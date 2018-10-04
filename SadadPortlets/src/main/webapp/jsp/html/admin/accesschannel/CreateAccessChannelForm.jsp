<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<table style="width: 100%">
					<tbody>
						<tr><td><p class="attnbox"><fmt:message key="access-channel.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p></td></tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="access-channel.portlet.label.create-access-channel" bundle="${bndlLang}" /></legend>
					<form id="frmCreateAccessChannel" method="post" action="<portlet:resourceURL id="CreateAccessChannelForm"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
									<!-- Begin: Data entry fields -->
										<tbody>
											
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtAccessChannel"><fmt:message key="access-channel.portlet.label.access-channel" bundle="${bndlLang}" /> : </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="txtAccessChannel" id="txtAccessChannel" class="outputData" value="${psb.selectedAccessChannel.accessChannel}" maxlength="256" autocomplete="off"/>
												</td>
											</tr>

											
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtDescription"><fmt:message key="access-channel.portlet.label.description" bundle="${bndlLang}" /> : *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="txtDescription" id="txtDescription" class="outputData" value="${psb.description}" autocomplete="off" maxlength="256" type="text">
												</td>
											</tr>
											<!-- End: Data entry fields -->
										</tbody>
									</table>
								</td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<!-- Buttons Group -->
							<tr>
								<td>
									<input type="hidden" name="reqAction" id="reqAction"/>
									<input class="button" value="<fmt:message key="access-channel.portlet.button.save" bundle="${bndlLang}" />" onclick="doQueryFormSubmission('frmCreateAccessChannel', 1);" type="submit" name="btnSave"/>
									<input class="button" value="<fmt:message key="access-channel.portlet.button.cancel" bundle="${bndlLang}" />" type="reset" name="btnCancel"/>
								</td>
							</tr>
						</tbody>
					</table>
					</form>
				</fieldset>
			</td>
		</tr>
	</tbody>
</table>