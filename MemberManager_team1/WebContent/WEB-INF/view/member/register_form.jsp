<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>회원가입</title>
</head>
<body>
${param["failMessage"] } 
<form action="/MemberManager_team1/controller" method="post">
	<input type="hidden" name="command" value="register">
	<table>
	
		<tr>
			<td><b>회원가입</b></td>
		</tr>
		<tr>
			<td><input type="text" name="id" size="30" placeholder="아이디" required="required"></td>
		</tr>
		<tr>
			<td><input type="password" name="password" size="30" placeholder="비밀번호" required="required"></td>
		</tr>
		<tr>
			<td><input type="text" name="name" size="30" placeholder="이름" required="required"></td>
		</tr>
		<tr>
			<td><input type="email" name="email" size="30" placeholder="E-mail" required="required"></td>
		</tr>
		<tr>
			<td><input type="submit" value="회원가입"></td>
		</tr>
	
	</table>
</form>
</body>
</html>