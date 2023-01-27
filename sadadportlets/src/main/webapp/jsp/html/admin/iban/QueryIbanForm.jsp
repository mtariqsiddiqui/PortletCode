<%@ page import="com.sadad.scm.common._1.PartyIdTypeType"%>
<% pageContext.setAttribute("partyIdTypeType", PartyIdTypeType.values()); %>
<%@ page import="com.sadad.portal.common.utils.IbanStatus" %>
<% pageContext.setAttribute("ibanStatus", IbanStatus.values()); %>
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
					<form name="frmQueryIban" id="frmQueryIban" method="post" action='<portlet:resourceURL id="QueryIbanList"/>'>
						<table style="width: 100%">
							<tbody>
								<tr>
									<td>
										<table class="dataEntryPageTable" style="border: 0; width: 100%; padding: 0;">
											<tbody>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label id="lbl4Org" class="label" for="cmbBillerId">
															<fmt:message key="iban.portlet.label.biller" bundle="${bndlLang}" /> *</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<c:if test="${psb.partnerType == 'biller' or psb.partnerType == 'sadad'}">
															<select class="rqf" id="cmbBillerId" name="param_billerId" style="display: inline;">
																<c:choose>
																	<c:when test="${psb.partnerType == 'biller'}">
																		<option selected value="<c:out value='${psb.partnerKey}' />">
																			<c:out value="${BillerList[psb.partnerKey].partnerName}" />
																		</option>
																	</c:when>
																	<c:otherwise>
																		<option value="">
																			<fmt:message key="iban.portlet.label.please-select" bundle="${bndlLang}" />
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
														<label class="label" for="txtIban">
															<fmt:message key="iban.portlet.label.iban" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input value="${psb.iban}" name="param_iban" id="txtIban"
														 autocomplete="off" maxlength="32" type="text"/>
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label class="label" for="txtSettlementId">
															<fmt:message key="iban.portlet.label.settlement-id" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input value="${psb.settlementId}" name="param_settlementId" id="txtSettlementId"
														 autocomplete="off" maxlength="32" type="text" />
													</td>
												</tr>												
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="cmbCustomerIdType">
															<fmt:message key="iban.portlet.label.customer-id-type" bundle="${bndlLang}"/>
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<select name="param_customerIdType" id="cmbCustomerIdType">
															<option value="">
																<fmt:message key="iban.portlet.label.please-select" bundle="${bndlLang}"/>
															</option>
															<c:forEach items="${partyIdTypeType}" var="idType">
																<option <c:if test="${psb.customerIdType == idType}">selected</c:if> 
																	value="${idType}">${idType}</option>
															</c:forEach>
														</select>
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtCustomerId">
															<fmt:message key="iban.portlet.label.customer-id" bundle="${bndlLang}"/>
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input name="param_customerId" value="${psb.customerId}" id="txtCustomerId" autocomplete="off" maxlength="20" type="text">
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label class="label" for="txtFromDate">
															<fmt:message key="iban.portlet.label.from-date" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input value="${psb.fromDate}" name="param_fromDate" id="txtFromDate"
														 autocomplete="off" maxlength="10" type="text" readonly placeholder="YYYY-MM-DD" />
													</td>
												</tr>
												
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label class="label" for="txtToDate">
															<fmt:message key="iban.portlet.label.to-date" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input value="${psb.toDate}" name="param_toDate" id="txtToDate"
														 autocomplete="off" maxlength="10" type="text" readonly placeholder="YYYY-MM-DD" />
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" width="200px" valign="top" nowrap height="27">
														<label class="label" for="cmbIbanStatus">
															<fmt:message key="iban.portlet.label.iban-status" bundle="${bndlLang}" /> *
														</label>
													</td>
													<td class="outputDataCell" valign="top" nowrap style="width: 100%;">
														<select name="param_status" class="rqf" id="cmbIbanStatus">
															<c:forEach items="${ibanStatus}" var="ibs">
																<option value="${ibs.value}" <c:if test="${ibs.value == psb.status}">selected</c:if>>${ibs.name}</option>
															</c:forEach>
														</select>
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td>
										<input type="hidden" value="QUERY_FORM" id="hdnPageId" />									
										<input type="hidden" id="txtPageNo" name="param_pageNumber" value="0" />
										<input type="hidden" name="param_operation" value="callListIban" />
										<input class='button' value='<fmt:message key="iban.portlet.button.search" bundle="${bndlLang}"/>' onclick="$('#txtPageNo').val(0);setupOptionalQueryIbanFields();doQueryFormSubmission('frmQueryIban');" type='submit' />
										<input class='button' value='<fmt:message key="iban.portlet.button.report" bundle="${bndlLang}"/>' onclick="$('#txtPageNo').val(-2);setupOptionalQueryIbanFields();doQueryFormSubmission('frmQueryIban');" type='submit' />
										<portlet:resourceURL id="QueryIbanForm" var="clearURL"><portlet:param name="param_operation" value="clearSessionBeanObject"/></portlet:resourceURL>
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