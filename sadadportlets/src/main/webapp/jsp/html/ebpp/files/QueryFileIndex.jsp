<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<jsp:directive.include file="../../common/JspIncludeStaticFiles.jspf" />
<span id="msgContainer"></span> 
<div id="page1" style="display: block;">
	<div id="container_1"><jsp:include page="${psb.screen.container1}" /></div>
	<div id="container_2"><jsp:include page="${psb.screen.container2}" /></div>
</div>
<div class="modal64" id="ajaxLoader"></div>
<script type="text/javascript">
	$(document).ready(function() {
	init();
	onContainer1Loads();
	onContainer2Loads();	
	_objKV['FILE_DOWNLOAD_URL'] = '${psb.FILE_DOWNLOAD_URL}';
	_objKV['error_while_download'] = '<fmt:message bundle="${bndlLang}" key="ebpp.portlet.label.error-while-download" />';
	_objKV['error_file_archive'] = '<fmt:message bundle="${bndlLang}" key="ebpp.portlet.label.error-file-archive" />';
	_objKV['AGGREGATOR_HASHED_KEY'] = '${psb.hashedPartnerKey}';
});
</script>