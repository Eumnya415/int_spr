<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-01-05
  Time: 오후 2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<form action="/student/login" method="post">
<p>ID : <input type="text" name="memberId" placeholder="아이디를 입력하세요" required autofocus></p>
<p>PW : <input type="password" name="memberPassword" placeholder="비밀번호를 입력하세요" required></p>
    <input type="submit" value="로그인">
</form>
</body>
</html>
