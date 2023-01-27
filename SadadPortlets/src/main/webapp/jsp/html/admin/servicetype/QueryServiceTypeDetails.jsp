<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<!-- Main Table -->
<table style="width: 100%">
	<tbody>
		<tr>
			<td class="myCaption">
				<fmt:message key="service-type.portlet.label.service-type-details" bundle="${bndlLang}" />
			</td>
		</tr>
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
											<th style="width: 25%"><fmt:message key="service-type.portlet.label.service-type-code" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.selectedServiceType.serviceTypeCode}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="service-type.portlet.label.parent-service-type-code" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.selectedServiceType.parentServiceTypeCode}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="service-type.portlet.label.description" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.selectedServiceType.description}</td>
										</tr>
										<!-- End: Data display fields -->
									</tbody>
								</table>
							</td>
							<td class="NewsColumnCell" width="33%" valign="top">
								<table class="tableclass">
									<tbody>
										<tr>
											<th style="width: 25%"><fmt:message key="service-type.portlet.label.service-type-tag" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.selectedServiceType.serviceTypeCode}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="service-type.portlet.label.parent-service-type-tag" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.selectedServiceType.parentServiceTypeTag}</td>
											
										</tr>
										
										<tr>
											<th style="width: 25%"><fmt:message key="service-type.portlet.label.status" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.selectedServiceType.status}</td>
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
		<tr>
			<td>
				<input type="button" class="button" value="<fmt:message key="service-type.portlet.button.update" bundle="${bndlLang}" />"
					onclick="doPostUrl('<portlet:resourceURL id="QueryServiceTypeUpdateForm"/>', 1);" />
				<fmt:message var="btnStatusLabel" key="service-type.portlet.button.deactivate" bundle="${bndlLang}" />
				<c:if test="${psb.selectedServiceType.status == 'INACTIVE'}">
					<fmt:message var="btnStatusLabel" key="service-type.portlet.button.activate" bundle="${bndlLang}" />								
				</c:if>
				<portlet:resourceURL id="QueryServiceTypeDetails" var="toggleStatusUrl">
					<portlet:param name="param_operation" value="callActivateOrDeActivateAccountType"/>
				</portlet:resourceURL>
				<input type="button" class="button" value="${btnStatusLabel}"
					onclick="doPostUrl('${toggleStatusUrl}', 1);" /> 
				<input type="button" class="button" 
					value="<fmt:message key="service-type.portlet.button.audit" bundle="${bndlLang}" />" onclick="" />
				<form method="post" action='<portlet:actionURL/>'>
					<input type="hidden" name="fpWhereTo" id="fpWhereTo" value=""/>
					<input type="submit" class="button" onclick="navigate(this);" name="finish" value="<fmt:message key="service-type.portlet.button.finish" bundle="${bndlLang}"/>" />
				</form>
			</td>
		</tr>
	</tbody>
</table>