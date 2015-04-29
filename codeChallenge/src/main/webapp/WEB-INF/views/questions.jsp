<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Questions</title>
</head>
<body>
<h1>Questions</h1>
	<s:form commandName="userQuestionnare" action="${pageContext.request.contextPath}/User/processAnswers" method="post">
		<s:errors element="div" path="*" cssStyle="color:red"/><br/>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td>Q1:</td>
				<td><s:select path="question1">
					<s:option value="" label="Please Select"></s:option>
					<s:option value="How old are you ?"></s:option>
					<s:option value="What is your favourite Color ?"></s:option>
					<s:option value="What is your first school ?"></s:option>
				</s:select></td>
				<td><s:input path="answer1"/></td>
			</tr>
			<tr>
				<td>Q2:</td>
				<td><s:select path="question2">
					<s:option value="" label="Please Select"></s:option>
					<s:option value="How old are you ?"></s:option>
					<s:option value="What is your favourite Color ?"></s:option>
					<s:option value="What is your first school ?"></s:option>
				</s:select></td>
				<td><s:input path="answer2"/></td>
			</tr>
			<tr>
				<td>Q3:</td>
				<td><s:select path="question3">
					<s:option value="" label="Please Select"></s:option>				
					<s:option value="How old are you ?"></s:option>
					<s:option value="What is your favourite Color ?"></s:option>
					<s:option value="What is your first school ?"></s:option>
				</s:select></td>
				<td><s:input path="answer3"/></td>
			</tr>
		</table><br/>
		<input type="submit" value="Submit">
	</s:form>

</body>
</html>