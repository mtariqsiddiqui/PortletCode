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
	<legend><fmt:message key="ebpp.portlet.label.get-rejected-accounts" bundle="${bndlLang}"/></legend>
	<form name="frmAdvRejAccount" id="frmAdvRejAccount" method="post" action='<portlet:resourceURL id="RejectedAccountsList"/>'>
		<table class="dataEntryPageTable" style="width:100%; border: none; padding: 10px; border-collapse: separate; border-spacing: 10px;">
			<!-- Begin: Data entry fields -->
			<tbody>
				<tr class="DataEntryFieldRow">
					<td class="labelCell"style="width: 20%; vertical-align: top; height: 27" nowrap>
						<label class="label" for="txtRquid"><fmt:message key="ebpp.portlet.label.rquid" bundle="${bndlLang}"/> *</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
						<input type="text" name="param_rquid" id="txtRquid" value="${psb.rquid}" autocomplete="off" maxlength="36" class="rqf"/>
					</td>
				</tr>
					<tr class="DataEntryFieldRow">
						<td class="labelCell"style="width: 20%; vertical-align: top; height: 27" nowrap>
							<label class="label" for="fpBillerId">
								<fmt:message key="ebpp.portlet.label.biller" bundle="${bndlLang}"/> *
							</label>
						</td>
						<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
							<select name="param_billerId" class="rqf" id="fpBillerId">
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
											<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
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
							<%-- Display Search Engine to SADAD and Bank Users --%>
							<c:if test="${psb.partnerType == 'bank' or psb.partnerType == 'sadad'}">
								<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('fpBillerId', 'e13b5b1608ad566f94ba9fe7849aca38');">
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
							<label class="label" for="txtEntityKey"><fmt:message key="ebpp.portlet.label.account-number" bundle="${bndlLang}"/> *</label>
						</td>
						<td class="outputDataCell" width="100%" valign="top" nowrap>
							<input name="param_ebppEntityKey" class="rqf" value="${psb.ebppEntityKey}" id="txtEntityKey" autocomplete="off" maxlength="50" type="text"/>
							
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="hidden" name="param_operation" value="callBulkUploadService_GetRejected" />
							<input type="hidden" name="param_searchType" value="ACCOUNT" />						
							<input class="button" value="<fmt:message key="ebpp.portlet.button.search" bundle="${bndlLang}"/>" onclick="doQueryFormSubmission('frmAdvRejAccount', 2)" type="submit"/>
							<portlet:resourceURL id="RejectedAccountAdvanceForm" var="clearURL"><portlet:param name="param_operation" value="clearSessionBeanObject"/></portlet:resourceURL>
							<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.clear" bundle="${bndlLang}"/>" onclick="doQueryFormReset('${clearURL}');" />
						&nbsp;&nbsp;
							<div style="display: inline-block;">
								<a href="#" onclick="doPostUrl('<portlet:resourceURL id="RejectedAccountForm"/>', 1);"><fmt:message key="ebpp.portlet.label.simple-search" bundle="${bndlLang}"/> </a>
							</div>	
						</td>
					</tr>
			</tbody>
		</table>
	</form>
</fieldset>