<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request1</title>
</head>
<body>

	<h2>등록작업</h2>
	
	<form action="${initParam.rootPath }/FrontController" method="post">
		<input type="hidden" name ="command" value="register">
		<input type="text" name = "info" placeholder="등록 정보">
		<input type="submit" value="등록">
	</form>

</body>
</html>