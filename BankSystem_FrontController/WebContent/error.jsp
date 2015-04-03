<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 발생</title>
</head>
<body>
	<font color="red">
		오류가 발생하였습니다.<br/>
		오류 내용 : ${requestScope.failMessage }<br/>
	</font>
		<a href="/BankSystem_FrontController/index.jsp">메인페이지</a>
</body>
</html>