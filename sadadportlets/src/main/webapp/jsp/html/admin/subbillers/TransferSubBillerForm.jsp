<%@ page import="com.sadad.scm.common._1.ConfigurationStatusEnum"%>
<% pageContext.setAttribute("configStatusEnum", ConfigurationStatusEnum.values()); %>

<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmTransferBiller" id="frmTransferBiller" method="post" action="<portlet:resourceURL id="TransferSubBillerForm"/>">
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
					<legend><fmt:message key="subbiller.portlet.label.transfer-subbiller" bundle="${bndlLang}" /></legend>
					<table>
						<tbody>
							<tr class="DataEntryFieldRow">
								<td class="labelCell" valign="top" nowrap height="27">
									<label class="label" for="txtBillerId"><fmt:message key="subbiller.portlet.label.subbiller-id" bundle="${bndlLang}" /> * </label>
								</td>
								<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
									<input name="param_billerId" id="txtBillerId" class="rqf" value="${psb.billerId}" autocomplete="off">
								</td>
							</tr>
							
							
							<!-- Buttons Group -->
							<tr>
								<td>
									<input type="hidden" name="param_operation" value="callTransferPartner">
									<input type="submit" id="btnSearch" class="button" 
										value="<fmt:message key="subbiller.portlet.button.submit" bundle="${bndlLang}" />" 
										onclick="doQueryFormSubmission('frmTransferBiller', 1);" />
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