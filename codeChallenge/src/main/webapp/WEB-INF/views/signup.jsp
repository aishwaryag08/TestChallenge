<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign-up</title>
</head>
<body>
	<h1>Signup </h1>
	<s:form commandName="user" action="${pageContext.request.contextPath}/User/signup" method="post">
		<s:errors element="div" path="*" cssStyle="color:red"/><br/>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td>Username</td>
				<td><s:input path="userName"/></td>
			</tr>
			<tr>
				<td>Birth Date(mm/dd/yyyy)</td>
				<td><s:input path="dob"/></td>
			</tr>
		</table><br/>
		<input type="submit" value="Submit">
	</s:form>
</body>
</html>