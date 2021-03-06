<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="error.jsp" %>
<c:choose>
	<c:when test="${empty sessionScope.login_info }">
	<a href="/MemberManager_team1/index.jsp">메인페이지</a>
	<a href="/MemberManager_team1/controller?command=link&path=/WEB-INF/view/member/register_form.jsp">회원가입</a>
	<a href="/MemberManager_team1/controller?command=link&path=/WEB-INF/view/member/login_form.jsp">로그인</a>
	</c:when>
	<c:otherwise>
	<a href="/MemberManager_team1/controller?command=link&path=/WEB-INF/view/member/main.jsp">메인페이지</a>
	<a href="/MemberManager_team1/controller?command=info">본인정보조회</a>
	<a href="/MemberManager_team1/controller?command=link&path=/WEB-INF/view/member/modify_form.jsp">회원정보 수정</a>
	<a href="/MemberManager_team1/controller?command=logout">로그아웃</a>
	<a href="/MemberManager_team1/controller?command=removeMember">회원탈퇴</a>	
	</c:otherwise>	
</c:choose>
<a href="/MemberManager_team1/controller?command=memberAllList">전체회원정보</a>
<hr/>