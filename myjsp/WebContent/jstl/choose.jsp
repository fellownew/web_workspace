<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choose</title>
</head>
<body>
<% request.setAttribute("age",15); %>
당신의 나이는 ${requestScope.age }세 이므로 당신은 
<c:choose>

	<c:when test="${requestScope.age<=10 }">
		어린이
	</c:when>
	<c:when test="${requestScope.age>10 && requestScope.age <20}">
		청소년
	</c:when>
	<c:otherwise>
		성인
	</c:otherwise>
</c:choose>
입니다.

<hr/>

<!-- 
로그인 : 마이페이지, 로그아웃, 회원탈퇴, 고객센터
미로그인 : 회원가입, 로그인, 고객센터
 -->
 
<% session.setAttribute("login_info","id"); %>

<c:choose>
	<c:when test="${not empty sessionScope.login_info }">
		마이페이지, 로그아웃, 회원탈퇴
	</c:when>
	<c:otherwise>
		회원가입, 로그인
	</c:otherwise>
</c:choose>
, 고객센터

<br/>


</body>
</html>