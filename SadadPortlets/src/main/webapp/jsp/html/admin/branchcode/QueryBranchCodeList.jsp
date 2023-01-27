<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="branch-code.portlet.label.branch-code-list" bundle="${bndlLang}" /></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="branch-code.portlet.label.bank-id" bundle="${bndlLang}" /></th>
			<th><fmt:message key="branch-code.portlet.label.bank-name" bundle="${bndlLang}" /></th>
			<th><fmt:message key="branch-code.portlet.label.branch-code" bundle="${bndlLang}" /></th>
			<th><fmt:message key="branch-code.portlet.label.status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="branch-code.portlet.label.action" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:forEach items="${psb.branchCodeList}" var="branchCode">
			<tr>
				<td>${psb.bankId}</td>
				<td>${BankList[psb.bankId].partnerName}</td>
				<td>${branchCode.branchCode}</td>
				<td>${branchCode.status}</td>
				<td>
				<portlet:resourceURL id="QueryBranchCodeDetails" var="queryBranchCodeDetailsUrl">
					<portlet:param name="param_bankId" value="${psb.bankId}"/>
					<portlet:param name="param_branchCode" value="${branchCode.branchCode}"/>
					<portlet:param name="param_operation" value="callGetBankBranch"/>
				</portlet:resourceURL>
				<a href="#" title='<fmt:message key="branch-code.portlet.more-details" bundle="${bndlLang}"/>'
					onclick='doPostUrl("${queryBranchCodeDetailsUrl}", 1);' style="display: inline-block;">
						<img border="0"
						src='/static/images/item_details.png'/>
				</a></td>
			</tr>
		</c:forEach>
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>