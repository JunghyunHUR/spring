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
<link rel="stylesheet" href="resources/css/summernote-bs4.min.css">
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
    <h1 class="text-center m-5">MY SPBBS</h1>
    <div class="container">
        <form class="row was-validated" name="update_form" action="updateok" method="post">
            <div class="col-md-6">
                <label>이름</label>
                <input type="text" name="uname" class="form-control" placeholder="이름" value="${update.uname }" required/>
                <div class="invalid-feedback">이름을 입력하세요.</div>
            </div>
            <div class="col-md-6">
                <label>비밀번호</label>
                <input type="text" name="upass" class="form-control" placeholder="비밀번호" value="${update.upass }" required/>
                <div class="invalid-feedback">비밀번호를 입력하세요.</div>
            </div>
            <div class="col-md-12">
                <label>제목</label>
                <input type="text" name="title" class="form-control" placeholder="제목" value="${update.title }" required/>
                <div class="invalid-feedback">제목을 입력하세요.</div>
            </div>
            <div class="col-md-12">
                <textarea name="content" id="content">${update.content }</textarea>
            </div>
            <input type="hidden" name="num" value="${update.num }">
            <input type="hidden" name="s_group" value="${update.s_group }">
            <input type="hidden" name="s_step" value="${update.s_step}">
            <input type="hidden" name="s_indent" value="${update.s_indent }">
            <div class="col-12 text-center">
                <a href="list" class="btn btn-danger"> 취 소 </a> &nbsp;&nbsp;&nbsp;&nbsp;
                <button type="submit" class="btn btn-primary"> 전 송 </button>
            </div>
        </form>
    </div>


    <script src="resources/js/jquery.min.js"></script>
    <script src="resources/js/popper.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/summernote-bs4.min.js"></script>
    <script src="resources/js/script.js"></script>
</body>
</html>