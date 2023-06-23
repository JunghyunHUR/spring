<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Welcome!!</h1>
    <p>환영 합니다. ${userid}님!!!</p>
    <form action="logout" method="post">
        <input type="submit" value="logout" />
    </form>
</body>
</html>