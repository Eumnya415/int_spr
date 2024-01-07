<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<head>
    <title>학생등록</title>
</head>
<body>
<h1>학생 등록</h1>
<a href="/student/studentList">홈</a>
<form action="/student/update" method="post">
    <p>학번 : <input type="text" name="studentId" value="${student.studentId}" readonly></p>
    <p>이름 : <input type="text" name="studentName" value="${student.studentName}" readonly></p>
    <p>국어 : <input type="number" min="0" max="100" name="korean" value="${student.korean}" placeholder="국어 점수를 입력하세요." required ></p>
    <p>영어 : <input type="number" min="0" max="100" name="english" value="${student.english}" placeholder="영어 점수를 입력하세요." required ></p>
    <p>수학 : <input type="number" min="0" max="100" name="math" value="${student.math}" placeholder="수학 점수를 입력하세요." required ></p>
    <input type="submit" value="수정하기"><button type="button" onclick="deleteStudent(${student.studentId})" value="삭제">삭제</button>
</form>
</body>
<script>
    const deleteStudent = (studentId) => {
        console.log(studentId)
        location.href = "/student/delete?studentId=" + studentId
    }
</script>
</html>
