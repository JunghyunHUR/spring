<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="board.BBSDTO, java.util.*"    
%>
<%@ include file="include/header.jsp" %>
<jsp:useBean id="bbs" class="board.BBSDDL" scope="page" />
<jsp:useBean id="dto" class="board.BBSDTO" scope="page" />
<%
	Vector data = bbs.getSelect(0, 6);
%>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-6 my-5">
            <h2 class="text-center">공지사항</h2>
            <ol class="list-group list-group-numbered">
                <%
                for(int i = 1; i <= 5; i++){
                %>
                <li class="list-group-item list-group-item-action">
                    <a href="#">공지사항<%= i %> 입니다.</a>
                </li>
                <%
                }
                %>
            </ol>
            
            <h2 class="text-center mb-4 mt-4">자유게시판</h2>
            <ol class="list-group list-group-numbered">
                <%
                for(int i = 1; i <= 5; i++){
                	BBSDTO dt = (BBSDTO) data.elementAt(i);
					int num = dt.getNum();
					int count = dt.getCount();
					String title = dt.getTitle();
                %>
                <li class="list-group-item list-group-item-action">
                    <a href="/board/Count?num=<%= num%>&count=<%= count%>"><%= title %> </a>
                </li>
                <%
                }
                %>
            </ol>
        </div>
        <div class="col-md-6 col-6 my-5">
            <h2 class="text-center mb-4">갤러리</h2>
            <div class="row">
                <div class="col-md-4 col-4">
                    <figure class="card card-product">
                        <div class="img-wrap"><img src="images/001.jpg" class="img-thumbnail" alt="image"></div>
                        <figcaption class="info-wrap p-3">
                            <h5 class="title">Another name of item</h5>
                            <p class="desc">Some small description gose here</p>
                        </figcaption>
                    </figure>
                </div>
                <div class="col-md-4 col-4">
                    <figure class="card card-product">
                        <div class="img-wrap"><img src="images/002.jpg" class="img-thumbnail" alt="image"></div>
                        <figcaption class="info-wrap p-3">
                            <h5 class="title">Another name of item</h5>
                            <p class="desc">Some small description gose here</p>
                        </figcaption>
                    </figure>
                </div>
                <div class="col-md-4 col-4">
                    <figure class="card card-product">
                        <div class="img-wrap"><img src="images/003.jpg" class="img-thumbnail" alt="image"></div>
                        <figcaption class="info-wrap p-3">
                            <h5 class="title">Another name of item</h5>
                            <p class="desc">Some small description gose here</p>
                        </figcaption>
                    </figure>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="include/footer.jsp" %>