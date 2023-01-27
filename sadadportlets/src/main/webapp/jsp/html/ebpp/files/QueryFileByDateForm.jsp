<%@ page import="com.sadad.portal.common.utils.DateRange2"%>
<%@ page import="com.sadad.portal.common.utils.QueryFileStatus"%>
<%@ page import="com.sadad.portal.common.utils.BankQueryFileTypes"%>
<%@ page import="com.sadad.portal.common.utils.BillerQueryFileTypes"%>
<%@ page import="com.sadad.portal.common.utils.SadadOrganisationType2"%>
<%	pageContext.setAttribute("dateRange", DateRange2.values());
	pageContext.setAttribute("fileStatus", QueryFileStatus.values());
	pageContext.setAttribute("bankFileTypes", BankQueryFileTypes.values());
	pageContext.setAttribute("billerFileTypes", BillerQueryFileTypes.values());
	pageContext.setAttribute("organisationTypes", SadadOrganisationType2.values());
%>
<jsp:directive.include file="../../common/JspDeclarations.jspf" />

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
						<fmt:message key="ebpp.portlet.label.search-by-date" bundle="${bndlLang}" />
					</legend>
					<form name="frmQueryFileByDate" id="frmQueryFileByDate" method="post" action='<portlet:resourceURL id="core_FileSummary"/>'>
						<table style="width: 100%">
							<tbody>
								<tr>
									<td>
										<table class="dataEntryPageTable" style="border: 0; width: 100%; padding: 0;">
											<tbody>

												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label class="label" for="cmbOrgType">
															<fmt:message key="ebpp.portlet.label.organisation-type" bundle="${bndlLang}" /> *
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<select name="param_orgType" class="rqf" id="cmbOrgType" onchange="onChangePartnerType(this.value);"
														 <c:out value="${psb.partnerType != 'sadad' ? 'disabled' : ''}" />>
														<c:forEach items="${organisationTypes}" var="org">
															<option <c:if test="${ psb.partnerType == org.value || org.value == psb.orgType }">selected</c:if>
																value="${org.value}">${org.name}</option>
														</c:forEach>
														</select>
													</td>
												</tr>

												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label id="lbl4Org" class="label" for="cmbBillerId">
															<fmt:message key="ebpp.portlet.label.organisation-name" bundle="${bndlLang}" /> *</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<input type="hidden" id="txtPartnerId" name="param_orgId"/>
														<c:if test="${psb.partnerType == 'biller' or psb.partnerType == 'sadad'}">
															<select class="" id="cmbBillerId" style="display: inline;"
															 onchange="partnerKeyChange(this.value);">
																<c:choose>
																	<c:when test="${psb.partnerType == 'biller'}">
																		<option selected value="<c:out value='${psb.partnerKey}' />">
																			<c:out value="${BillerList[psb.partnerKey].partnerName}" />
																		</option>
																	</c:when>
																	<c:otherwise>
																		<option value="">
																			<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}" />
																		</option>
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
															<select class="" id="cmbBankId" style="display: inline;" onchange="partnerKeyChange(this.value);">
																<c:choose>
																	<c:when test="${psb.partnerType == 'bank' }">
																		<option selected value="<c:out value='${psb.partnerKey}' />">
																			<c:out value="${BankList[psb.partnerKey].partnerName}" />
																		</option>
																	</c:when>
																	<c:otherwise>
																		<option value="">
																			<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}" />
																		</option>
																		<c:forEach items="${BankList}" var="bank">
																			<option value="<c:out value="${bank.value.partnerKey}"/>" <c:if test="${bank.value.partnerKey == psb.orgId}">selected</c:if>>
																			<c:out value="${bank.value.partnerName}" />
																			</option>
																		</c:forEach>
																	</c:otherwise>
																</c:choose>
															</select>
														</c:if>
														<c:if test="${psb.partnerType == 'sadad'}">
															<button id="callSrchEngnBtn" type="button" onclick="#">
																<img src="/static/images/search.png" height="12px" width="12px">
															</button>
														</c:if>													
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label id="lbl4FileType" class="label" for="cmbBillerFileType">
															<fmt:message key="ebpp.portlet.label.file-type" bundle="${bndlLang}" /> *
														</label>
													</td>
													<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
														<input type="hidden" id="txtFileType" name="param_fileType"/>
														<c:if test="${psb.partnerType == 'biller' or psb.partnerType == 'sadad'}">
															<select class="outputData" id="cmbBillerFileType" style="display: inline;"
															 onchange="fileTypeChange(this.value);">
																<option value="">
																	<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}" />
																</option>
																<c:forEach items="${billerFileTypes}" var="type">
																	<option value="${type.value}" <c:if test="${type.value == psb.fileType }">selected</c:if>>
																		${type.name}
																	</option>
																</c:forEach>
															</select>
														</c:if>
														<c:if test="${psb.partnerType == 'bank' or psb.partnerType == 'sadad'}">
															<select class="outputData" id="cmbBankFileType" style="display: inline;"
															 onchange="fileTypeChange(this.value);">
																<option value="">
																	<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}" />
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
														<label class="label" for="txtArrivalFromDate">
															<fmt:message key="ebpp.portlet.label.arrival-date" bundle="${bndlLang}" /> *
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input class="rqf" value="${psb.arrivalDateFrom}" name="param_arrivalDateFrom" id="txtArrivalFromDate"
														 autocomplete="off" maxlength="10" type="text" readonly placeholder="YYYY-MM-DD" />
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell"style="width: 200px;" valign="top" nowrap height="27"></td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<select class="rqf" id="cmbArrivalDateRange" name="param_arrivalDateRange">
															<%-- <option selected value="1"><fmt:message key="ebpp.portlet.label.exact" bundle="${bndlLang}" /></option> --%>
															<c:forEach items="${dateRange}" var="range">
																<option value="${range.value}">${range.name}</option>
															</c:forEach>
														</select>
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;">
														<label class="label" for="ProcessingDateRange_StartDt_field">
															<fmt:message key="ebpp.portlet.label.processing-date" bundle="${bndlLang}" />
														</label>
													</td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<input class="outputData" value="${psb.processDateFrom}" name="param_processDateFrom" id="txtProcessFromDate"
														 autocomplete="off" maxlength="10" type="text" readonly placeholder="YYYY-MM-DD" />
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" valign="top" nowrap height="27" style="width: 200px;"></td>
													<td class="outputDataCell" width="100%" valign="top" nowrap>
														<select class="outputData" id="cmbProcessDateRange" name="param_processDateRange">
															<%-- <option selected value="1"><fmt:message key="ebpp.portlet.label.exact" bundle="${bndlLang}" /></option> --%>
															<c:forEach items="${dateRange}" var="range">
																<option value="${range.value}">${range.name}</option>
															</c:forEach>
														</select>
													</td>
												</tr>
												<tr class="DataEntryFieldRow">
													<td class="labelCell" width="200px" valign="top" nowrap height="27">
														<label class="label" for="cmbFileStatus">
															<fmt:message key="ebpp.portlet.label.file-status" bundle="${bndlLang}" /> *
														</label>
													</td>
													<td class="outputDataCell" valign="top" nowrap style="width: 100%;">
														<select name="param_fileStatus" class="rqf" id="cmbFileStatus">
															<c:forEach items="${fileStatus}" var="fs">
																<option value="${fs.value}">${fs.name}</option>
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
										<input type="hidden" name="param_rquid"/> 
										<input type="hidden" name="param_operation" value="callSearchFilesAdvanced" />
										<input class='button' value='<fmt:message key="ebpp.portlet.button.search" bundle="${bndlLang}"/>' onclick='submitFileSearchByDate(doQueryFormSubmission);' type='submit' />
										<portlet:resourceURL id="QueryFileByDateForm" var="clearURL"><portlet:param name="param_operation" value="clearSessionBeanObject"/></portlet:resourceURL>
										<input class='button' value='<fmt:message key="ebpp.portlet.button.clear" bundle="${bndlLang}"/>' onclick="doQueryFormReset('${clearURL}');" type='button' />
										&nbsp;&nbsp;
										<div style="display: inline;">
											<a href="#" onclick="switchQueryForms('<portlet:resourceURL id="QueryFileForm" />', 1);">
											<fmt:message key="ebpp.portlet.label.search-by-rquid" bundle="${bndlLang}" />
											</a>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</fieldset>
			</td>
		</tr>
	</tbody>
</table>