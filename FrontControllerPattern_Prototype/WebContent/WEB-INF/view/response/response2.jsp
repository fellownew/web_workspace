<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Response2</title>
</head>
<body>

	${param.id }로 조회한 결과<p/>
	
결과1 : ${requestScope.result1 } <br/>
결과2 : ${requestScope.result2 } <br/>
<a href="${initParam.rootPath }/index.jsp">메인링크</a>

</body>
</html>
