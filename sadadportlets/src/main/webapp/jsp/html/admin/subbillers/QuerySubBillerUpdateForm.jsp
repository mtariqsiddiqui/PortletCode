<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="subbiller.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="subbiller.portlet.label.update-subbiller" bundle="${bndlLang}" /></legend>
					<form id="frmUpdateSubBiller" method="post" action="<portlet:resourceURL id="QuerySubBillerDetails"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
									<!-- Begin: Data entry fields -->
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerId"><fmt:message key="subbiller.portlet.label.subbiller-id" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input readonly="readonly" value="${psb.selectedSubBiller.billerId}" maxlength="25" autocomplete="off" >
													<input type="hidden" value="${psb.selectedSubBiller.billerId}" name="param_billerId">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerNameEng"><fmt:message key="subbiller.portlet.label.legal-name-english" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_billerNameEnglish" id="txtBillerNameEng" class="rqf" value="${psb.selectedSubBiller.billerNameEnglish}" autocomplete="off"  maxlength="50">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBillerNameArb"><fmt:message key="subbiller.portlet.label.legal-name-arabic" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_billerNameArabic" id="txtBillerNameArb" class="rqf" value="${psb.selectedSubBiller.billerNameArabic}"  maxlength="100" autocomplete="off">
												</td>
											</tr>											
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtLegalIdType"><fmt:message key="subbiller.portlet.label.legal-id-type" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<select name="param_legalIdType" id="txtLegalIdType" class="rqf">
														<option value="CR_NUMBER">Commercial Registration</option>
														<option value="UNIFIED_CR">Unified Commercial Registration</option>
														<option value="ROYAL_DECREE">Royal Decree</option>
														
													</select>
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtLegalIdNumber"><fmt:message key="subbiller.portlet.label.legal-id-number" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_legalIdNumber" id="txtLegalIdNumber" class="rqf" value="${psb.selectedSubBiller.legalIdNumber}" maxlength="15" autocomplete="off" onblur="chop(this);">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBankName"><fmt:message key="subbiller.portlet.label.bank-name" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<select name="param_billingAccountBankId" id="txtBankName" class="">
														<option value="">
															<fmt:message key="subbiller.portlet.label.please-select" bundle="${bndlLang}"/>
														</option>														
														<c:forEach items="${BankList}" var="bank">
															<option <c:if test="${psb.selectedSubBiller.billingAccountBankId == bank.value.partnerKey}">selected</c:if>
																value="<c:out value="${bank.value.partnerKey}" />">
																<c:out value="${bank.value.partnerName}" />
															</option>
														</c:forEach>
													</select>
													<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('txtBankName', '32c7fcd2cd9c32b19841d743dc09d56f');">
														<img src="/static/images/search.png" height="12px" width="12px">
													</button>
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtIbanNumber"><fmt:message key="subbiller.portlet.label.iban-number" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_ibanNumber" id="txtIbanNumber" class="" value="${psb.selectedSubBiller.ibanNumber}" maxlength="24" autocomplete="off" onblur="chop(this);">
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtTradeLicenseExpiry"><fmt:message key="subbiller.portlet.label.trade-license-expiry-date" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_tradeLicenseExpiryDate" id="txtTradeLicenseExpiry" class="" value="${psb.selectedSubBiller.tradeLicenseExpiryDate}" maxlength="10" placeholder="14YY-MM-DD" title="<fmt:message key="subbiller.portlet.title.hijri-format" bundle="${bndlLang}" />" autocomplete="off">												
												</td>
											</tr>
											
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtShortName"><fmt:message key="subbiller.portlet.label.short-name" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_shortName" id="txtShortName" class="rqf" value="${psb.selectedSubBiller.shortName}" maxlength="15" autocomplete="off">												
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtBusinessCategory"><fmt:message key="subbiller.portlet.label.business-category" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<%-- <input type="text" name="param_shortName" id="txtBusinessCategory" class="rqf" value="${psb.businessCategory}" maxlength="15" autocomplete="off"> --%>
													<select name="param_businessCategory" id="txtBusinessCategory" class="rqf">
<option value="01">Airlines</option>
<option value="02">Banking</option>
<option value="03">Business Services</option>
<option value="04">Charitable entities</option>
<option value="05">Commissions / Institutions</option>
<option value="06">Education</option>
<option value="07">Government Funded</option>
<option value="08">Installments</option>
<option value="09">Institution / Others</option>
<option value="10">Insurance</option>
<option value="11">ISP/Data</option>
<option value="12">Ministries</option>
<option value="13">Municipalities</option>
<option value="14">Other Transport/Cargo</option>
<option value="15">Printed Press</option>
<option value="16">Property</option>
<option value="17">Retail</option>
<option value="18">Technology</option>
<option value="19">Telecom</option>
<option value="20">Transport</option>
<option value="21">TV/Radio</option>
<option value="22">University</option>
<option value="23">Utility</option>
</select>												
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtAddress"><fmt:message key="subbiller.portlet.label.address" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_address" id="txtAddress" class="rqf" value="${psb.selectedSubBiller.address}" maxlength="150" autocomplete="off">												
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtLandline"><fmt:message key="subbiller.portlet.label.landline" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_landline" id="txtLandline" class="rqf" value="${psb.selectedSubBiller.landline}" maxlength="10" autocomplete="off">												
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtMobile"><fmt:message key="subbiller.portlet.label.mobile" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_mobile" id="txtMobile" class="rqf" value="${psb.selectedSubBiller.mobile}" maxlength="14" autocomplete="off">												
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtEmail"><fmt:message key="subbiller.portlet.label.email-address" bundle="${bndlLang}" /> * </label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_email" id="txtEmail" class="rqf" value="${psb.selectedSubBiller.email}" maxlength="129" autocomplete="off">												
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtVatNumber"><fmt:message key="subbiller.portlet.label.vat-number" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input type="text" name="param_vatNumber" id="txtVatNumber" class="nbr" value="${psb.selectedSubBiller.vatNumber}" maxlength="15" autocomplete="off">												
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
									<input type="hidden" name="param_operation" id="param_operation" value="callUpdatePartner" />
									<input class="button" value="<fmt:message key="subbiller.portlet.button.save" bundle="${bndlLang}" />" onclick="doQueryFormSubmission('frmUpdateSubBiller', 1);" type="submit" />
									<input class="button" value="<fmt:message key="subbiller.portlet.button.cancel" bundle="${bndlLang}" />" onclick="doPostUrl('<portlet:resourceURL id="QuerySubBillerDetails" />', 1);" type="button" />
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