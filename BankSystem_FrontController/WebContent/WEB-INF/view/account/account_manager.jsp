<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통장관리</title>
</head>
<body>
${sessionScope.id }님이 보유하고 있는 통장 리스트<br/>
<select name="account">
<c:forEach items="${requestScope.list}" var="acc">
	<option>${acc }</option>
</c:forEach>
</select><br/>
<a href="/BankSystem_FrontController/controller?command=createAccount">통장 개설</a><br/>
<a href="">통장 해지</a>
</body>
</html>