<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품목록</h2>
<%String errorMessage = (String)request.getAttribute("error_message"); %>
<%if(errorMessage!=null){ %>
	<font color="red"><%=errorMessage %></font>
<%} %>
 <form action="/SimpleLoginCart_WithFilter/confirm/addItemsToCart" method="post">
    <input type="checkbox" name="items" value="TV"/> TV<br/>
    <input type="checkbox" name="items" value="DVD"/> DVD<br/>
    <input type="checkbox" name="items" value="모니터"/> 모니터<br/>
    <input type="checkbox" name="items" value="노트북"/> 노트북<br/>
    <input type="checkbox" name="items" value="우롱차"/> 우롱차<br/>
    <input type="checkbox" name="items" value="녹차"/> 녹차<br/>
    <input type="checkbox" name="items" value="커피"/> 커피<br/>
	<input type="submit" value="장바구니담기"/>
 </form>
</body>
</html>










