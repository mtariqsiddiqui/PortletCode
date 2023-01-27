<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmQueryBranchCode" id="frmQueryBranchCode" method="post" action="<portlet:resourceURL id="QueryBranchCodeList"/>">
<table style="width: 100%;">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="branch-code.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="branch-code.portlet.label.get-branch-code" bundle="${bndlLang}" /></legend>
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%;">
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="cmbPartnerKey"><fmt:message key="branch-code.portlet.label.bank" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
													<select name="param_bankId" class="rqf" id="cmbPartnerKey" onchange="onChangePartnerKey(this, '<portlet:resourceURL id="QueryBranchCodeForm"/>');">
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
													<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('cmbPartnerKey', '32c7fcd2cd9c32b19841d743dc09d56f', 'onChangePartnerKey', '<portlet:resourceURL id="QueryBranchCodeForm"/>');">
														<img src="/static/images/search.png" height="12px" width="12px">
													</button>
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="cmbBranchCode"><fmt:message key="branch-code.portlet.label.branch-code" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
													<select name="param_branchCode" id="cmbBranchCode" onchange="$('#detailTable').DataTable().search(this.value).draw();">
														<option value="">
															<fmt:message key="branch-code.portlet.label.all" bundle="${bndlLang}"/>
														</option>
														<c:forEach items="${psb.branchCodeList}" var="branchCode">
															<option value="<c:out value="${branchCode.branchCode}" />">
																<c:out value="${branchCode.branchCode}" />
															</option>
														</c:forEach>
													</select>
												</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
							<!-- tr>
								<td></td>
							</tr-->
							<!-- Buttons Group -->
							<tr>
								<td>
									<input type="hidden" name="param_operation" value="callListBankBranch"> 
									<input type="submit" id="btnSearch" class="button" value="<fmt:message key="branch-code.portlet.button.search" bundle="${bndlLang}" />" 
										onclick="doQueryFormSubmission('frmQueryBranchCode', 2, true, $('#cmbBranchCode').val());"/>
								</td>
							</tr>
						</tbody>
					</table>
				</fieldset>
				<!-- END Query Segment -->
			</td>
		</tr>
		<!-- End Form/Details container -->
	</tbody>
</table>
</form>
<!-- END Main Table -->