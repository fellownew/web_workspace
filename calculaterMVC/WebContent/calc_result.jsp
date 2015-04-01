<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calc Result</title>
</head>
<body>
	계산 결과 : ${requestScope.result }
	<p/>
	<a href="/calculaterMVC/request_plus.jsp">더하기 요청</a><br/>
	<a href="/calculaterMVC/request_minus.jsp">빼기 요청</a><br/>
</body>
</html>