<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
    <div class="container detail">
        <h3 class="text-center">${detail.title }</h3>
        <div class="row">
            <div class="col-md-4">
                <label>글쓴이 : </label> ${detail.uname}
            </div>
            <div class="col-md-4">
                <label>날짜 : </label> ${detail.wdate}
            </div>
            <div class="col-md-4">
                <label>조회수 : </label> ${detail.hit}
            </div>
        </div>
        <div class="detailview border border-gray p-5">
            ${detail.content}
        </div>
    </div>
    <div class="container mt-2">
        <div class="row justify-content-flex-end button-group">
            <a href="list" class="btn btn-primary">목록보기</a>
            <a href="write" class="btn btn-success">글쓰기</a>
            <a href="reply?num=${detail.num }" class="btn btn-warning">답글달기</a>
            <a href="update?num=${detail.num }" class="btn btn-danger">수정하기</a>
            <a href="del?num=${detail.num }" class="btn btn-warning">삭제</a>
        </div>
    </div>
</body>
</html>