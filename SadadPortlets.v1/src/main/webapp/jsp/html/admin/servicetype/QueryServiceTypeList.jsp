<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="service-type.portlet.label.service-type-list" bundle="${bndlLang}" />:</span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="service-type.portlet.label.service-type-tag" bundle="${bndlLang}" /></th>
			<th><fmt:message key="service-type.portlet.label.service-type-code" bundle="${bndlLang}" /></th>
			<th><fmt:message key="service-type.portlet.label.status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="service-type.portlet.label.action" bundle="${bndlLang}" />:</th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:forEach items="${psb.serviceTypeList}" var="serviceTypeList">
			<tr>
				<td>${psb.serviceType}</td>
				<td>${serviceTypeList.description}</td>
				<td>${serviceTypeList.status}</td>
				<td>
				<a href="#" title='<fmt:message key="service-type.portlet.more-details" bundle="${bndlLang}"/>'
					onclick='doPostUrl("<portlet:resourceURL id="QueryServiceTypeDetails"><portlet:param name="txtServiceType" value="${serviceTypeList.serviceType}"/></portlet:resourceURL>", 1);'>
						<img border="0"
						src='${thisRequest.getContextPath()}/static/images/item_details.png'/>
				</a></td>
			</tr>
		</c:forEach>
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>