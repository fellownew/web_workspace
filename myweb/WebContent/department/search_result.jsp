<%@page import="department.vo.Department"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
//Integer id = (Integer)(request.getAttribute("id"));
//String name = (String)request.getAttribute("name");
//String location = (String)request.getAttribute("location");
Department dept = (Department)request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
<h3>조회 정보 결과</h3><br/>
<!-- id는 request.getParameter("departmentID")로 해도 됨. -->
ID : <%=request.getParameter("id") %><br/>
<% if(dept!=null){%>

이름 : <%=dept.getDepartmentName() %><br/>
위치 : <%=dept.getLocation() %><p/>
<%}else{%>
	조회한 부서가 없습니다.<p/>
<%} %>

<a href="/myweb/department/searchbyid_form.html">조회 폼으로 돌아가기</a>
<a href="/myweb/department/register_department_form.jsp"> 등록 폼으로 가기</a>
</body>
</html>