<br/><jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
	<table id="detailTable" class="tableclass" style="width:100%">
		<caption class="myCaption">
			<fmt:message key="ebpp.portlet.label.rejected-payments" bundle="${bndlLang}"/>
		</caption>
		<!-- Begin: Data display fields -->
						<!-- Begin: table header row -->
		<thead>
			<tr>
				<th><fmt:message key="ebpp.portlet.label.biller-name" bundle="${bndlLang}"/></th>
				<th><fmt:message key="ebpp.portlet.label.transaction-number" bundle="${bndlLang}"/></th>
				<th><fmt:message key="ebpp.portlet.label.error-code" bundle="${bndlLang}"/></th>
				<th><fmt:message key="ebpp.portlet.label.error-description" bundle="${bndlLang}"/></th>
				<th><fmt:message key="ebpp.portlet.label.file-name" bundle="${bndlLang}"/></th>
			</tr>
		</thead>
		<!-- End: table header row -->
		<!-- Begin: repeated data rows -->
		<tbody>
			<c:forEach items="${psb.rejectedPayments}" var="rp">
			<tr>				
				<td>${BillerList[psb.partnerKey].partnerName}</td>
				<td>${rp.sadadNumber}</td>
				<td>${rp.errorCode}</td>
				<td>${rp.errorDesc}</td>
				<td>${rp.fileName}</td>
			</tr>
			</c:forEach>
			<!-- End: repeated data rows -->
		</tbody>
	</table>
</fieldset>