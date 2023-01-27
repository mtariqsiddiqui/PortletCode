<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="ebpp.portlet.label.account-summary" bundle="${bndlLang}" /></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="ebpp.portlet.label.biller-name" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.service-type" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.account-number" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.options" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:forEach items="${psb.accounts}" var="acc"> 
			<tr>
				<td><span id="dh_billerName">${BillerList[acc.value.billerId].partnerName}</span></td>
				<td><span id="dh_serviceType">${acc.value.serviceType}</span></td>
				<td><span id="dh_accountNumber">${acc.value.accountNumber}</span></td>
				<td><span id="dh_lifecycle">${acc.value.lifecycle}</span></td>
				<td>
					<portlet:resourceURL var="accountDetailsUrl" id="core_AccountDetails"><portlet:param name="param_accountKey" value="${acc.key}"/></portlet:resourceURL>
					<a href="#" title="Click to see more details" onclick='doPostUrl("${accountDetailsUrl}", 1);' style="display: inline-block;">
						<img width="25" height="25" border="0" alt="Account Details" src='/static/images/option_icon.png'>
					</a>
				</td>
			</tr>
 		</c:forEach>
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>