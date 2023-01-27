<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="ebpp.portlet.label.bills-summary" bundle="${bndlLang}"/></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="ebpp.portlet.label.biller-name" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.account-number" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.bill-number" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.bill-cycle" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.bill-type" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.bill-category" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.bill-generated-date" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.net" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.payment-count" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.options" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:forEach items="${psb.bills}" var="bill">
			<tr>
				<td>${BillerList[psb.billerId].partnerName}</td>
				<td>${bill.value.accountNumber}</td>
				<td>${bill.value.billNumber}</td>
				<td>${bill.value.billCycle}</td>
				<td>${bill.value.billType}</td>
				<td>${bill.value.billCategory}</td>
				<td>${bill.value.billGeneratedDate}</td>
				<td>${bill.value.netAmount}</td>
				<td>${bill.value.billStatus}</td>
				<td>${bill.value.paymentCount}</td>
				<td>
					<portlet:resourceURL var="billDetailsUrl" id="core_BillsDetails">
						<portlet:param name="param_billNumber" value="${bill.key}"/>
					</portlet:resourceURL>
					<a href="#" title="Click to see more details" onclick='doPostUrl("${billDetailsUrl}", 1);'>
						<img width="25" height="25" border="0" alt="Account Details" src='${thisRequest.getContextPath()}/static/images/option_icon.png'>
					</a>
				</td>
			</tr>
		</c:forEach>
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>