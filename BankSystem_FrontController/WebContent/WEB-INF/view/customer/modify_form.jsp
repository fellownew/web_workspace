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
			<td><input type="text" name="id" size="30" placeholder="아이디" value="${sessionScope.login_info.id }" readonly="readonly"></td>
		</tr>
		<tr>
			<td><input type="password" name="password" size="30" placeholder="비밀번호" required="required" autofocus="autofocus"></td>
		</tr>
		<tr>
			<td><input type="text" name="name" size="30" placeholder="이름" required="required"></td>
		</tr>
		<tr>
			<td><input type="text" name="job" size="30" placeholder="직업" required="required" maxlength="20"></td>
		</tr>
		<tr>
			<td><input type="number" name="age" size="60" placeholder="나이" required="required" maxlength="20" min="17" max="150"></td>
		</tr>
		<tr>
			<td>성별 : <label><input type="radio" name="sex" value="false">남</label><label><input type="radio" name="sex" value="ture">여</label></td>
		</tr>
		<tr>
			<td><input type="text" name="phoneNumber" size="30" placeholder="전화번호" required="required" maxlength="30"></td>
		</tr>
		<tr>
			<td><input type="text" name="address" size="30" placeholder="주소" required="required" maxlength="50"></td>
		</tr>
		<tr>
			<td><input type="submit" value="회원 정보 수정"></td>
		</tr>
	
	</table>
</form>
</body>
</html>