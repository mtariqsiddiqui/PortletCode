<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmCloseSubBiller" id="frmCloseSubBiller" method="post" action="<portlet:resourceURL id="QuerySubBillerDetails_go_back"/>">
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
					<legend><fmt:message key="subbiller.portlet.label.close-subbiller" bundle="${bndlLang}" /></legend>
					<table>
						<tbody>
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="txtBillerId"><fmt:message key="subbiller.portlet.label.subbiller-id" bundle="${bndlLang}" /> *</label>
								</td>
								<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
									<input class="rqf" name="txtBillerId" value="${psb.selectedSubBiller.billerId}" maxlength="25" autocomplete="off" disabled>
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
									<input name="param_status" id="txtBillerStatus" class="rqf" value="CLOSE" autocomplete="off" disabled>
								</td>
							</tr>
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="txtReason"><fmt:message key="subbiller.portlet.closure.reason" bundle="${bndlLang}" />*</label>
								</td>
								<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
									<textarea style="margin: 0px; width: 200px; height: 40px;" class="rqf" name="param_justification" id="txtReason"></textarea>
								</td>
							</tr>
							<!-- Buttons Group -->
							<tr>
								<td>
									<input type="hidden" name="param_operation" value="callCloseSubBiller">
									<input type="submit" id="btnClose" class="button" value="<fmt:message key="subbiller.portlet.button.close" bundle="${bndlLang}" />" onclick="doQueryFormSubmission('frmCloseSubBiller', 1);" />
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