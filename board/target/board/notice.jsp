<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%! String fname = null; %>
<%	
		fname = request.getParameter("fname");
		if(fname == null || "null".equals(fname)){
			fname = "main.jsp";
		}else{
			fname += ".jsp";
		}
%>	
<%@ include file="include/header.jsp" %>
<div class="container">
	<h2>공지사항</h2>
	<table class="table table-striped noticetbl">
		<thead>
			<tr>
				<th class="col-1">No.</th>
				<th class="col-7 text-center">제목</th>
				<th class="col-1">글쓴이</th>
				<th class="col-1">조회수</th>
				<th class="col-1">댓글수</th>
				<th class="col-1">작성시간</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>num</td>
				<td class="text-center"><a href="#">title</a></td>
				<td>userid</td>
				<td>count</td>
				<td>reply</td>
				<td>wdate</td>
			</tr>
		</tbody>
	</table>
	<div class="write-box text-end">
		<a href="#" class="btn btn-primary">글쓰기</a>
	</div>
</div>
<%@ include file="include/footer.jsp" %>