<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Error</title>
</head>
<body>
	<%=request.getAttribute("error_message") %>
	에러가 발생하였습니다. 잠시 후 다시 시도해 주세요.
</body>
</html>