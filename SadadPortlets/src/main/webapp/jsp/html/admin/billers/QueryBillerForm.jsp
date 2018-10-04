<%@ page import="com.sadad.scm.common._1.ConfigurationStatusEnum"%>
<% pageContext.setAttribute("configStatusEnum", ConfigurationStatusEnum.values()); %>

<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmQueryBiller" id="frmQueryBiller" method="post" action="<portlet:resourceURL id="QueryBillerList"/>">
<table style="width: 100%;">
	<tbody>
		<tr>
			<td>
				<table style="width: 100%;">
					<tbody>
						<tr><td><p class="attnbox"><fmt:message key="biller.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p></td></tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="biller.portlet.label.get-biller" bundle="${bndlLang}" /></legend>
					<table>
						<tbody>
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="cmbPartnerKey"><fmt:message key="biller.portlet.label.biller" bundle="${bndlLang}" />&nbsp;:&nbsp;*</label>
								</td>
								<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
									<select name="txtBillerId" id="txtBillerId" class="outputData" onchange="onChangePartnerKey(this);">
										<option value="">
											<fmt:message key="biller.portlet.label.all" bundle="${bndlLang}"/>
										</option>												
										<c:forEach items="${BillerList}" var="biller">
											<option <c:if test="${psb.partnerKey == biller.value.partnerKey}">selected</c:if>
												value="<c:out value="${biller.value.partnerKey}" />">
												<c:out value="${biller.value.partnerName}" />
											</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="PaymentCategory_field"><fmt:message key="biller.portlet.label.status" bundle="${bndlLang}" />&nbsp;:&nbsp;</label>
								</td>
								<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
									<select name="txtBillerStatus" id="txtBillerStatus" class="outputData">
										<option value="">
											<fmt:message key="biller.portlet.label.all" bundle="${bndlLang}"/>
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
										value="<fmt:message key="biller.portlet.button.search" bundle="${bndlLang}" />" 
										onclick="doQueryFormSubmission('frmQueryBiller', 2);" />
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