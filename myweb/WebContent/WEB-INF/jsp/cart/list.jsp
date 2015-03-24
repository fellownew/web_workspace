<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>쇼핑 리스트</title>
</head>
<body>

	<form action="/myweb/addItemsTocart" method="post">
	<h5> 상품 목록 </h5>
	<label><input type="checkbox" name="product" value="CPU">CPU</label><br/>
	<label><input type="checkbox" name="product" value="RAM">RAM</label><br/>
	<label><input type="checkbox" name="product" value="메인보드">메인보드</label><br/>
	<label><input type="checkbox" name="product" value="VGA">VGA</label><br/>
	<label><input type="checkbox" name="product" value="SSD">SSD</label><br/>
	<label><input type="checkbox" name="product" value="HDD">HDD</label><br/>
	<label><input type="checkbox" name="product" value="ODD">ODD</label><br/>
	<label><input type="checkbox" name="product" value="케이스">케이스</label><br/>
	<label><input type="checkbox" name="product" value="파워">파워</label><br/>
	<label><input type="checkbox" name="product" value="모니터">모니터</label><br/>
	<label><input type="checkbox" name="product" value="키보드">키보드</label><br/>
	<label><input type="checkbox" name="product" value="마우스">마우스</label><br/>
	<label><input type="checkbox" name="product" value="노트북">노트북</label><br/>
	<input type="submit" value="장바구니 담기" style="background-color: #B2CCFF">
	</form>
	<p/>
	<!-- for문을 이용한 체크박스 테스트 -->
	<form action="/myweb/addItemsTocart" method="post">
	<h5> 상품 목록 </h5>
	<%String[] str = {"CPU","RAM","메인보드","VGA", "SSD","HDD","ODD","케이스","파워","모니터","키보드","마우스","노트북"};
	for(int i = 0;i<str.length;i++){ %>
	<label><input type="checkbox" name="product" value="<%=str[i] %>"><%=str[i] %></label><br/>
	<%} %>
	<input type="submit" value="장바구니 담기" style="background-color: #B2CCFF">
	</form>
</body>
</html>