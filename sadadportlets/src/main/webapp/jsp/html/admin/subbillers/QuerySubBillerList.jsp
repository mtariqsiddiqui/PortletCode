<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="subbiller.portlet.label.subbiller-list" bundle="${bndlLang}" /></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="subbiller.portlet.label.subbiller-id" bundle="${bndlLang}" /></th>
			<th><fmt:message key="subbiller.portlet.label.subbiller-name" bundle="${bndlLang}" /></th>
			<th><fmt:message key="subbiller.portlet.label.status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="subbiller.portlet.label.action" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:choose>
		<c:when test="${empty psb.billerId}">
			<c:forEach items="${psb.subBillerMap}" var="biller">
				<tr>
					<td>${biller.value.billerId}</td>
					<td>${biller.value.billerNameEnglish}</td>
					<td>${biller.value.status}</td>
					<td>
					<portlet:resourceURL id="QuerySubBillerDetails" var="querySubBillerDetailsUrl">
						<portlet:param name="param_billerId" value="${biller.value.billerId}"/>
						<portlet:param name="param_operation" value="callGetPartnerDetails"/>
					</portlet:resourceURL>				
					<a href="#" title='<fmt:message key="subbiller.portlet.more-details" bundle="${bndlLang}"/>'
						onclick='doPostUrl("${querySubBillerDetailsUrl}", 1);' style="display: inline-block;">
							<img border="0"
							src='/static/images/item_details.png'/>
					</a></td>
				</tr>
			</c:forEach>	
		</c:when>
		<c:otherwise>
			<tr>
				<td>${psb.billerId}</td>
				<td>${psb.subBillerMap[psb.billerId].billerNameEnglish}</td>
				<td>${psb.subBillerMap[psb.billerId].status}</td>
				<td>
				<portlet:resourceURL id="QuerySubBillerDetails" var="querySubBillerDetailsUrl">
					<portlet:param name="param_billerId" value="${psb.billerId}"/>
					<portlet:param name="param_operation" value="callGetPartnerDetails"/>
				</portlet:resourceURL>
				<a href="#" title='<fmt:message key="subbiller.portlet.more-details" bundle="${bndlLang}"/>'
					onclick='doPostUrl("${querySubBillerDetailsUrl}", 1);' style="display: inline-block;">
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