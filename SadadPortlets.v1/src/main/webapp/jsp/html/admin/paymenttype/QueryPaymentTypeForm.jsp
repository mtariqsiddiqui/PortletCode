<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmQueryPaymentType" id="frmQueryPaymentType" method="post" action="<portlet:resourceURL id="QueryPaymentTypeList"/>">
<table style="width: 100%;">
	<tbody>
		<tr>
			<td>
				<table style="width: 100%;">
					<tbody>
						<tr><td><p class="attnbox"><fmt:message key="payment-type.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p></td></tr>
					</tbody>
				</table>
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
													<label class="label" for="cmbPartnerKey"><fmt:message key="payment-type.portlet.label.biller" bundle="${bndlLang}" />&nbsp;:&nbsp;*</label>
												</td>
												<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
													<select name="txtPartnerKey" class="outputData" id="cmbPartnerKey" onchange="onChangePartnerKey(this, '<portlet:resourceURL id="QueryPaymentTypeForm"/>');">
														<option value="">
															<fmt:message key="payment-type.portlet.label.please-select" bundle="${bndlLang}"/>
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
													<label class="label" for="PaymentCategory_field"><fmt:message key="payment-type.portlet.label.payment-type" bundle="${bndlLang}" />&nbsp;:&nbsp;</label>
												</td>
												<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
													<select name="txtPaymentType" class="outputData" id="cmbPaymentType" onchange="$('#detailTable').DataTable().search(this.value).draw();">
														<option value="">
															<fmt:message key="payment-type.portlet.label.please-select" bundle="${bndlLang}"/>
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
									<input type="submit" id="btnSearch" class="button" 
										value="<fmt:message key="payment-type.portlet.button.search" bundle="${bndlLang}" />" 
										onclick="doQueryFormSubmission('frmQueryPaymentType', 2, true, $('#cmbPaymentType').val());" disabled/>
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