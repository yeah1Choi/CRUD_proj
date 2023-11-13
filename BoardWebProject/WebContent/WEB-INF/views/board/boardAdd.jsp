<%@page import="kr.or.ddit.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록하기</title>
<style type="text/css">
	td, th {
		padding: 10px;
	}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
function goList(){
	location.href = "<%=request.getContextPath()%>/board/boardList.do"
}
</script>
</head>
<body>
<h1>게시물 등록</h1>
<hr><br>
<form action="<%=request.getContextPath()%>/board/boardAdd.do" method="post">
	<table border="1">
		<tr>
			<th>제목</th>
			<td> <input type="text" name="bo_title"> </td>
		</tr>
		<tr>
			<th>작성자</th>
			<td> <input type="text" name="bo_writer"> </td>
		</tr>
		<tr>
			<th>내용</th>
			<td> <textarea rows="10" cols="40" name="bo_content"></textarea> </td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="등록">
				<input type="button" value="게시판" onclick="goList()">
			</td>
		</tr>
	</table>
</form>
</body>
</html>