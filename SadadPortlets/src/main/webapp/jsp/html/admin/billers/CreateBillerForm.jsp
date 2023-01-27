<%@ page import="com.sadad.portal.common.utils.BillerTypes"%>
<% pageContext.setAttribute("billerTypes", BillerTypes.values()); %>
<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="biller.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="biller.portlet.label.create-biller" bundle="${bndlLang}" /></legend>
					<form id="frmCreateBiller" method="post" action="<portlet:resourceURL id="CreateBillerForm"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
									<!-- Begin: Data entry fields -->
										<tbody>
										<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerType"><fmt:message key="biller.portlet.label.partner-type" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<select name="param_billerType" id="txtBillerType" class="outputData">
														<c:forEach items="${billerTypes}" var="bType">
															<option value="${bType.value}">${bType.name}</option>
														</c:forEach>
													</select>
												</td>
											</tr>										
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerId"><fmt:message key="biller.portlet.label.biller-id" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="param_billerId" id="txtBillerId" class="rqf" value="${psb.billerId}" maxlength="3" pattern="[A-Za-z0-9]{3}" title='<fmt:message key="biller.portlet.title.biller-id" bundle="${bndlLang}"/>' autocomplete="off">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerName"><fmt:message key="biller.portlet.label.biller-name" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="param_billerName" id="txtBillerName" class="rqf" value="${psb.billerName}" maxlength="60" autocomplete="off" onblur="chop(this);">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerArabicName"><fmt:message key="biller.portlet.label.biller-arabic-name" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="param_billerArabicName" id="txtBillerArabicName" class="rqf" value="${psb.billerArabicName}" maxlength="60" autocomplete="off" onblur="chop(this);">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtDescription"><fmt:message key="biller.portlet.label.description" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="param_description" id="txtDescription" value="${psb.description}" maxlength="250" autocomplete="off">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBankName"><fmt:message key="biller.portlet.label.bank-name" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<select name="param_billingAccountBankId" id="txtBankName" class="rqf">
														<option value="">
															<fmt:message key="biller.portlet.label.please-select" bundle="${bndlLang}"/>
														</option>														
														<c:forEach items="${BankList}" var="bank">
															<option <c:if test="${psb.billingAccountBankId == bank.value.partnerKey}">selected</c:if>
																value="<c:out value="${bank.value.partnerKey}" />">
																<c:out value="${bank.value.partnerName}" />
															</option>
														</c:forEach>
													</select>
													<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('txtBankName', '32c7fcd2cd9c32b19841d743dc09d56f');">
														<img src="/static/images/search.png" height="12px" width="12px">
													</button>
												</td>
											</tr>											
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtSadadAccountNumber"><fmt:message key="biller.portlet.label.sadad-account-number" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="param_billingAccountNumber" id="txtSadadAccountNumber" class="rqf" value="${psb.billingAccountNumber}" maxlength="32" autocomplete="off">												
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtRefundBankId"><fmt:message key="biller.portlet.label.biller-refund-bank-id" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<select name="param_refundAccountBankId" id="txtRefundBankId">
														<option value="">
															<fmt:message key="biller.portlet.label.please-select" bundle="${bndlLang}"/>
														</option>														
														<c:forEach items="${BankList}" var="bank">
															<option <c:if test="${psb.refundAccountBankId == bank.value.partnerKey}">selected</c:if>
																value="<c:out value="${bank.value.partnerKey}" />">
																<c:out value="${bank.value.partnerName}" />
															</option>
														</c:forEach>
													</select>
													<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('txtRefundBankId', '32c7fcd2cd9c32b19841d743dc09d56f');">
														<img src="/static/images/search.png" height="12px" width="12px">
													</button>
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtSadadRefundAccount"><fmt:message key="biller.portlet.label.sadad-refund-account" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="param_refundAccountNumber" id="txtSadadRefundAccount" value="${psb.refundAccountNumber}" maxlength="32" autocomplete="off">												
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
									<input type="hidden" value="INACTIVE" name="param_status" />
									<input type="hidden" value="callCreatePartner" name="param_operation" />
									<input class="button" value="<fmt:message key="biller.portlet.button.save" bundle="${bndlLang}" />" onclick="doQueryFormSubmission('frmCreateBiller', 1);" type="submit" name="btnSave"/>
									<input class="button" value="<fmt:message key="biller.portlet.button.cancel" bundle="${bndlLang}" />" type="button" onclick="displayErrorOrMessage();$('#frmCreateBiller').trigger('reset');" name="btnCancel"/>									
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