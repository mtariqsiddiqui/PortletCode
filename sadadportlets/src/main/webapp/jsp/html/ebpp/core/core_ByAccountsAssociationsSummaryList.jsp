<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="ebpp.portlet.label.association-summary" bundle="${bndlLang}"/></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="ebpp.portlet.label.account-status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.account-number" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.association" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.options" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:forEach items="${psb.association}" var="asc">
			<tr>
				<td>${asc.value.accountStatus}</td>
				<td>${asc.value.accountNumber}</td>
				<td>${asc.value.associationType}</td>
				<td>
					<portlet:resourceURL var="associationDetailsUrl" id="core_ByCustomerAssociationsDetails">
						<portlet:param name="param_associationKey" value="${asc.key}"/>
					</portlet:resourceURL>
					<a href="#" title="Click to see more details" onclick='doPostUrl("${associationDetailsUrl}", 1);' style="display: inline-block;">
						<img width="25" height="25" border="0" alt="Account Details" src='/static/images/option_icon.png'>
					</a>
					&nbsp;
					<portlet:resourceURL var="deleteAssociations" id="core_ByAccountsAssociationsSummaryList">
						<portlet:param name="param_customerId" value="${asc.value.officialIdNumber}"/>
						<portlet:param name="param_customerIdType" value="${asc.value.officialIdType}"/>
						<portlet:param name="param_accountNumber" value="${asc.value.accountNumber}"/>
						<portlet:param name="param_billerId" value="${asc.value.billerId}"/>
						<portlet:param name="param_associationKey" value="${asc.key}"/>
						<portlet:param name="param_operation" value="callCustomerService_CustomerDisassociation"/>
					</portlet:resourceURL>
					<a href="#" title="Click to delete association" onclick='doPostUrl("${deleteAssociations}", 0);' style="display: inline-block;">
						<img width="25" height="25" border="0" alt="Delete Association" src='/static/images/deactivate1.png'>
					</a>
				</td>
			</tr>
		</c:forEach>
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>