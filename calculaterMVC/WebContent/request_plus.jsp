<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request plus</title>
</head>
<body>
<form action="/calculaterMVC/plus">

	<input type="number" name="num1" max="2100000000" placeholder="첫번째 숫자 " autofocus="autofocus"/><br/>
	<input type="number" name="num2" max="2100000000" placeholder="두번째 숫자 "/><br/>
	<input type="submit" value="더하기"/>

</form>
</body>
</html>