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
	<legend><fmt:message key="ebpp.portlet.label.get-rejected-bills" bundle="${bndlLang}"/></legend>
	<form method="post" action='<portlet:resourceURL id="RejectedBillsList"/>' name="frmRejectedBills" id="frmRejectedBills">
		<table class="dataEntryPageTable" style="width:100%; border: none; padding: 10px; border-collapse: separate; border-spacing: 10px;">
			<tbody>
				<tr class="DataEntryFieldRow">
					<td class="labelCell" style="width: 20%; vertical-align: top; height: 27" nowrap>
						<label class="label" for="txtRquid"><fmt:message key="ebpp.portlet.label.rquid" bundle="${bndlLang}"/> *</label>
					</td>
					<td class="outputDataCell" style="width: 80%; vertical-align: top;" nowrap>
						<input type="text" name="param_rquid" id="txtRquid" value="${psb.rquid}" autocomplete="off" maxlength="36" class="rqf"/>
						<input type="hidden" name="param_operation" value="callBulkUploadService_ListRejected" />
						<input type="hidden" name="param_searchType" value="BILL" />						
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="hidden" name="param_billerId" value=""/>
						<input class="button" value="<fmt:message key="ebpp.portlet.button.search" bundle="${bndlLang}"/>" onclick="doQueryFormSubmission('frmRejectedBills', 2)" type="submit"/>
						<portlet:resourceURL id="RejectedBillForm" var="clearURL"><portlet:param name="param_operation" value="clearSessionBeanObject"/></portlet:resourceURL>
						<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.clear" bundle="${bndlLang}"/>" onclick="doQueryFormReset('${clearURL}');" />
					&nbsp;&nbsp;
						<div style="display: inline-block;">
							<a href="#" onclick="doPostUrl('<portlet:resourceURL id="RejectedBillAdvanceForm"/>', 1);"><fmt:message key="ebpp.portlet.label.advanced-search" bundle="${bndlLang}"/> </a>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</fieldset>