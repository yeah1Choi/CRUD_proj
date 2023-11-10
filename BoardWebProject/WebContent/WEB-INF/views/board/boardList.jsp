<%@page import="kr.or.ddit.vo.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script type="text/javascript">
function goAdd(){
	location.href = "<%=request.getContextPath()%>/board/boardAdd.do";
}
</script>
</head>
<body>
<%
	List<Board> list = (List<Board>)request.getAttribute("boardList");
%>
<h1>게시판</h1>
<hr>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
	<%
	if(list == null || list.size() == 0){
	%>
	<tr>
		<td colspan="5">
			<p>조회하실 게시물이 존재하지 않습니다.</p>
		</td>
	</tr>
	<%
		} else {
			for(Board board : list){
	%>
	<tr>
		<td><a href="<%=request.getContextPath()%>/board/boardDetail.do?bo_no=<%=board.getBo_no()%>"><%=board.getBo_no()%></a></td>
		<td><%=board.getBo_title()%></td>
		<td><%=board.getBo_writer()%></td>
		<td><%=board.getBo_date()%></td>
		<td><%=board.getBo_hit()%></td>
	</tr>
	<%
			}		
		}
	%>
	<tr>
		<td colspan="5"> <input type="button" value="등록" onclick="goAdd()"> </td>
	</tr>
</table>
</body>
</html>