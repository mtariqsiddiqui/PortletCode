<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
   <tbody>
	  <tr>
		 <td class="myCaption"><fmt:message key="ebpp.portlet.label.file-details" bundle="${bndlLang}"/></td>
	  </tr>
	  <tr>
		 <td>
			<table style="width: 100%">
			   <!--Begin: Data display fields-->
			   <tbody>
				  <tr  class="NewsColumnWrapper">
					 <td  class="NewsColumnCell" style="width: 33%;" valign="top">
						<!--Begin: Data display fields-->
						<table class="tableclass">
						   <tbody>
							  <tr >
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.organisation-name" bundle="${bndlLang}"/></th>
								 <td style="width: 25%">
									<c:if test="${psb.orgType == 'biller'}">
										${BillerList[psb.files[psb.fileKey].partnerKey].partnerName}
									</c:if>
									<c:if test="${psb.orgType == 'bank'}">
										${BankList[psb.files[psb.fileKey].partnerKey].partnerName}
									</c:if>								 </td>
							  </tr>
							  <tr >
								 <th style="width: 25%">File Category</th>
								 <td style="width: 25%">${psb.files[psb.fileKey].fileType}</td>
							  </tr>
							  <!--End: Data display fields-->
						   </tbody>
						</table>
					 </td>
					 <td  class="NewsColumnCell" style="width: 33%;" valign="top">
						<!--Begin: Data display fields-->
						<table class="tableclass">
						   <tbody>
							  <tr >
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.organisation-type" bundle="${bndlLang}"/></th>
								 <td style="width: 25%; text-transform: capitalize;">${psb.orgType}</td>
							  </tr>
							  <!--End: Data display fields-->
						   </tbody>
						</table>
					 </td>
				  </tr>
				  <tr >
					 <td colspan="4" height="25"><fmt:message key="ebpp.portlet.label.request-details" bundle="${bndlLang}"/></td>
				  </tr>
				  <tr  class="NewsColumnWrapper">
					 <td  class="NewsColumnCell" style="width: 33%;" valign="top">
						<!--Begin: Data display fields-->
						<table class="tableclass">
						   <tbody>
							  <tr >
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.rquid" bundle="${bndlLang}"/></th>
								 <td style="width: 25%">
								 	<a href="#" onclick="fileDownload('${psb.files[psb.fileKey].fileDownloadUrl}');">${psb.files[psb.fileKey].rquid}</a>
								 </td>
							  </tr>
							  <tr >
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.file-name" bundle="${bndlLang}"/></th>
								 <td style="width: 25%">${psb.fileKey}</td>
							  </tr>
							  <tr >
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.arrival-date" bundle="${bndlLang}"/></th>
								 <td style="width: 25%">${psb.files[psb.fileKey].fileCreationDate}</td>
							  </tr>
							  <!--End: Data display fields-->
						   </tbody>
						</table>
					 </td>
					 <td  class="NewsColumnCell" style="width: 33%;" valign="top">
						<!--Begin: Data display fields-->
						<table class="tableclass">
						   <tbody>
							  <tr >
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.file-status" bundle="${bndlLang}"/></th>
								 <td style="width: 25%">${psb.files[psb.fileKey].status}</td>
							  </tr>
							  <tr >
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.file-size" bundle="${bndlLang}"/></th>
								 <td style="width: 25%">${psb.files[psb.fileKey].fileSize}</td>
							  </tr>
							  <tr >
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.processed-date" bundle="${bndlLang}"/></th>
								 <td style="width: 25%">${psb.files[psb.fileKey].fileProcessingDate}</td>
							  </tr>
							  <!--End: Data display fields-->
						   </tbody>
						</table>
					 </td>
				  </tr>
				  <tr >
					 <td colspan="4" height="25"><fmt:message key="ebpp.portlet.label.response-details" bundle="${bndlLang}"/></td>
				  </tr>
				  <tr  class="NewsColumnWrapper">
					 <td  class="NewsColumnCell" style="width: 33%;" valign="top">
						<!--Begin: Data display fields-->
						<table class="tableclass">
						   <tbody>
							  <tr >
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.rquid" bundle="${bndlLang}"/></th>
								 <td style="width: 25%">
									<span id="response_rquid"></span>
								 </td>
							  </tr>
							  <tr >
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.file-name" bundle="${bndlLang}"/></th>
								 <td style="width: 25%">
								 	<span id="response_fileName"></span>
								 </td>
							  </tr>
							  <tr>
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.arrival-date" bundle="${bndlLang}"/></th>
								 <td style="width: 25%">
								 	<span id="response_fileArrivalDate"></span>
								 </td>
							  </tr>
							  <!--End: Data display fields-->
						   </tbody>
						</table>
					 </td>
					 <td  class="NewsColumnCell" style="width: 33%;" valign="top">
						<!--Begin: Data display fields-->
						<table class="tableclass">
						   <tbody>
							  <tr >
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.file-status" bundle="${bndlLang}"/></th>
								 <td style="width: 25%">
								 	<span id="response_fileStatus"></span>
								 </td>
							  </tr>
							  <tr >
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.file-size" bundle="${bndlLang}"/></th>
								 <td style="width: 25%">
								 	<span id="response_fileSize"></span>
								 </td>
							  </tr>
							  <tr >
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.processed-date" bundle="${bndlLang}"/></th>
								 <td style="width: 25%">
								 	<span id="response_fileProcessedDate"></span>
								 </td>
							  </tr>
							  <!--End: Data display fields-->
						   </tbody>
						</table>
					 </td>
				  </tr>
				  <tr >
					 <td colspan="4" height="25"><fmt:message key="ebpp.portlet.label.processing-details" bundle="${bndlLang}"/></td>
				  </tr>
				  <tr  class="NewsColumnWrapper">
					 <td  class="NewsColumnCell" style="width: 33%;" valign="top">
						<!--Begin: Data display fields-->
						<table class="tableclass">
						   <tbody>
							  <tr >
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.no-of-records" bundle="${bndlLang}"/></th>
								 <td style="width: 25%">${psb.files[psb.fileKey].successCount + psb.files[psb.fileKey].failureCount}</td>
							  </tr>
							  <tr >
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.no-of-rejected-records" bundle="${bndlLang}"/></th>
								 <td style="width: 25%">${psb.files[psb.fileKey].failureCount}</td>
							  </tr>
							  <!--End: Data display fields-->
						   </tbody>
						</table>
					 </td>
					 <td  class="NewsColumnCell" style="width: 33%;" valign="top">
						<!--Begin: Data display fields-->
						<table class="tableclass">
						   <tbody>
							  <tr >
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.no-of-accepted-records" bundle="${bndlLang}"/></th>
								 <td style="width: 25%">${psb.files[psb.fileKey].successCount}</td>
							  </tr>
							  <tr >
								 <th style="width: 25%"><fmt:message key="ebpp.portlet.label.no-of-pending-records" bundle="${bndlLang}"/></th>
								 <td style="width: 25%">0</td>
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
	  		<input type="button" class="button" value='<fmt:message key="ebpp.portlet.button.associated-files" bundle="${bndlLang}"/>' onclick="doPostUrl('<portlet:resourceURL id="core_FileAssociatedSummary"/>', 2);" />
	  		<input type="button" class="button" value='<fmt:message key="ebpp.portlet.button.download" bundle="${bndlLang}"/>' onclick="fileDownload('${psb.files[psb.fileKey].fileDownloadUrl}');"/>
	  		
	  		<input type="button" class="button" value="<fmt:message key="ebpp.portlet.button.audit" bundle="${bndlLang}"/>" onclick='console.log("button clicked.");'/>
	  		<form method="post" action="<portlet:actionURL/>">
				<input type="hidden" name="fpWhereTo" id="fpWhereTo" value=""/>
				<input type="submit" class="button" onclick="navigate(this);" name="back" value="<fmt:message key="ebpp.portlet.button.back" bundle="${bndlLang}"/>"/>
				<input type="submit" class="button" onclick="navigate(this);" name="finish" value="<fmt:message key="ebpp.portlet.button.finish" bundle="${bndlLang}"/>"/>
			</form>								
		</td>
	</tr>	  
  </tbody>
</table>