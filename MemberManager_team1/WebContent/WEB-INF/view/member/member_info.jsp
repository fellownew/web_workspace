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
			<td>이메일</td>
			<td>${requestScope.info.email }</td>
		</tr>	
		<tr>
			<td>가입일자</td>
			<td>${requestScope.info.date }</td>
		</tr>	
	</table>
	<a href="/MemberManager_team1/controller?command=link&path=/WEB-INF/view/member/modify_form.jsp">회원정보 수정</a>
	<a href="/MemberManager_team1/controller?command=removeMember">회원탈퇴</a>
</body>
</html>