<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<table style="width: 100%">
					<tbody>
						<tr><td><p class="attnbox"><fmt:message key="branch-code.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p></td></tr>
					</tbody>
				</table>
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
													<label class="label" for="txtBillerId"><fmt:message key="branch-code.portlet.label.bank" bundle="${bndlLang}" />:</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<select name="txtPartnerKey" class="outputData" id="cmbPartnerKey">
														<option value="">
															<fmt:message key="branch-code.portlet.label.please-select" bundle="${bndlLang}"/>
														</option>														
														<c:forEach items="${BankList}" var="bank">
															<option <c:if test="${psb.partnerKey == bank.value.partnerKey}">selected</c:if>
																value="<c:out value="${bank.value.partnerKey}" />">
																<c:out value="${bank.value.partnerName}" />
															</option>
														</c:forEach>
													</select>
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerCategory"><fmt:message key="branch-code.portlet.label.branch-code" bundle="${bndlLang}" /> : </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="txtBranchCode" id="txtBranchCode" class="outputData" value="${psb.selectedBranchCode.branchCode}" maxlength="256" autocomplete="off"/>
												</td>
											</tr>
											<!-- End: Data entry fields -->
										</tbody>
									</table>
								</td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<!-- Buttons Group -->
							<tr>
								<td>
									<input type="hidden" name="reqAction" id="reqAction"/>
									<input class="button" value="<fmt:message key="branch-code.portlet.button.save" bundle="${bndlLang}" />" onclick=";doQueryFormSubmission('frmCreateBranchCode', 1);" type="submit" name="btnSave"/>
									<input class="button" value="<fmt:message key="branch-code.portlet.button.cancel" bundle="${bndlLang}" />" type="reset" name="btnCancel"/>
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