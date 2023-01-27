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
	_objKV['regex_initial'] = '<fmt:message bundle="${bndlCommon}" key="regex_initial" />';
	_objKV['^[A-Za-z]+$'] = '<fmt:message bundle="${bndlCommon}" key="^[A-Za-z]+$" />';
	_objKV['^[A-Za-z\\s]+$'] = '<fmt:message bundle="${bndlCommon}" key="^[A-Za-z\\s]+$" />';
	_objKV['^\\d{2,4}$'] = '<fmt:message bundle="${bndlCommon}" key="^\\d{2,4}$" />';
	_objKV['^[a-zA-Z0-9]+$'] = '<fmt:message bundle="${bndlCommon}" key="^[a-zA-Z0-9]+$" />';
	_objKV['^[\\w\\W]+'] = '<fmt:message bundle="${bndlCommon}" key="^[\\w\\W]+" />';
	_objKV['^[\\w\\W]{4,50}'] = '<fmt:message bundle="${bndlCommon}" key="^[\\w\\W]{4,50}" />';
	_objKV['^([5-9]\\d|[1-9]\\d{2,})$'] = '<fmt:message bundle="${bndlCommon}" key="^([5-9]\\d|[1-9]\\d{2,})$" />';
});
</script>