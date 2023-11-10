<%@page import="kr.or.ddit.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정하기</title>
</head>
<body>
<%
	Board board = (Board)request.getAttribute("board");
%>
<h1>게시물 수정</h1>
<hr>
<form action="<%=request.getContextPath()%>/board/boardUpdate.do" method="post">
	<input type="hidden" name="bo_no" value="<%=board.getBo_no()%>">
	<table border="1">
		<tr>
			<th>제목</th>
			<td> <input type="text" name="bo_title" value="<%=board.getBo_title()%>"> </td>
		</tr>
		<tr>
			<th>작성자</th>
			<td> <input type="text" name="bo_writer" value="<%=board.getBo_writer()%>"> </td>
		</tr>
		<tr>
			<th>내용</th>
			<td> <textarea rows="10" cols="40" name="bo_content"><%=board.getBo_content()%></textarea> </td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정">
				<input type="button" value="게시판" onclick="goList()">
			</td>
		</tr>
	</table>
</form>
</body>
</html>