<%@ page import="com.sadad.portal.common.utils.BillerTypes"%>
<% pageContext.setAttribute("billerTypes", BillerTypes.values()); %>
<%@ page import="com.sadad.scm.common._1.ConfigurationStatusEnum"%>
<% pageContext.setAttribute("configStatusEnum", ConfigurationStatusEnum.values()); %>

<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmQueryBiller" id="frmQueryBiller" method="post" action="<portlet:resourceURL id="QueryBillerList"/>">
<table style="width: 100%;">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="biller.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="biller.portlet.label.search-biller" bundle="${bndlLang}" /></legend>
					<table>
						<tbody>
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="txtBillerId"><fmt:message key="biller.portlet.label.partner-type" bundle="${bndlLang}" /> *</label>
								</td>
								<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
									<select name="param_billerType" id="txtPartnerType" onchange="onChangePartnerType(this.value);"
										<c:out value="${psb.partnerType != 'sadad' ? 'disabled' : ''}" />>
										<c:forEach items="${billerTypes}" var="bType">
											<option <c:if test="${ psb.partnerType == bType.value }">selected</c:if> 
												value="${bType.value}">${bType.name}</option>
										</c:forEach>
									</select>
								</td>
							</tr>	
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="txtBillerId"><fmt:message key="biller.portlet.label.biller-name" bundle="${bndlLang}" /> *</label>
								</td>
								<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
									<select id="txtBillerId" style="display: block-inline;" onchange="onChangePartnerKey(this);">
										<option value="">
											<fmt:message key="biller.portlet.label.all" bundle="${bndlLang}"/>
										</option>												
										<c:forEach items="${BillerOnlyList}" var="biller">
											<option <c:if test="${psb.billerId == biller.value.partnerKey}">selected</c:if>
												value="<c:out value="${biller.value.partnerKey}" />">
												<c:out value="${biller.value.partnerName}" />
											</option>
										</c:forEach>
									</select>
									<button id="srchBiller" type="button" onclick="callSearchEngine('txtBillerId', '76cff8fd2def7b0465d7f1979eb99cd0', 'onChangePartnerKey');" style="display: block-inline;">
										<img src="/static/images/search.png" height="12px" width="12px">
									</button>
									<select id="txtAggregatorId" style="display: block-inline;" onchange="onChangePartnerKey(this);">
										<option value="">
											<fmt:message key="biller.portlet.label.all" bundle="${bndlLang}"/>
										</option>												
										<c:forEach items="${AggregatorList}" var="biller">
											<option <c:if test="${psb.billerId == biller.value.partnerKey}">selected</c:if>
												value="<c:out value="${biller.value.partnerKey}" />">
												<c:out value="${biller.value.partnerName}" />
											</option>
										</c:forEach>
									</select>
									<button id="srchAggregator" type="button" onclick="callSearchEngine('txtAggregatorId', '43e028dfdaab976ddd27cc17c457542f', 'onChangePartnerKey');" style="display: block-inline;">
										<img src="/static/images/search.png" height="12px" width="12px">
									</button>
								</td>
							</tr>
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="txtBillerStatus"><fmt:message key="biller.portlet.label.status" bundle="${bndlLang}" /></label>
								</td>
								<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
									<select name="param_status" id="txtBillerStatus" class="outputData">
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
									<input type="hidden" name="param_operation" value="callGetPartnerList">
									<input type="hidden" name="param_billerId" id="txtPartnerId" value="">
									<input type="submit" id="btnSearch" class="button" 
										value="<fmt:message key="biller.portlet.button.search" bundle="${bndlLang}" />" 
										onclick="doQueryFormSubmission('frmQueryBiller', 2);" />
								</td><td></td>
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