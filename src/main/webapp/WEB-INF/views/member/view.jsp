
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>회원가입</h1>
		<p>아이디: ${output.id}</p>
		<p>패스워드: ${output.password}</p>
		<p>이름: ${output.name}</p>
		<p>성별: ${output.gender}</p>
		<p>생년월일: ${output.birth}</p>
		<p>이메일: ${output.mail}</p>
		<p>핸드폰번호: ${output.phone}</p>
		<p>주소: ${output.address}</p>
		<p>가입날짜: ${output.reg}</p>

		<hr/>

		<a href="${pageContext.request.contextPath}/member/add.do">[회원가입]</a>

		
</body>
</html>