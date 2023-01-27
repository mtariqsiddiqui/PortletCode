<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="payment-type.portlet.label.payment-type-list" bundle="${bndlLang}" /></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<%-- <th><fmt:message key="payment-type.portlet.label.biller-id" bundle="${bndlLang}" /></th>
			<th><fmt:message key="payment-type.portlet.label.biller-name" bundle="${bndlLang}" /></th> --%>
			<th><fmt:message key="payment-type.portlet.label.payment-type" bundle="${bndlLang}" /></th>
			<th><fmt:message key="payment-type.portlet.label.status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="payment-type.portlet.label.action" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:forEach items="${psb.paymentTypeList}" var="paymentTypeList">
			<tr>
				<%-- <td>${psb.billerId}</td>
				<td>${BillerList[psb.billerId].partnerName}</td> --%>
				<td>${paymentTypeList.paymentType}</td>				
				<td>${paymentTypeList.status}</td>
				<td>
				<a href="#" title='<fmt:message key="payment-type.portlet.more-details" bundle="${bndlLang}"/>'
					onclick='doPostUrl("<portlet:resourceURL id="QueryPaymentTypeDetails"><portlet:param name="param_billerId" value="${psb.billerId}"/><portlet:param name="param_paymentType" value="${paymentTypeList.paymentType}"/><portlet:param name="param_operation" value="callGetPaymentType"/></portlet:resourceURL>", 1);' style="display: inline-block;">
						<img border="0"
						src='/static/images/item_details.png'/>
				</a></td>
			</tr>
		</c:forEach>
		<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>