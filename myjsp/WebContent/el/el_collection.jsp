<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servlet.vo.Address"%>
<%@page import="servlet.vo.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>


<%
ArrayList list = new ArrayList();
String[] names = {"김철수","이영희","박달재"};
request.setAttribute("names", names);
list.add("one");
list.add("two");
list.add(new Member("id-2","2222","임꺽정",23,false));
list.add(new Member("id-3","3333","맙소사",43,true,new Address("addr-id2","444-333","경기도 수원시")));
session.setAttribute("list",list);

HashMap map = new HashMap();
map.put("productName","TV");
map.put("maker","Samsong");
map.put("price",100000);
map.put("high price",1000000);
request.setAttribute("product", map);


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Colletion</title>
</head>
<body>
<h2>EL을 이용해 배열의 값 조회</h2>
${requestScope.names["0"] }
${requestScope.names[1] }
${requestScope.names["2"] } <br/>
	
${sessionScope.list[0] } - ${sessionScope.list[1] } - ${sessionScope.list[2]} <br/>
${sessionScope.list[3] } <br/>
${sessionScope.list[3].address }<p/>

회원은 20살 미만인가? ${sessionScope.list[3].age <20?"미성년":"성년"} <br/>
회원의 이름은 임꺽정인가? ${sessionScope.list[2].name == "임꺽정"?"맞다":"아니다" }<p/>

<h2>EL을 이용해 Map의 값 조회</h2>
제품명 : ${requestScope.product.productName } <br/>
메이커 : ${requestScope.product.maker} <br/>
가격 : ${requestScope["product"].price} <br/>
최고가 : ${requestScope.product["high price"]}






</body>
</html>