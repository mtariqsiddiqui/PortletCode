<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<jsp:directive.include file="../../common/JspIncludeStaticFiles.jspf" />
<span id="msgContainer" class="${psb.messageToDisplay.messageType}_Message">${psb.messageToDisplay.displayMessage}</span>
<div id="page1" style="display: block;">
	<div id="container_1"><jsp:include page="${psb.screen.container1}" /></div>
	<div id="container_2"><jsp:include page="${psb.screen.container2}" /></div>
</div>
<div class="modal64" id="ajaxLoader"></div>
<script type="text/javascript">
	$(document).ready(function() {
	onContainer1Loads();
	onContainer2Loads();
	_objKV['err_new_password_same'] = '<fmt:message bundle="${bndlLang}" key="user.portlet.new-password-cannot-same" />';
	_objKV['err_password_mismatch'] = '<fmt:message bundle="${bndlLang}" key="user.portlet.password-mismatch" />';	
});
</script>