<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학점관리</title>
</head>
<body>
<h1>학점관리</h1>

<table border="1px">
    <tr>
        <th>학번</th>
        <th>이름</th>
    </tr>
    <c:forEach items="${studentList}" var="student">
    <tr>
        <td><a href="/student/update?studentId=${student.studentId}">${student.studentId}</a></td>
        <td>${student.studentName}</td>
    </tr>
    </c:forEach>
</table>
<a href="/student/login">로그인</a>
<a href="/student/save">학생등록</a>

</body>
</html>
