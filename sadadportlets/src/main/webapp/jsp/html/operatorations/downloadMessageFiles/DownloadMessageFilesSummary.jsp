<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<!-- <fieldset>
<table id="detailTable" class="tableclass" style="width: 100%;">
	<caption class="myCaption"><fmt:message key="ow.portlet.label.file-summary" bundle="${bndlLang}"/></caption>
	<thead>
		<tr>
			<th><fmt:message key="ow.portlet.label.asynchronous-rquid" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ow.portlet.label.rquid" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ow.portlet.label.organisation-name" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ow.portlet.label.arrival-date" bundle="${bndlLang}"/></th>			
			<th><fmt:message key="ow.portlet.label.file-name" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ow.portlet.label.status" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ow.portlet.label.options" bundle="${bndlLang}"/></th>
			<%-- 
			<th><fmt:message key="ow.portlet.label.file-category" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ow.portlet.label.rquid" bundle="${bndlLang}"/></th>
			<th><fmt:message key="ow.portlet.label.processed-date" bundle="${bndlLang}"/></th>
			--%>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${psb.files}" var="file">
		<tr>
			<td>${file.value.rquid}</td>
			<td>${file.value.uuid}</td>
			<td>
				<c:if test="${psb.orgType == 'biller'}">
					${BillerList[file.value.partnerKey].partnerName}
				</c:if>
				<c:if test="${psb.orgType == 'bank'}">
					${BankList[file.value.partnerKey].partnerName}
				</c:if>
			</td>
			<td>${file.value.fileCreationDate}</td>
			<td>${file.value.fileName}</td>
			<td>${file.value.status}</td>
			<%-- 
			<td>${file.value.fileType}</td>
			<td>${file.value.rquid}</td>
			<td>${file.value.fileProcessingDate}</td> 
			--%>
			<td>
				<portlet:resourceURL var="sendBatchFileUrl">
					<portlet:param name="param_orgId" value="${file.value.partnerKey}" />
					<portlet:param name="param_rquid" value="${file.value.rquid}" />
					<portlet:param name="param_fileType" value="${file.value.fileType}" />
					<portlet:param name="param_fileName" value="${file.value.fileName}" />
					<portlet:param name="param_jsonObj" value="jsonObj" />
					<portlet:param name="param_operation" value="callDropMessageForSendingFile" />
				</portlet:resourceURL>
				<a title="<fmt:message key="ow.portlet.label.send-batch-files" bundle="${bndlLang}"/>" href="#" onclick='sendBatchFileMessage("${sendBatchFileUrl}", 1);'>
					<img width="25" height="25" border="0" src="src='/static/images/send.png"
					 alt="<fmt:message key="ow.portlet.label.send-batch-files" bundle="${bndlLang}"/>" style="display: inline-block;">
				</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<p>
	<input type="button" class="button" value="<fmt:message key="ow.portlet.label.send-batch-files" bundle="${bndlLang}"/>" />
</p>
</fieldset>
 -->