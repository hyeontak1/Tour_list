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
<script>
$(document).ready(function(){
	$("#btnLogin").click(function(){
		// 태크.val() : 태그에 입력된 값
		// 태크.vla("값") : 태그의 값을 변경
		var id = $("#id").val();
		var password = $("#password").val();
		if(id == "") {
			alert("아이디를 입력하세요.");
			$("#id").focus(); // 입력 포커스 이동
			return; // 함수 종료
		}
		if(password == "") {
			alert("비밀번호를 입력하세요.");
			$("#password").focus();
			return;
		}
		// 폼 내부의 데이터를 전송할 주소
		document.form1.action="${path}/tour_list/loginCheck.do"
		// 제출
		document.form1.submit();
	});
});
</script>
</head>
<body>
<%@ include file="../login/menu.jsp" %>
<h2>로그인</h2>
<form name="form1" method="post">
<table border="1" width="400px">
<tr>
<td>아이디</td>
<td><input name="id" id="id"></td>
</tr>
<tr>
<td>비밀번호</td>
<td><input type="password" name="password" id="password"></td>
</tr>
<tr>
<td colspan="2" align="center">
<button type="button" id="btnLogin">로그인</button>
<c:if test="${msg == 'failure'}">
<div style="color: red">
아이디 또는 비밀번호가 일치하지 않습니다.
</div>
</c:if>
<c:if test="${msg == 'logout'}">
<div sttle="color: red">
로그아웃되었습니다.
</div>
</c:if>
</td>
</tr>
</table>
</form>
</body>
</html>