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
			<td>직업</td>
			<td>${requestScope.info.job }</td>
		</tr>	
		<tr>
			<td>나이</td>
			<td>${requestScope.info.age }</td>
		</tr>	
		<tr>
			<td>성별</td>
			<td>${requestScope.info.sex?"여성":"남성"}</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${requestScope.info.phoneNumber }</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${requestScope.info.address }</td>
		</tr>
	</table>
	<a href="/BankSystem_FrontController/controller?command=link&path=/WEB-INF/view/member/login_form.jsp">로그인 하기</a>
</body>
</html>