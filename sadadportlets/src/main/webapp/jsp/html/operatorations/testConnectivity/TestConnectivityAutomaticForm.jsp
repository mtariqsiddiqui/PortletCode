<%@ page import="com.sadad.portal.common.utils.SadadOrganisationType2"%>
<%@ page import="com.sadad.portal.common.utils.BillerTestConnectionMessageCode"%>
<%@ page import="com.sadad.portal.common.utils.BankTestConnectionMessageCode"%>
<% pageContext.setAttribute("organisationTypes", SadadOrganisationType2.values()); %>
<% pageContext.setAttribute("billerMsgCodes", BillerTestConnectionMessageCode.values()); %>
<% pageContext.setAttribute("bankMsgCodes", BankTestConnectionMessageCode.values()); %>
<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<p class="attnbox">
	<fmt:message key="ow.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" />
</p>

<form id="frmAutoConfig" name="frmAutoConfig" method="post" action='<portlet:resourceURL id="TestConnectivitySummary"/>'>
	<fieldset>
		<legend><fmt:message key="ow.portlet.label.automatic-configuration" bundle="${bndlLang}"/></legend>
		<table>
			<tbody>
				<tr class="DataEntryFieldRow">
					<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
						<fmt:message key="ow.portlet.label.protocol" bundle="${bndlLang}" /> *
					</td>
					<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
						<select id="cmbProtocol" name="param_protocol" required>
							<option value="TELNET" selected>Telnet</option>
							<option value="PING">Ping</option>
						</select>
					</td>
				</tr>
				<tr class="DataEntryFieldRow">
					<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
						<fmt:message key="ow.portlet.label.partner-type" bundle="${bndlLang}" /> *
					</td>
					<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
						<select name="param_orgType" class="outputData" required id="cmbOrgType" onchange="onChangePartnerType(this.value);" <c:out value="${psb.partnerType != 'sadad' ? 'disabled' : ''}" />>
							<c:forEach items="${organisationTypes}" var="org">
								<option <c:if test="${ psb.partnerType == org.value || org.value == psb.orgType }">selected</c:if> value="${org.value}">
									${org.name}
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr class="DataEntryFieldRow">
					<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
						<fmt:message key="ow.portlet.label.select-partner" bundle="${bndlLang}" /> *
					</td>
					<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
						<select class="outputData" id="cmbBillerId" onchange="partnerKeyChange(this.value);">
							<c:choose>
								<c:when test="${psb.partnerType == 'biller'}">
									<option selected value="<c:out value='${psb.partnerKey}' />">
										<c:out value="${BillerList[psb.partnerKey].partnerName}" />
									</option>
								</c:when>
								<c:otherwise>
									<c:forEach items="${BillerList}" var="biller">
										<option value="<c:out value="${biller.value.partnerKey}"/>" <c:if test="${biller.value.partnerKey == psb.orgId}">selected</c:if>>
											<c:out value="${biller.value.partnerName}" />
										</option>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</select>
						<select class="outputData" id="cmbBankId" onchange="partnerKeyChange(this.value);">
							<c:choose>
								<c:when test="${psb.partnerType == 'bank' }">
									<option selected value="<c:out value='${psb.partnerKey}' />">
										<c:out value="${BankList[psb.partnerKey].partnerName}" />
									</option>
								</c:when>
								<c:otherwise>
									<c:forEach items="${BankList}" var="bank">
										<option value="<c:out value="${bank.value.partnerKey}"/>" <c:if test="${bank.value.partnerKey == psb.orgId}">selected</c:if>>
										<c:out value="${bank.value.partnerName}" />
										</option>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</select>
						<button id="callSrchEngnBtn" type="button" onclick="#">
							<img src="/static/images/search.png" height="12px" width="12px">
						</button>
					</td>
				</tr>
				<tr class="DataEntryFieldRow">
					<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
						<fmt:message key="ow.portlet.label.select-msg-code" bundle="${bndlLang}" /> *
					</td>
					<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
						<select class="outputData" id="cmbBillerCodes" onchange="msgCodeChange(this.value);">
							<c:forEach items="${billerMsgCodes}" var="blmc">
								<option value="${blmc.value}">
									${blmc.name}
								</option>
							</c:forEach>
						</select>
						<select class="outputData" id="cmbBankCodes" onchange="msgCodeChange(this.value);">
							<c:forEach items="${bankMsgCodes}" var="bkmc">
								<option value="${bkmc.value}">
									${bkmc.name}
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>				
				<tr class="DataEntryFieldRow">
					<td colspan="2" style="width: 100%" valign="top" nowrap>
						<input type="hidden" name="param_testType" value="Automatic" />
						<input type="hidden" name="param_operation" value="callTestConnectionAutomatic" />
						<input type="hidden" id="txtMsgCode" name="param_msgCode" value="" />
						<input type="hidden" id="txtPartnerId" name="param_orgId" value="" />
						
						<input class="button" type="submit" onclick="doQueryFormSubmission('frmAutoConfig', 2);" value='<fmt:message key="ow.portlet.button.test-connection" bundle="${bndlLang }"/>'>
						&nbsp;						
						<a href="#" onclick="doPostUrl('<portlet:resourceURL id="TestConnectivityManualForm" />', 1)">
							<fmt:message key="ow.portlet.label.manual-test" bundle="${bndlLang}"/>
						</a>
					</td>
				</tr>
			</tbody>
		</table>
	</fieldset>
</form>