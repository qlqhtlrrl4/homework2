<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이수 구분별 학점 조회</title>
</head>
<body>
<table border="1px">

		<tr>
			<c:forEach var="im" items="${infoModel}" begin="0" step="1">
				<td align="center">${im.getDivision()}</td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach var="im" items="${infoModel}" begin="0" step="1">
				<td align="center">${im.getGrade()}</td>
			</c:forEach>
		</tr>

	</table>
	<br>
	<a href="${pageContext.request.contextPath}/home">home</a>
</body>
</html>