<%@ page import="com.sadad.scm.common._1.ConfigurationStatusEnum"%>
<% pageContext.setAttribute("configStatusEnum", ConfigurationStatusEnum.values()); %>
<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmQuerySubBiller" id="frmQuerySubBiller" method="post" action="<portlet:resourceURL id="QuerySubBillerList"/>">
<table style="width: 100%;">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="subbiller.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="subbiller.portlet.label.search-subbiller" bundle="${bndlLang}" /></legend>
					<table>
						<tbody>
							
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="txtAggregatorId"><fmt:message key="subbiller.portlet.label.aggregator-name" bundle="${bndlLang}" /> *</label>
								</td>
								<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
									<select class="rqf" name="param_aggregatorId" id="txtAggregatorId" onchange="onChangeOwnerKey(this, '<portlet:resourceURL id="QuerySubBillerForm"/>');">
										<c:choose>
											<c:when test="${psb.partnerType == 'aggregator'}">
												<option selected value="<c:out value='${psb.partnerKey}' />">
													<c:out value="${AggregatorList[psb.partnerKey].partnerName}" />
												</option>
											</c:when>
											<c:otherwise>
												<option value=""><fmt:message key="subbiller.portlet.label.please-select" bundle="${bndlLang}"/></option>
												<c:forEach items="${AggregatorList}" var="aggregator">
													<option value="${aggregator.value.partnerKey}" <c:if test="${psb.aggregatorId == aggregator.value.partnerKey}">selected</c:if>>
														<c:out value="${aggregator.value.partnerName}" />
													</option>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</select>
									<c:if test="${psb.partnerType == 'sadad'}">
									<button id="callSrchEngnBtn1" type="button" onclick="callSearchEngine('txtAggregatorId', '43e028dfdaab976ddd27cc17c457542f', 'onChangeOwnerKey', '<portlet:resourceURL id="QuerySubBillerForm"/>');">
										<img src="/static/images/search.png" height="12px" width="12px">
									</button>
									</c:if>
								</td>
							</tr>
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="txtBillerId"><fmt:message key="subbiller.portlet.label.subbiller-name" bundle="${bndlLang}" /> *</label>
								</td>
								<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
									<select name="param_billerId" id="txtBillerId" <c:if test="${empty psb.aggregatorId}">disabled</c:if> onchange="onChangePartnerKey(this);">
										<option value="">
											<fmt:message key="subbiller.portlet.label.all" bundle="${bndlLang}"/>
										</option>
										<c:forEach items="${AggregatorBillerList[psb.aggregatorId]}" var="biller">
											<option <c:if test="${psb.billerId == biller.value.partnerKey}">selected</c:if>
												value="<c:out value="${biller.value.partnerKey}" />">
												<c:out value="${biller.value.partnerName}" />
											</option>
										</c:forEach>
									</select>
									<c:if test="${not empty psb.aggregatorId}">
										<button id="callSrchEngnBtn2" type="button" onclick="callSearchEngine('txtBillerId', 'a5e383e5e7a87a6844dd02fa04944c35&q1=${psb.hashedPartnerKey}', 'onChangePartnerKey');">
											<img src="/static/images/search.png" height="12px" width="12px">
										</button>
									</c:if>
								</td>
							</tr>
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="txtBillerStatus"><fmt:message key="subbiller.portlet.label.status" bundle="${bndlLang}" /></label>
								</td>
								<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
									<select name="param_status" id="txtBillerStatus" class="outputData">
										<option value="">
											<fmt:message key="subbiller.portlet.label.all" bundle="${bndlLang}"/>
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
									<input type="submit" id="btnSearch" class="button" 
										value="<fmt:message key="subbiller.portlet.button.search" bundle="${bndlLang}" />" 
										onclick="doQueryFormSubmission('frmQuerySubBiller', 2);" />
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