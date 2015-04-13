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
<table style="text-align: center; width: 1500 "border="1">
	<thead>
		<tr>
			<td>No</td>
			<td>회원ID</td>
			<td>패스워드</td>
			<td>이름</td>
			<td>계좌</td>
			<td>신용등급</td>
			<td>직업</td>
			<td>나이</td>
			<td>성별</td>
			<td>전화번호</td>
			<td>주소</td>
		</tr>	
	</thead>
	<tbody>
	<c:forEach items="${requestScope.customers }" var="cus" varStatus="i">
			<tr>
				<td>${i.count}</td>  <!-- 또는 .index  -->
				<td>${cus.id }</td>
				<td>${cus.password}</td>
				<td>${cus.name}</td>
				<td>${cus.account}</td>
				<td>${cus.creditRating}</td>
				<td>${cus.job}</td>
				<td>${cus.age}</td>
				<td>${cus.sex?"여자":"남자"}</td>
				<td>${cus.phoneNumber}</td>
				<td>${cus.address}</td>
				
			</tr>	
	</c:forEach>
	</tbody>
</table>
</body>
</html>