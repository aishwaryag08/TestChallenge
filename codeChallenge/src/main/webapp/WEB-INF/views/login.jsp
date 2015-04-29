<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Security Question</title>
</head>
<body>
<span>Please answer the security question</span>
<s:form action="${pageContext.request.contextPath}/User/validate" method="post" commandName="securityQuestion">
	<s:errors element="div" path="*" cssStyle="color:red"/>
	<table>
		<tr>
			<td>${sessionScope.sessionQuestionnare.question1}</td>
			<td><s:input path="answer"/></td>
		</tr>
	</table>
	<input type="submit" value="Submit"/>
</s:form>
</body>
</html>