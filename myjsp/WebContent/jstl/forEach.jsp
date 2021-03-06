<%@page import="servlet.vo.Member"%>
<%@page import="servlet.vo.Address"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ForEach</title>
</head>
<body>
<%
int[] nums = {10,20,30,40,50,60,70,80,90};
request.setAttribute("nums", nums);

ArrayList<Member> memList = new ArrayList<Member>();
memList.add(new Member("id-1","1111","홍길동",22,false,new Address("ad-1","123-233","부산")));
memList.add(new Member("id-2","2222","김철수",25,false,new Address("ad-2","353-123","서울")));
memList.add(new Member("id-3","3333","박철수",34,true,new Address("ad-3","547-128","대구")));
memList.add(new Member("id-4","4444","최영희",27,false,new Address("ad-4","354-884","대전")));
memList.add(new Member("id-5","5555","이영희",14,false,new Address("ad-5","954-415","광주")));

request.setAttribute("memberlist", memList);

HashMap<String, Object> map = new HashMap<String, Object>();
map.put("이름","a");
map.put("나이","b");
map.put("주소","c");
map.put("member",memList.get(0));
map.put(memList.get(1).getId(),memList.get(1).getName());
request.setAttribute("map",map);
%>
<c:forEach items="${requestScope.nums }" var="num">
	nums : ${num } <br/>
</c:forEach>
<br/>

<table style="text-align: center; width: 600px;"border="1">
	<thead>
		<tr>
			<td>No</td>
			<td>회원ID</td>
			<td>패스워드</td>
			<td>이름</td>
			<td>나이</td>
			<td>결혼여부</td>
			<td>우편번호</td>
			<td>상세주소</td>
		</tr>	
	</thead>
	<tbody>
	<c:forEach items="${requestScope.memberlist }" var="member" varStatus="i">
			<tr>
				<td>${i.count}</td>  <!-- 또는 .index  -->
				<td>${member.id }</td>
				<td>${member.password}</td>
				<td>${member.name}</td>
				<td>${member.age}</td>
				<td>${member.marriage?"기혼":"미혼"}</td>
				<td>${member.address.zipcode}</td>
				<td>${member.address.addressDetail }</td>
			</tr>	
	</c:forEach>
	</tbody>
</table>

<hr/>

<table border="1">
	<thead style="text-align: center">
		<tr>
			<td>Key</td>
			<td>Value</td>
		</tr>	
	</thead>
	<tbody>
		<c:forEach items="${requestScope.map }" var="var">
			<tr>
				<td>${var.key }</td>
				<td>${var.value }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<hr/>

<c:forEach var="i" begin="1" end="20" step="2">
	Hello World ${i} ! <br>
</c:forEach>

</body>
</html>