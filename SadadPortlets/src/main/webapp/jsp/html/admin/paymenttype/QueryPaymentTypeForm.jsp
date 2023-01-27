<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmQueryPaymentType" id="frmQueryPaymentType" method="post" action="<portlet:resourceURL id="QueryPaymentTypeList"/>">
<table style="width: 100%;">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="payment-type.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="payment-type.portlet.label.get-payment-type" bundle="${bndlLang}" /></legend>
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%;">
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="cmbPartnerKey"><fmt:message key="payment-type.portlet.label.biller" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
													<select name="param_billerId" class="rqf" id="cmbPartnerKey" onchange="onChangePartnerKey(this, '<portlet:resourceURL id="QueryPaymentTypeForm"/>');">
														<option value="">
															<fmt:message key="payment-type.portlet.label.please-select" bundle="${bndlLang}"/>
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
													<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('cmbPartnerKey', 'e13b5b1608ad566f94ba9fe7849aca38', 'onChangePartnerKey', '<portlet:resourceURL id="QueryPaymentTypeForm"/>');">
														<img src="/static/images/search.png" height="12px" width="12px">
													</button>
													</c:if>
													<c:if test="${psb.partnerType == 'aggregator'}">
													<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('cmbPartnerKey', 'a5e383e5e7a87a6844dd02fa04944c35&q1=${psb.hashedPartnerKey}', 'onChangePartnerKey', '<portlet:resourceURL id="QueryPaymentTypeForm"/>');">
														<img src="/static/images/search.png" height="12px" width="12px">
													</button>
													</c:if>
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="cmbPaymentType"><fmt:message key="payment-type.portlet.label.payment-type" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
													<select name="param_paymentType" id="cmbPaymentType" onchange="$('#detailTable').DataTable().search(this.value).draw();">
														<option value="">
															<fmt:message key="payment-type.portlet.label.all" bundle="${bndlLang}"/>
														</option>													
														<c:forEach items="${psb.paymentTypeList}" var="paymentTypeList">
															<option value="<c:out value="${paymentTypeList.paymentType}" />"><c:out value="${paymentTypeList.paymentType}" /></option>
														</c:forEach>
													</select>
												</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
							<!-- Buttons Group -->
							<tr>
								<td>
									<input type="hidden" name="param_operation" value="callListPaymentType" />
									<input type="submit" id="btnSearch" class="button" 
										value="<fmt:message key="payment-type.portlet.button.search" bundle="${bndlLang}" />" 
										onclick="doQueryFormSubmission('frmQueryPaymentType', 2, true, $('#cmbPaymentType').val());" />
								</td>
							</tr>
						</tbody>
					</table>
				</fieldset>
				<!-- END Query Segment -->
			</td>
		</tr>
	</tbody>
</table>
</form>