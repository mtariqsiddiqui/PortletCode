<jsp:directive.include file="../../common/JspDeclarations.jspf" />

<form name="frmQueryBill" id="frmQueryBill" method="post" action="<portlet:resourceURL id="core_BillsSummary"/>">
	<table style="width: 100%">
		<!-- Form or Details container -->
		<tbody>
			<tr>
				<td>
					<table style="width: 100%">
						<tbody>
							
							<tr>
								<td>
									<p class="attnbox"><fmt:message key="ebpp.portlet.marked-fields-are-mandatory" bundle="${bndlLang}"/></p>
								</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td>
				<!-- Query Segment -->
					<fieldset>
						<legend>
							<fmt:message key="ebpp.portlet.label.search-for-bill" bundle="${bndlLang}"/>
							
						</legend>
						<table>
							<tbody>
								<tr>
									<td class="myCaption"></td>
								</tr>
								<tr>
									<td>
										<table  style="width: 100%">
											<!-- Begin: Data entry fields -->
											<tbody>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="cmbPartnerKey">
															<fmt:message key="ebpp.portlet.label.biller" bundle="${bndlLang}"/>&nbsp;:&nbsp;*
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<select name="txtPartnerKey" class="outputData" required="true" id="cmbPartnerKey" onchange="onChangePartnerKey(this);">
															<option value="">
																<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
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
													<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
														<label class="label" for="txtBillNumber">
															<fmt:message key="ebpp.portlet.label.bill-number" bundle="${bndlLang}"/>&nbsp;:&nbsp;*
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%; vertical-align:top" nowrap>
														<input name="txtBillNumber" class="outputData" value="${psb.bills[psb.billKey].billNumber}" required="true" id="txtBillNumber" autocomplete="off" maxlength="256" type="text">
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
										<input type="submit" class="button" value="<fmt:message key="ebpp.portlet.button.submit" bundle="${bndlLang}"/>" onclick="doQueryFormSubmission('frmQueryBill');" />
										<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.clear" bundle="${bndlLang}"/>" onclick="doQueryFormReset();" />
									</td>
								</tr>
							</tbody>
						</table>
					</fieldset>
					<!-- END Query Segment --></td>
			</tr>
			<!-- End Form/Details container -->
			<!-- List Container -->
			<tr>
				<td></td>
			</tr>
			<!-- END List Container -->
		</tbody>
	</table>
	<!-- END Main Table -->
</form>