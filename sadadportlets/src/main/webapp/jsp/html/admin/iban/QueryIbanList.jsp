<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="iban.portlet.label.iban-list" bundle="${bndlLang}" /></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="iban.portlet.label.biller" bundle="${bndlLang}" /></th>
			<th><fmt:message key="iban.portlet.label.iban" bundle="${bndlLang}" /></th>
			<th><fmt:message key="iban.portlet.label.customer-id" bundle="${bndlLang}" /></th>
			<th><fmt:message key="iban.portlet.label.settlement-id" bundle="${bndlLang}" /></th>
			<th><fmt:message key="iban.portlet.label.create-date" bundle="${bndlLang}" /></th>
			<th><fmt:message key="iban.portlet.label.status" bundle="${bndlLang}" /></th>
			<c:if test="${psb.pageNumber >= -1}"><th><fmt:message key="iban.portlet.label.action" bundle="${bndlLang}" /></th></c:if>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:forEach items="${psb.ibans}" var="iban">
			<c:choose>
    			<c:when test="${not empty iban.value.pendingRecord}">
    				<c:set var="ibanRec" value="${iban.value.pendingRecord}"></c:set>
    			</c:when>
    			<c:otherwise>
    				<c:set var="ibanRec" value="${iban.value.currentRecord}"/>
			    </c:otherwise>
			</c:choose>
			<tr>
				<td>${BillerList[iban.value.billerId].partnerName}</td>
				<td>${ibanRec.iban}</td>
				<td>${ibanRec.customerIdType}_${ibanRec.customerId}</td>
				<td>${ibanRec.settlementId}</td>
				<td>${ibanRec.createDate}</td>
				<td>${ibanRec.status}</td>
				<c:if test="${psb.pageNumber >= -1}">
				<td><a href="#" title='<fmt:message key="iban.portlet.more-details" bundle="${bndlLang}"/>'
					onclick='doPostUrl("<portlet:resourceURL id="QueryIbanDetails"><portlet:param name="param_ibanKey" value="${iban.key}"/></portlet:resourceURL>", 1);' style="display: inline-block;">
						<img border="0" src='/static/images/item_details.png'/>
					</a></td></c:if>
			</tr>
		</c:forEach>	
		<!-- End: repeated data rows -->
	</tbody>
</table>
<p>
<c:if test="${psb.pageNumber > 0}">
	<c:if test="${psb.pageNumber > 1}">
		<portlet:resourceURL var="fetchPrevPage" id="QueryIbanList">
			<portlet:param name="param_fetchOperator" value="-"/>
			<portlet:param name="param_operation" value="callListIban"/>
		</portlet:resourceURL>
		<input type="button" class="button" 
			value="<fmt:message key="iban.portlet.button.fetch-prev-page" bundle="${bndlLang}"/>" 
			onclick='doPostUrl("${fetchPrevPage}", 2);'/>
	</c:if>
	<c:if test="${psb.pageNumber < psb.totalPages}">
		<portlet:resourceURL var="fetchNextPage" id="QueryIbanList">
			<portlet:param name="param_fetchOperator" value="+"/>
			<portlet:param name="param_operation" value="callListIban"/>
		</portlet:resourceURL>
		<input type="button" class="button" 
			value="<fmt:message key="iban.portlet.button.fetch-next-page" bundle="${bndlLang}"/>" 
			onclick='doPostUrl("${fetchNextPage}", 2);'/>
	</c:if>
</c:if>
</p>
</fieldset>