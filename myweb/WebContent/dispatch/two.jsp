<%@page import="java.io.PrintWriter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
//java코드 request scope에서 binding된 attribute 조회
String message = (String)request.getAttribute("message");
Date time = (Date)request.getAttribute("time");
String currentTime=null;
if(time!=null){
	currentTime = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(time);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
two.jsp 입니다. <br/>
<h3><%=message%><br/></h3>
현재 시간 : <%=currentTime %><br/>
<a href="/myweb/dispatch/request.html">Dispatch 요청 페이지 (dispatch/request.html)로 이동</a>
</body>
</html>