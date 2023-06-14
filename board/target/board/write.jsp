<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, board.MembersDTO"
%>
<jsp:useBean id="mem" class="board.MemberDDL" scope="page" />
<jsp:useBean id="dto" class="board.MembersDTO" scope="page" />

<%
	String user = (String) session.getAttribute("user");
	Vector data = mem.getSelect(user);
	int size = data.size();
	for(int i = 0; i < size; i++){
		MembersDTO dt = (MembersDTO)data.elementAt(i);
		pageContext.setAttribute("dto", dt);
	}
%>
<style>
	#title{
		width: 100%;
		margin: 20px 0 10px;
	}
	.textarea-box{
		margin: 10px 0 20px;
	}
    textarea{
        display: block;
        width: 100%;
        height: 300px;
    }
    .write-btn-box{
    	float: right;
    }
    button{
    	margin-top: 10px;
        margin-right: 35px;
    }
</style>
<%@ include file="include/header.jsp" %>
<div class="container">
    <h1>게시판 글쓰기</h1>
    <form name="boardfrom" class="boardform" action="/board/WriteOk" method="post">
        <input type="text" id="title" name="title" placeholder="제목">
        <div class="textarea-box">
	        <textarea name="content" id="content"></textarea>
        </div>
        <input type="hidden" name="userid" id="userid" value="${ dto.userid }">
        <input type="hidden" name="userpass" id="userpass" value="${ dto.userpass }">
        <input type="hidden" name="username" id="username" value="${ dto.username }">
        <input type="hidden" name="useremail" id="useremail" value="${ dto.useremail }">
        <input type="hidden" name="uip" id="uip" value="${ dto.uip }">
        <div class="write-btn-box">
            <button type="button" class="btn btn-primary" onclick="writeBoard()">글쓰기</a>
        </div>
    </form>
</div>
<%@ include file="include/footer.jsp" %>