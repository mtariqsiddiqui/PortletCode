<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%;">
	<tbody>
		<tr>
			<td><p class="attnbox"><fmt:message key="ebpp.portlet.marked-fields-are-mandatory" bundle="${bndlLang}"/></p></td>
		</tr>
	</tbody>
</table>
<!-- Main Table -->
<fieldset>
	<legend><fmt:message key="ebpp.portlet.label.search-for-refund" bundle="${bndlLang}"/></legend>
	<form method="post" action='<portlet:resourceURL id="core_RefundSummary"/>' name="frmQueryRefund" id="frmQueryRefund">
		<table class="dataEntryPageTable" style="width:100%; border: none; padding: 10px; border-collapse: separate; border-spacing: 10px;">
			<tbody>
				<tr class="DataEntryFieldRow">
					<td class="labelCell" style="width: 20%; vertical-align: top; height: 27" nowrap>
						<label class="label" for="fpRquid"><fmt:message key="ebpp.portlet.label.refund-id" bundle="${bndlLang}"/> *</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
						<input class="outputData" value="${psb.refundId}" name="param_refundId" id="txtRefundId" autocomplete="off" maxlength="256" type="text" required/>
					</td>
				</tr>
				<tr>
					<td align="left" colspan="2">
						<input class="button" value="<fmt:message key="ebpp.portlet.button.search" bundle="${bndlLang}"/>" onclick="doQueryFormSubmission('frmQueryRefund', 2);" type="submit"/>
						<input class="button" value="<fmt:message key="ebpp.portlet.button.clear" bundle="${bndlLang}"/>" onclick=";" type="button"/>
						<div style="display: inline;">
							<a href="#" onclick="doPostUrl('<portlet:resourceURL id="QueryRefundAdvanceForm"/>', 1);"><fmt:message key="ebpp.portlet.label.advanced-search" bundle="${bndlLang}"/> </a>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</fieldset>