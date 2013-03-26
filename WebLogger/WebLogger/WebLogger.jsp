<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Log</title>
<script type="text/javascript" src="Ajax.js"></script>
<script type="text/javascript">
	
	function appendLog(message) {
		
		message = message.replace('/\\r/g','<br>');
		message = message.replace('/\\n/g','<br>');
		message = message.replace('/Content-type: text/plain/g','');
		message = message.replace('/--End/g','');
		document.getElementById('log').innerHTML = message;
	}

	function showLog() {
		document.getElementById('log').innerHTML = "";
		var req = new XMLHttpRequest();
		req.onreadystatechange = function() {
			//alert('req.readyState'+req.readyState);
			//alert('respose'+req.responseText);
			if(req.readyState  == 3 || req.readyState == 4 ) {
				appendLog(req.responseText);
			}
		}
		req.open('POST', '/WebLogger/WebLogger', true);
		req.send();
	}
	
	function process() {
		var req = new XMLHttpRequest();
		req.open('GET', '/WebLogger/Dummy', true);
		req.send();
	}
</script>
</head>
<body>
	<form action="WebLogger" method="post">
		<input type="button" value="Show Log" onclick="showLog();">
		<input type="button" value="Process" onclick="process();">
		<div id="log"></div>
	</form>
</body>
</html>