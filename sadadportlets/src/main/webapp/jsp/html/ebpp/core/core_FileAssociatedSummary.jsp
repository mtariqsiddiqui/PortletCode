<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table id="DataTable" class="tableclass" style="width: 100%; padding: 0px;">
	<caption class="myCaption">
		<fmt:message key="ebpp.portlet.label.associated-files" bundle="${bndlLang}" />
	</caption>
	<thead>
		<tr>
			<th><fmt:message key="ebpp.portlet.label.rquid" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.file-category" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.options" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${psb.files[psb.fileKey].associatedFiles}" var="file">
			<tr>
				<td>${file.value.rquid}</td>
				<td>${file.value.fileType}</td>
				<td>
					<portlet:resourceURL var="fileDetailsUrl">
						<portlet:param name="param_orgId" value="${file.value.partnerKey}" />
						<portlet:param name="param_rquid" value="${file.value.rquid}" />
						<portlet:param name="param_fileType" value="${file.value.fileType}" />
						<portlet:param name="param_fileName" value="${file.value.fileName}" />						
						<portlet:param name="param_jsonObj" value="jsonObj" />
						<portlet:param name="param_operation" value="callSearchAssociatedFileDetails" />
					</portlet:resourceURL>
					<a href="#" onclick="getAssociatedFileDetails('${fileDetailsUrl}');"><fmt:message key="ebpp.portlet.label.details" bundle="${bndlLang}" /></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>