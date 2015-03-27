<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>회원가입</title>
</head>
<body>
<form action="/BankSystem/register">
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
		<td><label><input type="radio" name="sex" checked="checked">Male</label>
		    <label><input type="radio" name="sex">Female</label></td>
	</tr>
	<tr>
		<td><input type="number" name="age" size="30" min="18" placeholder="나이" required="required"></td>
	</tr>
	<tr>
		<td><input type="text" name="job" size="30" placeholder="직업" required="required"></td>
	</tr>
	<tr>
		<td><input type="text" name="address" size="30" placeholder="주소" required="required"></td>
	</tr>
	<tr>
		<td><select name="phone0">
			<option value="010" selected="selected">010</option>
			<option>011</option>
			<option>016</option>
			<option>019</option>
		</select>
			<input type="number" name="phone1" size="4" maxlength="4" required="required"><input type="number" name="phone2" size="4" maxlength="4" required="required">
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="회원가입"></td>
	</tr>

</table>
</form>
</body>
</html>