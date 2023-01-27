<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="ebpp.portlet.label.customer-summary" bundle="${bndlLang}"/></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="ebpp.portlet.label.official-id-number" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.official-id-type" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.options" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<tr>
			<td>${psb.customer.officialIdNumber}</td>
			<td>${psb.customer.officialIdType}</td>
			<td>${psb.customer.customerStatus}</td>
			<td>
				<portlet:resourceURL var="customerDetailsUrl" id="core_CustomerDetails"/>
				<a href="#" title="Click to see more details" onclick='doPostUrl("${customerDetailsUrl}", 1);' style="display: inline-block;">
					<img width="25" height="25" border="0" alt="Account Details" src='/static/images/option_icon.png'>
				</a>
			</td>
		</tr>
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>