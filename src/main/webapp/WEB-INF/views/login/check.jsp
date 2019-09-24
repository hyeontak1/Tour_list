<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로그인 페이지</title>
</head>
<body>
<c:if test="${output == null}">
<form action="${pageContext.request.contextPath}/login/check_ok.do">
<div>
<label for="id">아이디</label>
<input type="text" id="id" name="id"/>
</div>
<div>
<label for="password">패스워드</label>
<input type="password" id="password" name="password"/>
</div>
<button type="submit">로그인</button>
</form>
</c:if>
<c:if test="${output != null}">
<form action="${pageContext.request.contextPath}/login/logout.do">
<div>${output.name}님 환영합니다.</div>
<button type="submit">로그아웃</button>
</form>
</c:if>
</body>
</html>