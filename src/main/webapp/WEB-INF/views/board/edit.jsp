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
<title>게시글 수정</title>
</head>
<body>
	<h1>게시글 수정</h1>
	<form method="post" action="${pageContext.request.contextPath }/board/edit_ok.do">
		<input type="hidden" name="idBoard" value="${output.deptno}"/>
		<div>
			<label for="title">제목: </label>
			<input type="text" name="title" id="title" value="${output.title}"/>
		</div>
		<div>
			<label for="write">"내용": </label>
			<input type="text" name="write" id="write" value="${output.write}"/>
		</div>
		<hr/>
		<button type="submit">저장하기</button>
		<button type="reset">다시작성</button>
	</form>
</body>
</html>