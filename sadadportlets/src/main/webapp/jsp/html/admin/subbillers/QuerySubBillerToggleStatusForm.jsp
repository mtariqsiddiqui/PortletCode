<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmToggleStatusSubBiller" id="frmToggleStatusSubBiller" method="post" action="<portlet:resourceURL id="QuerySubBillerDetails_go_back"/>">
<table style="width: 100%;">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="subbiller.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message var="lblToggleStatus" key="subbiller.portlet.label.deactivate-subbiller" bundle="${bndlLang}" />
						<c:if test="${psb.selectedSubBiller.status == 'INACTIVE'}"><fmt:message var="lblToggleStatus" key="subbiller.portlet.label.activate-subbiller" bundle="${bndlLang}" /></c:if>
						${lblToggleStatus}
					</legend>
					<table>
						<tbody>
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="txtBillerId"><fmt:message key="subbiller.portlet.label.subbiller-id" bundle="${bndlLang}" /> *</label>
								</td>
								<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
									<input class="rqf" name="txtBillerId" value="${psb.selectedSubBiller.billerId}" maxlength="25" autocomplete="off" disabled="disabled">
									<input type="hidden" value="${psb.selectedSubBiller.billerId}" name="param_billerId">
								</td>
							</tr>
			
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="txtBillerNameEng"><fmt:message key="subbiller.portlet.label.legal-name-english" bundle="${bndlLang}" /></label>
								</td>
								<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
									<input name="param_billerNameEnglish" id="txtBillerNameEng" class="rqf" value="${psb.selectedSubBiller.billerNameEnglish}" autocomplete="off" disabled>
								</td>
							</tr>
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="txtBillerNameArb"><fmt:message key="subbiller.portlet.label.legal-name-arabic" bundle="${bndlLang}" /></label>
								</td>
								<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
									<input name="param_billerNameArabic" id="txtBillerNameArb" class="rqf" value="${psb.selectedSubBiller.billerNameArabic}" autocomplete="off" disabled>
								</td>
							</tr>	
							
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="txtBillerStatus"><fmt:message key="subbiller.portlet.label.status" bundle="${bndlLang}" />*</label>
								</td>
								<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
									${psb.selectedSubBiller.status}
								</td>
							</tr>
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="txtReason"><fmt:message key="subbiller.portlet.toggle.sataus.reason" bundle="${bndlLang}" />*</label>
								</td>
								<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
									<textarea style="margin: 0px; width: 200px; height: 40px;" class="rqf" name="param_justification" id="txtReason"></textarea>
								</td>
							</tr>
							<!-- Buttons Group -->
							<tr>
								<td>
									<input type="hidden" name="param_operation" value="callActivateOrDeActivateBiller">
									<fmt:message var="btnStatusLabel" key="subbiller.portlet.button.deactivate" bundle="${bndlLang}" />
									<c:if test="${psb.selectedSubBiller.status == 'INACTIVE'}">
										<fmt:message var="btnStatusLabel" key="subbiller.portlet.button.activate" bundle="${bndlLang}" />
									</c:if>
									<input type="submit" id="btnSubmit" class="button" value="${btnStatusLabel}" onclick="doQueryFormSubmission('frmToggleStatusSubBiller', 1);" />
									<input class="button" value="<fmt:message key="subbiller.portlet.button.cancel" bundle="${bndlLang}" />" onclick="doPostUrl('<portlet:resourceURL id="QuerySubBillerDetails" />', 1);" type="button" />
										
								</td><td></td>
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