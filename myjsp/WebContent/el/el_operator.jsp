<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL_Operator</title>
</head>
<body>
<!-- 
EL의 Literal value 
문자열 : "값", '값'
숫자 : 정수, 실수
boolean  : true/false
null (출력이 안되는 값)
 - EL 에서의 리터럴 값 출력 : ${'값'} - ${"asdf"}, ${'안녕'}, ${35}
 		위.. 주석 안에 있어도 연산이 된다. 
-->



숫자 : ${2099 } , ${4234.5623 } <br/>
문자열 : ${"문자열" } , ${'String' } , ${"a" == 'a' } , ${null } , ${test.ttff } <br/>
사칙 연산 : 10/2 = ${10 / 2 } , 10 ${"div"} 2 = ${10div2 } , null+300 = ${null+300 } , 834 ${'mod'}13 = ${834 mod 13 } <br/>
비교연산 : ${10==20 } , ${10 eq 20 } , ${member.age == 20 } <br/>
empty(값이 문자열인 경우 null, loength 가 0이면 true) : ${empty null } ${empty "" } , ${empty " " } , ${empty "fasdf" }
</body>
</html>