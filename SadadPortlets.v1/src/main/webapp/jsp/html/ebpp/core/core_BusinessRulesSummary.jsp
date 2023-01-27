<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="ebpp.portlet.label.business-rules-summary" bundle="${bndlLang}"/></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="ebpp.portlet.label.biller-name" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.bill-category" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.rule-type" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.status" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:forEach items="${psb.businessRules}" var="br">
			<tr>
				<td>${BillerList[br.billerId].partnerName}</td>
				<td>${br.billCategory}</td>
				<td>${br.ruleType}</td>
				<td>${br.ruleStatus}</td>
			</tr>
		</c:forEach>
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>