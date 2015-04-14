<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통장 개설</title>
</head>
<body>
<form action="/BankSystem_FrontController/controller" method="post">
	<input type="hidden" name="command" value="createAccount">
	<table>
		<tr>
			<td><b>통장개설</b></td>
		</tr>
		<tr>
			<td><input type="text" name="id" size="30" placeholder="통장번호" required="required" maxlength="10" autofocus="autofocus"></td>
		</tr>
		<tr>
			<td><input type="password" name="password" size="30" placeholder="비밀번호" required="required" maxlength="20"></td>
		</tr>
		<tr>
			<td>
			통장종류 : <select name="type">
			<option value=${requestScope.type }/>
			</select>
		</td>
		</tr>
		<tr>
			<td><input type="submit" value="통장개설"><input type="reset" value="다시쓰기"> </td>
		</tr>	
	</table>
</form>
</body>
</html>