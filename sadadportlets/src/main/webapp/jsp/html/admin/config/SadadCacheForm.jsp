<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<table style="width: 100%">
	<tbody>
		<tr>
			<td>
				<p class="attnbox"><fmt:message key="sadad-config.portlet.marked-fields-are-mandatory" bundle="${bndlLang}" /></p>
			</td>
		</tr>
		<tr>
			<td>
				<fieldset>
					<legend><fmt:message key="sadad-config.portlet.label.refresh-was-cache" bundle="${bndlLang}" /></legend>
					<form id="frmCacheRefresh" method="post" action="<portlet:resourceURL id="CreateBranchCodeForm"/>">					
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 100%">
									<!-- Begin: Data entry fields -->
										<tbody>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="cmbCacheName"><fmt:message key="sadad-config.portlet.label.cache.name" bundle="${bndlLang}" /> *</label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<select name="param_cacheName" class="rqf" id="cmbCacheName">
															<option value="">
																<fmt:message key="sadad-config.portlet.label.please-select" bundle="${bndlLang}" />
															</option>
															<option value="ALL">ALL</option>
															<option value="PARTNER">PARTNER</option>
															<option value="BILLER">BILLER</option>
															<option value="AGGREGATOR">AGGREGATOR</option>
															<option value="SUBBILLER">SUBBILLER</option>
															<option value="BANK">BANK</option>
															<option value="SADAD">SADAD</option>
															<option value="SAMA">SAMA</option>
															<option value="CONFIGURATION">CONFIGURATION</option>
															<option value="LOOKUP">LOOKUP</option>
													</select>
												</td>
											</tr>
											<tr class="DataEntryFieldRow">
												<td class="labelCell" valign="top" nowrap height="27">
													<label class="label" for="txtCacheKey"><fmt:message key="sadad-config.portlet.label.cache.key" bundle="${bndlLang}" /></label>
												</td>
												<td class="outputDataCell" style="width: 100%" valign="top" nowrap>
													<input name="param_cacheKey" id="txtCacheKey" class="" value="${psb.cacheKey}" maxlength="50" />
												</td>
											</tr>
											<!-- End: Data entry fields -->
										</tbody>
									</table>
								</td>
							</tr>
							<!-- Buttons Group -->
							<tr>
								<td>
									<input type="hidden" name="param_operation" value="callRefreshCache"/>
									<input class="button" value="<fmt:message key="sadad-config.portlet.button.submit" bundle="${bndlLang}" />" onclick="doQueryFormSubmission('frmCacheRefresh', 1);" type="submit"/>
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