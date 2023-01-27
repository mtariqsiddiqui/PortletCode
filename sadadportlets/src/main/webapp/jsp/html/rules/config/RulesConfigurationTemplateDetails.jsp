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
								<table style="width: 100%">
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
											<fieldset><legend><fmt:message key="ebpp.portlet.label.availabe-subscription-options" bundle="${bndlLang}"/></legend>
												<form name='frmSubscribeRules' id='frmSubscribeRules' method='post' action='<portlet:resourceURL id="RulesConfigurationTemplateDetails" />'>
												<table class="tableclass" id="formTable" style="table-layout: fixed;width: 100%;">
													<tbody>
														<tr id="row_templateIdentifier"><th style="width: 15px;"></th>
															<c:forEach items="${RulesList[psb.configrationKey].attributes}" var="attr">
															<c:if test="${attr.value.templateIdentifier}">
															<th><label for="txtIdentifier">${attr.value.attribName} *</label></th>
															<td id="identifierData">
																<select id="txtIdentifier" name="param_identifier" class="rqf">
																	<option value=""><fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}" /></option>
																</select>
															</td>
															</c:if>
															</c:forEach>
														</tr>
														<tr>
															<th style="width: 15px;"></th>
															<th style="width: auto;word-break: break-all;"><fmt:message key="ebpp.portlet.label.template-name" bundle="${bndlLang}" /></th>
															<c:forEach items="${RulesList[psb.configrationKey].attributes}" var="attr">
																<c:if test="${not attr.value.templateIdentifier}">
																<th style="width: auto;word-break: break-all;">${attr.value.attribName}</th>
																</c:if>
															</c:forEach>
														</tr>
														<c:forEach items="${RulesList[psb.configrationKey].templateData.templates}" var="tmplt">
														<tr id="r_${tmplt.key}">
															<th style="width: 15px;">
																<input type="radio" name="param_partnerConfigValues" id="txt_${tmplt.key}_${tmplt.value.templateName}" value="${tmplt.key}@${tmplt.value.templateName}" style="width:15px;"/>
															</th>
															<td id="c_${tmplt.key}_Name">
																<label for="txt_${tmplt.key}_${tmplt.value.templateName}" style="word-break: break-all;min-width:100%;white-space:normal;">
																	${tmplt.value.templateName} / ${tmplt.value.description}
																</label>
															</td>
															<c:forEach items="${RulesList[psb.configrationKey].attributes}" var="attr">
															<c:if test="${not attr.value.templateIdentifier}">
															<td id="c_${tmplt.key}_${attr.key}">
																<label for="txt_${tmplt.key}_${tmplt.value.templateName}" style="word-break: break-all;min-width:100%;white-space:normal;">
																	${tmplt.value.templateAttributes[attr.key].defaultValue}
																</label>
															</td>
															</c:if>
															</c:forEach>
														</tr>
														</c:forEach>
													</tbody>
												</table>
												<input type="hidden" name="param_configuraitonName" value="${RulesList[psb.configrationKey].configName}"/>
												<input type="hidden" id="param_partnerConfigValues" name="param_partnerConfigValues" />
												<input type="hidden" id="txtConfigType" name="param_configType" value="${RulesList[psb.configrationKey].configType}" />											
												<input type="hidden" id="txtOperation" name="param_operation" value="callCreatePartnerConfiguration" />
												<input type="submit" class="button" onclick="setValuesForPartnerConfiguration(doQueryFormSubmission);" value='<fmt:message key="ebpp.portlet.button.subscribe" bundle="${bndlLang}"/>'/>
											</form>
											</fieldset>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<!-- Already Subscribed Table -->
							<td>
							<fieldset><legend><fmt:message key="ebpp.portlet.label.partner-subscription" bundle="${bndlLang}"/></legend>
							<form id="frmTmpltUnscribe" name="frmTmpltUnscribe" method="post" action='<portlet:resourceURL id="RulesConfigurationTemplateDetails"/>'>
								<table class="tableclass" id="partnerSubscription" style="table-layout:fixed;width:100%;">
									<tbody>
										<tr>
											<th style="width:15px;"></th>
											<th style="width:auto;"><fmt:message key="ebpp.portlet.label.partner-identifier" bundle="${bndlLang}" /></th>
											<th style="width:auto;"><fmt:message key="ebpp.portlet.label.template-name" bundle="${bndlLang}" /></th>
										</tr>
										<c:forEach items="${psb.partnerConfiguration[psb.configrationKey].templates}" var="ptmplt">
										<tr>
											<th style="width: 15px;"><input type="radio" name="param_partnerConfigValues" id="txt_${ptmplt.key}_${ptmplt.value.partnerConfigTemplateId}" value="${ptmplt.key}@${ptmplt.value.partnerConfigTemplateId}" style="width:15px;"/></th>
											<td><label style="word-break: break-all;min-width:100%;white-space:normal;" for="txt_${ptmplt.key}_${ptmplt.value.partnerConfigTemplateId}">${ptmplt.value.partnerTemplateIdentifier}</label></td>
											<td><label style="word-break: break-all;min-width:100%;white-space:normal;" for="txt_${ptmplt.key}_${ptmplt.value.partnerConfigTemplateId}">${RulesList[psb.configrationKey].templateData.templates[ptmplt.value.templateId].templateName} / ${RulesList[psb.configrationKey].templateData.templates[ptmplt.value.templateId].description}</label></td>
										</tr>
										</c:forEach>
									</tbody>
								</table>
								<input type="hidden" name="param_configuraitonName" value="${RulesList[psb.configrationKey].configName}"/>
								<input type="hidden" id="txtOperation" name="param_operation" value="callDeletePartnerConfiguration" />
								<input type="submit" class="button" onclick="unsubscribePartnerConfiguration(doQueryFormSubmission);" value='<fmt:message key="ebpp.portlet.button.unsubscribe" bundle="${bndlLang}"/>'/>
							</form>
							</fieldset>
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