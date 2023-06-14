<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/mvc02/resources/style.css">
</head>
<body>
	<h1 class="text-center">회원가입</h1>
	<div class="container">
		<form name="form" action="registerok.do" method="post">
			<ul class="register">
				<li>
					<label for="userId">아이디</label>
					<input type="text" name="userId">
				</li>
				<li>
					<label for="userPass">비밀번호</label>
					<input type="password" name="userPass">
				</li>
				<li>
					<label for="userName">이름</label>
					<input type="text" name="userName">
				</li>
				<li>
					<label for="userEmail">이메일</label>
					<input type="text" name="userEmail">
				</li>
				<li>
					<label for="userMobile">전화번호</label>
					<input type="text" name="userMobile">
				</li>
			</ul>
			<div class="text-center btnbox">
				<button type="reset"> 취 소 </button>
				<button type="submit"> 전 송 </button>
			</div>
		</form>
	</div>
</body>
</html>