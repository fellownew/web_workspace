<%@page import="java.text.DecimalFormat"%>
<%@ page import="java.lang.Integer" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
double result = (Double)request.getAttribute("result");
String message = (String)request.getAttribute("message");
boolean check = (Boolean)request.getAttribute("check");
DecimalFormat df = new DecimalFormat("#,###.##");
String dfResult = df.format(result);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>계산 결과</title>
</head>
<body>

<h1>계산 결과 : <%=check?dfResult:message %></h1>
</body>
</html>
