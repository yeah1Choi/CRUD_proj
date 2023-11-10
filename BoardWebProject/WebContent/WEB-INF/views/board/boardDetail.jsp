<%@page import="kr.or.ddit.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
function goUpdate(){
	var form = document.getElementById("frm");
	form.action = "<%=request.getContextPath()%>/board/boardUpdate.do"
	form.submit();
}
function goDelete(){
	var flagDel = confirm("정말로 삭제하시겠습니까? 삭제한 데이터는 되돌릴 수 없습니다.");
	
	if(!flagDel){
		return;
	}
	
	var form = document.getElementById("frm");
	form.action = "<%=request.getContextPath()%>/board/boardDelete.do"
	form.submit();
}
function goList(){
	location.href = "<%=request.getContextPath()%>/board/boardList.do"
}
</script>
</head>
<body>
<%
	Board board = (Board)request.getAttribute("board");
%>
<h1>게시물 상세보기</h1>
<hr>
<form name="frm" id="frm">
	<input type="hidden" name="bo_no" value="<%=board.getBo_no()%>">
	<table border="1">
		<tr>
			<th>번호</th>
			<td><%=board.getBo_no()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=board.getBo_title()%></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=board.getBo_writer()%></td>
		</tr>
		<tr>
			<th>날짜</th>
			<td><%=board.getBo_date()%></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><%=board.getBo_hit()%></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" onclick="goUpdate()">
				<input type="button" value="삭제" onclick="goDelete()">
				<input type="button" value="게시판" onclick="goList()">
			</td>
		</tr>
	</table>
</form>
</body>
</html>