<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:choose>
<c:when test="${sessionScope.id == null}">
<a href="${path}/tour_list/login.do">로그인</a>
</c:when>
<c:otherwise>
${sessionScope.name}님이 로그인중입니다.
<a href="${path}/tour_list/logout.do">로그아웃</a>
</c:otherwise>
</c:choose>
<hr/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>메뉴</title>
</head>
<body>

</body>
</html>