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
													<label class="label" for="cmbPartnerKey"><fmt:message key="bill-category.portlet.label.biller" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<select name="param_billerId" class="rqf" id="cmbPartnerKey">
														<option value="">
															<fmt:message key="bill-category.portlet.label.please-select" bundle="${bndlLang}"/>
														</option>
														<c:if test="${psb.partnerType == 'sadad'}">
															<c:forEach items="${BillerList}" var="biller">
																<option <c:if test="${psb.billerId == biller.value.partnerKey}">selected</c:if>
																	value="<c:out value="${biller.value.partnerKey}" />">
																	<c:out value="${biller.value.partnerName}" />
																</option>
															</c:forEach>
														</c:if>														
														<c:if test="${psb.partnerType == 'aggregator'}">
															<c:forEach items="${AggregatorBillerList[psb.partnerKey]}" var="biller">
																<option <c:if test="${psb.billerId == biller.value.partnerKey}">selected</c:if>
																	value="<c:out value="${biller.value.partnerKey}" />">
																	<c:out value="${biller.value.partnerName}" />
																</option>
															</c:forEach>
														</c:if>
													</select>
													<c:if test="${psb.partnerType == 'sadad'}">
													<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('cmbPartnerKey', 'e13b5b1608ad566f94ba9fe7849aca38');">
														<img src="/static/images/search.png" height="12px" width="12px">
													</button></c:if>
													<c:if test="${psb.partnerType == 'aggregator'}"> <%-- Or to Aggregator Users --%>
													<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('cmbPartnerKey', 'a5e383e5e7a87a6844dd02fa04944c35&q1=${psb.hashedPartnerKey}');">
														<img src="/static/images/search.png" height="12px" width="12px">
													</button></c:if>
												</td>
											</tr>

											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillCategory"><fmt:message key="bill-category.portlet.label.bill-category" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_billCategory" id="txtBillCategory" class="rqf" value="${psb.billCategory}" maxlength="50" autocomplete="off"/>
												</td>
											</tr>

											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtDescription"><fmt:message key="bill-category.portlet.label.description" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_description" id="txtDescription" class="rqf" value="${psb.description}" autocomplete="off" maxlength="100">
												</td>
											</tr>
											<!-- End: Data entry fields -->
										</tbody>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<input type="hidden" value="INACTIVE" name="param_status" />
									<input type="hidden" name="param_operation" value="callCreateBillCategory"/>
									<input class="button" value="<fmt:message key="bill-category.portlet.button.save" bundle="${bndlLang}" />" onclick=";doQueryFormSubmission('frmCreateBillCategory', 1);" type="submit" name="btnSave"/>
									<input class="button" value="<fmt:message key="bill-category.portlet.button.cancel" bundle="${bndlLang}" />" type="button" onclick="displayErrorOrMessage();$('#frmCreateBillCategory').trigger('reset');" name="btnCancel"/>
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