<%@ page import="com.sadad.scm.common._1.ConfigurationStatusEnum"%>
<% pageContext.setAttribute("configStatusEnum", ConfigurationStatusEnum.values()); %>

<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmQueryBank" id="frmQueryBank" method="post" action="<portlet:resourceURL id="QueryBankList"/>">
<table style="width: 100%;">
	<tbody>
		<tr>
			<td>
				<table style="width: 100%;">
					<tbody>
						<tr><td><p class="attnbox"><fmt:message key="bank.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p></td></tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="bank.portlet.label.get-bank" bundle="${bndlLang}" /></legend>
					<table>
						<tbody>
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="cmbPartnerKey"><fmt:message key="bank.portlet.label.bank" bundle="${bndlLang}" />&nbsp;:&nbsp;*</label>
								</td>
								<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
									<select name="txtBankId" id="txtBankId" class="outputData" onchange="onChangePartnerKey(this);">
										<option value="">
											<fmt:message key="bank.portlet.label.all" bundle="${bndlLang}"/>
										</option>												
										<c:forEach items="${BankList}" var="bank">
											<option <c:if test="${psb.partnerKey == bank.value.partnerKey}">selected</c:if>
												value="<c:out value="${bank.value.partnerKey}" />">
												<c:out value="${bank.value.partnerName}" />
											</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="PaymentCategory_field"><fmt:message key="bank.portlet.label.status" bundle="${bndlLang}" />&nbsp;:&nbsp;</label>
								</td>
								<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
									<select name="txtBankStatus" id="txtBankStatus" class="outputData">
										<option value="">
											<fmt:message key="bank.portlet.label.all" bundle="${bndlLang}"/>
										</option>													
										<c:forEach items="${configStatusEnum}" var="cfgStatus">
												<option value="${cfgStatus}">${cfgStatus}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<!-- Buttons Group -->
							<tr>
								<td>
									<input type="submit" id="btnSearch" class="button" 
										value="<fmt:message key="bank.portlet.button.search" bundle="${bndlLang}" />" 
										onclick="doQueryFormSubmission('frmQueryBank', 2);" />
								</td>
							</tr>
						</tbody>
					</table>
				</fieldset>
				<!-- END Query Segment -->
			</td>
		</tr>
	</tbody>
</table>
</form>