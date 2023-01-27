<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="bill-category.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="bill-category.portlet.label.update-bill-category" bundle="${bndlLang}" /></legend>
					<form id="frmUpdateBillCategory" method="post" action="<portlet:resourceURL id="QueryBillCategoryDetails"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
									<!-- Begin: Data entry fields -->
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerId"><fmt:message key="bill-category.portlet.label.biller" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input id="txtBillerId" class="outputData" value="${psb.selectedBillCategory.billerId}"  disabled="disabled" type="text"/>
													<input name="param_billerId" value="${psb.selectedBillCategory.billerId}" type="hidden"/>
												</td>
											</tr>

											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerCategory"><fmt:message key="bill-category.portlet.label.bill-category" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input class="outputData" value="${psb.selectedBillCategory.billCategory}" id="txtBillerCategory" disabled="disabled" type="text"/>
													<input name="param_billCategory" value="${psb.selectedBillCategory.billCategory}" type="hidden" />
												</td>
											</tr>

											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtDescription"><fmt:message key="bill-category.portlet.label.description" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="param_description" class="rqf" value="${psb.selectedBillCategory.description}" id="txtDescription" autocomplete="off" maxlength="100" type="text" />
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
									<input type="hidden" name="param_operation" id="param_operation" value="callUpdateBillCategory"/>
									<input class="button" value="<fmt:message key="bill-category.portlet.button.save" bundle="${bndlLang}" />" onclick="doQueryFormSubmission('frmUpdateBillCategory', 1);" type="submit" />
									<input class="button" value="<fmt:message key="bill-category.portlet.button.cancel" bundle="${bndlLang}" />" onclick="doPostUrl('<portlet:resourceURL id="QueryBillCategoryDetails" />', 1);" type="button" />
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
