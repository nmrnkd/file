<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>auth</title>
</head>
<body>
<c:choose>
	<c:when test="${userid == null }">
		<a href="${contextPath }/auth">이메일 인증하기</a>
	</c:when>
	<c:otherwise>
		${userid }님 이메일 인증이 완료되었습니다.
	</c:otherwise>
</c:choose>

</body>
</html>