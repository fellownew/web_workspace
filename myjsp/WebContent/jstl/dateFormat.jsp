<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DateFormat</title>
</head>
<body>
<!-- 
	fmt:formatDate 태그 : SimpleDateFormat(java.util.Date-> 형식화된 문자열)의 태그화
	value : 변경할 Date 객체 (날짜, 시간) 객체
	type : 형식화할 값의 종류 (날짜 : date, 시간 : time, 날짜/시간 : both)
	dateStyle, timeStyle : 기본적으로 제공되는 날짜/시간의 포맷을 지정 - short, medium, long
	pattern : 형식을 직접 지정 (type을 지정할 필요 없다.) 형식 : SimpleDateFormat에서 사용한 형식 사용.
		yyyy MM dd HH mm ss 등
 -->
 <!-- locale(언어코드_국가코드)을 설정하면 그 지역에 맞는 형태의 날짜 시간 형태로 보여준다. 
 	ISO에서 지정한 코드로 해야함. 국가 코드 : ISO 3166, 언어코드 : ISO-639
 	locale 설정 : fmt:setLocale value="언어코드_국가코드"
  -->
 <c:set var="now" value="<%=new java.util.Date() %>"/>
 <!-- fmt:setLocale value="en_US"/-->
<h2>formatDate 태그를 이용해 날짜 형식화</h2>
1) <fmt:formatDate value="${now }" type="date"/> <br/>
2) <fmt:formatDate value="${now }" type="time"/> <br/>
3) <fmt:formatDate value="${now }" type="both" timeZone="american"/> <br/>
4) <fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="short"/> <br/>
5) <fmt:formatDate value="${now }" type="both" dateStyle="medium" timeStyle="medium"/> <br/>
6) <fmt:formatDate value="${now }" type="both" dateStyle="long" timeStyle="long"/> <br/>
7) <fmt:formatDate value="${now }" type="both" pattern="yyyy년 MM월 dd일  E요일 HH시 mm분 ss초" /> <br/>

 
 
</body>
</html>