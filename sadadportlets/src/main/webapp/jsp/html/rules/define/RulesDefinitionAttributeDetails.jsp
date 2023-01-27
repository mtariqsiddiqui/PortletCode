<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<c:choose>
	<c:when test="${psb.organisationType == 'bank' }">
		<c:set var="RulesList" value="${BankRulesList}" scope="request"/>
	</c:when>
	<c:when test="${psb.organisationType == 'biller' }">
		<c:set var="RulesList" value="${BillerRulesList}" scope="request"/>
	</c:when>
	<c:when test="${psb.organisationType == 'sadad' }">
		<c:set var="RulesList" value="${SadadRulesList}" scope="request"/>
	</c:when>
</c:choose>
<script type="text/javascript">
try {
	var configFieldSeparator = '${psb.PARTNER_CONFIG_FIELD_SEPARATOR}';
	var configRecordSeparator = '${psb.PARTNER_CONFIG_RECORD_SEPARATOR}';
	var sConfig = JSON.parse('${RulesList[psb.configrationKey].getJsonString()}');
	var pConfig = JSON.parse('${psb.partnerConfiguration[psb.configrationKey].getJsonString()}');
} catch (error) {
	// console.error(error);
}
</script>
<!-- Main Table -->
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<table style="width: 100%">
					<tbody>
						<tr>
							<td class="myCaption"><fmt:message key="ebpp.portlet.label.configuration-details" bundle="${bndlLang}" /></td>
						</tr>
						<tr>
							<td>
								<form name='frmChangeRuleStatus' id='frmChangeRuleStatus' method='post' action='<portlet:resourceURL id="RulesDefinitionAttributeDetails" />'>
								<table  style="width: 100%">
									<!-- Begin: Data display fields -->
									<tbody>
										<tr class="NewsColumnWrapper">
											<td class="NewsColumnCell" style="width: 100%" valign="top">
												<!-- Begin: Data display fields -->												
												<table class="tableclass" id="headerTable">
													<tbody>
														<tr>
															<th style="width: 25%"><fmt:message key="ebpp.portlet.label.configuration-name" bundle="${bndlLang}" /></th>
															<td style="width: 75%">${RulesList[psb.configrationKey].configName} (${RulesList[psb.configrationKey].description})</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="ebpp.portlet.label.status" bundle="${bndlLang}" /></th>
															<td style="width: 75%">${RulesList[psb.configrationKey].status}</td>
														</tr>
													</tbody>
												</table>
											</td>
										</tr>
										<tr class="NewsColumnWrapper">
											<td class="NewsColumnCell" style="width: 100%" valign="top">
											<fieldset><legend><fmt:message key="ebpp.portlet.label.rule-attributes-detail" bundle="${bndlLang}"/></legend>
												<table class="tableclass" id="formTable">
													<tbody>
														<tr>
															<th style="width: 34%"><fmt:message key="ebpp.portlet.label.attributes" bundle="${bndlLang}" /></th>
															<!--<th style="width: 33%"><fmt:message key="ebpp.portlet.label.configured-value" bundle="${bndlLang}" /></th>-->
															<th style="width: 33%"><fmt:message key="ebpp.portlet.label.default-value" bundle="${bndlLang}" /></th>
														</tr>
														<c:forEach items="${RulesList[psb.configrationKey].attributes}" var="attr">
														<tr id="row__${attr.value.attribId}"></tr>
														</c:forEach>
													</tbody>
												</table>
												<input type="hidden" name="param_configuraitonName" value="${RulesList[psb.configrationKey].configName}"/>
												<input type="hidden" name="param_status" value="${RulesList[psb.configrationKey].status}"/>
												<input type="hidden" id="txtConfigType" name="param_configType" value="${RulesList[psb.configrationKey].configType}" />
												<input type="hidden" id="txtOperation" name="param_operation" value="callPartnerConfigurationActivateOrDeActivate" />
												<input type="submit" class="button" onclick="doQueryFormSubmission('frmChangeRuleStatus', 1);" value='<fmt:message key="ebpp.portlet.button.activate-dedeactivate" bundle="${bndlLang}"/>'/>
											</fieldset>
											</td>
										</tr>
									</tbody>
								</table>
								</form>
							</td>
						</tr>
						<!-- Buttons Group -->
						<tr>
							<td><br/>
								<form method="post" action="<portlet:actionURL/>">
									<input type="hidden" name="fpWhereTo" id="fpWhereTo" value="" />
									<input type="submit" class="button" onclick="navigate(this);" name="back" value='<fmt:message key="ebpp.portlet.button.back" bundle="${bndlLang}"/>'/>
									<input type="submit" class="button" onclick="navigate(this);" name="finish" value='<fmt:message key="ebpp.portlet.button.finish" bundle="${bndlLang}"/>'/>
								</form>									
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
	</tbody>
</table>
<%--
${psb.configrationKey}
<hr>
${RulesList[psb.configrationKey].getJsonString()}
<hr>
${psb.partnerConfiguration[psb.configrationKey].getJsonString()}
--%>