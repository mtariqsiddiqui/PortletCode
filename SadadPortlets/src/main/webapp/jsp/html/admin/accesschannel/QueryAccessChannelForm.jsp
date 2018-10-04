<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<form name="frmQueryAccessChannel" id="frmQueryAccessChannel" method="post" action="<portlet:resourceURL id="QueryAccessChannelList"/>">
<table style="width: 100%;">
	<tbody>
		<tr>
			<td>
				<table style="width: 100%;">
					<tbody>
						<tr><td><p class="attnbox"><fmt:message key="access-channel.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p></td></tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="access-channel.portlet.label.get-access-channel" bundle="${bndlLang}" /></legend>
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%;">
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="cmbAccessChannel"><fmt:message key="access-channel.portlet.label.access-channel" bundle="${bndlLang}" />&nbsp;:&nbsp;*</label>
												</td>
												<td class="outputDataCell" style="width: 100%;" valign="top" nowrap>
													<select name="txtAccessChannel" class="outputData" id="cmbAccessChannel" >
														<option value="">
															<fmt:message key="access-channel.portlet.label.please-select" bundle="${bndlLang}"/>
														</option>												
														<c:forEach items="${AccessChannelList}" var="accessChannel">
															<option  <c:if test="${psb.accessChannel == accessChannel.value.code}">selected</c:if> 
																value="<c:out value="${accessChannel.value.code}" />">
																<c:out value="${accessChannel.value.code}" />
															</option>
														</c:forEach>
													</select>
												</td>
											</tr>
											
										</tbody>
									</table>
								</td>
							</tr>
							<!-- Buttons Group -->
							<tr>
								<td>
									<input type="submit" id="btnSearch" class="button" 
										value="<fmt:message key="access-channel.portlet.button.search" bundle="${bndlLang}" />" 
										onclick="doQueryFormSubmission('frmQueryAccessChannel', 2);" />
								</td>
							</tr>
						</tbody>
					</table>
				</fieldset>
				<!-- END Query Segment -->
			</td>
		</tr>
	</tbody>
</table>
</form>