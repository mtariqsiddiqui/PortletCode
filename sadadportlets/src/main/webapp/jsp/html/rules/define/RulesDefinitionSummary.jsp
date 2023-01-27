<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<fieldset>

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

<table id="detailTable" class="tableclass" style="width:100%">
	<caption class="myCaption">
		<span class="caption"><fmt:message key="ebpp.portlet.label.configuration-summary" bundle="${bndlLang}" /></span>
	</caption>
	<!-- Begin: table header row -->
	<thead>
		<tr>
			<th><fmt:message key="ebpp.portlet.label.configuration-name" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.description" bundle="${bndlLang}" /></th>
			<th><fmt:message key="ebpp.portlet.label.config-type" bundle="${bndlLang}" /></th>
<%-- 			<th><fmt:message key="ebpp.portlet.label.is-configured" bundle="${bndlLang}" /></th> --%>
			<th><fmt:message key="ebpp.portlet.label.action" bundle="${bndlLang}" /></th>
		</tr>
	</thead>
	<!-- End: table header row -->
	<tbody>
	<!-- Begin: repeated data rows -->
	<c:forEach items="${RulesList}" var="rule">
	<tr>
		<td>${rule.value.configName}</td>
		<td>${rule.value.description}</td>
		<td>${rule.value.configType}</td>
<%-- 		<td>${empty psb.partnerConfiguration[rule.key] ? 'Not Configured' : psb.partnerConfiguration[rule.key].configured}</td> --%>
		<td>
			<c:if test="${rule.value.configType eq 'ATTRIBUTE Based'}">
				<%-- <c:set var="jspResourceId" value="RulesConfigurationAttributeDetails" scope="request"/> --%>
				<portlet:resourceURL var="ruleDetailsUrl" id="RulesDefinitionAttributeDetails">
					<portlet:param name="param_configrationKey" value="${rule.key}"/>
				</portlet:resourceURL>
			</c:if>
			
			<c:if test="${rule.value.configType eq 'TEMPLATE Based'}">
				<%-- <c:set var="jspResourceId" value="RulesConfigurationTemplateDetails" scope="request"/> --%>
				<c:if test="${not empty psb.partnerConfiguration[rule.key]}">
					<portlet:resourceURL var="ruleDetailsUrl" id="RulesDefinitionTemplateDetails">
						<portlet:param name="param_configrationKey" value="${rule.key}"/>
					</portlet:resourceURL>
				</c:if>				
				<c:if test="${empty psb.partnerConfiguration[rule.key]}">
					<portlet:resourceURL var="ruleDetailsUrl" id="RulesDefinitionTemplateDetails">
						<portlet:param name="param_configrationKey" value="${rule.key}"/>
						<portlet:param name="param_configuraitonName" value="${rule.value.configName}"/>
						<portlet:param name="param_operation" value=""/>
					</portlet:resourceURL>
				</c:if>
			</c:if>
		
			<a href="#" title='<fmt:message key="ebpp.portlet.more-details" bundle="${bndlLang}"/>' onclick="doPostUrl('${ruleDetailsUrl}', 1);"  style="display: inline-block;">
				<img border="0" src='/static/images/item_details.png'/>
			</a>
		</td>
	</tr>
	</c:forEach>
	<!-- End: repeated data rows -->
	</tbody>
</table>
</fieldset>