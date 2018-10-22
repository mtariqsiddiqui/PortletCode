<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="ebpp.portlet.label.payments-summary" bundle="${bndlLang}"/></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="ebpp.portlet.label.biller-name" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.bank-name" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.account-number" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.sptn" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.amount" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.service-id" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.refund-id" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.options" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:forEach items="${psb.payments}" var="pay">
			<tr>
				<td>${BillerList[psb.billerId].partnerName}</td>
				<td>${pay.value.bankName}</td>
				<td>${pay.value.accountNumber}</td>
				<td>${pay.value.sadadNumber}</td>
				<td>${pay.value.amount}</td>
				<td>${pay.value.paymentStatus}</td>
				<td>${pay.value.serviceId}</td>
				<td>${pay.value.refundId}refund-id</td>
				<td>
					<portlet:resourceURL var="paymentDetailsUrl" id="core_PaymentsDetails">
						<portlet:param name="param_paymentKey" value="${pay.key}"/>
					</portlet:resourceURL>
					<a href="#" title="Click to see more details" onclick='doPostUrl("${paymentDetailsUrl}", 1);'>
						<img width="25" height="25" border="0" alt="Account Details" src='${thisRequest.getContextPath()}/static/images/option_icon.png'>
					</a>
				</td>
			</tr>
		</c:forEach>
		<!-- End: repeated data rows -->
	</tbody>
</table>
<p><input id="applyPaymentChanges" class="button" style="display: inline" value="<fmt:message key="ebpp.portlet.button.apply-changes" bundle="${bndlLang}"/>" onclick="" type="submit"></p>

</fieldset>