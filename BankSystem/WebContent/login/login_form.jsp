<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<%
	String message = (String)request.getAttribute("failMessage") ;
%>
<%if(message != null){ %>
	<font color="red"><%=message%></font>
<%} %>


<form action="/BankSystem/login" method="post">
<table>
	<tr>
		<th colspan="2">로그인</th>
	</tr>
	<tr>
		<td colspan="2"><input type="text" name="id" size="30" maxlength="20" placeholder="ID" tabindex="1" autofocus="autofocus"></td>
		<td rowspan="2"><input type="image" src="/myweb/images/loginimg.jpg" width="100" tabindex="3"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="password" name="password" size="30" placeholder="비밀번호" tabindex="2"></td>
	</tr>
	<tr>
		<td><a href="/BankSystem/login/register_form.jsp"> 회원가입</a></td>
	</tr>
</table>
</form>


</body>
</html>

