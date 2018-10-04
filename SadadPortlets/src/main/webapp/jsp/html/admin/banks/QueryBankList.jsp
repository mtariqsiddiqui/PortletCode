<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="bank.portlet.label.bank-list" bundle="${bndlLang}" /></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="bank.portlet.label.bank-id" bundle="${bndlLang}" /></th>
			<th><fmt:message key="bank.portlet.label.bank-name" bundle="${bndlLang}" /></th>
			<th><fmt:message key="bank.portlet.label.status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="bank.portlet.label.action" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
	<c:choose>
		<c:when test="${empty psb.selectedBank}">
			<c:forEach items="${BankList}" var="bank">
				<tr>
					<td>${bank.value.partnerKey}</td>
					<td>${bank.value.partnerName}</td>
					<td>${bank.value.partnerStatus}</td>
					<td>
					<a href="#" title='<fmt:message key="bank.portlet.more-details" bundle="${bndlLang}"/>'
						onclick='doPostUrl("<portlet:resourceURL id="QueryBankDetails"><portlet:param name="txtBankId" value="${bank.value.partnerKey}"/></portlet:resourceURL>", 1);'>
							<img border="0"
							src='${thisRequest.getContextPath()}/static/images/item_details.png'/>
					</a></td>
				</tr>
			</c:forEach>	
		</c:when>
		<c:otherwise>
			<tr>
				<td>${psb.partnerKey}</td>
				<td>${BankList[psb.partnerKey].partnerName}</td>
				<td>${BankList[psb.partnerKey].partnerStatus}</td>
				<td>
				<a href="#" title='<fmt:message key="bank.portlet.more-details" bundle="${bndlLang}"/>'
					onclick='doPostUrl("<portlet:resourceURL id="QueryBankDetails"><portlet:param name="txtBankId" value="${psb.partnerKey}"/></portlet:resourceURL>", 1);'>
						<img border="0"
						src='${thisRequest.getContextPath()}/static/images/item_details.png'/>
				</a></td>
			</tr>
		</c:otherwise>
	</c:choose>
	<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>