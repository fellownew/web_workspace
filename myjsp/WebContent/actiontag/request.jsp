<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request</title>
</head>

<body>
<jsp:include page="/include/menu.jsp"/>
	<form action="/myjsp/actiontag/response2.jsp" method="post"><br/>
	<input type="text" name="id" placeholder="ID"><br/>
	<input type="password"	name="password" placeholder="PassWord"><br/>
	<input type="text" name="name" placeholder="이름"><br/>
	<input type="number" name="age" placeholder="나이"><br/>
	<label><input type="radio" name="marriage" value="true">기혼</label>
	<label><input type="radio" name="marriage" value="false">미혼</label><br/>
	<input type="submit" value="확인">
</form>
<p/>
	<a href="/myjsp/setAttribute">Set Attribute 요청</a>
</body>
</html>