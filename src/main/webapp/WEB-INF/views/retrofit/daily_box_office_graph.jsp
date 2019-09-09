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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/billboard.min.css" />
</head>
<body>
	<h1>${targetDt}박스오피스</h1>
	<form name="form1" method="get"
		action="${pageContext.request.contextPath}/retrofit/daily_box_office_graph.do">
		<label for="targetDt">검색일 : </label> <input type="date" id="date"
			name="date" value="${date}" /> <input type="submit" value="검색" />
	</form>
	<hr />
	<div id="barChart" style="width: 1024px; height: 600px"></div>
	<script src="//􏰁d3js.org/d3.v5.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/billboard.min.js"></script>
	<script>
		var chart = bb.generate({
		
		/** 그래프가 표시될 HTML 태그의 id값 지정 */
		bindto: "#barChart",

		/** 데이터설정 􏰆*/
		data: {
			// 데이터들 설정 [이름, 값1, 값2, 값3, ..., 값n]
			columns: [['영화제목', ${movieNmStr}], ['관람객수', ${audiCntStr}]],
			x: '영화제목',			// x축으로 사용할 데이터의 이름
			types: {
				"관람객수": "bar" // 그래프 종류 (데이터이름: 종류 )
			}
		},

		/** x, y축의 특성 설정 􏰆*/
		axis: {
			// x축 설정
			x: {
				type: "category", // 􏰁 종류(timeseries, category, indexed)
				height: 150,	  //  􏰁x축 텍스트 영역의 높이	
				tick: {			  //  x축의 텍스트 속성
					rotate: -45,
					multiline: false 
					}
				}
			}
		});
    </script>
</body>
</html>