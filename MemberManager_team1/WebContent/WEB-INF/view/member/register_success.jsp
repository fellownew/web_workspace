<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 성공</title>
</head>
<body>
	${requestScope.info.id }님 환영합니다. 회원가입에 성공하였습니다.<br/>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>${requestScope.info.id }</td>
		</tr>
		<tr>
			<td>password</td>
			<td>${requestScope.info.password }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${requestScope.info.name }</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${requestScope.info.email }</td>
		</tr>	
		<tr>
			<td>가입일자</td>
			<td>${requestScope.info.date }</td>
		</tr>	
	</table>
</body>
</html>