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
						<label class="label" for="fpRquid"><fmt:message key="ebpp.portlet.label.rquid" bundle="${bndlLang}"/> *</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
						<input class="outputData" value="${psb.rquid}" name="param_rquid" id="txtRquid" autocomplete="off" maxlength="256" type="text" required/>
					</td>
				</tr>
					<tr class="DataEntryFieldRow">
						<td class="labelCell"style="width: 20%; vertical-align: top; height: 27" nowrap>
							<label class="label" for="fpBillerId">
								<fmt:message key="ebpp.portlet.label.biller" bundle="${bndlLang}"/> *
							</label>
						</td>
						<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
							<select name="param_billerId" class="outputData" required="true" id="fpBillerId" onchange="onChangePartnerKey(this);">
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
							<label class="label" for="fpAccountNumber"><fmt:message key="ebpp.portlet.label.account-number" bundle="${bndlLang}"/> *</label>
						</td>
						<td class="outputDataCell" width="100%" valign="top" nowrap="">
							<input name="param_ebppEntityKey" class="outputData" value="${psb.ebppEntityKey}" id="fpAccountNumber" autocomplete="off" maxlength="256" type="text" required/>
						</td>
					</tr>
					<tr>
						<td align="left" colspan="2">
							<input class="button" value="<fmt:message key="ebpp.portlet.button.search" bundle="${bndlLang}"/>" onclick="doQueryFormSubmission('frmAdvRejAccount', 2)" type="submit"/>
							<input class="button" value="<fmt:message key="ebpp.portlet.button.clear" bundle="${bndlLang}"/>" onclick=";" type="button"/>
							<div style="display: inline;">
								<a href="#" onclick="doPostUrl('<portlet:resourceURL id="RejectedAccountForm"/>', 1);"><fmt:message key="ebpp.portlet.label.simple-search" bundle="${bndlLang}"/> </a>
							</div>	
						</td>
					</tr>
			</tbody>
		</table>
	</form>
</fieldset>