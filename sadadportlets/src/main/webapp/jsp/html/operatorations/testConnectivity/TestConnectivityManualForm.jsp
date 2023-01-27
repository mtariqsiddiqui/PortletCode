<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<p class="attnbox">
	<fmt:message key="ow.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" />
</p>

<form id="frmManualConfig" name="frmManualConfig" method="post" action='<portlet:resourceURL id="TestConnectivitySummary"/>'>
	<fieldset>
		<legend><fmt:message key="ow.portlet.label.manual-configuration" bundle="${bndlLang}"/></legend>
		<table>
			<tbody>
				<tr class="DataEntryFieldRow">
					<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
						<label for="cmbProtocol"><fmt:message key="ow.portlet.label.protocol" bundle="${bndlLang}"/> *</label>
					</td>
					<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
						<select id="cmbProtocol" name="param_protocol" onchange="protocolChange(this.value);">
							<option value="TELNET">Telnet</option>
							<option value="PING">Ping</option>
						</select>
					</td>
				</tr>
				<tr class="DataEntryFieldRow">
					<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
						<label for="address"><fmt:message key="ow.portlet.label.partner-alias" bundle="${bndlLang}"/> *</label> 
					</td>
					<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
						<input id="txtIpAddress" type="text" name="param_ipAddress" value="" required maxlength="25">
					</td>
				</tr>
				<tr class="DataEntryFieldRow">
				<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
					<label for="address"><fmt:message key="ow.portlet.label.destination-port" bundle="${bndlLang}"/><span id="reqMark">*</span></label>
				</td>
				<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
					<input name="Port Number" type="number" id="txtPortNumber" name="param_port" value="" maxlength="6">
				</td>
				</tr>
				<tr class="DataEntryFieldRow">
					<td colspan="2" style="width: 100%" valign="top" nowrap>
						<input type="hidden" name="param_testType" value="Manual" />
						<input type="hidden" name="param_operation" value="callTestConnectionManual" />
						<input class="button" type="submit" onclick="doQueryFormSubmission('frmManualConfig', 2);" value='<fmt:message key="ow.portlet.button.test-connection" bundle="${bndlLang }"/>'>
						&nbsp;						
						<a href="#" onclick="doPostUrl('<portlet:resourceURL id="TestConnectivityAutomaticForm" />', 1)">
							<fmt:message key="ow.portlet.label.automatic-test" bundle="${bndlLang}"/>
						</a>
					</td>
				</tr>
			</tbody>
		</table>
	</fieldset>
</form>