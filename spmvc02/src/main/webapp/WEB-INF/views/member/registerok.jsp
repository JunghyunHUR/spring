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
		<ul class="register">
			<li>
				<label for="userId">아이디</label>
				${ register.userId }
			</li>
			<li>
				<label for="userPass">비밀번호</label>
				${ register.userPass }
			</li>
			<li>
				<label for="userName">이름</label>
				${ register.userName }
			</li>
			<li>
				<label for="userEmail">이메일</label>
				${ register.userEmail }
			</li>
			<li>
				<label for="userMobile">전화번호</label>
				${ register.userMobile }
			</li>
		</ul>
	</div>
</body>
</html>