<br/><jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>
<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="ebpp.portlet.label.refunds-summary" bundle="${bndlLang}"/></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="ebpp.portlet.label.refund-id" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.bank" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.biller" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.customer" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.refund-status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.notification-status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.reconciliation-status" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.options" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:forEach items="${psb.refunds}" var="rfd">
			<tr>
				<td>${rfd.value.refundId}</td>
				<td>${BankList[rfd.value.bankId].partnerName}</td>
				<td>${BillerList[rfd.value.billerId].partnerName}</td>
				<td>${rfd.value.customerId}</td>
				<td>${rfd.value.refundStatus}</td>
				<td>${rfd.value.notificationStatus}</td>
				<td>${rfd.value.refundStatus}</td>
				<td>
					<portlet:resourceURL var="refundDetailsUrl" id="core_RefundsDetails">
						<portlet:param name="param_refundKey" value="${rfd.key}"/>
					</portlet:resourceURL>
					<a href="#" title="Click to see more details" onclick='doPostUrl("${refundDetailsUrl}", 1);'>
						<img width="25" height="25" border="0" alt="Refund Details" src='${thisRequest.getContextPath()}/static/images/option_icon.png'>
					</a>
				</td>
			</tr>
		</c:forEach>
		<!-- End: repeated data rows -->
	</tbody>
</table>
<p><input id="applyPaymentChanges" class="button" style="display: inline" value="<fmt:message key="ebpp.portlet.button.apply-changes" bundle="${bndlLang}"/>" onclick="" type="submit"></p>

</fieldset>