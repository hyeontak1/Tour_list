<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page trimDirectiveWhitespaces="true" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>카카오 이미지 검색</h1>
		<form name ="form1" method ="get" 
		action="${pageContext.request.contextPath}/retrofit/kakao_image_search.do">
		<label for ="query">검색어:</label>
		<input type="search" id ="query" name="query" value="${query}" />
		<input type="submit" value="검색">		
		</form>
		    <c:if test="${image!=null && fn:length(image.documents) > 0}">
		<hr />
		<table border="1">
		 <c:forEach var="item" items="${image.documents}" varStatus="status"> 
		     <c:if test="${status.index % 4==0}">
		         <tr>            
		         </c:if>            
		         <td><a href="${item.doc_url}"><img src="${item.thumbnail_url}" /></a></td>           
		          <c:if test="${(status.index+1) % 4==0}">
		        	</tr>
		          </c:if>
		         </c:forEach> 
		
		
		
		</table>
		
		</c:if>
	
</body>
</html>