<%@ page import="com.sadad.portal.common.utils.DateRange"%>
<%@ page import="com.sadad.scm.common._1.RefundStatusTypeEnums"%>
<%@ page import="com.sadad.schema.service.refundsearch._1.NotificationStatusTypeEnum"%>
<%@ page import="com.sadad.schema.service.refundsearch._1.ReconciliationStatusTypeEnum"%>
<% pageContext.setAttribute("dateRange", DateRange.values()); %>
<% pageContext.setAttribute("refundStatusTypeEnums", RefundStatusTypeEnums.values()); %>
<% pageContext.setAttribute("notificationStatusTypeEnum", NotificationStatusTypeEnum.values()); %>
<% pageContext.setAttribute("reconciliationStatusTypeEnum", ReconciliationStatusTypeEnum.values()); %>

<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%;">
	<tbody>
		<tr>
			<td><p class="attnbox"><fmt:message key="ebpp.portlet.marked-fields-are-mandatory-with-choices" bundle="${bndlLang}"/></p></td>
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
						<label class="label" for="cmbBillerId">
							<fmt:message key="ebpp.portlet.label.biller" bundle="${bndlLang}"/>
						</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
						<select name="param_billerId" class="outputData" id="cmbBillerId">
							<c:choose>
								<c:when test="${psb.partnerType == 'biller' }">
									<option selected value="<c:out value='${psb.partnerKey}' />">
										<c:out value="${BillerList[psb.partnerKey].partnerName}" />
									</option>
								</c:when>
								<c:when test="${psb.partnerType == 'aggregator' }">
									<option value=""><fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/></option>
									<c:forEach items="${AggregatorBillerList[psb.partnerKey]}" var="biller">
										<option <c:if test="${psb.billerId == biller.value.partnerKey}">selected</c:if>
											value="<c:out value="${biller.value.partnerKey}" />">
											<c:out value="${biller.value.partnerName}" />
										</option>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<option value="">
										<fmt:message key="ebpp.portlet.label.all" bundle="${bndlLang}"/>
									</option>
									<c:forEach items="${BillerList}" var="biller">
										<option <c:if test="${psb.billerId == biller.value.partnerKey}">selected</c:if> 
											value="<c:out value="${biller.value.partnerKey}" />">
											<c:out value="${biller.value.partnerName}" />
										</option>
									</c:forEach>
								</c:otherwise>
							</c:choose>							
						</select>
						<%--Display Search Engine to SADAD & Bank users --%>
						<c:if test="${psb.partnerType == 'bank' or psb.partnerType == 'sadad'}">
							<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('cmbBillerId', 'e13b5b1608ad566f94ba9fe7849aca38');">
								<img src="/static/images/search.png" height="12px" width="12px">
							</button>
						</c:if>
						<c:if test="${psb.partnerType == 'aggregator'}"> <%-- Or to Aggregator Users --%>
							<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('cmbPartnerKey', 'a5e383e5e7a87a6844dd02fa04944c35&q1=${psb.hashedPartnerKey}');">
								<img src="/static/images/search.png" height="12px" width="12px">
							</button>
						</c:if>
					</td>
				</tr>					
				<tr class="DataEntryFieldRow">
					<td class="labelCell"style="width: 20%; vertical-align: top; height: 27" nowrap>
						<label class="label" for="cmbBankId">
							<fmt:message key="ebpp.portlet.label.bank" bundle="${bndlLang}"/>
						</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
						<select name="param_bankId" class="outputData" id="cmbBankId">
							<c:choose>
								<c:when test="${psb.partnerType == 'bank' }">
									<option selected value="<c:out value='${psb.partnerKey}' />">
										<c:out value="${BankList[psb.partnerKey].partnerName}" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="">
										<fmt:message key="ebpp.portlet.label.all" bundle="${bndlLang}"/>
									</option>
									<c:forEach items="${BankList}" var="bank">
										<option <c:if test="${psb.bankId == bank.value.partnerKey}">selected</c:if>
											value="<c:out value="${bank.value.partnerKey}" />">
											<c:out value="${bank.value.partnerName}" />
										</option>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</select>
						<%--Display Search Engine to SADAD & Biller users --%>
						<c:if test="${psb.partnerType == 'aggregator' or psb.partnerType == 'biller' or psb.partnerType == 'sadad'}">
							<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('cmbBankId', '32c7fcd2cd9c32b19841d743dc09d56f');">
								<img src="/static/images/search.png" height="12px" width="12px">
							</button>
						</c:if>						
					</td>
				</tr>
				<tr class="DataEntryFieldRow">
					<td class="labelCell"style="width: 20%; vertical-align: top; height: 27" nowrap>
						<label class="label" for="fpFromDate"><fmt:message key="ebpp.portlet.label.from-date" bundle="${bndlLang}"/> *</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
					<input class="rqf" value="${psb.fromDate}" name="param_fromDate" id="fpFromDate" autocomplete="off" maxlength="10" type="text" placeholder="YYYY-MM-DD"/>
					</td>
				</tr>
				<tr class="DataEntryFieldRow">
					<td class="labelCell"style="width: 20%; vertical-align: top; height: 27" nowrap>
						<label class="label" for="cmbDateRange">
							<fmt:message key="ebpp.portlet.label.date-range" bundle="${bndlLang}"/> *
						</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
						<select name="param_dateRange" class="rqf" id="cmbDateRange">
							<option value="">
								<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
							</option>
							<c:forEach items="${dateRange}" var="range">
								<option <c:if test="${psb.dateRange == range.value}">selected</c:if>
								value="${range.value}">${range.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr class="DataEntryFieldRow">
					<td class="labelCell"style="width: 20%; vertical-align: top; height: 27" nowrap>
						<label class="label" for="choice1of3">
							<fmt:message key="ebpp.portlet.label.refund-status" bundle="${bndlLang}"/> **
						</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
						<select name="param_refundStatus" class="rqf" id="choice1of3" onchange="onChangeStatus(this);">
							<option value="">
								<fmt:message key="ebpp.portlet.label.not-selected" bundle="${bndlLang}"/>
							</option>
							<c:forEach items="${refundStatusTypeEnums}" var="refundStatus">
								<option <c:if test="${psb.refundStatus == refundStatus}">selected</c:if> 
									value="${refundStatus}">${refundStatus}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr class="DataEntryFieldRow">
					<td class="labelCell"style="width: 20%; vertical-align: top; height: 27" nowrap>
						<label class="label" for="choice2of3">
							<fmt:message key="ebpp.portlet.label.notification-status" bundle="${bndlLang}"/> **
						</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
						<select name="param_notiStatus" class="rqf" id="choice2of3" onchange="onChangeStatus(this);">
							<option value="">
								<fmt:message key="ebpp.portlet.label.not-selected" bundle="${bndlLang}"/>
							</option>
							<c:forEach items="${notificationStatusTypeEnum}" var="notiStatus">
								<option <c:if test="${psb.notiStatus == notiStatus}">selected</c:if> value="${notiStatus}">${notiStatus}</option>
							</c:forEach>							
						</select>
					</td>
				</tr>
				
				<tr class="DataEntryFieldRow">
					<td class="labelCell"style="width: 20%; vertical-align: top; height: 27" nowrap>
						<label class="label" for="choice3of3">
							<fmt:message key="ebpp.portlet.label.reconciliation-status" bundle="${bndlLang}"/> **
						</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
						<select name="param_reconStatus" class="rqf" 					id="choice3of3" onchange="onChangeStatus(this);">
							<option value="">
								<fmt:message key="ebpp.portlet.label.not-selected" bundle="${bndlLang}"/>
							</option>
							<c:forEach items="${reconciliationStatusTypeEnum}" var="reconStatus">
								<option <c:if test="${psb.reconStatus == reconStatus}">selected</c:if> value="${reconStatus}">${reconStatus}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="hidden" name="param_operation" value="callRefundService_ListRefund" />
						<input class="button" value="<fmt:message key="ebpp.portlet.button.search" bundle="${bndlLang}"/>" onclick="doQueryFormSubmission('frmAdvRejAccount', 2)" type="submit"/>
						<portlet:resourceURL id="QueryRefundAdvanceForm" var="clearURL"><portlet:param name="param_operation" value="clearSessionBeanObject"/></portlet:resourceURL>
						<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.clear" bundle="${bndlLang}"/>" onclick="doQueryFormReset('${clearURL}');" />
						<div style="display: inline-block; padding:5px;">
							<a href="#" onclick="doPostUrl('<portlet:resourceURL id="QueryRefundForm"/>', 1);"><fmt:message key="ebpp.portlet.label.simple-search" bundle="${bndlLang}"/> </a>
						</div>	
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</fieldset>