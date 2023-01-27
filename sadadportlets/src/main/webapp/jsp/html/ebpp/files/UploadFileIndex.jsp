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
	_objKV['FILE_UPLOAD_URL'] = '${psb.FILE_UPLOAD_URL}';
	_objKV['MAX_FILE_SIZE'] = ${psb.MAX_FILE_SIZE};
	_objKV['MAX_FILES_UPLOAD'] = ${psb.MAX_FILES_UPLOAD};
	_objKV['upload_label'] = '<fmt:message bundle="${bndlLang}" key="ebpp.portlet.button.upload" />';
	_objKV['delete_label'] = '<fmt:message bundle="${bndlLang}" key="ebpp.portlet.button.delete" />';
	_objKV['error_while_upload'] = '<fmt:message bundle="${bndlLang}" key="ebpp.portlet.label.error-while-upload" />';
	_objKV['max_file_error'] = '<fmt:message bundle="${bndlLang}" key="ebpp.portlet.label.sadad-missing-data-error" />';	
	_objKV['sadad-missing-data-error'] = '<fmt:message bundle="${bndlLang}" key="ebpp.portlet.label.sadad-missing-data-error" />';
	_objKV['sadad-file-size-error'] = '<fmt:message bundle="${bndlLang}" key="ebpp.portlet.label.sadad-file-size-error" />';
	_objKV['sadad-file-not-supported'] = '<fmt:message bundle="${bndlLang}" key="ebpp.portlet.label.sadad-file-not-supported" />';
	_objKV['sadad-file-upload-success'] = '<fmt:message bundle="${bndlLang}" key="ebpp.portlet.label.sadad-file-upload-success" />';
	_objKV['sadad-file-upload-failed'] = '<fmt:message bundle="${bndlLang}" key="ebpp.portlet.label.sadad-file-upload-failed" />';
});
</script>