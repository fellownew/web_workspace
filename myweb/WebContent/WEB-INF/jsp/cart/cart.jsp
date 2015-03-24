<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% HashMap<String,Integer> cartList = (HashMap<String, Integer>) session.getAttribute("cartMap"); 
	Set<String> keyset = cartList.keySet();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>장바구니</title>
</head>
<body>
<!-- 담긴 물품이 없을 경우의 메시지 이며 error메시지를 받아서 페이지 리턴 받는 방법도 있음. -->
<!-- String errorMessage = requset.getAttribute("errorMessage");
if(errorMessage!=null){ message }-->

<%if(cartList.size()==0){ %>
	담긴 물품이 없습니다.
<%}%>

<table style="text-align:center; min-width:300px; font-size: 13pt" border="1">
	<tr>
		<td>제품명</td>
		<td>수량</td>
	</tr>
	<% for(String key:keyset){%>
		<tr>
			<td><%=key %></td>
			<td><%=cartList.get(key) %></td>
		</tr>
	<% }%>

</table>
	<a href="/myweb/order">주문</a> - 미구현<br/> 
	<a href="/myweb/shoppingList">쇼핑 리스트 보기</a><br/>
	<a href="/myweb/logout">로그아웃</a> ※장바구니 내용이 없어집니다.
</body>
</html>