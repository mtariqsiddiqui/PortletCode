/**
 * init() function call from Theme on every page.
 */
function init() {
	// IE doesn't have trim / startsWith / endsWith function
	if (!String.prototype.startsWith) {
		String.prototype.startsWith = function(searchString, position) {
			position = position || 0;
			return this.indexOf(searchString, position) === position;
		};
	}
	if (!String.prototype.endsWith) {
		String.prototype.endsWith = function(pattern) {
			var d = this.length - pattern.length;
			return d >= 0 && this.lastIndexOf(pattern) === d;
		};
	}
	if (!String.prototype.trim) {
		String.prototype.trim = function() {
			return this.replace(/^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g, '');
		};
	}
	// Production steps of ECMA-262, Edition 6, 22.1.2.1
	if (!Array.from) {
		Array.from = (function() {
			var toStr = Object.prototype.toString;
			var isCallable = function(fn) {
				return typeof fn === 'function'
						|| toStr.call(fn) === '[object Function]';
			};
			var toInteger = function(value) {
				var number = Number(value);
				if (isNaN(number)) {
					return 0;
				}
				if (number === 0 || !isFinite(number)) {
					return number;
				}
				return (number > 0 ? 1 : -1) * Math.floor(Math.abs(number));
			};
			var maxSafeInteger = Math.pow(2, 53) - 1;
			var toLength = function(value) {
				var len = toInteger(value);
				return Math.min(Math.max(len, 0), maxSafeInteger);
			};

			// The length property of the from method is 1.
			return function from(arrayLike/* , mapFn, thisArg */) {
				// 1. Let C be the this value.
				var C = this;

				// 2. Let items be ToObject(arrayLike).
				var items = Object(arrayLike);

				// 3. ReturnIfAbrupt(items).
				if (arrayLike == null) {
					throw new TypeError(
							'Array.from requires an array-like object - not null or undefined');
				}

				// 4. If mapfn is undefined, then let mapping be false.
				var mapFn = arguments.length > 1 ? arguments[1]
						: void undefined;
				var T;
				if (typeof mapFn !== 'undefined') {
					// 5. else
					// 5. a If IsCallable(mapfn) is false, throw a TypeError
					// exception.
					if (!isCallable(mapFn)) {
						throw new TypeError(
								'Array.from: when provided, the second argument must be a function');
					}

					// 5. b. If thisArg was supplied, let T be thisArg; else let
					// T be undefined.
					if (arguments.length > 2) {
						T = arguments[2];
					}
				}

				// 10. Let lenValue be Get(items, "length").
				// 11. Let len be ToLength(lenValue).
				var len = toLength(items.length);

				// 13. If IsConstructor(C) is true, then
				// 13. a. Let A be the result of calling the [[Construct]]
				// internal method
				// of C with an argument list containing the single item len.
				// 14. a. Else, Let A be ArrayCreate(len).
				var A = isCallable(C) ? Object(new C(len)) : new Array(len);

				// 16. Let k be 0.
				var k = 0;
				// 17. Repeat, while k < len… (also steps a - h)
				var kValue;
				while (k < len) {
					kValue = items[k];
					if (mapFn) {
						A[k] = typeof T === 'undefined' ? mapFn(kValue, k)
								: mapFn.call(T, kValue, k);
					} else {
						A[k] = kValue;
					}
					k += 1;
				}
				// 18. Let putStatus be Put(A, "length", len, true).
				A.length = len;
				// 20. Return A.
				return A;
			};
		}());
	}
}

/**
 * Chop the leading and trailing spaces of source object
 * 
 * @param srcObj
 * @returns trimed value of the srcObj
 */
function chop(srcObj) { srcObj.value = srcObj.value.trim() ; }

/**
 * Display Ajax loader gif (in-progress) image in Modal
 */
function makePageBusy(){
    $('#ajaxLoader').fadeIn(250);
}

/**
 * Hides Ajax loader gif (in-progress) image
 */
function makePageUnBusy(){
  $('#ajaxLoader').fadeOut(250);
}

/**
 * Display or Clear error or success messages on page (#msgContainer)
 * 
 * @param txt -
 *            message to display (optional if undefined then any previous
 *            message will be cleared)
 * @param cls -
 *            CSS class (optional if undefined then ERROR class will be applied)
 */
function displayErrorOrMessage(txt, cls){
	if(typeof txt === "undefined") {
		$('#msgContainer').html('');
		$('#msgContainer').removeClass();
	} else {
		$('#msgContainer').html(txt);
		$('#msgContainer').removeClass();
		if(typeof cls === "undefined")
			$('#msgContainer').addClass('ERROR_Message');
		else
			$('#msgContainer').addClass(cls+'_Message');
	}
}

/**
 * Reset the form, sets the value '' to all form fields
 */
function doQueryFormReset(resetURL){
    makePageBusy();
    displayErrorOrMessage(); // clearing any previous message
    
    $.ajax({
        type: 'post',
        url: resetURL,
        cache: false,
        success: function (response, status, xhr) {
        	var ct = xhr.getResponseHeader('content-type') || '';
            if (ct.indexOf('html') > -1) {
            	if(response.substring(0, 41).indexOf('LOGIN_PAGE_RENDER') > -1) { // Session Timeout
            		window.location.reload();
            		return;
            	}
				$("#container_1").html(response);
				$("#container_2").html('');
				onContainer1Loads();				
            } else {
            	displayErrorOrMessage(response.displayMessage, response.messageType);
				$("#container_2").html('');
            }
            makePageUnBusy();
        },
        error: function (xhr, textStatus, errorThrown) {
        	// _objKV is defined in JspIncludeStaticFiles.jspf file, getting its keys and values from Language resource bundles
        	var strErr = _objKV['sadad-generic-error'];
            displayErrorOrMessage(strErr);
			$("#container_2").html('');
            makePageUnBusy();
        }
    });	
};

/**
 * Submits the form to the server
 * 
 * @param formName
 * @param responseContainer - number if provided response will be rendered in to that specific container, otherwise container_2 is default
 * @param applyFilter - boolean if provided applies filter on detail table
 * @param filterValue - string if provided detail table will be filtered with this value
 */
function doQueryFormSubmission(formName, responseContainer, applyFilter, filterValue) {
	$('#' + formName).submit(function (e) {
        e.preventDefault(); // avoid to execute the actual submit of the form.
        e.stopImmediatePropagation();

		if(isDataValid()) {
			makePageBusy();
			displayErrorOrMessage(); // clearing any previous message

			$.ajax({
				type: $(this).attr('method'),
				url: $(this).attr('action'),
				data: $(this).serialize(),
				cache: false,
				success: function (response, status, xhr) {
					var ct = xhr.getResponseHeader('content-type') || '';
					if (ct.indexOf('html') > -1) {
						if(response.substring(0, 41).indexOf('LOGIN_PAGE_RENDER') > -1) { // Session Timeout
							window.location.reload();
							return;
						}
						if(typeof responseContainer === "undefined" || responseContainer === 2) {
							$("#container_2").html(response);
							onContainer2Loads(applyFilter, filterValue);
						}
						else if(typeof responseContainer === "number") {
							if(responseContainer === 1) {
								$("#container_1").html(response);
								$("#container_2").html('');
								onContainer1Loads();
							}
						}
					} else {
						displayErrorOrMessage(response.displayMessage, response.messageType);
						$("#container_2").html('');
					}
					makePageUnBusy();
				},
				error: function (xhr, textStatus, errorThrown) {
					// _objKV is defined in JspIncludeStaticFiles.jspf file, getting its keys and values from Language resource bundles
					var strErr = _objKV['sadad-generic-error'];
					displayErrorOrMessage(strErr);
					$("#container_2").html('');
					makePageUnBusy();
				}
			});
		}
	});
}

/**
 * Post serveResource URL to server
 * 
 * @param pUrl - URL to Post to server
 * @param container - container to reneder the server resonse, possible values (1 or 2)
 */
function doPostUrl(pUrl, container, jParams) {
    makePageBusy();
    displayErrorOrMessage(); // clearing any previous message
    $.ajax({
        type: 'post',
        url: pUrl,
		data: jParams,
        cache: false,
        success: function (response, status, xhr) {
        	var ct = xhr.getResponseHeader('content-type') || '';
            if (ct.indexOf('html') > -1) {
            	if(response.substring(0, 41).indexOf('LOGIN_PAGE_RENDER') > -1) { // Session Timeout
            		window.location.reload();
            		return;
            	}
				if(container === 1) {
					$("#container_1").html(response);
					$("#container_2").html('');
					onContainer1Loads();
				} else if(container === 2) {
					$("#container_2").html(response);
					onContainer2Loads();
				}
            } else {
            	displayErrorOrMessage(response.displayMessage, response.messageType);
				$("#container_2").html('');
            }
            makePageUnBusy();
        },
        error: function (xhr, textStatus, errorThrown) {
        	// _objKV is defined in JspIncludeStaticFiles.jspf file, getting its keys and values from Language resource bundles
        	var strErr = _objKV['sadad-generic-error'];
            displayErrorOrMessage(strErr);
			$("#container_2").html('');
            makePageUnBusy();
        }, timeout: 300000 // sets timeout to 5 minutes
    });	
}

/**
 * Executes after every container 1 loads
 */
function onContainer1Loads() {
	$('input[type=text][id$=Date]').datepicker({
		minDate : -190,
		maxDate : "0",
		dateFormat: 'yy-mm-dd',
		showOtherMonths : true,
		selectOtherMonths : true,
		changeMonth : true,
		changeYear : true,
		showWeek : true,
		firstDay : 1
	});
	
	if (typeof onContainer1LoadsFromModule === "function") { 
		onContainer1LoadsFromModule();
	}
}

/**
 * Executes after every container 2 loads
 * 
 * @param applyFilter - boolean if true DataTable values will be filtered
 * @param filterValue - string if provided DataTable will be filtered with this value
 */
function onContainer2Loads(applyFilter, filterValue) {
	$('#detailTable').DataTable({
		dom : 'lfrtBip',
		buttons : [ 'copyHtml5', 'csvHtml5', 'excelHtml5', 'pdfHtml5', 'print' ],
		language : { "url": "/static/javascript/library/i18n/"+_objKV['pageLanguage']+".json" }
	});
	
	if(typeof applyFilter === "boolean" && typeof filterValue !== "undefined")
		if(applyFilter === true) {
			$('#detailTable').DataTable().search(filterValue).draw();
//			regExSearch = ^\\s + filterValue +'\\s*$';
//			$('#detailTable').DataTable().search(regExSearch, true, false).draw();
		}
	
	if (typeof onContainer2LoadsFromModule === "function") { 
		onContainer2LoadsFromModule();
	}
}

/**
 * Calls Portlet Action URL
 * 
 * @param srcObj - HTML Input type element, usually button with name "back" or "finish".
 */
function navigate(srcObj) {
	makePageBusy();
	$('#fpWhereTo').val(srcObj.name);
}


/**
 * Call the backend webservice to cancel or uncancel the the payment status
 * core_PaymentSummary is rendered from Accounts, Bills and Payments that's 
 * why applyPaymentStatusChange function is party of sadadCommon insteam of 
 * paymentsPortlet
 * 
 */
function applyPaymentStatusChange(value, key, map) {
	makePageBusy();
    displayErrorOrMessage(); // clearing any previous message
    
	// check if the original status is changed by user
	if(paymentMap.get(key) !== value) {
		if(value === "CANCELED") {
			console.log(key + " will be canceled.");
		    
		    $.ajax({
		        type: 'post',
		        url: paymentMap.get('changeStatusUrl'),
		        data : { 'param_paymentId' : key, 'param_operation' : 'callPaymentService_Cancel' },
		        cache: false,
		        success: function (response, status, xhr) {
		        	console.log(response);
		        	displayErrorOrMessage(response.displayMessage, response.messageType);
		        	makePageUnBusy();
		        },
		        error: function (xhr, textStatus, errorThrown) {
		        	// _objKV is defined in JspIncludeStaticFiles.jspf file, getting its keys and values from Language resource bundles
		        	var strErr = _objKV['sadad-generic-error'];
		            displayErrorOrMessage(strErr);
		            makePageUnBusy();
		        }
		    });
		} else if(value === "UNCANCEL") {
			$.ajax({
				type: 'post',
			    url: paymentMap.get('changeStatusUrl'),
			    data : { 'param_paymentId' : key, 'param_operation' : 'callPaymentService_UnCancel' },
			    cache: false,
			    success: function (response, status, xhr) {
			    	console.log(response);
			    	displayErrorOrMessage(response.displayMessage, response.messageType);
			    	makePageUnBusy();
			    },
			    error: function (xhr, textStatus, errorThrown) {
			    	// _objKV is defined in JspIncludeStaticFiles.jspf file, getting its keys and values from Language resource bundles
			    	var strErr = _objKV['sadad-generic-error'];
			        displayErrorOrMessage(strErr);
			        makePageUnBusy();
			    }
			});			
		}
	}
}

/**
 * Format the given date in yyyy-mm-dd
 * 
 * @param date
 * @returns formatted date
 */
function formatDateYMD(date) {
	var d = new Date(date), month = '' + (d.getMonth() + 1), day = ''
			+ d.getDate(), year = d.getFullYear();

	if (month.length < 2)
		month = '0' + month;
	if (day.length < 2)
		day = '0' + day;

	return [ year, month, day ].join('-');
}


/**
 * Post serveResource URL to server to get counter part bill details
 * 
 * @param pUrl - URL to Post to server
 */
function showCounterPartDetails(pUrl) {
    makePageBusy();
    displayErrorOrMessage(); // clearing any previous message
    
    $.ajax({
        type: 'post',
        url: pUrl,
        cache: false,
        success: function (response, status, xhr) {
        	var ct = xhr.getResponseHeader('content-type') || '';
            if (ct.indexOf('html') > -1) {
            	if(response.substring(0, 41).indexOf('LOGIN_PAGE_RENDER') > -1) { // Session Timeout
            		window.location.reload();
            		return;
            	}
            } else {
            	$('#response_billNumber').html(response.billNumber);
            	$('#response_billType').html(response.billType);
            	$('#response_origianlAmount').html(response.origianlAmount);
            	$('#response_billGeneratedDate').html(response._billGeneratedDate);
            	$('#response_billCycle').html(response.billCycle);
            	$('#response_billCategory').html(response.billCategory);
            	$('#response_netAmount').html(response.netAmount);
            	$('#response_expiryDate').html(response._expiryDate);
            	$('#response_paymentCount').html(response.paymentCount);
            	// Reset back to the previous bill
            	$('#showCounterButton').attr('onclick', 'doPostUrl($("#resetCounterPart").val(), 1);');
            }
            makePageUnBusy();
        }, 
        error: function (xhr, textStatus, errorThrown) {
        	// _objKV is defined in JspIncludeStaticFiles.jspf file, getting its keys and values from Language resource bundles
        	var strErr = _objKV['sadad-generic-error'];
            displayErrorOrMessage(strErr);
			$("#container_2").html('');
            makePageUnBusy();
        }
    });	
}

/**
 * The function is doing certain general data validation using some regular expression.
 * 
 * @returns boolean - True if all entered data is correct as per assigned class, otherwise False
 */
function isDataValid() {
	let nbNodes = document.querySelectorAll(".nbr"); // Number only
	let rqNodes = document.querySelectorAll(".rqf"); // Required fields
	let chNodes = document.querySelectorAll(".chr"); // Character only
	let csNodes = document.querySelectorAll(".chs"); // Character with Space
	let cnNodes = document.querySelectorAll(".cnr"); // Characters and Numbers
	let emNodes = document.querySelectorAll(".eml"); // Email Address 
	let mbNodes = document.querySelectorAll(".mbp"); // Mobile Nubmer 
	let validationFailed = false;
	// Required field checking
	let errorMessage = _objKV['sadad-missing-field'] + "<ul>";
	for (var i = 0; i < rqNodes.length; i++) {
		if(rqNodes[i].value.trim() === "") {
			validationFailed = true;
			let lblText = document.querySelector('label[for="'+rqNodes[i].id+'"]').innerHTML.trim();
			lblText = lblText.replace('*', '').replace('*', '').trim();
			errorMessage = errorMessage + "<ol>" + lblText + "</ol>";
		}
	}
	errorMessage = errorMessage + "</ul>";
	if(validationFailed) {
		displayErrorOrMessage(errorMessage);
		return false;
	}
	// Number format checking
	errorMessage =  _objKV['sadad-invalid-nbr'] + "<ul>"; // re-assign new error message values for number format 
	for (var i = 0; i < nbNodes.length; i++) {
		if(nbNodes[i].value.trim().length > 0) {
			if(! /^\d+$/.test(nbNodes[i].value.trim())) {
				validationFailed = true;
				let lblText = document.querySelector('label[for="'+nbNodes[i].id+'"]').innerHTML.trim();
				lblText = lblText.replace('*', '').replace('*', '').trim();
				errorMessage = errorMessage + "<ol>" + lblText + "</ol>";
			}
		}
	}
	errorMessage = errorMessage + "</ul>";
	if(validationFailed) {
		displayErrorOrMessage(errorMessage);
		return false;
	}
	// Character only checking
	errorMessage =  _objKV['sadad-invalid-chr'] + "<ul>"; // re-assign new error message values for number format 
	for (var i = 0; i < chNodes.length; i++) {
		if(chNodes[i].value.trim().length > 0) {
			if(! /^[A-Za-z]+$/.test(chNodes[i].value.trim())) {
				validationFailed = true;
				let lblText = document.querySelector('label[for="'+chNodes[i].id+'"]').innerHTML.trim();
				lblText = lblText.replace('*', '').replace('*', '').trim();
				errorMessage = errorMessage + "<ol>" + lblText + "</ol>";
			}
		}
	}
	errorMessage = errorMessage + "</ul>";
	if(validationFailed) {
		displayErrorOrMessage(errorMessage);
		return false;
	}
	// Character with SPACE checking
	errorMessage =  _objKV['sadad-invalid-chs'] + "<ul>"; // re-assign new error message values for character with space format 
	for (var i = 0; i < csNodes.length; i++) {
		if(csNodes[i].value.trim().length > 0) {
			if(! /^[A-Za-z\s]+$/.test(csNodes[i].value.trim())) {
				validationFailed = true;
				let lblText = document.querySelector('label[for="'+csNodes[i].id+'"]').innerHTML.trim();
				lblText = lblText.replace('*', '').replace('*', '').trim();
				errorMessage = errorMessage + "<ol>" + lblText + "</ol>";
			}
		}
	}
	errorMessage = errorMessage + "</ul>";
	if(validationFailed) {
		displayErrorOrMessage(errorMessage);
		return false;
	}
	// Character with Number checking
	errorMessage =  _objKV['sadad-invalid-cnr'] + "<ul>"; // re-assign new error message values for character with number format 
	for (var i = 0; i < cnNodes.length; i++) {
		if(csNodes[i].value.trim().length > 0) {			
			if(! /^[a-zA-Z0-9]+$/.test(cnNodes[i].value.trim())) {
				validationFailed = true;
				let lblText = document.querySelector('label[for="'+cnNodes[i].id+'"]').innerHTML.trim();
				lblText = lblText.replace('*', '').replace('*', '').trim();
				errorMessage = errorMessage + "<ol>" + lblText + "</ol>";
			}
		}
	}
	errorMessage = errorMessage + "</ul>";
	if(validationFailed) {
		displayErrorOrMessage(errorMessage);
		return false;
	}
	// Email Address format checking
	errorMessage =  _objKV['sadad-invalid-email'] + "<ul>"; // re-assign new error message values for number format 
	for (var i = 0; i < emNodes.length; i++) {
		if(emNodes[i].value.trim().length > 0) {
			if(! /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(emNodes[i].value.trim())) {
				validationFailed = true;
				let lblText = document.querySelector('label[for="'+emNodes[i].id+'"]').innerHTML.trim();
				lblText = lblText.replace('*', '').replace('*', '').trim();
				errorMessage = errorMessage + "<ol>" + lblText + "</ol>";
			}
		}
	}
	errorMessage = errorMessage + "</ul>";
	if(validationFailed) {
		displayErrorOrMessage(errorMessage);
		return false;
	}
	// Mobile Number checking
	errorMessage =  _objKV['sadad-invalid-mobile'] + "<ul>"; // re-assign new error message values for number format 
	for (var i = 0; i < mbNodes.length; i++) {
		if(mbNodes[i].value.trim().length > 0) {
			if(! /^(([\+0]{1,2})?(\d{1,3}))?(\d{9,10})$/.test(mbNodes[i].value.trim())) {
				validationFailed = true;
				let lblText = document.querySelector('label[for="'+mbNodes[i].id+'"]').innerHTML.trim();
				lblText = lblText.replace('*', '').replace('*', '').trim();
				errorMessage = errorMessage + "<ol>" + lblText + "</ol>";
			}
		}
	}
	errorMessage = errorMessage + "</ul>";
	if(validationFailed) {
		displayErrorOrMessage(errorMessage);
		return false;
	}

	// Custom Data Validation from specific modules
	if (typeof customDataValidationFromModule === "function") { 
		return customDataValidationFromModule();
	}
	
	return true;
}