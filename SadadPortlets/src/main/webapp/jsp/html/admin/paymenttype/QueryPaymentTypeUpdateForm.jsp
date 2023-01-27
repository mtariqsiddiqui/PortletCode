<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="payment-type.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="payment-type.portlet.label.update-payment-type" bundle="${bndlLang}" /></legend>
					<form id="frmUpdatePaymentType" method="post" action="<portlet:resourceURL id="QueryPaymentTypeDetails"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
									<!-- Begin: Data entry fields -->
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerId"><fmt:message key="payment-type.portlet.label.biller-id" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input id="txtBillerId" class="outputData" value="${psb.billerId}"  disabled="disabled"/>
													<input name="param_billerId" value="${psb.billerId}" type="hidden"/>
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtPaymentType"><fmt:message key="payment-type.portlet.label.payment-type" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input class="outputData" value="${psb.selectedPaymentType.paymentType}" id="txtPaymentType" disabled="disabled"/>
													<input name="param_paymentType" value="${psb.selectedPaymentType.paymentType}" type="hidden" />
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="chkIsPrepaid"><fmt:message key="payment-type.portlet.label.is-prepaid" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input id="chkIsPrepaid" class="outputData" type="checkbox" <c:if test="${psb.selectedPaymentType.prepaid}">checked</c:if>>
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="chkIsDefault"><fmt:message key="payment-type.portlet.label.is-default" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input id="chkIsDefault" class="outputData" type="checkbox" <c:if test="${psb.selectedPaymentType.deefault}">checked</c:if>>
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="chkCanReverse"><fmt:message key="payment-type.portlet.label.can-reverse" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input id="chkCanReverse" class="outputData" type="checkbox" <c:if test="${psb.selectedPaymentType.reverse}">checked</c:if> onclick="showHideReversalConfiguration();">
												</td>
											</tr>
											<tr id="optRow" class="DataEntryFieldRow" style="display: 'none';">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="chkCanReverse"><fmt:message key="payment-type.portlet.label.time-limit" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<select id="cmbTimeLimit" name="param_timeLimit" class="outputData">
														<option value="TILL_RECON" <c:if test="${psb.selectedPaymentType.timeLimit == 'TILL_RECON'}">selected</c:if>>Till Reconciliation</option>
														<option value="TILL_NEXT_DAY" <c:if test="${psb.selectedPaymentType.timeLimit == 'TILL_NEXT_DAY'}">selected</c:if>>Next BusinessDay</option>
													</select>												
												</td>
											</tr>
											<!-- End: Data entry fields -->
										</tbody>
									</table>
								</td>
							</tr>
							<tr id="optRow" style="display: 'none';">
								<td>
									<b><fmt:message key="payment-type.portlet.label.access-channels-that-permit-payment-reversal" bundle="${bndlLang}" /></b><br>
									<table class="tablelayout">
										<tbody>
											<tr>
												<td>
													<select id="srcChannels" size="5" multiple="multiple" ondblclick="pushChannel($('#srcChannels').val());"></select>
												</td>
												<td>&nbsp;</td>
												<td>
													<input type="button" class="button" value="&gt;&gt;" onclick="pushChannel($('#srcChannels').val());" /><br><br>
													<input type="button" class="button" value="&lt;&lt;" onclick="popChannel($('#trgChannels').val());" />
												</td>
												<td>
													<select id="trgChannels" size="5" multiple="multiple"></select>
												</td>			
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
							<!-- Adding Service type / Payment mismatch type change -->
							<tr class="DataEntryFieldRow">
								<td>
									<b><fmt:message key="payment-type.portlet.label.select-service-type-association" bundle="${bndlLang}" /></b><br>
									<table class="tablelayout">
										<tbody>
											<tr>
												<td>
													<select id="srcServiceType" size="5" multiple="multiple" ondblclick="pushServiceType($('#srcServiceType').val());"></select>
												</td>
												<td>&nbsp;</td>
												<td>
													<input type="button" class="button" value="&gt;&gt;" onclick="pushServiceType($('#srcServiceType').val());" /><br><br>
													<input type="button" class="button" value="&lt;&lt;" onclick="popServiceType($('#trgServiceType').val());" />
												</td>
												<td>
													<select id="trgServiceType" size="5" multiple="multiple"></select>
												</td>			
											</tr>
										</tbody>
									</table>
								</td>
							</tr>							
							<!-- Buttons Group -->
							<tr>
								<td>									
									<input type="hidden" name="param_prepaid" id="txtPrepaid"/>
									<input type="hidden" name="param_defaultPostpaid" id="txtPostpaid"/>
									<input type="hidden" name="param_deefault" id="txtDefault"/>
									<input type="hidden" name="param_reverse" id="txtReverse"/>
									<input type="hidden" name="param_accessChannels" id="txtTargetChannels"/>
									<input type="hidden" name="param_serviceTypes" id="txtTargetServiceTypes"/>
									<input type="hidden" name="param_status" value="${psb.selectedPaymentType.status}"/>									
									<input type="hidden" name="param_operation" id="param_operation" value="callUpdatePaymentType"/>
									<input class="button" value="<fmt:message key="payment-type.portlet.button.save" bundle="${bndlLang}" />" onclick="prepareFormSubmission(this); doQueryFormSubmission('frmUpdatePaymentType', 1);" type="submit" />
									<input class="button" value="<fmt:message key="payment-type.portlet.button.cancel" bundle="${bndlLang}" />" onclick="$('#param_operation').val('');doPostUrl('<portlet:resourceURL id="QueryPaymentTypeDetails" />', 1);" type="button" />
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
<script type="text/javascript">
	selectedChannels = [<c:forEach items="${psb.selectedPaymentType.accessChannels}" var="channel">'<c:out value="${fn:trim(channel)}"/>',</c:forEach>];
	selectedServiceTypes = [<c:forEach items="${psb.selectedPaymentType.serviceTypes}" var="svctyp">'<c:out value="${fn:trim(svctyp)}"/>',</c:forEach>];
</script>