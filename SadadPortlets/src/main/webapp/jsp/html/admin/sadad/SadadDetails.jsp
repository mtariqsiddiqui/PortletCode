<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<span class="${psb.messageToDisplay.messageType}_Message">${psb.messageToDisplay.displayMessage}</span>
<!-- Main Table -->
<table style="width: 100%">
	<tbody>
		<!--  Details container -->
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
											<th style="width: 25%"><fmt:message key="sadad-admin.portlet.label.sadad-id" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.sadadId}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="sadad-admin.portlet.label.sadad-name" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.sadadName}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="sadad-admin.portlet.label.description" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.sadadDescription}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="sadad-admin.portlet.label.sadad-current-account-number" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.sadadCurrentAccount}</td>
										</tr>
										
										<!-- End: Data display fields -->
									</tbody>
								</table>
							</td>
							<td class="NewsColumnCell" width="33%" valign="top">
								<table class="tableclass">
									<tbody>
										<tr>
											<th style="width: 25%"><fmt:message key="sadad-admin.portlet.label.account-bank-id" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.accountBankId}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="sadad-admin.portlet.label.account-bank-name" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.accountBankName}</td>

										</tr>

										<tr>
											<th style="width: 25%"><fmt:message key="sadad-admin.portlet.label.refund-max-limit" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.refundMaxLimit}</td>
										</tr>
										<!-- End: Data display fields -->
									</tbody>
								</table>
							</td>
						</tr>
						<!-- End: Data display fields -->
						<!-- End: PageContentsContainer -->
					</tbody>
				</table>
			</td>
		</tr>
		<!-- Buttons Group -->
		<tr>
			<td>
				<input type="button" class="button" value="<fmt:message key="sadad-admin.portlet.button.update" bundle="${bndlLang}" />" onclick="doPostUrl('<portlet:resourceURL id="SadadUpdateForm"/>', 1);" />
				<input type="button" class="button" value="<fmt:message key="sadad-admin.portlet.button.audit" bundle="${bndlLang}" />" onclick="" /> 
			</td>
		</tr>
	</tbody>
</table>
