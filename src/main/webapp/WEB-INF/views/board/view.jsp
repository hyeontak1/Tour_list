<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
 	<h1>게시글</h1>
 	<p>번호:${output.idBoard }</p>
 	<p>제목:${output.title }</p>
 	<p>내용:${output.write }</p>
 	<hr/>
 	<a href="${pageContext.request.contextPath}/board/list.do">[목록보기]</a>
 	<a href="${pageContext.request.contextPath}/board/add.do">[학과추과]</a>
 	<a href="${pageContext.request.contextPath}/board/edit.do?idBoard=${output.idBoard}">[학과수정]</a>
 	<a href="${pageContext.request.contextPath}/board/delete_ok.do?idBoard=${output.idBoard}">[학과삭제]</a>
</body>
</html>