<jsp:directive.include file="../../common/JspDeclarations.jspf" />

<table style="width: 100%">
	<tbody>
		<tr>
			<td class="myCaption">
				<fmt:message key="access-channel.portlet.label.access-channel-details" bundle="${bndlLang}" />
			</td>
		</tr>
		<tr>
			<td>
				<table style="width: 100%">
					<tbody>
						<tr class="NewsColumnWrapper">
							<td class="NewsColumnCell" width="33%" valign="top">
								<table class="tableclass">
									<tbody>
										<tr>
											<th style="width: 25%"><fmt:message key="access-channel.portlet.label.access-channel" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.selectedAccessChannel.accessChannel}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="access-channel.portlet.label.status" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.selectedAccessChannel.status}</td>
										</tr>									
									</tbody>
								</table>
							</td>
							<td class="NewsColumnCell" width="33%" valign="top">
								<table class="tableclass">
									<tbody>
										<tr>
											<th style="width: 25%"><fmt:message key="access-channel.portlet.label.description" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.selectedAccessChannel.description}</td>
										</tr>										
									</tbody>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" class="button" value="<fmt:message key="access-channel.portlet.button.update" bundle="${bndlLang}" />"
					onclick="doPostUrl('<portlet:resourceURL id="QueryAccessChannelUpdateForm"/>', 1);" />
				<fmt:message var="btnStatusLabel" key="access-channel.portlet.button.deactivate" bundle="${bndlLang}" />
				<c:if test="${psb.selectedAccessChannel.status == 'INACTIVE'}">
					<fmt:message var="btnStatusLabel" key="access-channel.portlet.button.activate" bundle="${bndlLang}" />								
				</c:if>
				<portlet:resourceURL id="QueryAccessChannelDetails" var="toggleStatusUrl">
					<portlet:param name="param_operation" value="callActivateOrDeActivateAccessChannel"/>
				</portlet:resourceURL>
				<input type="button" class="button" value="${btnStatusLabel}"
					onclick="doPostUrl('${toggleStatusUrl}', 1);" /> 
				<input type="button" class="button" 
					value="<fmt:message key="access-channel.portlet.button.audit" bundle="${bndlLang}" />" onclick="" />
				<form method="post" action='<portlet:actionURL/>'>
					<input type="hidden" name="fpWhereTo" id="fpWhereTo" value=""/>
					<input type="submit" class="button" onclick="navigate(this);" name="finish" value="<fmt:message key="access-channel.portlet.button.finish" bundle="${bndlLang}"/>" />
				</form>
			</td>
		</tr>
	</tbody>
</table>