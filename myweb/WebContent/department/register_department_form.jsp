<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
<h2>부서 등록</h2>
<form action="/myweb/registerDepartment" method="post">
부서ID : <input type="text" name="id"><br/>
부서명 : <input type="text" name="name"><br/>
지역 : <input type="text" name="location"><br/>
<input type="submit" value="부서등록">
</form>
</body>
</html>