<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학기별 이수 학점 조회</title>
</head>
<body>

	<table border="1px">
		<tr>
			<td>년도</td><td>학기</td><td>이수 학점</td><td>상세보기</td>
		</tr>
		<c:forEach var="im" items="${infoModel}" begin="0" step="1">
			<tr>
				<td align="center">${im.getYear()}</td><td align="center">${im.getSemester()}</td><td align="center">${im.getGrade()}</td><td align="center">
				<a href="${pageContext.request.contextPath}/showDetails?year=${im.year}&semester=${im.semester}">링크</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="${pageContext.request.contextPath}/home">home</a>
</body>
</html>