<%@ page import="com.sadad.scm.common._1.RefundStatusCodeTypeEnums"%>
<%@ page import="com.sadad.schema.service.refundsearch._1.ReconciliationStatusTypeEnum"%>
<% pageContext.setAttribute("refundStatusCodeTypeEnums", RefundStatusCodeTypeEnums.values()); %>
<% pageContext.setAttribute("reconciliationStatusTypeEnum", ReconciliationStatusTypeEnum.values()); %>

<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%;">
	<tbody>
		<tr>
			<td><p class="attnbox"><fmt:message key="ebpp.portlet.marked-fields-are-mandatory" bundle="${bndlLang}"/></p></td>
		</tr>
	</tbody>
</table>
<!-- Main Table -->
<fieldset>
	<legend><fmt:message key="ebpp.portlet.label.search-for-refund" bundle="${bndlLang}"/></legend>
	<form name="frmAdvRejAccount" id="frmAdvRejAccount" method="post" action='<portlet:resourceURL id="core_RefundSummary"/>'>
		<table class="dataEntryPageTable" style="width:100%; border: none; padding: 10px; border-collapse: separate; border-spacing: 10px;">
			<!-- Begin: Data entry fields -->
			<tbody>
				<tr class="DataEntryFieldRow">
					<td class="labelCell"style="width: 20%; vertical-align: top; height: 27" nowrap>
						<label class="label" for="fpBillerId">
							<fmt:message key="ebpp.portlet.label.biller" bundle="${bndlLang}"/> *
						</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
						<select name="param_billerId" class="outputData" required="true" id="cmbBillerId" onchange="onChangePartnerKey(this);">
							<option value="">
								<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
							</option>
							<c:forEach items="${BillerList}" var="biller">
								<option value="<c:out value="${biller.value.partnerKey}" />">
									<c:out value="${biller.value.partnerName}" />
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>					
				<tr class="DataEntryFieldRow">
					<td class="labelCell"style="width: 20%; vertical-align: top; height: 27" nowrap>
						<label class="label" for="fpBillerId">
							<fmt:message key="ebpp.portlet.label.bank" bundle="${bndlLang}"/> *
						</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
						<select name="param_bankId" class="outputData" required="true" id="cmbBankId" onchange="onChangePartnerKey(this);">
							<option value="">
								<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
							</option>
							<c:forEach items="${BankList}" var="bank">
								<option value="<c:out value="${bank.value.partnerKey}" />">
									<c:out value="${bank.value.partnerName}" />
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr class="DataEntryFieldRow">
					<td class="labelCell"style="width: 20%; vertical-align: top; height: 27" nowrap>
						<label class="label" for="fpRquid"><fmt:message key="ebpp.portlet.label.from-date" bundle="${bndlLang}"/> *</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
						<input class="outputData" value="${psb.fromDate}" name="fpFromDate" id="fpFromDate" autocomplete="off" maxlength="256" type="text" required/>
					</td>
				</tr>
				<tr class="DataEntryFieldRow">
					<td class="labelCell"style="width: 20%; vertical-align: top; height: 27" nowrap>
						<label class="label" for="fpBillerId">
							<fmt:message key="ebpp.portlet.label.date-range" bundle="${bndlLang}"/> *
						</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
						<select name="fpBillerId" class="outputData" required="required" id="fpBillerId" onchange="onChangePartnerKey(this);">
							<option value="">
								<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
							</option>
							<c:forEach items="${BillerList}" var="biller">
								<option <c:if test="${psb.billerId == biller.value.partnerKey}">selected</c:if>
									value="<c:out value="${biller.value.partnerKey}" />">
									<c:out value="${biller.value.partnerName}" />
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr class="DataEntryFieldRow">
					<td class="labelCell"style="width: 20%; vertical-align: top; height: 27" nowrap>
						<label class="label" for="fpBillerId">
							<fmt:message key="ebpp.portlet.label.refund-status" bundle="${bndlLang}"/> *
						</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
						<select name="fpBillerId" class="outputData" required="true" id="fpBillerId" onchange="onChangePartnerKey(this);">
							<option value="">
								<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
							</option>
							<c:forEach items="${refundStatusCodeTypeEnums}" var="refundStatus">
								<option value="${refundStatus}">${refundStatus}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr class="DataEntryFieldRow">
					<td class="labelCell"style="width: 20%; vertical-align: top; height: 27" nowrap>
						<label class="label" for="fpBillerId">
							<fmt:message key="ebpp.portlet.label.notification-status" bundle="${bndlLang}"/> *
						</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
						<select name="fpBillerId" class="outputData" required="true" id="fpBillerId" onchange="onChangePartnerKey(this);">
							<option value="">
								<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
							</option>
							<c:forEach items="${reconciliationStatusTypeEnum}" var="reconStatus">
								<option value="${reconStatus}">${reconStatus}</option>
							</c:forEach>							
						</select>
					</td>
				</tr>
				
				<tr class="DataEntryFieldRow">
					<td class="labelCell"style="width: 20%; vertical-align: top; height: 27" nowrap>
						<label class="label" for="fpBillerId">
							<fmt:message key="ebpp.portlet.label.reconciliation-status" bundle="${bndlLang}"/> *
						</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
						<select name="fpBillerId" class="outputData" required="true" id="fpBillerId" onchange="onChangePartnerKey(this);">
							<option value="">
								<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
							</option>
							<c:forEach items="${BillerList}" var="biller">
								<option <c:if test="${psb.billerId == biller.value.partnerKey}">selected</c:if>
									value="<c:out value="${biller.value.partnerKey}" />">
									<c:out value="${biller.value.partnerName}" />
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td align="left" colspan="2">
						<input class="button" value="<fmt:message key="ebpp.portlet.button.search" bundle="${bndlLang}"/>" onclick="doQueryFormSubmission('frmAdvRejAccount', 2)" type="submit"/>
						<input class="button" value="<fmt:message key="ebpp.portlet.button.clear" bundle="${bndlLang}"/>" onclick=";" type="button"/>
						<div style="display: inline;">
							<a href="#" onclick="doPostUrl('<portlet:resourceURL id="QueryRefundForm"/>', 1);"><fmt:message key="ebpp.portlet.label.simple-search" bundle="${bndlLang}"/> </a>
						</div>	
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</fieldset>