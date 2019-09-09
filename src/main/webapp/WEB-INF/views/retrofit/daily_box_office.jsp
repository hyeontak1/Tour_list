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
<link rel="stylesheet" type="text/css"
   href="${pageContext.request.contextPath}/assets/billboard.min.css" />
</head>
<body>
   <h1>"${targetDt}"박스오피스</h1>
   <form name="form1" method="get"
      action="${pageContext.request.contextPath}/retrofit/daily_box_office.do">
      <label for="targetDt">검색일: </label> <input type="date" id="date"
         name="date" value="${date}" /> <input type="submit" value="검색" />
   </form>

   <hr />

   <!-- 비교 없어도 됨 -->
   <c:if test="${list != null && fn:length(list) > 0}">
   <!-- ----- -->
   
      <table border="1">
         <thead>
            <tr>
               <th>순위</th>
               <th>제목</th>
               <th>개봉일</th>
               <th>누적매출액</th>
               <th>오늘관객수</th>
               <th>누적관객수</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach var="item" items="${list}" varStatus="status">
               <tr>
                  <td>"${item.rank}"</td>
                  <td>"${item.movieNm}"</td>
                  <td>"${item.openDt}</td>
                  <td><fmt:formatNumber value="${item.salesAcc}" pattern="#,###" />원</td>
                  <td><fmt:formatNumber value="${item.audiCnt}" pattern="#,###" />명</td>
                  <td><fmt:formatNumber value="${item.audiAcc}" pattern="#,###" />명</td>
               </tr>
            </c:forEach>
         </tbody>
      </table>
   </c:if>
</body>
</html>