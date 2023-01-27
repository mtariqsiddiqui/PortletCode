<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width: 100%;">
	<caption class="myCaption"><fmt:message key="ebpp.portlet.label.file-summary" bundle="${bndlLang}"/></caption>
	<thead>
		<tr>
			<th><fmt:message key="ebpp.portlet.label.organisation-name" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ebpp.portlet.label.file-category" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ebpp.portlet.label.status" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ebpp.portlet.label.rquid" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ebpp.portlet.label.file-name" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ebpp.portlet.label.arrival-date" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ebpp.portlet.label.processed-date" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ebpp.portlet.label.options" bundle="${bndlLang}"/></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${psb.files}" var="file">
		<tr>
			<td>
				<c:if test="${psb.orgType == 'biller'}">
					${BillerList[file.value.partnerKey].partnerName}
				</c:if>
				<c:if test="${psb.orgType == 'bank'}">
					${BankList[file.value.partnerKey].partnerName}
				</c:if>
			</td>
			<td>${file.value.fileType}</td>
			<td>${file.value.status}</td>
			<td>${file.value.rquid}</td>
			<td>${file.value.fileName}</td>
			<td>${file.value.fileCreationDate}</td>
			<td>${file.value.fileProcessingDate}</td>
			<td>
				<portlet:resourceURL var="fileDetailsUrl" id="core_FileDetails">
					<portlet:param name="param_fileKey" value="${file.key}"/>
				</portlet:resourceURL>
				<a title="File Details" href="#" onclick='doPostUrl("${fileDetailsUrl}", 1);'>
					<img width="25" height="25" border="0" src="/static/images/file_details.png" alt="File Details" style="display: inline-block;">
				</a>
				<a title="File Download" href="#" onclick="fileDownload('${file.value.fileDownloadUrl}');">
					<img width="25" height="25" border="0" src="/static/images/file_download.png" alt="File Download" style="display: inline-block;">
				</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<p>
<c:if test="${psb.pageNumber > 1}">
	<portlet:resourceURL var="moiPayments" id="core_PaymentsSummary">
		<portlet:param name="param_operation" value="callPaymentService_ListByPayor"/>
	</portlet:resourceURL>
	<input type="button" class="button" 
		value="<fmt:message key="ebpp.portlet.button.fetch-more-data" bundle="${bndlLang}"/>" 
		onclick='doPostUrl("${moiPayments}", 2);'/>
</c:if>
</p>
</fieldset>