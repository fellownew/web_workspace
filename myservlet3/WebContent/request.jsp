<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request</title>
</head>
<body>
	<h2>HelloWorldServlet</h2>
	<form action="/myservlet3/hello" method="post">
		<input type="text" name="name" placeholder="이름">
		<input type="submit" value="전송">
	</form>
<hr/>
	<form action="/myservlet3/greet" method="post">
		<input type="text" name="name" placeholder="이름">
		<input type="submit" value="전송">
	</form>
</body>
</html>