<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="service-type.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="service-type.portlet.label.update-service-type" bundle="${bndlLang}" /></legend>
					<form id="frmUpdateServiceType" method="post" action="<portlet:resourceURL id="QueryServiceTypeDetails"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
									<!-- Begin: Data entry fields -->
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtParentServiceId"><fmt:message key="service-type.portlet.label.parent-service-type" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input id="txtParentServiceId" value="${psb.selectedServiceType.parentServiceTypeCode}"  disabled="disabled"/>
													<input name="param_parentServiceTypeCode" value="${psb.selectedServiceType.parentServiceTypeCode}" type="hidden"/>
												</td>
											</tr>

											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtServiceTypeTag"><fmt:message key="service-type.portlet.label.service-type-tag" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input value="${psb.selectedServiceType.serviceTypeCode}" id="txtServiceTypeTag" disabled="disabled"/>
													<input name="param_serviceTypeTag" value="${psb.selectedServiceType.serviceTypeTag}" type="hidden" />
												</td>
											</tr>
											
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtServiceTypeCode"><fmt:message key="service-type.portlet.label.service-type-code" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input value="${psb.selectedServiceType.serviceTypeCode}" id="txtServiceTypeCode" disabled="disabled"/>
													<input name="param_serviceTypeCode" value="${psb.selectedServiceType.serviceTypeCode}" type="hidden" />
												</td>
											</tr>

											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtDescription"><fmt:message key="service-type.portlet.label.description" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="param_description" class="rqf" value="${psb.selectedServiceType.description}" id="txtDescription" autocomplete="off" maxlength="100" type="text">
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
									<input type="hidden" name="param_operation" id="param_operation" value="callUpdateAccountType"/>
									<input class="button" value="<fmt:message key="service-type.portlet.button.save" bundle="${bndlLang}" />" onclick="doQueryFormSubmission('frmUpdateServiceType', 1);" type="submit" />
									<input class="button" value="<fmt:message key="service-type.portlet.button.cancel" bundle="${bndlLang}" />" onclick="doPostUrl('<portlet:resourceURL id="QueryServiceTypeDetails" />', 1);" type="button" />
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
