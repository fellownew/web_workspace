<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 정보</title>
</head>
<body>
	<h2>내 정보 조회</h2>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>${requestScope.info.id }</td>
		</tr>
		<tr>
			<td>password</td>
			<td>${requestScope.info.password }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${requestScope.info.name }</td>
		</tr>
		<tr>
			<td>직업</td>
			<td>${requestScope.info.job }</td>
		</tr>	
		<tr>
			<td>나이</td>
			<td>${requestScope.info.age }</td>
		</tr>	
		<tr>
			<td>성별</td>
			<td>${requestScope.info.sex?"여성":"남성"}</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${requestScope.info.phoneNumber }</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${requestScope.info.address }</td>
		</tr>	
	</table>
	<c:if test="${not empty sessionScope.login_info }">
		<a href="/BankSystem_FrontController/controller?command=link&path=/WEB-INF/view/member/modify_form.jsp">회원정보 수정</a>
		<a href="/BankSystem_FrontController/controller?command=removeCustomer">회원탈퇴</a>
	</c:if>
</body>
</html>