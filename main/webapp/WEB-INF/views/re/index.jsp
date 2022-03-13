<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link type="text/css" rel="stylesheet" href="${contextPath }/css/test.css">
</head>
<body>
<h1>TESTING</h1>

	<img src="${contextPath }/resources/1.JPG" width="50px" height= "50px">
	<img src="${contextPath }/resources/test/신의 놀이 표지.jpg" width="50px" height= "50px">
	<img src='<c:url value="/resources/1.JPG"/>' width="50px" height="50px">
	<form action="result">
		<input type="text" name="id"><br>
		<input type="submit" value="전송"><br>
	</form>
</body>
</html>