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

	로그인 성공. <%=loginId %>님 반갑습니다.<br/>
	<a href="/myweb/logout">로그아웃</a><br/>
	<a href="/myweb/shoppingList">쇼핑 리스트 보기</a>
	
</body>
</html>