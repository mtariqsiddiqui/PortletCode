<%@ page import="com.sadad.portal.common.utils.SadadOrganisationType5"%>
<% pageContext.setAttribute("organisationTypes", SadadOrganisationType5.values()); %>
<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmQueryRulesDefinition" id="frmQueryRulesDefinition" method="post" action="<portlet:resourceURL id="RulesDefinitionSummary" />">
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox">
					<fmt:message key="ebpp.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" />
				</p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend>
						<fmt:message key="ebpp.portlet.label.query-configurations" bundle="${bndlLang}" />
					</legend>
					<table style="width: 100%;">
						<tr>
							<td>
								<table class="dataEntryPageTable" style="width: 100%;">
									<tbody>
										<tr class="DataEntryFieldRow">
											<td class="labelCell" width="200px" valign="top" nowrap height="27">
												<label class="label" for="cmbOrgType">
													<fmt:message key="ebpp.portlet.label.organisation-type" bundle="${bndlLang}" /> *
												</label>
											</td>
											<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
												<select class="rqf" name="param_organisationType" id="cmbOrgType" onchange="onChangePartnerType(this.value);">
												<c:forEach items="${organisationTypes}" var="org">
													<option <c:if test="${psb.organisationType == org.value}">selected</c:if> value="${org.value}">${org.name}</option>
												</c:forEach>
												</select>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<input type="hidden" name="param_configuraitonName" value="" />
								<input type="hidden" name="param_operation" value="" />
								<input class='button' value='<fmt:message key="ebpp.portlet.button.search" bundle="${bndlLang}"/>' onclick="doQueryFormSubmission('frmQueryRulesDefinition');" type="submit"/>
								<portlet:resourceURL id="RulesDefinitionForm" var="clearURL"><portlet:param name="param_operation" value="clearSessionBeanObject"/></portlet:resourceURL>
								<input class='button' value='<fmt:message key="ebpp.portlet.button.reset" bundle="${bndlLang}"/>' onclick="doQueryFormReset('${clearURL}');" type="button"/>
							</td>
						</tr>
					</table>
				</fieldset>
			</td>
		</tr>
	</tbody>
</table>
</form>