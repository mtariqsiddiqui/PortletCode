<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<c:choose>
	<c:when test="${psb.organisationType == 'bank' }">
		<c:set var="RulesList" value="${BankRulesList}" scope="request"/>
	</c:when>
	<c:when test="${psb.organisationType == 'biller'}">
		<c:set var="RulesList" value="${BillerRulesList}" scope="request"/>
	</c:when>
	<c:when test="${psb.organisationType == 'aggregator'}">
		<c:set var="RulesList" value="${AggregatorRulesList}" scope="request"/>
	</c:when>
	<c:when test="${psb.organisationType == 'sadad' }">
		<c:set var="RulesList" value="${SadadRulesList}" scope="request"/>
	</c:when>
	<c:when test="${psb.organisationType == 'subbiller' }">
		<c:set var="RulesList" value="${SubBillerRulesList}" scope="request"/>
	</c:when>
</c:choose>
<script type="text/javascript">
try {
	var configFieldSeparator = '${psb.PARTNER_CONFIG_FIELD_SEPARATOR}';
	var configRecordSeparator = '${psb.PARTNER_CONFIG_RECORD_SEPARATOR}';
	var sConfig = JSON.parse('${RulesList[psb.configrationKey].getJsonString()}');
	var pConfig = JSON.parse('${psb.partnerConfiguration[psb.configrationKey].getJsonString()}');
} catch (error) {
	pConfig = undefined;
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
								<form name='frmSubscribeRules' id='frmSubscribeRules' method='post' action='<portlet:resourceURL id="RulesConfigurationAttributeDetails" />'>
								<table  style="width: 100%">
									<!-- Begin: Data display fields -->
									<tbody>
										<tr class="NewsColumnWrapper">
											<td class="NewsColumnCell" style="width: 100%" valign="top">
												<!-- Begin: Data display fields -->												
												<table class="tableclass" id="headerTable">
													<tbody>
														<tr>
															<th style="width: 25%"><fmt:message key="ebpp.portlet.label.partner-name" bundle="${bndlLang}" /></th>
															<td style="width: 75%">
															<c:if test="${psb.partnerId eq 'SADAD-001'}">SADAD</c:if>
															<c:if test="${psb.partnerId ne 'SADAD-001'}">${BankList[psb.partnerId].partnerName} ${BillerList[psb.partnerId].partnerName}</c:if>
															</td>
														</tr>
														<tr>
															<th style="width: 25%"><fmt:message key="ebpp.portlet.label.configuration-name" bundle="${bndlLang}" /></th>
															<td style="width: 75%">${RulesList[psb.configrationKey].configName} (${RulesList[psb.configrationKey].description})</td>
														</tr>
													</tbody>
												</table>
											</td>
										</tr>
										<tr class="NewsColumnWrapper">
											<td class="NewsColumnCell" style="width: 100%" valign="top">
											<fieldset><legend><fmt:message key="ebpp.portlet.label.create-update-partner-configuration" bundle="${bndlLang}"/></legend>
												<table class="tableclass" id="formTable">
													<tbody>
														<tr>
															<th style="width: 34%"><fmt:message key="ebpp.portlet.label.attributes" bundle="${bndlLang}" /></th>
															<th style="width: 33%"><fmt:message key="ebpp.portlet.label.configured-value" bundle="${bndlLang}" /></th>
															<th style="width: 33%"><fmt:message key="ebpp.portlet.label.default-value" bundle="${bndlLang}" /></th>
														</tr>
														<c:forEach items="${RulesList[psb.configrationKey].attributes}" var="attr">
														<tr id="row_${attr.value.attribId}"></tr>
														</c:forEach>
													</tbody>
												</table>
												<input type="hidden" name="param_configuraitonName" value="${RulesList[psb.configrationKey].configName}"/>
												<input type="hidden" id="param_partnerConfigValues" name="param_partnerConfigValues" />
												<input type="hidden" id="txtConfigType" name="param_configType" value="${RulesList[psb.configrationKey].configType}" />
												<input type="hidden" id="txtOperation" name="param_operation" value="" />
												<input type="submit" class="button" onclick="setValuesForPartnerConfiguration(doQueryFormSubmission);" value='<fmt:message key="ebpp.portlet.button.configure" bundle="${bndlLang}"/>'/>
												<portlet:resourceURL id="RulesConfigurationAttributeDetails" var="deleteConfigUrl">
													<portlet:param name="param_partnerId" value="${psb.partnerId}"/>
													<portlet:param name="param_configrationKey" value="${psb.configrationKey}"/>
													<portlet:param name="param_operation" value="callDeletePartnerConfiguration"/>
													<portlet:param name="param_configuraitonName" value="${RulesList[psb.configrationKey].configName}"/>
												</portlet:resourceURL>
												<input type="button" class="button" onclick="doPostUrl('${deleteConfigUrl}', 1)" id="btnDeleteConfig" value='<fmt:message key="ebpp.portlet.button.unconfigure" bundle="${bndlLang}"/>'/>
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