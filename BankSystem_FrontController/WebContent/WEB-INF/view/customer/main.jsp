<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 메인 페이지</title>
</head>
<body>
<h1>회원관리</h1>
	${sessionScope.login_info.id }님 안녕하세요
	<a href="/BankSystem_FrontController/controller?command=accountManager">통장관리</a>
	<a href="/BankSystem_FrontController/controller?command=link&path=/WEB-INF/view/member/main.jsp">입/출금</a>
	<a href="/BankSystem_FrontController/controller?command=link&path=/WEB-INF/view/member/main.jsp">송금</a>
	<a href="/BankSystem_FrontController/controller?command=link&path=/WEB-INF/view/member/main.jsp">대출</a>
</body>
</html>