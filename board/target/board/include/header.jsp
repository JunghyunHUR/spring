<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko-kr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="resource/css/bootstrap.css" />
<link rel="stylesheet" href="resource/css/style.css" />
<title>Insert title here</title>
</head>
<body>
    <header>
        <div class="container">
            <div class="row">
                <div class="col-md-5"></div>
                <div class="col-md-2 text-center">
                    <h1><a href="index.jsp" class="brand">MY BBS</a></h1>
                </div>
                <div class="col-md-5 text-end">
                    <nav class="top-nav">
                    	<c:choose>
	                   		<c:when test="${sessionScope.level == 0 || empty sessionScope.level}">
		                        <a href="index.jsp?fname=member/login">로그인</a> | 
		                        <a href="index.jsp?fname=member/register">회원가입</a>
	                   		</c:when>
	                   		
	                   		<c:otherwise>
		                        <a href="/board/Logout">로그아웃</a> | 
		                        <a href="index.jsp?fname=member/edtregister">회원수정</a>
	                   		</c:otherwise>
                   		</c:choose>
                   		<c:if  test="${sessionScope.level == 99}">
	                        <a href="index.jsp?fname=member/memberlist">회원관리</a> 
                   		</c:if>
                    </nav>
                </div>
            </div>
            <div class="row flex-center">
                <nav class="navi pb-3 text-center">
                    <a href="notice.jsp">공지사항</a>
                    <a href="gallery.jsp">갤러리</a>
                    <a href="column.jsp">컬럼게시판</a>
                    <a href="free.jsp">자유게시판</a>
                </nav>
            </div>
        </div>
    </header>