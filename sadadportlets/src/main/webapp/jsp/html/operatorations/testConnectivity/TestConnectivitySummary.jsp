<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="ow.portlet.label.test-connection-summary" bundle="${bndlLang}" /></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="ow.portlet.label.test-type" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ow.portlet.label.protocol" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ow.portlet.label.partner-alias" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ow.portlet.label.connection-status" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:forEach items="${psb.testConnectionResults}" var="tcr"> 
			<tr>
				<td>${psb.testType}</td>
				<td>${psb.protocol}</td>
				<td>
					<c:if test="${psb.testType == 'Automatic'}">
						<c:out value="${psb.orgId}"/>
					</c:if>
					<c:if test="${psb.testType == 'Manual'}">
						<c:out value="${psb.ipAddress} : ${psb.port}"/>
					</c:if>
				</td>
				<td>
					${tcr.statusCode} - ${tcr.statusDesc}
				</td>
			</tr>
 		</c:forEach>
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>