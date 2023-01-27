<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td class="myCaption">
				<fmt:message key="iban.portlet.label.iban-details" bundle="${bndlLang}" />
			</td>
		</tr>
		<tr>
			<td>
				<c:if test="${empty psb.action}">
				<c:if test="${!empty psb.ibans[psb.ibanKey].currentRecord}">
				<table class="tableclass">
					<tbody>
					<tr>
						<th style="width: 20%"></th>
						<th style="width: 40%"><fmt:message key="iban.portlet.label.existing-record" bundle="${bndlLang}" /></th>
						<th style="width: 40%"><fmt:message key="iban.portlet.label.pending-approval-record" bundle="${bndlLang}" /></th>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.biller-id" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].billerId}</td>
						<td>${psb.ibans[psb.ibanKey].billerId}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.biller-name" bundle="${bndlLang}" /></th>
						<td>${BillerList[psb.ibans[psb.ibanKey].billerId].partnerName}</td>
						<td>${BillerList[psb.ibans[psb.ibanKey].billerId].partnerName}</td>		
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.iban" bundle="${bndlLang}" /></th>
						<td <c:if test="${psb.ibans[psb.ibanKey].currentRecord.iban ne psb.ibans[psb.ibanKey].pendingRecord.iban}">class="crnt_rcrd"</c:if>>${psb.ibans[psb.ibanKey].currentRecord.iban}</td>
						<td <c:if test="${psb.ibans[psb.ibanKey].currentRecord.iban ne psb.ibans[psb.ibanKey].pendingRecord.iban}">class="pndg_rcrd"</c:if>>${psb.ibans[psb.ibanKey].pendingRecord.iban}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.settlement-id" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].currentRecord.settlementId}</td>
						<td>${psb.ibans[psb.ibanKey].pendingRecord.settlementId}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.customer-id" bundle="${bndlLang}" /></th>
						<td <c:if test="${(psb.ibans[psb.ibanKey].currentRecord.customerIdType ne psb.ibans[psb.ibanKey].pendingRecord.customerIdType) || (psb.ibans[psb.ibanKey].currentRecord.customerId ne psb.ibans[psb.ibanKey].pendingRecord.customerId)}">class="crnt_rcrd"</c:if>>${psb.ibans[psb.ibanKey].currentRecord.customerIdType}_${psb.ibans[psb.ibanKey].currentRecord.customerId}</td>
						<td <c:if test="${(psb.ibans[psb.ibanKey].currentRecord.customerIdType ne psb.ibans[psb.ibanKey].pendingRecord.customerIdType) || (psb.ibans[psb.ibanKey].currentRecord.customerId ne psb.ibans[psb.ibanKey].pendingRecord.customerId)}">class="pndg_rcrd"</c:if>>${psb.ibans[psb.ibanKey].pendingRecord.customerIdType}_${psb.ibans[psb.ibanKey].pendingRecord.customerId}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.status" bundle="${bndlLang}" /></th>
						<td <c:if test="${psb.ibans[psb.ibanKey].currentRecord.status ne psb.ibans[psb.ibanKey].pendingRecord.status}">class="crnt_rcrd"</c:if>>${psb.ibans[psb.ibanKey].currentRecord.status}</td>
						<td <c:if test="${psb.ibans[psb.ibanKey].currentRecord.status ne psb.ibans[psb.ibanKey].pendingRecord.status}">class="pndg_rcrd"</c:if>>${psb.ibans[psb.ibanKey].pendingRecord.status}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.create-date" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].currentRecord.createDate}</td>
						<td>${psb.ibans[psb.ibanKey].pendingRecord.createDate}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.action" bundle="${bndlLang}" /></th>
						<td></td>
						<td>${psb.ibans[psb.ibanKey].pendingRecord.action}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.justification" bundle="${bndlLang}" /></th>
						<td></td>
						<td>${psb.ibans[psb.ibanKey].pendingRecord.justification}</td>
					</tr>
					</tbody>
				</table></c:if>
				<c:if test="${empty psb.ibans[psb.ibanKey].currentRecord}">
				<table class="tableclass">
					<tbody>
					<tr>
						<th style="width: 20%"></th>
						<th style="width: 40%"><fmt:message key="iban.portlet.label.pending-approval-record" bundle="${bndlLang}" /></th>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.biller-id" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].billerId}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.biller-name" bundle="${bndlLang}" /></th>
						<td>${BillerList[psb.ibans[psb.ibanKey].billerId].partnerName}</td>		
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.iban" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].pendingRecord.iban}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.settlement-id" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].pendingRecord.settlementId}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.customer-id" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].pendingRecord.customerIdType}_${psb.ibans[psb.ibanKey].pendingRecord.customerId}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.status" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].pendingRecord.status}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.create-date" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].pendingRecord.createDate}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.action" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].pendingRecord.action}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.justification" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].pendingRecord.justification}</td>
					</tr>
					</tbody>
				</table></c:if>
				</c:if>
				<%-- <c:if test="${!empty psb.action and (psb.action eq psb.getACTION_APPROVE() or psb.action eq psb.getACTION_REJECT())}"> --%>
				<c:if test="${!empty psb.action and (psb.action eq PortalConstant.ACTION_APPROVE or psb.action eq PortalConstant.ACTION_REJECT)}">
				<table class="tableclass">
					<tbody>
					<tr>
						<th style="width: 20%"></th>
						<th style="width: 40%"><fmt:message key="iban.portlet.label.approval-rejection-details" bundle="${bndlLang}" /></th>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.biller-id" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].billerId}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.biller-name" bundle="${bndlLang}" /></th>
						<td>${BillerList[psb.ibans[psb.ibanKey].billerId].partnerName}</td>		
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.iban" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].currentRecord.iban}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.settlement-id" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].currentRecord.settlementId}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.customer-id" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].currentRecord.customerIdType}_${psb.ibans[psb.ibanKey].currentRecord.customerId}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.status" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].currentRecord.status}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.create-date" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].currentRecord.createDate}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.action" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].pendingRecord.action}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.justification" bundle="${bndlLang}" /></th>
						<td>${psb.justification}</td>
					</tr>
					</tbody>
				</table></c:if>
			</td>
		</tr>
		<tr>
			<td>
				<c:if test="${psb.ibans[psb.ibanKey].approvalRejectAllowed}">
				<portlet:resourceURL id="ApproveIbanUpdateForm" var="approveIbanUrl">
					<portlet:param name="param_action" value="APPROVE"/>
					<portlet:param name="param_ibanKey" value="${iban.key}"/>
				</portlet:resourceURL>
				<input type="button" class="button" value="<fmt:message key="iban.portlet.button.approve" bundle="${bndlLang}" />" onclick="doPostUrl('${approveIbanUrl}', 1);" />
				<portlet:resourceURL id="ApproveIbanUpdateForm" var="rejectIbanUrl">
					<portlet:param name="param_action" value="REJECT"/>
					<portlet:param name="param_ibanKey" value="${iban.key}"/>
				</portlet:resourceURL>
				<input type="button" class="button" value="<fmt:message key="iban.portlet.button.reject" bundle="${bndlLang}" />" onclick="doPostUrl('${rejectIbanUrl}', 1);" />
				</c:if>
				<form method="post" action='<portlet:actionURL/>'>
					<input type="hidden" name="fpWhereTo" id="fpWhereTo" value=""/>
					<input type="submit" class="button" onclick="navigate(this);" name="back" value="<fmt:message key="iban.portlet.button.back" bundle="${bndlLang}"/>"/>
					<input type="submit" class="button" onclick="navigate(this);" name="finish" value="<fmt:message key="iban.portlet.button.finish" bundle="${bndlLang}"/>" />
				</form>
			</td>
		</tr>
	</tbody>
</table>
