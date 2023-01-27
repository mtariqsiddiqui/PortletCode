<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<jsp:directive.include file="../../common/JspIncludeStaticFiles.jspf" />

<form name="frmSadadConfig" id="frmSadadConfig" method="post" action="${sadadConfigActionURL}">
	<table>
		<tr>
			<td><fmt:message key="sadad-config.portlet.label.refresh.bank-list" bundle="${bndlLang}"/></td>
			<td style="width : 30px;"></td>
			<td><input type="button" onclick='doPostUrl("<portlet:resourceURL id="BankList"/>", 1);' value="<fmt:message key="sadad-config.portlet.label.refresh-data" bundle="${bndlLang}"/>"/></td>
		</tr>
		<tr>
			<td><fmt:message key="sadad-config.portlet.label.refresh.biller-list" bundle="${bndlLang}"/></td>
			<td></td>
			<td><input type="button" onclick='doPostUrl("<portlet:resourceURL id="BillerList"/>", 1);' value="<fmt:message key="sadad-config.portlet.label.refresh-data" bundle="${bndlLang}"/>"/></td>
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
	</table>
</form>
<div class="modal64" id="ajaxLoader"></div>