<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FormatNumber</title>
</head>
<body>
<!-- DecimalFormet을 태그화 시킨 것. -->
<!-- formatNumber : 
	value : 변경할 값을 지정
	type : number(숫자 그대로) || currency(단위) || percent(%) - value*100을 해서 출력.
	groupingUsed : true(기본) || false - 자릿수 구분자 추가 여부 지정.
	maxFractionDigits : 값 - 정수 - 소수점 이하 최대 자릿수  
	minFractionDigits : 값 - 정수 - 소수점 이하 최소 자릿수
	maxIntegerDigits : 값 - 정수 - 정수부 최대 자릿수
	minIntegerDigits : 값 - 정수 - 정수부 최소 자릿수
	pettern : 전환문자를 이용한 출력 형식 패턴 지정(#,0).
	
-->
<c:set scope="request" value="123456789.1234" var="num"/>

1)<fmt:formatNumber value="${requestScope.num }" type="number"/><br/>	
2)<fmt:formatNumber value="${requestScope.num }" type="currency"/><br/>	
3)<fmt:formatNumber value="${requestScope.num }" type="percent"/><br/>	
4)<fmt:formatNumber value="${requestScope.num }" type="number" maxFractionDigits="2" maxIntegerDigits="3" groupingUsed="false"/><br/>	
5)<fmt:formatNumber value="${requestScope.num }" type="number" pattern="#,###.#"/><br/>
	<fmt:setLocale value="en_US"/>
6)<fmt:formatNumber value="${requestScope.num }" type="currency"/><br/>	
	<fmt:setLocale value="zh_CN"/>
7)<fmt:formatNumber value="${requestScope.num }" type="currency"/><br/>	
	<fmt:setLocale value="ja_JP"/>
8)<fmt:formatNumber value="${requestScope.num }" type="currency"/><br/>	
	<fmt:setLocale value="ko_KR"/>
9)<fmt:formatNumber value="${requestScope.num }" type="currency"/><p/>

<fmt:formatNumber pattern="#,###">${requestScope.num }</fmt:formatNumber><br/>	 
<fmt:formatNumber value="${requestScope.num }" pattern="#,000.0000" /><br/>
<fmt:formatNumber value="${requestScope.num }" currencySymbol="$" type="currency"  /><br/>
<fmt:formatNumber value="${requestScope.num }" currencyCode="JPY" type="currency" />

</body>
</html>