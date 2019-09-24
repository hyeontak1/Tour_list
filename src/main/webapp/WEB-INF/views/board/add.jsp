<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="include-header.jsp"%>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/board/add_ok.do">
		<table class="view">
			<colgroup>
				<col width="15%">
				<col width="*" />
			</colgroup>
			<caption>게시글 작성</caption>
			<tbody>
				<tr>
					<th scope="row">제목</th>
					<td><input type="text" id="title" name="title" class="wdp_90"></input></td>
				</tr>
				<tr>
					<td colspan="2" class="view_text"><textarea rows="20"
							cols="100" title="내용" id="content" name="content"></textarea></td>
				</tr>
			</tbody>
		</table>
		<button type="submit">저장하기</button>
		<button type="reset">다시작성</button>	
	</form>
	<%@ include file="include-body.jsp"%>

</body>
</html>
