<%@ page import="com.sadad.portal.common.utils.BillerSendBatchFileTypes"%>
<%@ page import="com.sadad.portal.common.utils.BankSendBatchFileTypes"%>
<%@ page import="com.sadad.portal.common.utils.SadadOrganisationType2"%>
<% pageContext.setAttribute("billerFileTypes", BillerSendBatchFileTypes.values()); %>
<% pageContext.setAttribute("bankFileTypes", BankSendBatchFileTypes.values()); %>
<% pageContext.setAttribute("organisationTypes", SadadOrganisationType2.values()); %>

<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmSendBatchFile" id="frmSendBatchFile" method="post" action="<portlet:resourceURL id="SendBatchFilesSummary" />">
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox">
					<fmt:message key="ow.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" />
				</p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend>
						<fmt:message key="ow.portlet.label.send-batch-files" bundle="${bndlLang}" />
					</legend>
					<table style="width: 100%;">
						<tr>
							<td>
								<table class="dataEntryPageTable" style="width: 100%;">
									<tbody>
										<tr class="DataEntryFieldRow">
											<td class="labelCell" width="200px" valign="top" nowrap height="27">
												<label class="label" for="cmbOrgType">
													<fmt:message key="ow.portlet.label.organisation-type" bundle="${bndlLang}" /> *
												</label>
											</td>
											<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
												<select name="param_orgType" class="outputData" required id="cmbOrgType" onchange="onChangePartnerType(this.value);"
												 <c:out value="${psb.partnerType != 'sadad' ? 'disabled' : ''}" />>
												<c:forEach items="${organisationTypes}" var="org">
													<option <c:if test="${ psb.partnerType == org.value || org.value == psb.orgType }">selected</c:if>
														value="${org.value}">${org.name}</option>
												</c:forEach>
												</select>
											</td>
											</tr>
										<tr class="DataEntryFieldRow">
											<td class="labelCell" width="200px" valign="top" nowrap height="27">
												<label class="label">
													<fmt:message key="ow.portlet.label.organisation-name" bundle="${bndlLang}" /> *</label>
											</td>
											<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
												<input type="hidden" id="txtPartnerId" name="param_orgId"/>
												<c:if test="${psb.partnerType == 'biller' or psb.partnerType == 'sadad'}">
													<select  class="outputData" id="cmbBillerId" style="display: inline;" onchange="partnerKeyChange(this.value);">
														<c:choose>
															<c:when test="${psb.partnerType == 'biller'}">
																<option selected value="<c:out value='${psb.partnerKey}' />">
																	<c:out value="${BillerList[psb.partnerKey].partnerName}" />
																</option>
															</c:when>
															<c:otherwise>
																<c:forEach items="${BillerList}" var="biller">
																	<option value="<c:out value="${biller.value.partnerKey}"/>" <c:if test="${biller.value.partnerKey == psb.orgId}">selected</c:if>>
																		<c:out value="${biller.value.partnerName}" />
																	</option>
																</c:forEach>
															</c:otherwise>
														</c:choose>
													</select>
												</c:if>
												<c:if test="${psb.partnerType == 'bank' or psb.partnerType == 'sadad'}">
													<select  class="outputData" id="cmbBankId" style="display: inline;" onchange="partnerKeyChange(this.value);">
														<c:choose>
															<c:when test="${psb.partnerType == 'bank' }">
																<option selected value="<c:out value='${psb.partnerKey}' />">
																	<c:out value="${BankList[psb.partnerKey].partnerName}" />
																</option>
															</c:when>
															<c:otherwise>
																<c:forEach items="${BankList}" var="bank">
																	<option value="<c:out value="${bank.value.partnerKey}"/>" <c:if test="${bank.value.partnerKey == psb.orgId}">selected</c:if>>
																		<c:out value="${bank.value.partnerName}" />
																	</option>
																</c:forEach>
															</c:otherwise>
														</c:choose>
													</select>
												</c:if>
												<button id="callSrchEngnBtn" type="button" onclick="#">
													<img src="/static/images/search.png" height="12px" width="12px">
												</button>
											</td>
										</tr>
										<tr class="DataEntryFieldRow">
											<td class="labelCell" width="200px" valign="top" nowrap height="27">
												<label class="label">
													<fmt:message key="ow.portlet.label.file-type" bundle="${bndlLang}" /> *
												</label>
											</td>
											<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
												<input type="hidden" id="txtFileType" name="param_fileType"/>
												<c:if test="${psb.partnerType == 'biller' or psb.partnerType == 'sadad'}">
													<select class="outputData" id="cmbBillerFileType" style="display: inline;" onchange="fileTypeChange(this.value);">
														<option value="">
															<fmt:message key="ow.portlet.label.please-select" bundle="${bndlLang}" />
														</option>
														<c:forEach items="${billerFileTypes}" var="type">
															<option value="${type.value}" <c:if test="${type.value == psb.fileType }">selected</c:if>>
																${type.name}
															</option>
														</c:forEach>
													</select>
												</c:if>
												<c:if test="${psb.partnerType == 'bank' or psb.partnerType == 'sadad'}">
													<select class="outputData" id="cmbBankFileType" style="display: inline;" onchange="fileTypeChange(this.value);">
														<option value="">
															<fmt:message key="ow.portlet.label.please-select" bundle="${bndlLang}" />
														</option>
														<c:forEach items="${bankFileTypes}" var="type">
															<option value="${type.value}" <c:if test="${type.value == psb.fileType }">selected</c:if>>
																${type.name}
															</option>
														</c:forEach>
													</select>
												</c:if>
											</td>
										</tr>
										<tr class="DataEntryFieldRow">
											<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
												<label class="label" for="txtRangeFromDate">
													<fmt:message key="ow.portlet.label.date-range" bundle="${bndlLang}" /> *
												</label>
											</td>
											<td class="outputDataCell" width="100%" valign="top" nowrap>
												<label class="label" for="txtRangeFromDate"><fmt:message key="ow.portlet.label.from" bundle="${bndlLang}" />
													<input class="outputData readonly" value="${psb.dateRangeFrom}" id="txtRangeFromDate" 
														autocomplete="off" maxlength="10" type="text" required placeholder="YYYY-MM-DD" />
												</label>
												<label class="label" for="txtRangeToDate"><fmt:message key="ow.portlet.label.to" bundle="${bndlLang}" />
													<input class="outputData readonly" value="${psb.dateRangeTo}" id="txtRangeToDate" 
														autocomplete="off" maxlength="10" type="text" required placeholder="YYYY-MM-DD" />
												</label>
											</td>
											</tr>										
										<tr class="DataEntryFieldRow">
											<td class="labelCell" width="200px" valign="top" nowrap height="27">
												<label class="label" for="txtRquid">
													<fmt:message key="ow.portlet.label.asynchronous-rquid" bundle="${bndlLang}" />
												</label>
											</td>
											<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
												<input name="param_asyncRquid" class="outputData" value="${psb.asyncRquid}" id="txtAsyncRquid" type="text" autocomplete="off" maxlength="50" />
											</td>
										</tr>
										<tr class="DataEntryFieldRow">
											<td class="labelCell" width="200px" valign="top" nowrap height="27">
												<label class="label" for="txtFileName">
													<fmt:message key="ow.portlet.label.file-name" bundle="${bndlLang}" />
												</label>
											</td>
											<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
												<input name="param_fileName" class="outputData" value="${psb.fileName}" id="txtFileName" type="text" autocomplete="off" maxlength="40" />
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<input type="hidden" name="param_fileStatus" value="PROCESSED,GENERATED,SENDING,SENT,FAILED_TO_SEND" />
								<input type="hidden" id="txtDateRangeFrom" name="param_dateRangeFrom" />
								<input type="hidden" id="txtDateRangeTo" name="param_dateRangeTo" />
								<input type="hidden" name="param_operation" value="callSearchFilesAdvanced" />
								<input class='button' value='<fmt:message key="ow.portlet.button.search" bundle="${bndlLang}"/>' onclick="setDatesForSubmission(doQueryFormSubmission);" type="submit"/>
								<portlet:resourceURL id="SendBatchFilesQueryForm" var="clearURL"><portlet:param name="param_operation" value="clearSessionBeanObject"/></portlet:resourceURL>
								<input class='button' value='<fmt:message key="ow.portlet.button.clear" bundle="${bndlLang}"/>' onclick="doQueryFormReset('${clearURL}');" type="button"/>
							</td>
						</tr>
					</table>
				</fieldset>
			</td>
		</tr>
	</tbody>
</table>
</form>