<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="user.portlet.label.user-list" bundle="${bndlLang}" /></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="user.portlet.label.user-id" bundle="${bndlLang}" /></th>
			<th><fmt:message key="user.portlet.label.first-name" bundle="${bndlLang}" /></th>
			<th><fmt:message key="user.portlet.label.last-name" bundle="${bndlLang}" /></th>
			<th><fmt:message key="user.portlet.label.status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="user.portlet.label.action" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:choose>
			<c:when test="${not empty psb.users}">
				<c:forEach items="${psb.users}" var="user">
					<tr>
						<td>${user.value.userId}</td>
						<td>${user.value.firstName}</td>
						<td>${user.value.lastName}</td>
						<td>${user.value.userStatus}</td>
						<td>
						<a href="#" title='<fmt:message key="user.portlet.more-details" bundle="${bndlLang}"/>'
							onclick='doPostUrl("<portlet:resourceURL id="SearchProfileDetails"><portlet:param name="param_userKey" value="${user.value.userId}"/><portlet:param name="param_operation" value="retrieveUserProfileById"/></portlet:resourceURL>", 1);' style="display: inline-block;">
								<img border="0" src='/static/images/item_details.png'/>
						</a></td>
					</tr>
				</c:forEach>	
			</c:when>
			<%-- <c:otherwise>
				<tr>
					<td>${DistrictList[psb.districtCode].code}</td>
					<td>${DistrictList[psb.districtCode].status}</td>
					<td>
					<a href="#" title='<fmt:message key="district-code.portlet.more-details" bundle="${bndlLang}"/>'
						onclick='doPostUrl("<portlet:resourceURL id="QueryDistrictCodeDetails"><portlet:param name="param_districtCode" value="${psb.districtCode}"/><portlet:param name="param_operation" value="callGetDistrictCode"/></portlet:resourceURL>", 1);' style="display: inline-block;">
							<img border="0" src='/static/images/item_details.png'/>
					</a></td>
				</tr>
			</c:otherwise> --%>
		</c:choose>	
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>