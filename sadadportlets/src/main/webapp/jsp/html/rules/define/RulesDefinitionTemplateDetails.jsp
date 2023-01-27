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
													</tbody>
												</table>
											</td>
										</tr>
										<tr class="NewsColumnWrapper">
											<td class="NewsColumnCell" style="width: 100%" valign="top">
											<fieldset><legend><fmt:message key="ebpp.portlet.label.rule-defined-templates" bundle="${bndlLang}"/></legend>
												<form name='frmChangeRuleStatus' id='frmChangeRuleStatus' method='post' action='<portlet:resourceURL id="RulesDefinitionTemplateDetails" />'>
												<table class="tableclass" id="formTable">
													<tbody>
														<tr id="row_templateIdentifier"><th></th>
															<c:forEach items="${RulesList[psb.configrationKey].attributes}" var="attr">
															<c:if test="${attr.value.templateIdentifier}">
															<th><fmt:message key="ebpp.portlet.label.template-identifier" bundle="${bndlLang}"/></th>
															<td>${attr.value.attribName}</td>
															</c:if>
															</c:forEach>
														</tr>
														<tr>
															<th style="width: auto"></th>
															<th style="width: auto; color: #2F4F4F;"><fmt:message key="ebpp.portlet.label.template-name" bundle="${bndlLang}" /></th>
															<th style="width: auto"><fmt:message key="ebpp.portlet.label.status" bundle="${bndlLang}"/></th>
															<c:forEach items="${RulesList[psb.configrationKey].attributes}" var="attr">
																<c:if test="${not attr.value.templateIdentifier}">
																<th style="width: auto">
																	${attr.value.attribName}
																</th>
																</c:if>
															</c:forEach>
														</tr>
															<c:forEach items="${RulesList[psb.configrationKey].templateData.templates}" var="tmplt">
															<tr id="r_${tmplt.key}">
																<th><input type="radio" name="param_partnerConfigValues" id="txt_${tmplt.key}_${tmplt.value.templateName}" value="${tmplt.key}@${tmplt.value.templateName}" onclick="setStatus('${tmplt.value.status}');" style="width:15px;"/></th>
																<td id="c_${tmplt.key}_Name">
																	<label style="color: #2F4F4F;" for="txt_${tmplt.key}_${tmplt.value.templateName}">${tmplt.value.templateName} / ${tmplt.value.description}</label>
																</td>
																<td id="c_${tmplt.key}_Status">
																	<label style="width: auto;" for="txt_${tmplt.key}_${tmplt.value.templateName}">${tmplt.value.status}</label>
																</td>
																<c:forEach items="${RulesList[psb.configrationKey].attributes}" var="attr">
																<c:if test="${not attr.value.templateIdentifier}">
																<td id="c_${tmplt.key}_${attr.key}">
																	<label style="width: auto;" for="txt_${tmplt.key}_${tmplt.value.templateName}">${tmplt.value.templateAttributes[attr.key].defaultValue}</label>
																</td>
																</c:if>
																</c:forEach>
															</tr>
															</c:forEach>
													</tbody>
												</table>
												<input type="hidden" name="param_configuraitonName" value="${RulesList[psb.configrationKey].configName}"/>
												<input type="hidden" id="txtStatus" name="param_status" />
												<input type="hidden" id="txtConfigType" name="param_configType" value="${RulesList[psb.configrationKey].configType}" />											
												<input type="hidden" id="txtOperation" name="param_operation" value="callPartnerConfigurationTemplateActivateOrDeActivate" />
												<input type="submit" class="button" onclick="changeTemplateState(doQueryFormSubmission);" value='<fmt:message key="ebpp.portlet.button.activate-dedeactivate" bundle="${bndlLang}" />'/>
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
							<fieldset><legend><fmt:message key="ebpp.portlet.label.define-new-template" bundle="${bndlLang}"/></legend>
							<form id="frmNewTmplt" name="frmNewTmplt" method="post" action='<portlet:resourceURL id="RulesDefinitionTemplateDetails"/>'>
								<table>
									<tbody>
										<tr>
											<td><label for="param_templateName"><fmt:message key="ebpp.portlet.label.template-name" bundle="${bndlLang}" />*</label></td>
											<td><input type="text" class="rqf" name="param_templateName" id="param_templateName" /></td>
										</tr>
										<tr>
											<td><label for="param_templateDescription"><fmt:message key="ebpp.portlet.label.template-description" bundle="${bndlLang}" />*</label></td>
											<td><input type="text" class="rqf" name="param_templateDescription" id="param_templateDescription" /></td>
										</tr>
										<c:forEach items="${RulesList[psb.configrationKey].attributes}" var="attr">
										<c:if test="${not attr.value.templateIdentifier}">
										<tr id="row_${attr.value.attribId}"></tr>
										</c:if>
										</c:forEach>
									</tbody>
								</table>
								<input type="hidden" name="param_configuraitonName" value="${RulesList[psb.configrationKey].configName}"/>
								<input type="hidden" id="param_partnerConfigValues" name="param_partnerConfigValues" value="" />
								<input type="hidden" id="txtOperation" name="param_operation" value="callCreateConfigurationTemplate" />
								<input type="submit" class="button" onclick="setValueForTemplateCreation(doQueryFormSubmission);" value='<fmt:message key="ebpp.portlet.button.define" bundle="${bndlLang}"/>'/>
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