<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmQueryDistrictCode" id="frmQueryDistrictCode" method="post" action="<portlet:resourceURL id="QueryDistrictCodeList"/>">
<table style="width: 100%;">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="district-code.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend>
						<fmt:message key="district-code.portlet.label.get-district-code" bundle="${bndlLang}" />
					</legend>
					<table style="width: 100%;">
						<tbody>
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="cmbDistrictCode">
										<fmt:message key="district-code.portlet.label.district-code" bundle="${bndlLang}" />&nbsp;:&nbsp;*
									</label>
								</td>
								<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
									<select name="txtDistrictCode" class="outputData" id="cmbDistrictCode">
										<option value="">
											<fmt:message key="district-code.portlet.label.please-select" bundle="${bndlLang}" />
										</option>
										<c:forEach items="${DistrictList}" var="district">
											<option <c:if test="${psb.districtCode == district.value.code}">selected</c:if>
												value="<c:out value="${district.value.code}" />">
												<c:out value="${district.value.code}" />
											</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" id="btnSearch" class="button" 
										value="<fmt:message key="district-code.portlet.button.search" bundle="${bndlLang}" />"
										onclick="doQueryFormSubmission('frmQueryDistrictCode', 2);" />
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