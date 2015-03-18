<%@ page contentType="text/html;charset=UTF-8"%>
<% String failMesseage = (String)request.getAttribute("fail_message");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
로그인 실패<br/>
실패사유 : <%=failMesseage %>
</body>
</html>