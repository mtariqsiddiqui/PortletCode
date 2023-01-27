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
			<th><fmt:message key="biller.portlet.label.action" bundle="${bndlLang}" />:</th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
	<c:choose>
		<c:when test="${empty psb.selectedBiller}">
			<c:forEach items="${BillerList}" var="biller">
				<tr>
					<td>${biller.value.partnerKey}</td>
					<td>${biller.value.partnerName}</td>
					<td>${biller.value.partnerStatus}</td>
					<td>
					<a href="#" title='<fmt:message key="biller.portlet.more-details" bundle="${bndlLang}"/>'
						onclick='doPostUrl("<portlet:resourceURL id="QueryBillerDetails"><portlet:param name="txtBillerId" value="${biller.value.partnerKey}"/></portlet:resourceURL>", 1);'>
							<img border="0"
							src='${thisRequest.getContextPath()}/static/images/item_details.png'/>
					</a></td>
				</tr>
			</c:forEach>	
		</c:when>
		<c:otherwise>
			<tr>
				<td>${psb.partnerKey}</td>
				<td>${BillerList[psb.partnerKey].partnerName}</td>
				<td>${BillerList[psb.partnerKey].partnerStatus}</td>
				<td>
				<a href="#" title='<fmt:message key="biller.portlet.more-details" bundle="${bndlLang}"/>'
					onclick='doPostUrl("<portlet:resourceURL id="QueryBillerDetails"><portlet:param name="txtBillerId" value="${psb.partnerKey}"/></portlet:resourceURL>", 1);'>
						<img border="0"
						src='${thisRequest.getContextPath()}/static/images/item_details.png'/>
				</a></td>
			</tr>
		</c:otherwise>
		</c:choose>
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>