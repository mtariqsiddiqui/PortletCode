<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmQueryBillCategory" id="frmQueryBillCategory" method="post" action="<portlet:resourceURL id="QueryBillCategoryList"/>">
<table style="width: 100%;">
	<tbody>
		<tr>
			<td>
				<table style="width: 100%;">
					<tbody>
						<tr><td><p class="attnbox"><fmt:message key="bill-category.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p></td></tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="bill-category.portlet.label.get-bill-category" bundle="${bndlLang}" /></legend>
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%;">
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="cmbPartnerKey"><fmt:message key="bill-category.portlet.label.biller" bundle="${bndlLang}" />&nbsp;:&nbsp;*</label>
												</td>
												<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
													<select name="txtPartnerKey" class="outputData" id="cmbPartnerKey" onchange="onChangePartnerKey(this, '<portlet:resourceURL id="QueryBillCategoryForm"/>');">
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
													<label class="label" for="cmbBillCategory"><fmt:message key="bill-category.portlet.label.bill-category" bundle="${bndlLang}" />&nbsp;:&nbsp;</label>
												</td>
												<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
													<select name="txtBillCategory" class="outputData" id="cmbBillCategory" onchange="$('#detailTable').DataTable().search(this.value).draw();">
														<option value="">
															<fmt:message key="bill-category.portlet.label.please-select" bundle="${bndlLang}"/>
														</option>
														<c:forEach items="${psb.billCategoryList}" var="billCategory">
															<option value="<c:out value="${billCategory.billCategory}" />">
																<c:out value="${billCategory.billCategory}" />
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
									<input type="submit" id="btnSearch" class="button" 
										value="<fmt:message key="bill-category.portlet.button.search" bundle="${bndlLang}" />" 
										onclick="doQueryFormSubmission('frmQueryBillCategory', 2, true, $('#cmbBillCategory').val());" disabled/>
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