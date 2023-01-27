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
	_objKV['error_length_10'] = '<fmt:message bundle="${bndlCommon}" key="14509" />';
	_objKV['error_NAT_1'] = '<fmt:message bundle="${bndlCommon}" key="14510" />';
	_objKV['error_IQA_2'] = '<fmt:message bundle="${bndlCommon}" key="14511" />';
});
</script>