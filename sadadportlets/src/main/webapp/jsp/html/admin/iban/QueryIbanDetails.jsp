<jsp:directive.include file="../../common/JspDeclarations.jspf" />

<table style="width: 100%">
	<tbody>
		<tr>
			<td class="myCaption">
				<fmt:message key="iban.portlet.label.iban-details" bundle="${bndlLang}" />
			</td>
		</tr>
		<tr>
			<td>
				<!-- Display only when BOTH CURRENT and PENDING RECORDS are present -->
				<c:if test="${!empty psb.ibans[psb.ibanKey].currentRecord && !empty psb.ibans[psb.ibanKey].pendingRecord}">
				<table class="tableclass">
					<tbody>
					<tr>
						<th style="width: 20%"></th>
						<th style="width: 40%"><fmt:message key="iban.portlet.label.existing-record" bundle="${bndlLang}" /></th>
						<th style="width: 40%"><fmt:message key="iban.portlet.label.pending-approval-record" bundle="${bndlLang}" /></th>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.biller-id" bundle="${bndlLang}" /></th>
						<td>${psb.billerId}</td>
						<td>${psb.billerId}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.biller-name" bundle="${bndlLang}" /></th>
						<td>${BillerList[psb.billerId].partnerName}</td>
						<td>${BillerList[psb.billerId].partnerName}</td>		
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.iban" bundle="${bndlLang}" /></th>
						<td <c:if test="${psb.ibans[psb.ibanKey].currentRecord.iban ne psb.ibans[psb.ibanKey].pendingRecord.iban}">style="color:#003300;background-color:#ccffb3;"</c:if>>${psb.ibans[psb.ibanKey].currentRecord.iban}</td>
						<td <c:if test="${psb.ibans[psb.ibanKey].currentRecord.iban ne psb.ibans[psb.ibanKey].pendingRecord.iban}">style="color:#660000;background-color:#ffb3b3;"</c:if>>${psb.ibans[psb.ibanKey].pendingRecord.iban}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.settlement-id" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].currentRecord.settlementId}</td>
						<td>${psb.ibans[psb.ibanKey].pendingRecord.settlementId}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.customer-id" bundle="${bndlLang}" /></th>
						<td <c:if test="${(psb.ibans[psb.ibanKey].currentRecord.customerIdType ne psb.ibans[psb.ibanKey].pendingRecord.customerIdType) || (psb.ibans[psb.ibanKey].currentRecord.customerId ne psb.ibans[psb.ibanKey].pendingRecord.customerId)}">style="color:#003300;background-color:#ccffb3;"</c:if>>${psb.ibans[psb.ibanKey].currentRecord.customerIdType}_${psb.ibans[psb.ibanKey].currentRecord.customerId}</td>
						<td <c:if test="${(psb.ibans[psb.ibanKey].currentRecord.customerIdType ne psb.ibans[psb.ibanKey].pendingRecord.customerIdType) || (psb.ibans[psb.ibanKey].currentRecord.customerId ne psb.ibans[psb.ibanKey].pendingRecord.customerId)}">style="color:#660000;background-color:#ffb3b3;"</c:if>>${psb.ibans[psb.ibanKey].pendingRecord.customerIdType}_${psb.ibans[psb.ibanKey].pendingRecord.customerId}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.status" bundle="${bndlLang}" /></th>
						<td <c:if test="${psb.ibans[psb.ibanKey].currentRecord.status ne psb.ibans[psb.ibanKey].pendingRecord.status}">style="color:#003300;background-color:#ccffb3;"</c:if>>${psb.ibans[psb.ibanKey].currentRecord.status}</td>
						<td <c:if test="${psb.ibans[psb.ibanKey].currentRecord.status ne psb.ibans[psb.ibanKey].pendingRecord.status}">style="color:#660000;background-color:#ffb3b3;"</c:if>>${psb.ibans[psb.ibanKey].pendingRecord.status}</td>
					</tr>
					<tr>
						<th><fmt:message key="iban.portlet.label.create-date" bundle="${bndlLang}" /></th>
						<td>${psb.ibans[psb.ibanKey].currentRecord.createDate}</td>
						<td>${psb.ibans[psb.ibanKey].pendingRecord.createDate}</td>
					</tr>
					</tbody>
				</table>
				</c:if>
				<!-- Display only when CURRENT RECORD is present -->			
				<c:if test="${empty psb.ibans[psb.ibanKey].pendingRecord}">
				<table style="width: 100%">
					<tbody>
						<tr class="NewsColumnWrapper">
							<td class="NewsColumnCell" width="33%" valign="top">
								<table class="tableclass">
									<tbody>
										<tr>
											<th style="width: 25%"><fmt:message key="iban.portlet.label.biller-id" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.billerId}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="iban.portlet.label.iban" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.ibans[psb.ibanKey].currentRecord.iban}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="iban.portlet.label.status" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.ibans[psb.ibanKey].currentRecord.status}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="iban.portlet.label.create-date" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.ibans[psb.ibanKey].currentRecord.createDate}</td>
										</tr>									</tbody>
								</table>
							</td>
							<td class="NewsColumnCell" width="33%" valign="top">
								<table class="tableclass">
									<tbody>
										<tr>
											<th style="width: 25%"><fmt:message key="iban.portlet.label.biller-name" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${BillerList[psb.billerId].partnerName}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="iban.portlet.label.settlement-id" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.ibans[psb.ibanKey].currentRecord.settlementId}</td>
										</tr>										
										<tr>
											<th style="width: 25%"><fmt:message key="iban.portlet.label.customer-id" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.ibans[psb.ibanKey].currentRecord.customerIdType}_${psb.ibans[psb.ibanKey].currentRecord.customerId}</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
				</c:if>
				<!-- Display only when PENDING RECORD is present -->
				<c:if test="${empty psb.ibans[psb.ibanKey].currentRecord}">
				<table style="width: 100%">
					<!-- Begin: Data display fields -->
					<tbody>
						<tr class="NewsColumnWrapper">
							<td class="NewsColumnCell" width="33%" valign="top">
								<table class="tableclass">
									<tbody>
										<tr>
											<th style="width: 25%"><fmt:message key="iban.portlet.label.biller-id" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.billerId}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="iban.portlet.label.iban" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.ibans[psb.ibanKey].pendingRecord.iban}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="iban.portlet.label.status" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.ibans[psb.ibanKey].pendingRecord.status}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="iban.portlet.label.create-date" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.ibans[psb.ibanKey].pendingRecord.createDate}</td>
										</tr>									</tbody>
								</table>
							</td>
							<td class="NewsColumnCell" width="33%" valign="top">
								<table class="tableclass">
									<tbody>
										<tr>
											<th style="width: 25%"><fmt:message key="iban.portlet.label.biller-name" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${BillerList[psb.billerId].partnerName}</td>
										</tr>
										<tr>
											<th style="width: 25%"><fmt:message key="iban.portlet.label.settlement-id" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.ibans[psb.ibanKey].pendingRecord.settlementId}</td>
										</tr>										
										<tr>
											<th style="width: 25%"><fmt:message key="iban.portlet.label.customer-id" bundle="${bndlLang}" /></th>
											<td style="width: 25%">${psb.ibans[psb.ibanKey].pendingRecord.customerIdType}_${psb.ibans[psb.ibanKey].pendingRecord.customerId}</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
				</c:if>
			</td>
		
		</tr>
		<tr>
			<td>
			<c:if test="${psb.ibans[psb.ibanKey].processIbanAllowed && psb.isIbanMaker()}">
				<input type="button" class="button" value='<fmt:message key="iban.portlet.button.update" bundle="${bndlLang}" />'
					onclick="doPostUrl('<portlet:resourceURL id="QueryIbanUpdateForm"/>', 1);" />
				<portlet:resourceURL id="QueryIbanDetails" var="toggleStatusUrl">
					<portlet:param name="param_action" value="DEACTIVATE"/>
					<portlet:param name="param_settlementId" value="${psb.ibans[psb.ibanKey].currentRecord.settlementId}"/>
					<portlet:param name="param_operation" value="callProcessIban"/>
				</portlet:resourceURL>
				<input type="button" class="button" value='<fmt:message key="iban.portlet.button.deactivate" bundle="${bndlLang}" />'
					onclick="doPostUrl('${toggleStatusUrl}', 1);" /> 					
			</c:if>
				<form method="post" action='<portlet:actionURL/>'>
					<input type="hidden" name="fpWhereTo" id="fpWhereTo" value=""/>
					<input type="submit" class="button" onclick="navigate(this);" name="back" value="<fmt:message key="iban.portlet.button.back" bundle="${bndlLang}"/>"/>
					<input type="submit" class="button" onclick="navigate(this);" name="finish" value="<fmt:message key="iban.portlet.button.finish" bundle="${bndlLang}"/>" />
				</form>
			</td>
		</tr>
	</tbody>
</table>