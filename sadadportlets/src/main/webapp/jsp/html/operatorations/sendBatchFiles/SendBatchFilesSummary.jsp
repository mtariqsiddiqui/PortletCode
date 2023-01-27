<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
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
			<td>
				<portlet:resourceURL var="sendBatchFileUrl">
					<portlet:param name="param_orgId" value="${file.value.partnerKey}" />
					<portlet:param name="param_sendBatchFiles" value="${file.key}" />
					<portlet:param name="param_jsonObj" value="jsonObj" />
					<portlet:param name="param_operation" value="callDropMessageInQueueForSendingFile" />
				</portlet:resourceURL>
				<input type="hidden" id="txt_SBF_${file.key}" value="${sendBatchFileUrl}"/>
				<a title="<fmt:message key="ow.portlet.label.send-batch-files" bundle="${bndlLang}"/>" href="#" onclick='sendBatchFileMessage("${sendBatchFileUrl}", 1);'>
					<img width="25" height="25" border="0" src="/static/images/send.png"
					 alt="<fmt:message key="ow.portlet.label.send-batch-files" bundle="${bndlLang}"/>" style="display: inline-block;">
				</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</fieldset>