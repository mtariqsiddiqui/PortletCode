<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width: 100%;">
	<caption class="myCaption"><fmt:message key="ebpp.portlet.label.spl-summary" bundle="${bndlLang}"/></caption>
	<thead>
		<tr>
			<th><fmt:message key="ebpp.portlet.label.bank-number" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ebpp.portlet.label.saddad-number" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ebpp.portlet.label.amount" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ebpp.portlet.label.options" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ebpp.portlet.label.payment-status" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ebpp.portlet.label.customer-id" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ebpp.portlet.label.beneficiary-id" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ebpp.portlet.label.service-id" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ebpp.portlet.label.refund-id" bundle="${bndlLang}"/></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${psb.spls}" var="spl">
		<tr>
			<td>${spl.value.bankNumber}</td>
			<td>${spl.value.paymentKey}</td>
			<td>${spl.value.amount}</td>
			<td><!-- option --></td>
			<td>${spl.value.status}</td>
			<td><!-- customer id --></td>
			<td><!-- beneficiary id --></td>
			<td><!-- service id --></td>
			<td><!-- refund id --></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</fieldset>