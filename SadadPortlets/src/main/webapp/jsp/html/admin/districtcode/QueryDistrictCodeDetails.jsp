<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<!-- Main Table -->
<table style="width: 100%">
	<tbody>
		<tr>
			<td class="myCaption">
				<fmt:message key="district-code.portlet.label.district-code-details" bundle="${bndlLang}" />
			</td>
			<tr>
				<td>
					<table style="width: 100%">
						<!-- Begin: Data display fields -->
						<tbody>
							<tr class="NewsColumnWrapper">
								<td class="NewsColumnCell" width="33%" valign="top">
									<table class="tableclass">
										<tbody>
											<tr>
												<th style="width: 25%"><fmt:message key="district-code.portlet.label.district-code" bundle="${bndlLang}" /></th>
												<td style="width: 25%">${psb.selectedDistrictCode.districtCode}</td>
											</tr>
											<!-- End: Data display fields -->
										</tbody>
									</table>
								</td>
								<td class="NewsColumnCell" width="33%" valign="top">
									<table class="tableclass">
										<tbody>
											<tr>
												<th style="width: 25%"><fmt:message key="district-code.portlet.label.status" bundle="${bndlLang}" /></th>
												<td style="width: 25%">${psb.selectedDistrictCode.status}</td>
											</tr>											
											<!-- End: Data display fields -->
										</tbody>
									</table>
								</td>
							</tr>
							<!-- End: Data display fields -->
							<!-- End: PageContentsContainer -->
						</tbody>
					</table>							
				</td>
			</tr>
			<!-- Buttons Group -->
			<tr>
				<td>
					<fmt:message var="btnStatusLabel" key="district-code.portlet.button.deactivate" bundle="${bndlLang}" />
					<c:if test="${psb.selectedDistrictCode.status == 'INACTIVE'}">
						<fmt:message var="btnStatusLabel" key="district-code.portlet.button.activate" bundle="${bndlLang}" />								
					</c:if>
					<portlet:resourceURL id="QueryDistrictCodeDetails" var="toggleStatusUrl">
						<portlet:param name="param_operation" value="callActivateOrDeActivateDistrictCode"/>
					</portlet:resourceURL>
					<input type="button" class="button" value="${btnStatusLabel}" onclick="doPostUrl('${toggleStatusUrl}', 1);" />
					<input type="button" class="button" value="<fmt:message key="district-code.portlet.button.audit" bundle="${bndlLang}" />" onclick="" />
					<form method="post" action='<portlet:actionURL/>'>
						<input type="hidden" name="fpWhereTo" id="fpWhereTo" value=""/>
						<input type="submit" class="button" onclick="navigate(this);" name="finish" value="<fmt:message key="district-code.portlet.button.finish" bundle="${bndlLang}"/>" />
					</form>
				</td>
			</tr>
			<!-- END Buttons Group -->
		<!-- End Details container -->
	</tbody>
</table>
<!-- END Main Table -->