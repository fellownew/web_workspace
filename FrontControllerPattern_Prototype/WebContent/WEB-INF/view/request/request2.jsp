<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request2</title>
</head>
<body>

	<h2>조회요청</h2>

	<form action="${initParam.rootPath }/FrontController" method="post">
		<input type="hidden" name ="command" value="search">
		<input type="text" name = "id" placeholder="조회 ID">
		<input type="submit" value="조회">
	</form>

</body>
</html>