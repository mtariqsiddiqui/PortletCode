<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="access-channel.portlet.label.access-channel-list" bundle="${bndlLang}" /></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="access-channel.portlet.label.access-channel" bundle="${bndlLang}" /></th>
			<th><fmt:message key="access-channel.portlet.label.description" bundle="${bndlLang}" /></th>
			<th><fmt:message key="access-channel.portlet.label.status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="access-channel.portlet.label.action" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:choose>
			<c:when test="${empty psb.accessChannel}">
				<c:forEach items="${AccessChannelList}" var="achList">
					<tr>
						<td>${achList.value.code}</td>
						<td>${achList.value.description}</td>
						<td>${achList.value.status}</td>
						<td>
							<portlet:resourceURL id="QueryAccessChannelDetails" var="accessChannelDetailsUrl">
								<portlet:param name="param_accessChannel" value="${achList.value.code}"/>
								<portlet:param name="param_operation" value="callGetAccessChannel"/>
							</portlet:resourceURL>
							<a href="#" title='<fmt:message key="access-channel.portlet.more-details" bundle="${bndlLang}"/>' onclick='doPostUrl("${accessChannelDetailsUrl}", 1);' style="display: inline-block;">
								<img border="0" src='/static/images/item_details.png'/>
							</a>
						</td>
					</tr>
				</c:forEach>	
			</c:when>
			<c:otherwise>
				<tr>
					<td>${AccessChannelList[psb.accessChannel].code}</td>
					<td>${AccessChannelList[psb.accessChannel].description}</td>					
					<td>${AccessChannelList[psb.accessChannel].status}</td>
					<td>
						<portlet:resourceURL id="QueryAccessChannelDetails" var="accessChannelDetailsUrl">
							<portlet:param name="param_accessChannel" value="${psb.accessChannel}"/>
							<portlet:param name="param_operation" value="callGetAccessChannel"/>
						</portlet:resourceURL>					
						<a href="#" title='<fmt:message key="access-channel.portlet.more-details" bundle="${bndlLang}"/>' onclick='doPostUrl("${accessChannelDetailsUrl}", 1);' style="display: inline-block;">
								<img border="0" src='/static/images/item_details.png'/>
						</a>
					</td>
				</tr>
			</c:otherwise>
		</c:choose>			
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>