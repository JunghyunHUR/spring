<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ teglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>login</h1>
    <c:if test="${param.error }">
    <p style="color:red">아이디 또는 비밀번호가 틀렸습니다.</p>
    </c:if>
    <form action="login" method="post">
        <label for="userid">아이디</label>
        <input type="text" name="userid" id="userid">
        <br />
        <label for="userpass">비밀번호</label>
        <input type="password" name="userpass" id="userpass">
        <br>
        <input type="submit" value=" 전 송 " />
    </form>

</body>
</html>