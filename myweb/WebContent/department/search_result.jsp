<%@ page contentType="text/html;charset=UTF-8"%>
<%
Integer id = (Integer)(request.getAttribute("id"));
String name = (String)request.getAttribute("name");
String location = (String)request.getAttribute("location");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
<h3>조회 정보 결과</h3><br/>
ID : <%=id %><br/>
이름 : <%=name %><br/>
위치 : <%=location %><br/>
<a href="/myweb/department/searchbyid_form.html">조회 폼으로 돌아가기</a>
</body>
</html>