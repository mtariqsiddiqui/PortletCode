<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<table style="width: 100%">
					<tbody>
						<tr><td><p class="attnbox"><fmt:message key="service-type.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p></td></tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="service-type.portlet.label.update-service-type" bundle="${bndlLang}" /></legend>
					<form id="frmCreateServiceType" method="post" action="<portlet:resourceURL id="CreateAccessChannelForm"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
									<!-- Begin: Data entry fields -->
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="cmbServiceType"><fmt:message key="service-type.portlet.label.service-type" bundle="${bndlLang}" />&nbsp;:&nbsp;*</label>
												</td>
												<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
													<select name="txtServiceType" class="outputData" id="cmbServiceType" >
														<option value="">
															<fmt:message key="service-type.portlet.label.please-select" bundle="${bndlLang}"/>
														</option>												
														<c:forEach items="${AccountTypeList}" var="serviceType">
															<option  <c:if test="${psb.serviceType == serviceType.value.code}">selected</c:if> 
																value="<c:out value="${serviceType.value.code}" />">
																<c:out value="${serviceType.value.code}" />
															</option>
														</c:forEach>
													</select>
												</td>
											</tr>

											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtServiceTypeTag"><fmt:message key="service-type.portlet.label.service-type-tag" bundle="${bndlLang}" /> : </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input class="outputData" value="${psb.selectedServiceType.serviceType}" id="txtServiceTypeTag" />
													<input name="txtServiceTypeTag" value="${psb.selectedServiceType.serviceType}" type="hidden" />
												</td>
											</tr>
											
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtServiceTypeCode"><fmt:message key="service-type.portlet.label.service-type-code" bundle="${bndlLang}" /> : </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input class="outputData" value="${psb.selectedServiceType.serviceType}" id="txtServiceTypeCode" />
													<input name="txtServiceTypeCode" value="${psb.selectedServiceType.serviceType}" type="hidden" />
												</td>
											</tr>

											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtDescription"><fmt:message key="service-type.portlet.label.description" bundle="${bndlLang}" /> : *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="txtDescription" class="outputData" value="${psb.selectedServiceType.description}" id="txtDescription" autocomplete="off" maxlength="256" type="text">
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
									<input class="button" value="<fmt:message key="service-type.portlet.button.save" bundle="${bndlLang}" />" onclick="$('#reqAction').val('Save');doQueryFormSubmission('frmCreateServiceType', 1);" type="submit" name="btnSave"/>
									<input class="button" value="<fmt:message key="service-type.portlet.button.cancel" bundle="${bndlLang}" />" onclick="$('#reqAction').val('Cancel');doQueryFormSubmission('frmCreateServiceType', 1);" type="submit" name="btnCancel"/>
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
