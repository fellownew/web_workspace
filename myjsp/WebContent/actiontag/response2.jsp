<%@ page contentType="text/html;charset=UTF-8"%>
	<jsp:useBean id="member" class="servlet.vo.Member" scope="page"/>

	<!--jsp:setProperty property="name" name="member" value="이철수"-->
	<jsp:setProperty property="*" name="member"/>
	<!-- useBean태그 안에 setProperty를 넣으면 마치 생성자처럼 값을 넣어줌. -->
	<jsp:useBean id="member2" class="servlet.vo.Member" scope="session">	
		<jsp:setProperty property="*" name="member2"/>
	</jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Response2</title>
</head>
<body>

<% 
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");
%>
	ID : <jsp:getProperty property="id" name="member"/><br/>
	password : <jsp:getProperty property="password" name="member"/><br/>
	이름 :<jsp:getProperty property="name" name="member"/><br/>
	나이 : <jsp:getProperty property="age" name="member"/><br/>
	결혼여부 : <jsp:getProperty property="marriage" name="member"/><p/>
	
	<h2> session의 회원 정보</h2>
	ID : <%=member2.getId() %> <br/>
	Password : <%=member2.getPassword() %>  <br/>
	이름 : <%=member2.getName() %>  <br/>
	나이 : <%=member2.getAge() %>  <br/>
	결혼 여부 : <%=member2.isMarriage()==true?"기혼":"미혼"%>  <p/>

	EL 출력 : ${sessionScope.member2.age } 이름 : ${sessionScope.member2.name }

	
	
		<a href="/myjsp/actiontag/request.jsp">요청페이지로 가기</a>
</body>
</html>