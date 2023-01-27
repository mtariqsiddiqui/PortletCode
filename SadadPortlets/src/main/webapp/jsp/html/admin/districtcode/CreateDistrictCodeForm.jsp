<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="district-code.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="district-code.portlet.label.create-district-code" bundle="${bndlLang}" /></legend>
					<form id="frmCreateDistrictCode" method="post" action="<portlet:resourceURL id="CreateDistrictCodeForm"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
									<!-- Begin: Data entry fields -->
										<tbody>
											
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtDistrictCode"><fmt:message key="district-code.portlet.label.district-code" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_districtCode" id="txtDistrictCode" class="rqf" value="${psb.districtCode}" maxlength="10" pattern="[A-Za-z0-9]{1,10}" title='<fmt:message key="district-code.portlet.title.district-code" bundle="${bndlLang}"/>' autocomplete="off"/>
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
									<input type="hidden" name="param_status" value="INACTIVE"/>
									<input type="hidden" name="param_operation" value="callCreateDistrictCode"/>
									<input class="button" value="<fmt:message key="district-code.portlet.button.save" bundle="${bndlLang}" />" onclick="doQueryFormSubmission('frmCreateDistrictCode', 1);" type="submit" name="btnSave"/>
									<input class="button" value="<fmt:message key="district-code.portlet.button.cancel" bundle="${bndlLang}" />" type="button" onclick="displayErrorOrMessage();$('#frmCreateDistrictCode').trigger('reset');"/>
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