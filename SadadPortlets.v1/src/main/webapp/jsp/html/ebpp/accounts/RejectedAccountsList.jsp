<br/><jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
	<table id="detailTable" class="tableclass" style="width:100%">
		<caption class="myCaption">
			<fmt:message key="ebpp.portlet.label.rejected-accounts" bundle="${bndlLang}"/>
		</caption>
		<!-- Begin: Data display fields -->
						<!-- Begin: table header row -->
		<thead>
			<tr>
				<th><fmt:message key="ebpp.portlet.label.biller-name" bundle="${bndlLang}"/></th>
				<th><fmt:message key="ebpp.portlet.label.account-number" bundle="${bndlLang}"/></th>
				<th><fmt:message key="ebpp.portlet.label.error-code" bundle="${bndlLang}"/></th>
				<th><fmt:message key="ebpp.portlet.label.error-description" bundle="${bndlLang}"/></th>
				<th><fmt:message key="ebpp.portlet.label.file-name" bundle="${bndlLang}"/></th>
			</tr>
		</thead>
		<!-- End: table header row -->
		<!-- Begin: repeated data rows -->
		<tbody>
			<c:forEach items="${psb.rejectedAccounts}" var="ra">
			<tr>				
				<td>${BillerList[psb.billerId].partnerName}</td>
				<td>${ra.accountNumber}</td>
				<td>${ra.errorCode}</td>
				<td>${ra.errorDesc}</td>
				<td>${ra.fileName}</td>
			</tr>
			</c:forEach>
			<!-- End: repeated data rows -->
		</tbody>
	</table>
</fieldset>