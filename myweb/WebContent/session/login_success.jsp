<%@ page contentType="text/html;charset=UTF-8"%>
<% String loginId = (String)session.getAttribute("login_id"); 
	//if(loginId==null){
		//로그인 페이지로 이동
	//}
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
	로그인 성공. <%=loginId %>님 반갑습니다.
	<form>
	<input type="text" name="testText">
	<input type="submit" name ="testTextSubmit" value="테스트">
	</form>
	<a href="/myweb/logout">로그아웃</a>
</body>
</html>