<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
   <h1>카카오 책 검색</h1>
   <form name="form1" method="get"
      action="${pageContext.request.contextPath}/retrofit/kakao_book_search.do">
      <label for="query">검색어: </label> <input type="search" id="query"
         name="query" value="${query}"> <input type="submit"
         value="검색어" />
   </form>

   <c:if test="${book != null && fn:length(book.documents) > 0}">
      <hr />
      <table border="1">
         <c:forEach var="item" items="${book.documents}" varStatus="status">
            <tr>
               <td><a href="${item.url}"><img src="${item.thumbnail}"
                     height="150" /></a></td>
               <td>
                  <h3>
                     <a href="${item.url}" target="_blank">${item.title}</a>
                  </h3>
                  <ul>
                     <li>정가: <fmt:formatNumber value="${item.price}"
                           pattern="#,###" />원
                     </li>
                     <li>판매가: <fmt:formatNumber value="${item.salePrice}"
                           pattern="#,###" />원
                     </li>
                     <li>저자: ${fn:join(item.authors, ",")}</li>
                     <li>출판사: ${item.publisher}</li>
                  </ul>
               </td>
            </tr>
         </c:forEach>
      </table>
   </c:if>
</body>
</html>