<br/><jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
	<table id="detailTable" class="tableclass" style="width:100%">
		<caption class="myCaption">
			<fmt:message key="ebpp.portlet.label.rejected-bills" bundle="${bndlLang}"/>
		</caption>
		<!-- Begin: Data display fields -->
						<!-- Begin: table header row -->
		<thead>
			<tr>
				<th><fmt:message key="ebpp.portlet.label.biller-name" bundle="${bndlLang}"/></th>
				<th><fmt:message key="ebpp.portlet.label.bill-number" bundle="${bndlLang}"/></th>
				<th><fmt:message key="ebpp.portlet.label.error-code" bundle="${bndlLang}"/></th>
				<th><fmt:message key="ebpp.portlet.label.error-description" bundle="${bndlLang}"/></th>
				<th><fmt:message key="ebpp.portlet.label.file-name" bundle="${bndlLang}"/></th>
			</tr>
		</thead>
		<!-- End: table header row -->
		<!-- Begin: repeated data rows -->
		<tbody>
			<c:forEach items="${psb.rejectedBills}" var="rb">
			<tr>				
				<td>${BillerList[psb.partnerKey].partnerName}</td>
				<td>${rb.billNumber}</td>
				<td>${rb.errorCode}</td>
				<td>${rb.errorDesc}</td>
				<td>${rb.fileName}</td>
			</tr>
			</c:forEach>
			<!-- End: repeated data rows -->
		</tbody>
	</table>
</fieldset>