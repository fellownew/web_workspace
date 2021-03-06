<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/view/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>
<h3>가입한 회원 목록</h3>
<table style="text-align: center; width: 1000 "border="1">
	<thead>
		<tr>
			<td>No</td>
			<td>회원ID</td>
			<td>패스워드</td>
			<td>이름</td>
			<td>이메일</td>
			<td>가입일자</td>
		</tr>	
	</thead>
	<tbody>
	<c:forEach items="${requestScope.members }" var="member" varStatus="i">
			<tr>
				<td>${i.count}</td>  <!-- 또는 .index  -->
				<td>${member.id }</td>
				<td>${member.password}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
				<td>${member.date}</td>
			</tr>	
	</c:forEach>
	</tbody>
</table>
</body>
</html>