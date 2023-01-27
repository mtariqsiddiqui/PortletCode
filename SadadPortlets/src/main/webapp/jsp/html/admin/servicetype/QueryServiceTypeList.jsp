<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="service-type.portlet.label.service-type-list" bundle="${bndlLang}" /></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="service-type.portlet.label.service-type-tag" bundle="${bndlLang}" /></th>
			<th><fmt:message key="service-type.portlet.label.description" bundle="${bndlLang}" /></th>
			<th><fmt:message key="service-type.portlet.label.status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="service-type.portlet.label.action" bundle="${bndlLang}" />:</th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:choose>
			<c:when test="${empty psb.serviceTypeCode}">
				<c:forEach items="${AccountTypeList}" var="actList">
					<tr>
						<td>${actList.value.code}</td>
						<td>${actList.value.description}</td>
						<td>${actList.value.status}</td>
						<td>
							<portlet:resourceURL id="QueryServiceTypeDetails" var="serviceTypeDetailsUrl">
								<portlet:param name="param_serviceTypeCode" value="${actList.value.code}"/>
								<portlet:param name="param_operation" value="callGetAccountType"/>
							</portlet:resourceURL>
							<a href="#" title='<fmt:message key="service-type.portlet.more-details" bundle="${bndlLang}"/>'
								onclick='doPostUrl("${serviceTypeDetailsUrl}", 1);' style="display: inline-block;">
									<img border="0"
									src='/static/images/item_details.png'/>
							</a>
						</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td>${AccountTypeList[psb.serviceTypeCode].code}</td>
					<td>${AccountTypeList[psb.serviceTypeCode].description}</td>					
					<td>${AccountTypeList[psb.serviceTypeCode].status}</td>
					<td>
						<portlet:resourceURL id="QueryServiceTypeDetails" var="serviceTypeDetailsUrl">
							<portlet:param name="param_serviceTypeCode" value="${psb.serviceTypeCode}"/>
							<portlet:param name="param_operation" value="callGetAccountType"/>
						</portlet:resourceURL>
						<a href="#" title='<fmt:message key="service-type.portlet.more-details" bundle="${bndlLang}"/>'
							onclick='doPostUrl("${serviceTypeDetailsUrl}", 1);' style="display: inline-block;">
								<img border="0"
								src='/static/images/item_details.png'/>
						</a>
					</td>
				</tr>
			</c:otherwise>
		</c:choose>			
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>