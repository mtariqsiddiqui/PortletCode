<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="ebpp.portlet.label.biller-information" bundle="${bndlLang}"/></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="ebpp.portlet.label.biller" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.biller-name" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.description" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.status" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<tr>
			<td>${psb.partnerKey}</td>
			<td>${BillerList[psb.partnerKey].partnerName}</td>
			<td>${BillerList[psb.partnerKey].partnerDescription}</td>
			<td>${BillerList[psb.partnerKey].partnerStatus}</td>
		</tr>
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>