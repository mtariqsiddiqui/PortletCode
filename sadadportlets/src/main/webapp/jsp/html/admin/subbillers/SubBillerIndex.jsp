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
	onContainer1Loads();
	onContainer2Loads();
	_objKV['error_invalid_iban'] = '<fmt:message bundle="${bndlCommon}" key="14524" />';
	_objKV['sadad-invalid-hijri'] = '<fmt:message bundle="${bndlCommon}" key="sadad-invalid-hijri" />';
	_objKV['sadad-invalid-addr'] = '<fmt:message bundle="${bndlCommon}" key="sadad-invalid-addr" />';
	_objKV['sadad-invalid-name'] = '<fmt:message bundle="${bndlCommon}" key="sadad-invalid-name" />';
	_objKV['sadad-invalid-lln'] = '<fmt:message bundle="${bndlCommon}" key="sadad-invalid-lln" />';
	_objKV['sadad-invalid-mobile'] = '<fmt:message bundle="${bndlCommon}" key="sadad-invalid-mobile" />';
	_objKV['sadad-invalid-email'] = '<fmt:message bundle="${bndlCommon}" key="sadad-invalid-email" />';
});
</script>