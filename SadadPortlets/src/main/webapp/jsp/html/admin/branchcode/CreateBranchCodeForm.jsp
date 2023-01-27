<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="branch-code.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="branch-code.portlet.label.create-branch-code" bundle="${bndlLang}" /></legend>
					<form id="frmCreateBranchCode" method="post" action="<portlet:resourceURL id="CreateBranchCodeForm"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
									<!-- Begin: Data entry fields -->
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="cmbPartnerKey"><fmt:message key="branch-code.portlet.label.bank" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<select name="param_bankId" class="rqf" id="cmbPartnerKey">
														<option value="">
															<fmt:message key="branch-code.portlet.label.please-select" bundle="${bndlLang}"/>
														</option>														
														<c:forEach items="${BankList}" var="bank">
															<option <c:if test="${psb.bankId == bank.value.partnerKey}">selected</c:if>
																value="<c:out value="${bank.value.partnerKey}" />">
																<c:out value="${bank.value.partnerName}" />
															</option>
														</c:forEach>
													</select>
													<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('cmbPartnerKey', '32c7fcd2cd9c32b19841d743dc09d56f');">
														<img src="/static/images/search.png" height="12px" width="12px">
													</button>
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBranchCode"><fmt:message key="branch-code.portlet.label.branch-code" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="param_branchCode" id="txtBranchCode" class="rqf" value="${psb.selectedBranchCode.branchCode}" maxlength="10" pattern="[A-Za-z0-9]{1,10}" title='<fmt:message key="branch-code.portlet.title.branch-code" bundle="${bndlLang}"/>' autocomplete="off"/>
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
									<input type="hidden" name="param_operation" value="callCreateBankBranch"/>
									<input class="button" value="<fmt:message key="branch-code.portlet.button.save" bundle="${bndlLang}" />" onclick=";doQueryFormSubmission('frmCreateBranchCode', 1);" type="submit" name="btnSave"/>
									<input class="button" value="<fmt:message key="branch-code.portlet.button.cancel" bundle="${bndlLang}" />" type="button" onclick="displayErrorOrMessage();$('#frmCreateBranchCode').trigger('reset');" name="btnCancel"/>
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