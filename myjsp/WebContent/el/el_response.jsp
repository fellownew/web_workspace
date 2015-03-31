<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="true" %>
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
	취미 : ${paramValues.hobby[0] }, ${paramValues.hobby[1] }, ${paramValues.hobby[2] }<p/>

<h2>쿠키 얻기</h2>
	쿠키 : ${cookie.cookie_id.value } ,  ${cookie["now"].value }

<h2>initParameter 얻기</h2>
	${initParam.tel } - ${initParam.address } - ${initParam["company name"] }<p/>

<h2>header 정보 얻기 </h2>
	${header }<p/>

</body>
</html>