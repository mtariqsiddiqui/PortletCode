<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox">
					<fmt:message key="iban.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" />
				</p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend>
						<fmt:message key="iban.portlet.label.search-for-iban" bundle="${bndlLang}" />
					</legend>
					<form name="frmQueryIban" id="frmQueryIban" method="post" action='<portlet:resourceURL id="RejectedIbanList"/>'>
						<table style="width: 100%">
							<tbody>
								<tr>
									<td>
										<table class="dataEntryPageTable" style="border: 0; width: 100%; padding: 0;">
											<tbody>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label id="lbl4Org" class="label" for="cmbBillerId">
															<fmt:message key="iban.portlet.label.biller" bundle="${bndlLang}" /></label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<c:if test="${psb.partnerType == 'biller' or psb.partnerType == 'sadad'}">
															<select id="cmbBillerId" name="param_billerId" style="display: inline;">
																<c:choose>
																	<c:when test="${psb.partnerType == 'biller'}">
																		<option selected value="<c:out value='${psb.partnerKey}' />">
																			<c:out value="${BillerList[psb.partnerKey].partnerName}" />
																		</option>
																	</c:when>
																	<c:otherwise>
																		<option value="">
																			<fmt:message key="iban.portlet.label.all" bundle="${bndlLang}" />
																		</option>
																		<c:forEach items="${BillerList}" var="biller">
																			<option value="<c:out value="${biller.value.partnerKey}"/>" <c:if test="${biller.value.partnerKey == psb.billerId}">selected</c:if>>
																			<c:out value="${biller.value.partnerName}" />
																			</option>
																		</c:forEach>
																	</c:otherwise>
																</c:choose>
															</select>
														</c:if>
														<c:if test="${psb.partnerType == 'sadad'}">
															<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('cmbBillerId', 'e13b5b1608ad566f94ba9fe7849aca38');">
																<img src="/static/images/search.png" height="12px" width="12px">
															</button>
														</c:if>													
													</td>
												</tr>
												
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label class="label" for="txtArrivalFromDate">
															<fmt:message key="iban.portlet.label.iban" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input class="" value="${psb.iban}" name="param_iban" id="txtIban"
														 autocomplete="off" maxlength="32" type="text" />
													</td>
												</tr>
												
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label class="label" for="txtArrivalFromDate">
															<fmt:message key="iban.portlet.label.settlement-id" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input class="" value="${psb.settlementId}" name="param_settlementId" id="txtIban"
														 autocomplete="off" maxlength="32" type="text" />
													</td>
												</tr>												
																								
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label class="label" for="txtArrivalFromDate">
															<fmt:message key="iban.portlet.label.from-date" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input class="" value="${psb.fromDate}" name="param_fromDate" id="txtFromDate"
														 autocomplete="off" maxlength="10" type="text" readonly placeholder="YYYY-MM-DD" />
													</td>
												</tr>
												
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label class="label" for="ProcessingDateRange_StartDt_field">
															<fmt:message key="iban.portlet.label.to-date" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input class="outputData" value="${psb.toDate}" name="param_toDate" id="txtToDate"
														 autocomplete="off" maxlength="10" type="text" readonly placeholder="YYYY-MM-DD" />
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td>
										<input type="hidden" name="param_status" value="REJECTED" />
										<input type="hidden" name="param_operation" value="callListIban" />
										<input class='button' value='<fmt:message key="iban.portlet.button.search" bundle="${bndlLang}"/>' onclick='doQueryFormSubmission("frmQueryIban");' type='submit' />
										<portlet:resourceURL id="RejectedIbanForm" var="clearURL"><portlet:param name="param_operation" value="clearSessionBeanObject"/></portlet:resourceURL>
										<input class='button' value='<fmt:message key="iban.portlet.button.clear" bundle="${bndlLang}"/>' onclick="doQueryFormReset('${clearURL}');" type='button' />
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</fieldset>
			</td>
		</tr>
	</tbody>
</table>