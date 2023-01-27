<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<jsp:directive.include file="../../common/JspIncludeStaticFiles.jspf" />

<form name="frmSadadConfig" id="frmSadadConfig" method="post" action="${sadadConfigActionURL}">
	<table>
		<tr>
			<td><fmt:message key="sadad-config.portlet.label.refresh.all-partners-list" bundle="${bndlLang}"/></td>
			<td style="width : 30px;"></td>
			<td><input type="button" onclick='doPostUrl("<portlet:resourceURL id="${PortalConstant.REFRESH_PARTNER_CACHE}"/>", 1);' value="<fmt:message key="sadad-config.portlet.label.refresh-data" bundle="${bndlLang}"/>"/></td>
		</tr>
		<tr>
			<td><fmt:message key="sadad-config.portlet.label.refresh.district-code-list" bundle="${bndlLang}"/></td>
			<td></td>
			<td><input type="button" onclick='doPostUrl("<portlet:resourceURL id="DistrictList"/>", 1);' value="<fmt:message key="sadad-config.portlet.label.refresh-data" bundle="${bndlLang}"/>"/></td>
		</tr>
		<tr>
			<td><fmt:message key="sadad-config.portlet.label.refresh.accessh-channel-list" bundle="${bndlLang}"/></td>
			<td></td>
			<td><input type="button" onclick='doPostUrl("<portlet:resourceURL id="AccessChannelList"/>", 1);' value="<fmt:message key="sadad-config.portlet.label.refresh-data" bundle="${bndlLang}"/>"/></td>
		</tr>
		<tr>
			<td><fmt:message key="sadad-config.portlet.label.refresh.account-type-list" bundle="${bndlLang}"/></td>
			<td></td>
			<td><input type="button" onclick='doPostUrl("<portlet:resourceURL id="AccountTypeList"/>", 1);' value="<fmt:message key="sadad-config.portlet.label.refresh-data" bundle="${bndlLang}"/>"/></td>
		</tr>		
		<tr>
			<td><fmt:message key="sadad-config.portlet.label.refresh.bank-business-rules" bundle="${bndlLang}"/></td>
			<td></td>
			<td><input type="button" onclick='doPostUrl("<portlet:resourceURL id="BankRulesList"/>", 1);' value="<fmt:message key="sadad-config.portlet.label.refresh-data" bundle="${bndlLang}"/>"/></td>
		</tr>		
		<tr>
			<td><fmt:message key="sadad-config.portlet.label.refresh.biller-business-rules" bundle="${bndlLang}"/></td>
			<td></td>
			<td><input type="button" onclick='doPostUrl("<portlet:resourceURL id="BillerRulesList"/>", 1);' value="<fmt:message key="sadad-config.portlet.label.refresh-data" bundle="${bndlLang}"/>"/></td>
		</tr>		
		<tr>
			<td><fmt:message key="sadad-config.portlet.label.refresh.sadad-business-rules" bundle="${bndlLang}"/></td>
			<td></td>
			<td><input type="button" onclick='doPostUrl("<portlet:resourceURL id="SadadRulesList"/>", 1);' value="<fmt:message key="sadad-config.portlet.label.refresh-data" bundle="${bndlLang}"/>"/></td>
		</tr>			
	</table>
</form>
<div class="modal64" id="ajaxLoader"></div>