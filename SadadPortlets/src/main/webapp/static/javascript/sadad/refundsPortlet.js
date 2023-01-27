/**
 * refundsPortlet = Refund releated portlet (Query Refund etc) 
 * This javascript file will be used for custom javascripts function written for this applicaiton.
 * 
 */

/**
 * Function to be called on page load via onContainerLoad1
 */
function onContainer1LoadsFromModule() {
	$(".requiredReadOnly").on('keydown paste', function(e){ e.preventDefault();	});
}

/**
 * Called on the change of Statusses combo box 
 */
function onChangeStatus(srcObj) {
	if(srcObj.value !== "")	{
		let nodes = document.querySelectorAll("select[id^=choice]");
		for(let i = 0; i < nodes.length; i++) {
			if(srcObj.id === nodes[i].getAttribute('id')) {
				nodes[i].setAttribute('class', 'rqf');
			} else {
				nodes[i].removeAttribute('class');
			}
		}
	} else {
		srcObj.removeAttribute('class');
		let nodes = document.querySelectorAll("select[id^=choice][class='rqf']");
		if (nodes.length == 0) {
			nodes = document.querySelectorAll("select[id^=choice]");
			let vz = 3;
			for(let i = 0; i < nodes.length; i++)
				if(nodes[i].value == "") 
					vz --;
			if(vz === 0)
				for(let i = 0; i < nodes.length; i++)
					nodes[i].setAttribute('class', 'rqf');
		}
	}
}