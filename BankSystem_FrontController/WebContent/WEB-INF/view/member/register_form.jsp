<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>회원가입</title>
</head>
<body>
	${sessionScope.failMessage }
	<c:if test="${not empty sessionScope.failMessage }">
		<c:remove var="failMessage" scope="session"/> 
	</c:if>
<form action="/BankSystem_FrontController/controller" method="post">
	<input type="hidden" name="command" value="register">
	<table>
		<tr>
			<td><b>회원가입</b></td>
		</tr>
		<tr>
			<td><input type="text" name="id" size="30" placeholder="아이디" required="required" maxlength="10" autofocus="autofocus"></td>
		</tr>
		<tr>
			<td><input type="password" name="password" size="30" placeholder="비밀번호" required="required" maxlength="20"></td>
		</tr>
		<tr>
			<td><input type="text" name="name" size="30" placeholder="이름" required="required" maxlength="15"></td>
		</tr>
		<tr>
			<td><input type="email" name="email" size="30" placeholder="E-mail" required="required" maxlength="40"></td>
		</tr>
		<tr>
			<td><input type="submit" value="회원가입"><input type="reset" value="다시쓰기"> </td>
		</tr>	
	</table>
</form>
</body>
</html>