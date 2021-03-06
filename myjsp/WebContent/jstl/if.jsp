<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조건문 - if</title>
</head>
<body>
	<c:if test="true">
		true 조건일 경우 출력 될 내용 <br/>
	</c:if>
	<c:if test="false">
		false 조건일 경우 출력 될 내용 <br/>
	</c:if>
	<c:if test="abc">
		abcd 조건일 경우 출력 될 내용 <br/>
		다른 값들은 모두 false로 취급 함.
		즉, true를 제외한 모든 것은 모두 false
	</c:if>
	<hr/>
	<% request.setAttribute("errorMessage","문제가 발생하였습니다.");%>
	<c:if test="${requestScope.errorMessage != null}">
		<font color="red">오류 발생 : ${requestScope.errorMessage } </font> 
	</c:if>
	<c:if test="${not empty requestScope.errorMessage}">
		<font color="red">오류 발생 : ${requestScope.errorMessage } </font> 
	</c:if>
	<hr/>
	<% session.setAttribute("age",29); %>
	
	메뉴 : 로그아웃, 마이페이지, 장바구니 
	<c:if test="${sessionScope.age>=20 }">, 성인상품
	</c:if>
	<hr/>
	
	
	

	
</body>
</html>