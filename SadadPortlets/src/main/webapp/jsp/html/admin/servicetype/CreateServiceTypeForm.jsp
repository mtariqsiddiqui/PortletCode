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
					<form id="frmCreateServiceType" method="post" action="<portlet:resourceURL id="CreateServiceTypeForm"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
									<!-- Begin: Data entry fields -->
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="cmbServiceType"><fmt:message key="service-type.portlet.label.parent-service-type-tag" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
													<select name="param_parentServiceTypeCode" id="cmbServiceType">
														<option value="">
															<fmt:message key="service-type.portlet.label.please-select" bundle="${bndlLang}"/>
														</option>												
														<c:forEach items="${AccountTypeList}" var="serviceType">
															<option  <c:if test="${psb.parentServiceTypeCode == serviceType.value.code}">selected</c:if> 
																value="<c:out value="${serviceType.value.code}" />">
																<c:out value="${serviceType.value.code}" />
															</option>
														</c:forEach>
													</select>
												</td>
											</tr>

											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtServiceTypeTag"><fmt:message key="service-type.portlet.label.service-type-tag" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" id="txtServiceTypeTag" name="param_serviceTypeTag" value="${psb.serviceTypeTag}" class="rqf" autocomplete="off" maxlength="4" onchange="$('#txtServiceTypeCode').val(this.value);"/>
												</td>
											</tr>
											
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtServiceTypeCode"><fmt:message key="service-type.portlet.label.service-type-code" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" id="txtServiceTypeCode" name="param_serviceTypeCode" readonly class="rqf" value="${psb.serviceTypeCode}" autocomplete="off" maxlength="4" />
												</td>
											</tr>

											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtDescription"><fmt:message key="service-type.portlet.label.description" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" id="txtDescription" name="param_description" value="${psb.description}" autocomplete="off" maxlength="100" class="rqf" />
												</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<input type="hidden" name="param_status" value="INACTIVE"/>
									<input type="hidden" name="param_operation" value="callCreateServiceType"/>
									<input class="button" value='<fmt:message key="service-type.portlet.button.save" bundle="${bndlLang}" />' onclick="doQueryFormSubmission('frmCreateServiceType', 1);" type="submit" id="btnSubmit"/>
									<portlet:resourceURL id="CreateServiceTypeForm" var="clearURL"><portlet:param name="param_operation" value="clearSessionBeanObject"/></portlet:resourceURL>
									<input class='button' value='<fmt:message key="service-type.portlet.button.cancel" bundle="${bndlLang}"/>' onclick="doQueryFormReset('${clearURL}');" type='button' id="btnCancel"/>
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