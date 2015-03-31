<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//JSP 에서 HttpSession객체 사용시 - request.getSession() 하지 않고 그냥 session이라는 변수를 사용.
	String loginId = (String)session.getAttribute("login_info");
	//if(loginId==null){//로그인페이지로 이동}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
로그인 성공. <%=loginId %> 님 환영합니다.<p>
<a href="/BankSystem/confirm/main">메인 페이지</a><br/>
<a href="/BankSystem/confirm/logout">로그아웃</a>
</body>
</html>

