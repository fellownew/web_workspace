<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입/출금</title>
</head>
<body>
<h2>입출금</h2>

<select name="account">
	<c:forEach items="accounts" var="acc"/>
	<option>${acc.id }</option>
</select>
</body>
</html>