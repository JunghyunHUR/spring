<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.*, board.DBConnect, java.net.*, java.util.*, board.MembersDTO"
%>

<jsp:useBean id="mem" class="board.MemberDDL" scope="page" />
<jsp:useBean id="mdto" class="board.MembersDTO" scope="page" />
<jsp:useBean id="bbs" class="board.BBSDDL" scope="page" />
<jsp:useBean id="bdto" class="board.BBSDTO" scope="page" />
<%!
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = "";
%>
<%
	String user = (String) session.getAttribute("user");
	Vector data = mem.getSelect(user);
	int size = data.size();
	for(int i = 0; i < size; i++){
		MembersDTO dt = (MembersDTO)data.elementAt(i);
		pageContext.setAttribute("mdto", dt);
	}
%>
<style>
		section{
		margin-bottom: 50px;
		}
		.header{
			border-bottom: 2px solid #333;
		}
		.title-box{
			padding: 15px 0 10px;
			border-bottom: 2px solid #333;
		}
		.title{
			margin: 0;
		}
		.content-box{
			padding: 30px 20px;
			border-bottom: 2px solid #333;
			margin-bottom: 10px;
		}
		.content-info{
			display: flex;
			justify-content: space-between;
			font-size: 13px;
		}
		textarea{
			width: 95%;
		}
		.reply-btn{
			float: right;
			margin-top: 10px;
		}
		.reply{
			border-top: 1px solid #777;
			padding: 15px;
			margin: 0;
		}
		.reply span{
			display: inline-block;
		}
		.reply span.date{
			text-align: end;
		}
	</style>
<%@ include file="include/header.jsp" %>
<section>
	<div class="container">
		<div class="header">
			<h3><a href="free.jsp">자유게시판</a></h3>
		</div>
	<%
	conn = 	new DBConnect().getConn();
	String param = URLDecoder.decode(request.getParameter("num"));
	sql = "select * from bbs where num=?";
	try{
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, param);
		rs = pstmt.executeQuery();
			
		if(rs.next()){
			%>
				<div class="title-box">
					<h2 class="title"><%=  rs.getString("title") %></h2>
					<div class="content-info">
						<span class="info">작성자 : <%= rs.getString("userid") %> | <%= rs.getString("wdate") %></span>
						<span class="info">조회수 <%= rs.getInt("count") %> | 댓글수 <%= rs.getInt("reply") %></span>
					</div>
				</div>
				<div class="content-box">
					<%= rs.getString("content") %>
				</div>
				
				<%
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null)try{rs.close();}catch(SQLException e){}
			if(pstmt != null)try{pstmt.close();}catch(SQLException e){}
			if(conn != null)try{conn.close();}catch(SQLException e){}
		}
		%>
		<h5>전체 댓글</h5>
		<div class="replybox">
		<%
		param = URLDecoder.decode(request.getParameter("num"));
		sql = "select * from comment where bbsnum = " + param;
		conn = 	new DBConnect().getConn();
		try{
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				String username = rs.getString("username");
				if(username.isEmpty() || username == null || username == ""){
		%>
			<p class="reply"><span class="col-1">익명</span><span class="col-9"> <%= rs.getString("comment") %></span><span class="col-2 date"> <%= rs.getString("wdate") %></span></p>
		<%
				}else{
					%>
			<p class="reply"><span class="col-1"><%= username %></span><span class="col-9"> <%= rs.getString("comment") %></span><span class="col-2 date"> <%= rs.getString("wdate") %></span></p>
					<%
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null)try{rs.close();}catch(SQLException e){}
			if(stmt != null)try{stmt.close();}catch(SQLException e){}
			if(conn != null)try{conn.close();}catch(SQLException e){}
		}
		%>
		</div>
		<%
		conn = 	new DBConnect().getConn();
		param = URLDecoder.decode(request.getParameter("num"));
		sql = "select * from bbs where num=?";
		try{
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, param);
			rs = pstmt.executeQuery();
			if(rs.next()){
		%>
		<form name="replyform" id="replyform" action="/board/Comment?num=<%= rs.getInt("num") %>&reply=<%= rs.getInt("reply") %>" method="post">
		<%
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null)try{rs.close();}catch(SQLException e){}
			if(pstmt != null)try{pstmt.close();}catch(SQLException e){}
			if(conn != null)try{conn.close();}catch(SQLException e){}
		}
		%>				
			<textarea name="comment" id="comment"></textarea>
			<input type="hidden" name="userid" id="userid" value="${ mdto.userid }">
        	<input type="hidden" name="userpass" id="userpass" value="${ mdto.userpass }">
			<div class="reply-btn">
				<button type="submit" class="btn btn-primary">댓글</button>
			</div>
		</form>
	</div>
</section>
	<%@ include file="include/footer.jsp" %>