<%@ page contentType="text/html;charset=UTF-8" %>
<%
Object loginInfo = session.getAttribute("login_info");
if(loginInfo==null){
%>
<a href="/MemberManager_team1/index.jsp">메인페이지</a>
<a href="/MemberManager_team1/controller?command=link&path=/WEB-INF/view/member/register_form.jsp">회원가입</a>
<a href="/MemberManager_team1/controller?command=link&path=/WEB-INF/view/member/login_form.jsp">로그인</a>

<%}else{ %>

<a href="/MemberManager_team1/controller?command=link&path=/WEB-INF/view/member/main.jsp">메인페이지</a>
<a href="/MemberManager_team1/controller?command=info">본인정보조회</a>
<a href="/MemberManager_team1/controller?command=link&path=/WEB-INF/view/member/modify_form.jsp">회원정보 수정</a>
<a href="/MemberManager_team1/controller?command=logout">로그아웃</a>
<a href="/MemberManager_team1/controller?command=removeMember">회원탈퇴</a>
<%}%>
<a href="/MemberManager_team1/controller?command=memberAllList">전체회원정보</a>
<hr/>