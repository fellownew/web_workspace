<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<font color="red">${requestScope.failMessage }</font>

<form action="/BankSystem_FrontController/controller" method="post">
<input type="hidden" name="command" value="login">
<table>
	<tr>
		<th colspan="2">로그인</th>
	</tr>
	<tr>
		<td colspan="2"><input type="text" name="id" size="30" maxlength="20" placeholder="ID" tabindex="1" autofocus="autofocus"></td>
		<td rowspan="2"><input type="image" src="/BankSystem_FrontController/images/loginimg.jpg" width="100" tabindex="3"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="password" name="password" size="30" placeholder="비밀번호" tabindex="2"></td>
	</tr>
</table>
</form>


</body>
</html>

