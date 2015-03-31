<%@page import="servlet.vo.Address"%>
<%@page import="servlet.vo.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%
request.setAttribute("name", "홍길동");
session.setAttribute("name", "임꺽정-session");
request.setAttribute("age",20);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getAttribute</title>
</head>
<body>
	이름 : ${name } <br/>
	세션 이름 : ${sessionScope.name } <br/>
	나이 : ${age } <br/>

	<%
	Address addr = new Address("addr-id0","123-456","경기도 성남시 분당구 삼평동");
	Member mem = new Member("id-1","1111","홍길동",22,false,addr);
	request.setAttribute("member",mem); 
	%>
	ID:${requestScope.member.id }<br/>
	패스워드 : ${requestScope.member.password}<br/>
	이름 : ${requestScope.member.name}<br/>
	나이 : ${requestScope.member.age}<br/>
	결혼 여부 : ${requestScope.member.marriage}<br/>
	
	주소 ID :${requestScope.member.address.ID}<br/>
	우편번호 : ${requestScope.member.address.zipcode } <br/>
	상세주소 : ${requestScope.member.address.addressDetail }<br/>
	
	<h2>[]를 이용한 EL처리</h2>
	ID : ${requestScope["member"]["id"] } <br/>
	우편번호 : ${requestScope["member"]["address"]["zipcode"] }
	
	
	
</body>
</html>