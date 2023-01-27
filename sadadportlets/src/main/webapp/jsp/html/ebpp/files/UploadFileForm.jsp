<%@ page import="com.sadad.portal.common.utils.BillerUploadFileTypes"%>
<%@ page import="com.sadad.portal.common.utils.BankUploadFileTypes"%>
<%@ page import="com.sadad.portal.common.utils.SadadOrganisationType2"%>
<%	pageContext.setAttribute("billerFileTypes", BillerUploadFileTypes.values());
	pageContext.setAttribute("bankFileTypes", BankUploadFileTypes.values());
	pageContext.setAttribute("organisationTypes", SadadOrganisationType2.values()); %>

<jsp:directive.include file="../../common/JspDeclarations.jspf" />

<table style="width: 100%;">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="ebpp.portlet.marked-fields-are-mandatory" bundle="${bndlLang}"/></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="ebpp.portlet.label.files-upload" bundle="${bndlLang}"/></legend>
					<table style="width: 100%;">
						<tbody>
							<tr class="DataEntryFieldRow">
								<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
									<label class="labelCell" for="cmbOrgType">
										<fmt:message key="ebpp.portlet.label.organisation-type" bundle="${bndlLang}"/> *
									</label>
								</td>
								<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
									<select name="param_orgType" class="rqf" id="cmbOrgType" onchange="onChangePartnerType(this.value);" <c:out value="${psb.partnerType != 'sadad' ? 'disabled' : ''}"/>>
										<%-- <option value="">
											<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
										</option> --%>
										<c:forEach items="${organisationTypes}" var="org">
											<option <c:if test="${ psb.partnerType == org.value }">selected</c:if>
												value="${org.value}">${org.name}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr class="DataEntryFieldRow">
								<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
									<label id="lbl4Org" class="labelCell" for="cmbBankId">
										<fmt:message key="ebpp.portlet.label.organisation-name" bundle="${bndlLang}"/> *
									</label>
								</td>
			<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
				<input type="hidden" id="txtPartnerId"/>
				<c:if test="${psb.partnerType == 'biller' or psb.partnerType == 'sadad'}">
					<select name="param_orgId" class="" id="cmbBillerId" style="display: inline;" onchange="partnerKeyChange(this.value);">
						<c:choose>
							<c:when test="${psb.partnerType == 'biller'}">
								<option selected value="<c:out value='${psb.partnerKey}' />">
									<c:out value="${BillerList[psb.partnerKey].partnerName}" />
								</option>
							</c:when>
							<c:otherwise>
								<option value="">
									<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
								</option>
								<c:forEach items="${BillerList}" var="biller">
									<option value="<c:out value="${biller.value.partnerKey}" />">
										<c:out value="${biller.value.partnerName}" />
									</option>
								</c:forEach>
							</c:otherwise>
						</c:choose>							
					</select>
				</c:if>
				<c:if test="${psb.partnerType == 'bank' or psb.partnerType == 'sadad'}">
					<select name="param_orgId" class="" id="cmbBankId" style="display: inline;" onchange="partnerKeyChange(this.value);">
						<c:choose>
							<c:when test="${psb.partnerType == 'bank' }">
								<option selected value="<c:out value='${psb.partnerKey}' />">
									<c:out value="${BankList[psb.partnerKey].partnerName}" />
								</option>
							</c:when>
							<c:otherwise>
								<option value="">
									<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
								</option>
								<c:forEach items="${BankList}" var="bank">
									<option value="<c:out value="${bank.value.partnerKey}" />">
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
			<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
				<label id="lbl4FileType" class="labelCell" for="cmbBankFileType">
					<fmt:message key="ebpp.portlet.label.file-type" bundle="${bndlLang}"/> *
				</label>
			</td>
			<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
				<input type="hidden" id="txtFileType" />
				<c:if test="${psb.partnerType == 'biller' or psb.partnerType == 'sadad'}">
				<select name="param_fileType" class="rqf" id="cmbBillerFileType" style="display: inline;" onchange="fileTypeChange(this.value);">
					<option value="">
						<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
					</option>
					<c:forEach items="${billerFileTypes}" var="type">
						<option value="${type.value}">${type.name}</option>
					</c:forEach>
				</select>
				</c:if>
				<c:if test="${psb.partnerType == 'bank' or psb.partnerType == 'sadad'}">
				<select name="param_fileType" class="" id="cmbBankFileType" style="display: inline;" onchange="fileTypeChange(this.value);">
					<option value="">
						<fmt:message key="ebpp.portlet.label.please-select" bundle="${bndlLang}"/>
					</option>
					<c:forEach items="${bankFileTypes}" var="type">
						<option value="${type.value}">${type.name}</option>
					</c:forEach>
				</select>
				</c:if>
			</td>
		</tr>
		<tr class="DataEntryFieldRow">
			<td class="labelCell" nowrap style="width:200px; vertical-align:top; height: 27;">
				<label class="labelCell" for="txtFiles">
					<fmt:message key="ebpp.portlet.label.file" bundle="${bndlLang}"/> *
				</label>
			</td>
			<td class="outputDataCell" style="width: 100%; " valign="top" nowrap>
				<input type="file" id="txtFiles" name="files[]" accept=".xml, .gz" multiple required onchange="prepareUpload(this);" />
			</td>
		</tr>		
		<tr>
			<td colspan="2" class="outputDataCell" style="width: 100%; text-align: right; vertical-align:top" nowrap>
				<input id="btnUploadAll" class="button" type="button" value="<fmt:message key="ebpp.portlet.button.upload" bundle="${bndlLang}"/>" 
					onclick="makePageBusy();doFileUploadSubmission();makePageUnBusy();">
			</td>
		</tr>
		</tbody>
	</table>
	<br/>
	<table id="filesTable" class="tableclass" style="width:100%">
	    <thead>
		    <tr>
			    <th style="width: 20%;"><fmt:message key="ebpp.portlet.label.file-name" bundle="${bndlLang}"/></th>
			    <th style="width: 10%;"><fmt:message key="ebpp.portlet.label.file-size" bundle="${bndlLang}"/></th>
			    <th style="width: 60%;"><fmt:message key="ebpp.portlet.label.upload-status" bundle="${bndlLang}"/></th>
			    <th style="width: 10%;"><fmt:message key="ebpp.portlet.label.options" bundle="${bndlLang}"/></th>
		    </tr>
	    </thead>
    	<tbody id="tbody2B_append"></tbody>
    </table>    
</fieldset>
</td>
</tr>
</tbody>
</table>