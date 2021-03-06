<%@page import="servlet.vo.Address"%>
<%@page import="servlet.vo.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Set</title>
</head>
<body>
<!-- 
1. 속성 영역에 attribute를 binding- var(Attribute이름), scope(저장 영역), value(속성)
2. binding된 Attribute의 property 값을 변경 - target(속성지정), property(property:setter), value(값)
 -->
 <!-- request.setAttribute("errorMesaage","오류가 발생했습니다."); -->
<c:set var="errorMessage" value="오류가 발생했습니다." scope="request"/>
<!-- session.setAttribute("name","홍길동") -->
<c:set var="name" scope="session">
	홍길동
</c:set>
${requestScope.errorMessage } - ${sessionScope.name }

<p/>

<c:set var="member" scope="request" value='<%=new Member("id-1","1111","홍길동",22,false,new Address("ad-1","123-233","부산")) %>'/>
이름 : ${requestScope.member.name }<br/>

Session 에러메시지 1 : ${sessionScope.sessionError } <br/>
<c:set var="sessionError" scope="session" value="${requestScope.errorMessage }"/>
Session 에러메시지 2 : ${sessionScope.sessionError } <br/>
<p/>
<!-- request.getAttribute("member").setName("김영수"); -->
<c:set target="${requestScope.member }" property="name" value="김영수"/>
바뀐 이름 : ${requestScope.member.name }<br/>
이전 나이 : ${requestScope.member.age }<br/>
<c:set target="${requestScope.member }" property="age" value="20"/>
바뀐 나이 : ${requestScope.member.age }<br/>
<a href="remove.jsp">remove.jsp</a>


</body>
</html>