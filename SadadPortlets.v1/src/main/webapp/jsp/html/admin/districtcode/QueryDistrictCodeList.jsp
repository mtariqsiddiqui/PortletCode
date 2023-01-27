<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="district-code.portlet.label.district-code-list" bundle="${bndlLang}" />:</span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="district-code.portlet.label.district-code" bundle="${bndlLang}" /></th>
			<th><fmt:message key="district-code.portlet.label.status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="district-code.portlet.label.action" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:choose>
			<c:when test="${empty psb.selectedDistrictCode}">
				<c:forEach items="${DistrictList}" var="dstCode">
					<tr>
						<td>${dstCode.value.code}</td>
						<td>${dstCode.value.status}</td>
						<td>
						<a href="#" title='<fmt:message key="district-code.portlet.more-details" bundle="${bndlLang}"/>'
							onclick='doPostUrl("<portlet:resourceURL id="QueryDistrictCodeDetails"><portlet:param name="txtDistrictCode" value="${dstCode.value.code}"/></portlet:resourceURL>", 1);'>
								<img border="0" src='${thisRequest.getContextPath()}/static/images/item_details.png'/>
						</a></td>
					</tr>
				</c:forEach>	
			</c:when>
			<c:otherwise>
				<tr>
					<td>${DistrictList[psb.districtCode].code}</td>
					<td>${DistrictList[psb.districtCode].status}</td>
					<td>
					<a href="#" title='<fmt:message key="district-code.portlet.more-details" bundle="${bndlLang}"/>'
						onclick='doPostUrl("<portlet:resourceURL id="QueryDistrictCodeDetails"><portlet:param name="txtDistrictCode" value="${psb.districtCode}"/></portlet:resourceURL>", 1);'>
							<img border="0" src='${thisRequest.getContextPath()}/static/images/item_details.png'/>
					</a></td>
				</tr>
			</c:otherwise>
		</c:choose>	
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>