<%@ page import="com.sadad.scm.common._1.PartyIdTypeType"%>
<% pageContext.setAttribute("partyIdTypeType", PartyIdTypeType.values()); %>
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
						<fmt:message key="iban.portlet.label.create-iban" bundle="${bndlLang}" />
					</legend>
					<form name="frmCreateIban" id="frmCreateIban" method="post" action='<portlet:resourceURL id="CreateIbanForm"/>'>
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
															<select class="rqf" id="cmbBillerId" name="param_billerId">
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
															<fmt:message key="iban.portlet.label.iban" bundle="${bndlLang}" /> *
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input class="rqf" value="${psb.iban}" name="param_iban" id="txtIban"
														 autocomplete="off" maxlength="24" type="text" style="text-transform:uppercase;"/>
													</td>
												</tr>
												
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label class="label" for="cmbAccountType">
															<fmt:message key="iban.portlet.label.account-type" bundle="${bndlLang}" /> *
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<select class="rqf" id="cmbAccountType" name="param_accountType" >
															<option value=""><fmt:message key="iban.portlet.label.please-select" bundle="${bndlLang}" /></option>
															<option value="BRA" <c:if test="${psb.accountType == 'BRA'}">selected</c:if>>BRA</option>
															<option value="CBA" <c:if test="${psb.accountType == 'CBA'}">selected</c:if>>CBA</option>
															<option value="CMA" <c:if test="${psb.accountType == 'CMA'}">selected</c:if>>CMA</option>
															<option value="CUA" <c:if test="${psb.accountType == 'CUA'}">selected</c:if>>CUA</option>
															<option value="DDA" <c:if test="${psb.accountType == 'DDA'}">selected</c:if>>DDA</option>
															<option value="LOC" <c:if test="${psb.accountType == 'LOC'}">selected</c:if>>LOC</option>
															<option value="MMA" <c:if test="${psb.accountType == 'MMA'}">selected</c:if>>MMA</option>
															<option value="SBA" <c:if test="${psb.accountType == 'SBA'}">selected</c:if>>SBA</option>
															<option value="SDA" <c:if test="${psb.accountType == 'SDA'}">selected</c:if>>SDA</option>
															<option value="SRA" <c:if test="${psb.accountType == 'SRA'}">selected</c:if>>SRA</option>
															<option value="SSA" <c:if test="${psb.accountType == 'SSA'}">selected</c:if>>SSA</option>
															<option value="SUS" <c:if test="${psb.accountType == 'SUS'}">selected</c:if>>SUS</option>
														 </select>
													</td>
												</tr>
												
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label class="label" for="txtSettlementId">
															<fmt:message key="iban.portlet.label.settlement-id" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input class="" value="${psb.settlementId}" id="txtSettlementId"  readonly
														 autocomplete="off" maxlength="32" type="text" /> <span id="spnCrtScs" style="color: green;"><fmt:message key="iban.portlet.label.note-settlement-id" bundle="${bndlLang}"/></span>
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="cmbCustomerIdType">
															<fmt:message key="iban.portlet.label.customer-id-type" bundle="${bndlLang}"/>&nbsp;*
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<select name="param_customerIdType" class="rqf" id="cmbCustomerIdType">
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
															<fmt:message key="iban.portlet.label.customer-id" bundle="${bndlLang}"/>&nbsp;*
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input name="param_customerId" class="rqf" value="${psb.customerId}" id="txtCustomerId" autocomplete="off" maxlength="20" type="text">
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td>
										<input type="hidden" value="CREATE_FORM" id="hdnPageId" />
										<input type="hidden" name="param_billerStatus" value="ACTIVE" />
										<c:if test="${psb.partnerKey != 'SADAD-001'}">
											<input type="hidden" name="param_billerStatus" value="${BillerList[psb.partnerKey].partnerStatus}" />
										</c:if>
										<input type="hidden" name="param_operation" value="callCreateIban" />
										<input class='button' value='<fmt:message key="iban.portlet.button.save" bundle="${bndlLang}"/>' onclick='createIban(doQueryFormSubmission);' type='submit' id="btnSave" />
										<portlet:resourceURL id="CreateIbanForm" var="clearURL"><portlet:param name="param_operation" value="clearSessionBeanObject"/></portlet:resourceURL>
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