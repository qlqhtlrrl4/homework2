<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세정보</title>
</head>
<body>
	<table border="1px">

		<tr>
			<td align="center">교과코드</td>
			<td align="center">교과목명</td>
			<td align="center">구분</td>
			<td align="center">학점</td>
		</tr>

		<c:forEach var="im" items="${infoModel}" begin="0" step="1">
			<tr>
				<td align="center">${im.getSubjectCode()}</td>
				<td align="center">${im.getSubjectName()}</td>
				<td align="center">${im.getDivision()}</td>
				<td align="center">${im.getGrade()}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="${pageContext.request.contextPath}/home">home</a>
</body>
</html>