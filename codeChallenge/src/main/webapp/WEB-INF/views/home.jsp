<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<script type="text/javascript">
	$( document ).ready(function() {
	    console.log( "ready!" );
	    $("#loginBttn").click(function(){
	    	$("#loginDiv").dialog({width:500});
	    });
	    
	    $("#submitBttn").click(function(e){
	    	e.preventDefault();
	    	var userName = $("#userName").val();
	    	if(userName == null || userName == ""){
	    		alert("Please enter a valid user name");
	    		return false;
	    	}
	    	$("#loginForm").submit();
	    })
	});
	</script>
</head>
<body>
<h1>
	Code Challenge!  
</h1>

<P>  Please select an option </P>
<form action="${pageContext.request.contextPath}/navigate" method="post">
	<table>
		<tr>
			<td><input type="submit" value="Sign-up" name="signup"/></td>
			<td><input type="button" value="Login" id="loginBttn"/></td>
		</tr>	
	</table>		
</form>
<div style="display:none" id="loginDiv" title="Login">
	<form action="${pageContext.request.contextPath}/login" method="post" id="loginForm">
		<table>
			<tr>
				<td>Username:</td>
				<td> <input type="text" name="userName" id="userName"/></td>
				<td><input type="submit" value="Submit" id="submitBttn"/></td>				
			</tr>
		</table>		
	</form>	
</div>
</body>
</html>
