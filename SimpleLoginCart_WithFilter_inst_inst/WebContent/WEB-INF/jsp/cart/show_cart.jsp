<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
//session scope에서 cart를 조회
HashMap<String, Integer> cart = (HashMap)session.getAttribute("cart");
Set<String> keys = cart.keySet();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>장바구니 내용</h2>
<table border='1' width="350">
	<tr>
		<td>상품명</td>
		<td>주문개수</td>
	</tr>
<%
for(String key : keys){
	int value = cart.get(key);
%>
	<tr>
		<td><%=key %></td>
		<td><%=value %></td>
	</tr>
<% }%>
</table>
<br>
<a href="/SimpleLoginCart_WithFilter_inst/member/showlist">쇼핑계속</a>
<a href="/SimpleLoginCart_WithFilter_inst/member/order">주문</a>
<a href="/SimpleLoginCart_WithFilter_inst/member/logout">로그아웃</a>
</body>
</html>








