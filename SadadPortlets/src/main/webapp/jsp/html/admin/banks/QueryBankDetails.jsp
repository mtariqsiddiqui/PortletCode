<jsp:directive.include file="../../common/JspDeclarations.jspf" />

<table style="width: 100%">
	<tbody>
		<tr>
			<td class="myCaption">
				<fmt:message key="bank.portlet.label.bank-details" bundle="${bndlLang}" />
			</td>
		</tr>
		<tr>
			<td>
				<table style="width: 100%">
					<!-- Begin: Data display fields -->
					<tbody>
						<tr class="NewsColumnWrapper">
							<td class="NewsColumnCell" width="33%" valign="top">
								<table class="tableclass">
									<tbody>
										<tr>
											<th style="width: 25%"><fmt:message key="bank.portlet.label.bank-id" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.bankId}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="bank.portlet.label.description" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.selectedBank.description}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="bank.portlet.label.status" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.selectedBank.status}</td>
										</tr>
									</tbody>
								</table>
							</td>
							<td class="NewsColumnCell" width="33%" valign="top">
								<table class="tableclass">
									<tbody>
										<tr>
											<th style="width: 25%"><fmt:message key="bank.portlet.label.bank-name" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.selectedBank.bankName}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="bank.portlet.label.sadad-account-number" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.selectedBank.suspenceAccount}</td>
										</tr>										
										<tr>
											<th style="width: 25%"><fmt:message key="bank.portlet.label.sadad-refund-account" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.selectedBank.refundAccount}</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" class="button" value="<fmt:message key="bank.portlet.button.update" bundle="${bndlLang}" />" onclick="doPostUrl('<portlet:resourceURL id="QueryBankUpdateForm"/>', 1);" />
				<fmt:message var="btnStatusLabel" key="bank.portlet.button.deactivate" bundle="${bndlLang}" />
				<c:if test="${psb.selectedBank.status == 'INACTIVE'}">
					<fmt:message var="btnStatusLabel" key="bank.portlet.button.activate" bundle="${bndlLang}" />								
				</c:if>
				<portlet:resourceURL id="QueryBankDetails" var="toggleStatusUrl">
					<portlet:param name="param_operation" value="callActivateOrDeActivateBank"/>
				</portlet:resourceURL>
				<input type="button" class="button" value="${btnStatusLabel}"
					onclick="doPostUrl('${toggleStatusUrl}', 1);" /> 
				<input type="button" class="button" 
					value="<fmt:message key="bank.portlet.button.audit" bundle="${bndlLang}" />" onclick="" />
				<form method="post" action='<portlet:actionURL/>'>
					<input type="hidden" name="fpWhereTo" id="fpWhereTo" value=""/>
					<input type="submit" class="button" onclick="navigate(this);" name="finish" value="<fmt:message key="bank.portlet.button.finish" bundle="${bndlLang}"/>" />
				</form>
			</td>
		</tr>
	</tbody>
</table> 