<%--jsp 페이지 헤더 선언 추가해야함 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page trimDirectiveWhitespaces="true" %>
 <%--JSTL이 제공하는 문법적 기능을"c"라는 태그를 통해 공급받겠다는 선언 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--이페이지에서 session을 사용할지 여부.기본값은 true --%>
<%@ page session="false" %>
<html>
<head>
   <title>Home</title>
<meta charset="utf-8" />
<%--"${pageContext.request.contextPath}" --%>

<link rel="stylesheet" type=" text/css" href="${pageContext.request.contextPath}/assets/css/style.css"/>
</head>

<body>
  <img src="${pageContext.request.contextPath}/assets/img/spring.png" width="320" />
<h1>   Hello world!  </h1>
<%--컨트롤러에서 model 객체를 통해 전달할 변수는 ${이름}형식으로 접근한다. --%>
<P>  The time on the server is ${serverTime}. </P>
<script type="text/css" src=" ${pageContext.request.contextPath}/assets/js/script.js"></script>
</body>
</html>