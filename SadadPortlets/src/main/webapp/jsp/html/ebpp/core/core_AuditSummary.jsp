<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="ebpp.portlet.label.audit-summary" bundle="${bndlLang}"/></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="ebpp.portlet.label.audit-date" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.audit-action" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.audit-type" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.audit-source" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.audit-source-id" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.options" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:forEach items="${psb.audits}" var="ad">
			<tr>
				<td>${ad.value.auditDate}</td>
				<td>${ad.value.auditAction}</td>
				<td>${ad.value.auditType}</td>
				<td>${ad.value.auditSource}</td>
				<td>${ad.value.auditSourceId}</td>
				<td>${ad.value.auditOption}</td>
			</tr>
		</c:forEach>
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>