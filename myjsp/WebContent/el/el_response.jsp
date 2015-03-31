<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("UTF-8");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL_Response</title>
</head>
<body>
<!-- 요청 파라미터 값을 출력만 해줌. -->
<h2>요청 파라미터 값 출력</h2>

	이름 : ${param.name } <br/>
	나이 : ${param.age } <br/>
	<c:choose>
		<c:when test="${not empty paramValues.hobby }">
		취미 : <c:forEach items="${paramValues.hobby }" var="hob">
					${hob }
				</c:forEach><p/>
		</c:when>
		<c:otherwise>
			선택된 취미가 없습니다.
		</c:otherwise>
	</c:choose>


<h2>쿠키 얻기</h2>
	쿠키 : ${cookie.cookie_id.value } ,  ${cookie["now"].value }

<h2>initParameter 얻기</h2>
	${initParam.tel } - ${initParam.address } - ${initParam["company name"] }<p/>

<h2>header 정보 얻기 </h2>
	${header }<p/>

</body>
</html>