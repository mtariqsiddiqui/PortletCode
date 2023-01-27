<jsp:directive.include file="../../common/JspDeclarations.jspf" />

<span class="${psb.messageToDisplay.messageType}_Message">${psb.messageToDisplay.displayMessage}</span>
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="sadad-admin.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="sadad-admin.portlet.label.update-sadad" bundle="${bndlLang}" /></legend>
					<form id='frmUpdateSadad' method='post' action='<portlet:resourceURL id="SadadDetails" />'>
						<table style="width: 100%">
						<!-- Begin: Data entry fields -->
							<tbody>
								<tr class="DataEntryFieldRow">
									<td class="labelCell" style="width: 22%;height: 30px;vertical-align: top;" nowrap>
										<label class="label" for="txtCurrentAccount"><fmt:message key="sadad-admin.portlet.label.sadad-current-account-number" bundle="${bndlLang}" /> *</label>
									</td>
									<td class="outputDataCell" style="width: auto;height: 30px;vertical-align: top;" nowrap>
										<input type="text" name="param_sadadCurrentAccount" id="txtCurrentAccount" class="rqf" value="${psb.sadadCurrentAccount}" maxlength="32" autocomplete="off" />
										
										
										
									</td>
								</tr>
								<tr class="DataEntryFieldRow">
									<td class="labelCell" style="width: 22%;height: 30px;vertical-align: top;" nowrap>
										<label class="label" for="txtBankId"><fmt:message key="sadad-admin.portlet.label.account-bank-name" bundle="${bndlLang}" /> *</label>
									</td>
									<td class="outputDataCell" style="width: auto;height: 30px;vertical-align: top;" nowrap>
									
										<select name="param_accountBankId" id="txtBankId" class="rqf">
											<option value="">
												<fmt:message key="sadad-admin.portlet.label.please-select" bundle="${bndlLang}"/>
											</option>
											<c:forEach items="${BankList}" var="bank">
												<option <c:if test="${psb.accountBankId == bank.value.partnerKey}">selected</c:if>
													value="<c:out value="${bank.value.partnerKey}" />">
													<c:out value="${bank.value.partnerName}" />
												</option>
											</c:forEach>
										</select>
										<button id="callSrchEngnBtn" type="button" onclick="callSearchEngine('txtBankId', '32c7fcd2cd9c32b19841d743dc09d56f');">
											<img src="/static/images/search.png" height="12px" width="12px">
										</button>
									</td>
								</tr>
								<tr class="DataEntryFieldRow">
									<td class="labelCell" style="width: 22%;height: 30px;vertical-align: top;" nowrap>
										<label class="label" for="txtRefundLimit"><fmt:message key="sadad-admin.portlet.label.refund-max-limit" bundle="${bndlLang}" /> *</label>
									</td>
									<td class="outputDataCell" style="width: auto;height: 30px;vertical-align: top;" nowrap>
										<input name="param_refundMaxLimit" id="txtRefundLimit" class="rqf" value="${psb.refundMaxLimit}" pattern="[0-9]{1,3}" maxlength="3" title='<fmt:message key="sadad-admin.portlet.title.refund-limit" bundle="${bndlLang}"/>' autocomplete="off" />
									</td>
								</tr>
								<!-- End: Data entry fields -->
								<tr>
									<td colspan="2">
										<input type="hidden" name="param_operation" value="callUpdateSADAD"/>
										<input class="button" value="<fmt:message key="sadad-admin.portlet.button.save" bundle="${bndlLang}" />" onclick="doQueryFormSubmission('frmUpdateSadad', 1);" type="submit" />
										<input class="button" value="<fmt:message key="sadad-admin.portlet.button.cancel" bundle="${bndlLang}" />" onclick="doPostUrl('<portlet:resourceURL id="SadadDetails" />', 1);" type="button" />
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