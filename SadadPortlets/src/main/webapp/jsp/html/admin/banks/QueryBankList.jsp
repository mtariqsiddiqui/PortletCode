<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="bank.portlet.label.bank-list" bundle="${bndlLang}" /></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="bank.portlet.label.bank-id" bundle="${bndlLang}" /></th>
			<th><fmt:message key="bank.portlet.label.bank-name" bundle="${bndlLang}" /></th>
			<th><fmt:message key="bank.portlet.label.status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="bank.portlet.label.action" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
	<c:choose>
		<c:when test="${empty psb.bankId}">
			<c:forEach items="${psb.bankMap}" var="bank">
				<tr>
					<td>${bank.value.bankId}</td>
					<td>${bank.value.bankName}</td>
					<td>${bank.value.status}</td>
					<td>
					<portlet:resourceURL id="QueryBankDetails" var="queryBankDetailsUrl">
						<portlet:param name="param_bankId" value="${bank.key}"/>
						<portlet:param name="param_operation" value="callGetPartnerDetails"/>
					</portlet:resourceURL>
					<a href="#" title='<fmt:message key="bank.portlet.more-details" bundle="${bndlLang}"/>'
						onclick='doPostUrl("${queryBankDetailsUrl}", 1);' style="display: inline-block;">
							<img border="0"
							src='/static/images/item_details.png'/>
					</a></td>
				</tr>
			</c:forEach>	
		</c:when>
		<c:otherwise>
			<tr>
				<td>${psb.bankId}</td>
				<td>${psb.bankMap[psb.bankId].bankName}</td>
				<td>${psb.bankMap[psb.bankId].status}</td>
				<td>
				<portlet:resourceURL id="QueryBankDetails" var="queryBankDetailsUrl">
					<portlet:param name="param_bankId" value="${psb.bankId}"/>
					<portlet:param name="param_operation" value="callGetPartnerDetails"/>
				</portlet:resourceURL>
				<a href="#" title='<fmt:message key="bank.portlet.more-details" bundle="${bndlLang}"/>'
					onclick='doPostUrl("${queryBankDetailsUrl}", 1);' style="display: inline-block;">
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