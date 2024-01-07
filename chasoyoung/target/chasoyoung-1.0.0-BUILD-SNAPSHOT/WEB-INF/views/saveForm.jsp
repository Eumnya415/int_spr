<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<head>
    <title>학생등록</title>
</head>
<body>
<h1>학생 등록</h1>
<a href="/student/studentList">홈</a>
<form action="/student/save" method="post">
    <p>학번 : <input type="text" name="studentId" placeholder="학번을 입력하세요." required autofocus></p>
    <p>이름 : <input type="text" name="studentName" placeholder="이름을 입력하세요." required ></p>
    <p>국어 : <input type="number" min="0" max="100" name="korean" placeholder="국어 점수를 입력하세요." required ></p>
    <p>영어 : <input type="number" min="0" max="100" name="english" placeholder="영어 점수를 입력하세요." required ></p>
    <p>수학 : <input type="number" min="0" max="100" name="math" placeholder="수학 점수를 입력하세요." required ></p>
    <input type="submit" value="입력"><button type="button" onclick="" value="초기화">초기화</button>
</form>
</body>
</html>
