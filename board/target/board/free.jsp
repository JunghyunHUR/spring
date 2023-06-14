<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, board.BBSDTO, board.DBConnect, java.net.*, java.sql.*"%>

<jsp:useBean id="bbs" class="board.BBSDDL" scope="page" />
<jsp:useBean id="dto" class="board.BBSDTO" scope="page" />
<%!	

	int listNum = 15; //한 페이지당 보여줄 목록 수
	int pageNum = 5; //한 블럭당 보여줄 페이지 수

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = "";
%>
<%
String pg = request.getParameter("page");
int mypg = 1;
try {
	mypg = Integer.parseInt(pg);
	if (mypg < 1) {
		mypg = 1;
	}
} catch (Exception t) {
	mypg = 1;
}
int limitNum = (mypg - 1) * listNum;

Vector data = bbs.getSelect(limitNum, listNum);

int maxColumn = bbs.getAllSelect();
int size = data.size();

/*
	1. 전체페이지 수 2. 전체블럭 수 3. 현재 블럭번호 4. 블럭당 시작번호 5. 블럭당 마지막 번호
*/
//1. 전체 페이지 수
int totalPage = (int) Math.ceil(maxColumn / (double) listNum);

//2. 전체 블럭 수
int totalBlock = (int) Math.ceil(totalPage / (double) pageNum);

//3. 현재 블럭 번호
int nowBlock = (int) Math.ceil(mypg / (double) pageNum);

//4. 블럭당 시작페이지 번호
int startNum = (nowBlock - 1) * pageNum + 1;

//5 블럭당 마지막 페이지 번호
int endNum = nowBlock * pageNum;
if (endNum > totalPage)
	endNum = totalPage;
%>

<%@ include file="include/header.jsp" %>
<div class="container">
	<h2>자유게시판</h2>
	<div class="row">
		<table class="table table-striped noticetbl">
			<thead>
				<tr>
					<th class="col-1">No.</th>
					<th class="col-6 text-center">제목</th>
					<th class="col-1 text-center">글쓴이</th>
					<th class="col-1 text-center">조회수</th>
					<th class="col-1 text-center">댓글수</th>
					<th class="col-2 text-center">작성시간</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < size; i++) {
					BBSDTO dt = (BBSDTO) data.elementAt(i);
					int num = dt.getNum();
					String title = dt.getTitle();
					String userid = dt.getUserid();
					int count = dt.getCount();
					String wdate = dt.getWdate();
					int reply = dt.getReply();
				%>
				<tr>
					<td><%=num%></td>
					<td class="text-center"><a href="/board/Count?num=<%= num%>&count=<%= count%>"><%=title%></a></td>
					<td class="text-center">
					<%if(userid == null || userid == "" || userid.isEmpty()){ %>
						익명
					<%}else {%>
					<%=userid%>
					<%} %>
					</td>
					<td class="text-center"><%=count%></td>
					<td class="text-center"><%=reply%></td>
					<td class="text-center"><%=wdate%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	<div class="write-box text-end">
		<a href="write.jsp" class="btn btn-primary">글쓰기</a>
	</div>
	</div>
	<div class="my-5 row mb-5">
		<ul class="pagination justify-content-center mb-5">
			<%
			//이전 페이지 출력
			//if(mypg > 1){
				if(startNum <= 1){
					out.print("<li class='page-item'><a href=\"?page=1\" class=\"page-link\">이전</a></li>");
				}else{
					int prevPage = startNum - 1;
					out.print("<li class='page-item'><a href=\"?page="+ prevPage +"\" class=\"page-link\">이전</a></li>");
				}
				if(mypg > 1){
%>
					<li class='page-item'><a href="?page=<%= mypg - 1 %>" class="page-link">&lt;</a></li>
<%
				}else{
%>	
					<li class='page-item'><a href="?page=<%= mypg %>" class="page-link">&lt;</a></li>
<%
				}
				//}
				//페이지 출력
				for(int i = startNum; i <= endNum; i++){
					String active = "";
					if(mypg == i){
						active = "active";
					}
%>
					<li class="page-item <%= active%>"><a href="?page=<%= i %>" class="page-link"><%= i %></a>
<%
				}
				//if(mypg < totalPage){
					if(mypg >= totalPage){
						mypg = totalPage;
%>
						<li class='page-item'><a href="?page=<%= mypg%>" class="page-link">&gt;</a></li>
<%
					}else{
%>
						<li class='page-item'><a href="?page=<%= mypg + 1 %>" class="page-link">&gt;</a></li>
<%
					}
					//다음 페이지 출력
					if(startNum >= totalPage){
						out.print("<li class='page-item'><a href=\"?page="+ totalPage +"\" class=\"page-link\">다음</a></li>");
					}else{
						int nextPage = endNum + 1;
						if(nextPage > totalPage){
							nextPage = totalPage;
						}
						out.print("<li class='page-item'><a href=\"?page="+ nextPage+"\" class=\"page-link\">다음</a></li>");
					}
				//}
%>		
		</ul>
	</div>
</div>

<%@ include file="include/footer.jsp" %>