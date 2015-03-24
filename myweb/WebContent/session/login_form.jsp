<%@ page contentType="text/html;charset=UTF-8"%>
<% String message = (String)request.getAttribute("failmessage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Login</title>
</head>
<body>
<form action="/myweb/session_login" method="post">
<!-- 실패 메시지에 따른 경고 메시지 출력 -->
<%if(message!=null){%>
	<font color=red><%=message %></font>
<%}%>
<!-- id/password 넘기기 -->

<table style="text-align:center">
	<tr>
		<td colspan="2"><h3>로그인(Session)</h3></td>
	</tr>
	<tr>
		<td>ID </td>
		<td><input type="text" name="id" autofocus="autofocus"></td>
	</tr>
	<tr>
		<td>Password </td>
		<td><input type="password" name="password"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="로그인" style="color: white;background-color: #005D00">
	</tr>
</table>
</form>
</body>
</html>