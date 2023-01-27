<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<script type="text/javascript">
// paymentMap contains the original status of the payments
var paymentMap = new Map(); 
// chngeMap contains the changed status of the payments
var changeMap = new Map();
</script>
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
			<th><fmt:message key="ebpp.portlet.label.options" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
		<!-- Begin: repeated data rows -->
		<c:forEach items="${psb.payments}" var="pay">
			<script type="text/javascript"> paymentMap.set('${pay.key}', '${pay.value.paymentStatus}'); paymentMap.set('changeStatusUrl', '<portlet:resourceURL />'); </script>
			<tr>
				<td>${BillerList[pay.value.billerId].partnerName}</td>
				<td>${BankList[pay.value.bankId].partnerName}</td>
				<td>${pay.value.accountNumber}</td>
				<td>${pay.value.sadadNumber}</td>
				<td>${pay.value.amount}</td>
				<td>
					<c:choose>
						<c:when test="${psb.partnerType == 'sadad' && psb.userType == 'admin'}">
							<c:choose>
								<c:when test="${ pay.value.paymentStatus == 'ADVISED' }">
									<c:set var="showButton" value="Yes" scope="page"/>
									${pay.value.ADVISED_OPTIONS(pay.key)}
								</c:when>
								<c:when test="${ pay.value.paymentStatus == 'TIMEOUT' }">
									<c:set var="showButton" value="Yes" scope="page"/>
									${pay.value.TIMEOUT_OPTIONS(pay.key)}
								</c:when>								
								<c:when test="${ pay.value.paymentStatus == 'CANCELED' }">
									<c:set var="showButton" value="Yes" scope="page"/>
									${pay.value.CANCELED_OPTIONS(pay.key)}
								</c:when>
								<c:otherwise>${pay.value.paymentStatus}</c:otherwise>
							</c:choose>						
						</c:when>
						<c:otherwise>${pay.value.paymentStatus}</c:otherwise>
					</c:choose>
				</td>
				<td>
					<portlet:resourceURL var="paymentDetailsUrl" id="core_PaymentsDetails">
						<portlet:param name="param_paymentKey" value="${pay.key}"/>
					</portlet:resourceURL>
					<a href="#" title="Click to see more details" onclick='doPostUrl("${paymentDetailsUrl}", 1);' style="display: inline-block;">
						<img width="25" height="25" border="0" alt="Details" src='/static/images/option_icon.png'>
					</a>
				</td>
			</tr>
		</c:forEach>
		<!-- End: repeated data rows -->
	</tbody>
</table>
<p>
<c:if test="${psb.partnerType == 'sadad' && psb.userType == 'admin' && showButton == 'Yes'}">
	<input type="button" id="applyPaymentChanges" class="button" style="display: inline" 
		value="<fmt:message key="ebpp.portlet.button.apply-changes" bundle="${bndlLang}"/>" 
		onclick=" changeMap.forEach(applyPaymentStatusChange);">
</c:if>
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