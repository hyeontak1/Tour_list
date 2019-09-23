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
<title>회원가입</title>
</head>
<body>
		<h1>회원가입</h1>
		<form method="post" action="${pageContext.request.contextPath}/member/add_ok.do">
			<div>
				<label for ="id">아이디</label>
				<input type ="text" name="id" id="id" />
			</div>
			<div>
				<label for ="password">패스워드</label>
				<input type ="text" name="password" id="password" />
			</div>
			
			<div>
				<label for ="name">이름</label>
				<input type ="text" name="name" id="name" />
			</div>	
			
			<div>
				<label for ="gender">성별</label>
				<input type ="text" name="gender" id="gender" />
			</div>	
			
			<div>
				<label for ="birth">생년월일</label>
				<input type ="text" name="birth" id="birth" />
			</div>	
			
			<div>
				<label for ="mail">이메일</label>
				<input type ="text" name="mail" id="mail" />
			</div>
			
			<div>
				<label for ="phone">핸드폰번호</label>
				<input type ="text" name="phone" id="phone" />
			</div>	
			
			<div>
				<label for ="address">주소</label>
				<input type ="text" name="address" id="address" />
			</div>
			
			<div>
				<label for ="reg">가입날짜</label>
				<input type ="text" name="reg" id="reg" />
			</div>				
			<hr/>
			
			<button type="submit">저장하기</button>
			<button type="reset">다시작성</button>
		</form>
</body>
</html>