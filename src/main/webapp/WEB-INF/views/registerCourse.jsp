<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수강 신청 하기</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
<h2>수강 신청 하기</h2>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/doRegister"
		modelAttribute="infoModel">
	<table class="formtable">
	<tr><td>과목코드:</td><td><sf:input type="text" path="subjectCode"/>
	<br><sf:errors path="subjectCode"/></td></tr>
	<tr><td>과목이름:</td><td><sf:input type="text" path="subjectName"/>
	<br><sf:errors path="subjectName"/></td></tr>
	<tr><td>구분:</td><td><sf:input type="text" path="division"/></td></tr>
	<tr><td>학점:</td><td><sf:input type="text" path="grade"/></td></tr>
	<tr><td></td><td><input type="submit" value="수강 신청"/></td></tr>
	</table>
	</sf:form>

	<br>
	<a href="${pageContext.request.contextPath}/home">home</a>
</body>
</html>