<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="biller.portlet.label.biller-list" bundle="${bndlLang}" /></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="biller.portlet.label.biller-id" bundle="${bndlLang}" /></th>
			<th><fmt:message key="biller.portlet.label.biller-name" bundle="${bndlLang}" /></th>
			<th><fmt:message key="biller.portlet.label.status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="biller.portlet.label.action" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
	<c:choose>
		<c:when test="${empty psb.billerId}">
			<c:forEach items="${psb.billerMap}" var="biller">
				<tr>
					<td>${biller.value.billerId}</td>
					<td>${biller.value.billerName}</td>
					<td>${biller.value.status}</td>
					<td>
					<portlet:resourceURL id="QueryBillerDetails" var="queryBillerDetailsUrl">
						<portlet:param name="param_billerId" value="${biller.key}"/>
						<portlet:param name="param_operation" value="callGetPartnerDetails"/>						
					</portlet:resourceURL>					
					<a href="#" title='<fmt:message key="biller.portlet.more-details" bundle="${bndlLang}"/>'
						onclick='doPostUrl("${queryBillerDetailsUrl}", 1);' style="display: inline-block;">
							<img border="0"
							src='/static/images/item_details.png'/>
					</a></td>
				</tr>
			</c:forEach>	
		</c:when>
		<c:otherwise>
			<tr>
				<td>${psb.billerId}</td>
				<td>${psb.billerMap[psb.billerId].billerName}</td>
				<td>${psb.billerMap[psb.billerId].status}</td>
				<td>
				<portlet:resourceURL id="QueryBillerDetails" var="queryBillerDetailsUrl">
					<portlet:param name="param_billerId" value="${psb.billerId}"/>
					<portlet:param name="param_operation" value="callGetPartnerDetails"/>
				</portlet:resourceURL>
				<a href="#" title='<fmt:message key="biller.portlet.more-details" bundle="${bndlLang}"/>'
					onclick='doPostUrl("${queryBillerDetailsUrl}", 1);' style="display: inline-block;">
						<img border="0"
						src='/static/images/item_details.png'/>
				</a></td>
			</tr>
		</c:otherwise>
		</c:choose>
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>