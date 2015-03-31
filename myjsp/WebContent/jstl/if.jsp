<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조건문 - if</title>
</head>
<body>
	<c:if test="true">
		true 조건일 경우 출력 될 내용 <br/>
	</c:if>
	<c:if test="false">
		false 조건일 경우 출력 될 내용 <br/>
	</c:if>
	<c:if test="abc">
		abcd 조건일 경우 출력 될 내용 <br/>
		다른 값들은 모두 false로 취급 함.
		즉, true를 제외한 모든 것은 모두 false
	</c:if>
	
	
	
</body>
</html>