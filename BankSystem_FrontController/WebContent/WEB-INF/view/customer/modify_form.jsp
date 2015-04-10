<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>
</head>
<body>
<form action="/BankSystem_FrontController/controller" method="post">
	<input type="hidden" name="command" value="modify">
	<table>
	
		<tr>
			<td><b>회원정보수정</b></td>
		</tr>
		<tr>
			<td><input type="text" name="id" size="30" placeholder="아이디" value="${sessionScope.login_info }" readonly="readonly"></td>
		</tr>
		<tr>
			<td><input type="password" name="password" size="30" placeholder="비밀번호" required="required" autofocus="autofocus"></td>
		</tr>
		<tr>
			<td><input type="text" name="name" size="30" placeholder="이름" required="required"></td>
		</tr>
		<tr>
			<td><input type="email" name="email" size="30" placeholder="E-mail" required="required"></td>
		</tr>
		<tr>
			<td><input type="submit" value="회원 정보 수정"></td>
		</tr>
	
	</table>
</form>
</body>
</html>