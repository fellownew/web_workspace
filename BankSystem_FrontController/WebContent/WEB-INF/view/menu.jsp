<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="error.jsp" %>
<%
Object loginInfo = session.getAttribute("login_info");
if(loginInfo==null){
%>
<a href="/BankSystem_FrontController/index.jsp">메인페이지</a>
<a href="/BankSystem_FrontController/controller?command=link&path=/WEB-INF/view/member/register_form.jsp">회원가입</a>
<a href="/BankSystem_FrontController/controller?command=link&path=/WEB-INF/view/member/login_form.jsp">로그인</a>

<%}else{ %>

<a href="/BankSystem_FrontController/controller?command=link&path=/WEB-INF/view/member/main.jsp">메인페이지</a>
<a href="/BankSystem_FrontController/controller?command=info">본인정보조회</a>
<a href="/BankSystem_FrontController/controller?command=link&path=/WEB-INF/view/member/modify_form.jsp">회원정보 수정</a>
<a href="/BankSystem_FrontController/controller?command=logout">로그아웃</a>
<a href="/BankSystem_FrontController/controller?command=removeMember">회원탈퇴</a>
<%}%>
<a href="/BankSystem_FrontController/controller?command=memberAllList">전체회원정보</a>
<hr/>