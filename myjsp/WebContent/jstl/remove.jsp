<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove</title>
</head>
<body>

에러 메시지 : ${sessionScope.sessionError } <br/>
<c:remove var="sessionError" scope="session"/>
remove 후 에러메시지 : ${sessionScope.sessionError } <br/>


<a href="set.jsp">set.jsp로 가기</a>



</body>
</html>