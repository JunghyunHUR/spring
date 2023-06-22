<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1 class="text-center title">목록보기</h1>
    <p class="text-center titlep">관리자 모드</p>
    <div class="container">
        <ul class="row">
	        <c:forEach var="list" items="${list }">
	        	<li class="col-6">
	                <a href="#" class="box">
	                    <img src="http://localhost:3000/images/tele.jpg" alt="${list.title }" />
	                    <article class="content">
	                        <h3>${list.title }</h3>
	                        <span>${list.categorya }</span><span>${list.categoryb }</span>
	                        <div class="wdate">
	                            <!-- 
	                             <span>2023-01-01</span><span>05:11:10</span>
	                             -->
	                             <span>${list.wdate }</span>
	                        </div>
	                        <p>
	                        	${list.content }
	                        </p>
	                    </article>
	                </a>
	            </li>
	        </c:forEach>
        <!-- 루프 -->
            <li class="col-6">
                
                <a href="#" class="box">
                    <img src="http://localhost:3000/images/tele.jpg" alt="tele" />
                    <article class="content">
                        <h3>제목입니다.</h3>
                        <span>카테고리a</span><span>카테고리b</span>
                        <div class="wdate">
                            <span>2023-01-01</span><span>05:11:10</span>
                        </div>
                        <p>
                        	Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
                            Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
                        </p>
                    </article>
                </a>
            </li>
            <li class="col-6">
                
                <a href="#" class="box">
                    <img src="http://localhost:3000/images/tele.jpg" alt="tele" />
                    <article class="content">
                        <h3>제목입니다.</h3>
                        <span>카테고리a</span><span>카테고리b</span>
                        <div class="wdate">
                            <span>2023-01-01</span><span>05:11:10</span>
                        </div>
                        <p>
                        	Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
                            Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
                        </p>
                    </article>
                </a>
            </li>
        <!-- /루프 -->
        </ul>
    </div>
</body>
</html>