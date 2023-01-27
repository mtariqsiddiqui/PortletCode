<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="access-channel.portlet.label.access-channel-list" bundle="${bndlLang}" />:</span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="access-channel.portlet.label.access-channel" bundle="${bndlLang}" /></th>
			<th><fmt:message key="access-channel.portlet.label.description" bundle="${bndlLang}" /></th>
			<th><fmt:message key="access-channel.portlet.label.status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="access-channel.portlet.label.action" bundle="${bndlLang}" />:</th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:forEach items="${psb.accessChannelList}" var="accessChannelList">
			<tr>
				<td>${psb.accessChannel}</td>
				<td>${accessChannelList.description}</td>
				<td>${accessChannelList.status}</td>
				<td>
				<a href="#" title='<fmt:message key="access-channel.portlet.more-details" bundle="${bndlLang}"/>'
					onclick='doPostUrl("<portlet:resourceURL id="QueryAccessChannelDetails"><portlet:param name="txtAccessChannel" value="${accessChannelList.accessChannel}"/></portlet:resourceURL>", 1);'>
						<img border="0"
						src='${thisRequest.getContextPath()}/static/images/item_details.png'/>
				</a></td>
			</tr>
		</c:forEach>
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>