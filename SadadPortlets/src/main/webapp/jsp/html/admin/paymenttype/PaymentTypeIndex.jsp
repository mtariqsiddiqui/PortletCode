<jsp:directive.include file="../../common/JspDeclarations.jspf" />
<jsp:directive.include file="../../common/JspIncludeStaticFiles.jspf" />
<span id="msgContainer"></span> 
<div id="page1" style="display: block;">
	<div id="container_1"><jsp:include page="${psb.screen.container1}" /></div>
	<div id="container_2"><jsp:include page="${psb.screen.container2}" /></div>
</div>
<div class="modal64" id="ajaxLoader"></div>
<script type="text/javascript">
	var allChannelsJson =  JSON.parse('${jsonAccessChannels}');
	allChannelsJson
		.sort(function (a, b) { if (a.name < b.name) { return -1; } if (a.name > b.name) { return 1; } return 0; })
		.filter(function(c){return c.status === "ACTIVE"})
		.forEach(function(chnl){allChannels.push(chnl.name)});
		
	var allServiceTypesJson = JSON.parse('${jsonAccountTypes}');
	allServiceTypesJson
		.sort(function (a, b) { if (a.name < b.name) { return -1; } if (a.name > b.name) { return 1; } return 0; })
		.filter(function(c){return c.status === "ACTIVE"})
		.forEach(function(act){allServiceTypes.push(act.name)});

	$(document).ready(function() {
	onContainer1Loads();
	onContainer2Loads();
	_objKV['invalid_iban'] = '<fmt:message bundle="${bndlCommon}" key="14524" />';
});
</script>