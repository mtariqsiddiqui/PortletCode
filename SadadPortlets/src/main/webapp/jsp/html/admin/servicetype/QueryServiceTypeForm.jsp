<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmQueryServiceType" id="frmQueryServiceType" method="post" action="<portlet:resourceURL id="QueryServiceTypeList"/>">
<table style="width: 100%;">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="service-type.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="service-type.portlet.label.get-service-type" bundle="${bndlLang}" /></legend>
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%;">
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
										</tbody>
									</table>
								</td>
							</tr>
							<!-- Buttons Group -->
							<tr>
								<td>
									<input type="submit" id="btnSearch" class="button" 
										value="<fmt:message key="service-type.portlet.button.search" bundle="${bndlLang}" />" 
										onclick="doQueryFormSubmission('frmQueryServiceType', 2);" />
								</td>
							</tr>
						</tbody>
					</table>
				</fieldset>
				<!-- END Query Segment -->
			</td>
		</tr>
	</tbody>
</table>
</form>