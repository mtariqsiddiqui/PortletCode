<jsp:directive.include file="../../common/JspDeclarations.jspf" />

<form name="frmQueryBill" id="frmQueryBill" method="post" action="<portlet:resourceURL id="core_BillsSummary"/>">
	<table style="width: 100%">
		<!-- Form or Details container -->
		<tbody>
			<tr>
				<td><p class="attnbox"><fmt:message key="ebpp.portlet.marked-fields-are-mandatory" bundle="${bndlLang}"/></p></td>
			</tr>
			<tr>
				<td>
				<!-- Query Segment -->
					<fieldset>
						<legend>
							<fmt:message key="ebpp.portlet.label.search-for-bill" bundle="${bndlLang}"/>							
						</legend>
						<table>
							<tbody>
								<tr>
									<td>
										<table  style="width: 100%">
											<!-- Begin: Data entry fields -->
											<tbody>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="cmbPartnerKey">
															<fmt:message key="ebpp.portlet.label.biller" bundle="${bndlLang}"/>&nbsp;*
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<select name="param_billerId" class="rqf" id="cmbPartnerKey" onchange="onChangePartnerKey(this);">
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
														<%--Display Search Engine to SADAD & Bank users --%>
														<c:if test="${psb.partnerType == 'bank' or psb.partnerType == 'sadad'}">
															<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('cmbPartnerKey', 'e13b5b1608ad566f94ba9fe7849aca38');">
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
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtBillNumber">
															<fmt:message key="ebpp.portlet.label.bill-number" bundle="${bndlLang}"/>&nbsp;*
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input name="param_billNumber" class="rqf" value="${psb.bills[psb.billKey].billNumber}" id="txtBillNumber" autocomplete="off" maxlength="40" type="text">
													</td>
												</tr>
												<!-- End: Data entry fields -->
											</tbody>
										</table>										
									</td>
								</tr>
								<!-- Buttons Group -->
								<tr>
									<td>
										<input type="hidden" name="param_operation" value="callBillService_GetByBillNumber" />
										<input type="submit" class="button" value="<fmt:message key="ebpp.portlet.button.submit" bundle="${bndlLang}"/>" onclick="doQueryFormSubmission('frmQueryBill');" />
										<portlet:resourceURL id="QueryBillForm" var="clearURL"><portlet:param name="param_operation" value="clearSessionBeanObject"/></portlet:resourceURL>
										<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.clear" bundle="${bndlLang}"/>" onclick="doQueryFormReset('${clearURL}');" />
									</td>
								</tr>
							</tbody>
						</table>
					</fieldset>
					<!-- END Query Segment --></td>
			</tr>
		</tbody>
	</table>
	<!-- END Main Table -->
</form>