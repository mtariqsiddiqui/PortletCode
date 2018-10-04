<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<table style="width: 100%">
					<tbody>
						<tr><td><p class="attnbox"><fmt:message key="bill-category.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p></td></tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="bill-category.portlet.label.create-bill-category" bundle="${bndlLang}" /></legend>
					<form id="frmCreateBillCategory" method="post" action="<portlet:resourceURL id="CreateBillCategoryForm"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
									<!-- Begin: Data entry fields -->
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerId"><fmt:message key="bill-category.portlet.label.biller" bundle="${bndlLang}" />:</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<select name="txtPartnerKey" class="outputData" id="cmbPartnerKey">
														<option value="">
															<fmt:message key="bill-category.portlet.label.please-select" bundle="${bndlLang}"/>
														</option>														
														<c:forEach items="${BillerList}" var="biller">
															<option <c:if test="${psb.partnerKey == biller.value.partnerKey}">selected</c:if>
																value="<c:out value="${biller.value.partnerKey}" />">
																<c:out value="${biller.value.partnerName}" />
															</option>
														</c:forEach>
													</select>
												</td>
											</tr>

											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerCategory"><fmt:message key="bill-category.portlet.label.bill-category" bundle="${bndlLang}" /> : </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="txtBillerCategory" id="txtBillerCategory" class="outputData" value="${psb.selectedBillCategory.billCategory}" maxlength="256" autocomplete="off"/>
												</td>
											</tr>

											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtDescription"><fmt:message key="bill-category.portlet.label.description" bundle="${bndlLang}" /> : *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="txtDescription" id="txtDescription" class="outputData" value="${psb.selectedBillCategory.description}" autocomplete="off" maxlength="256" type="text">
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
									<input class="button" value="<fmt:message key="bill-category.portlet.button.save" bundle="${bndlLang}" />" onclick=";doQueryFormSubmission('frmCreateBillCategory', 1);" type="submit" name="btnSave"/>
									<input class="button" value="<fmt:message key="bill-category.portlet.button.cancel" bundle="${bndlLang}" />" type="reset" name="btnCancel"/>
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