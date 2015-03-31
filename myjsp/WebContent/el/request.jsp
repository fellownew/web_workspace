<%@ page contentType="text/html;charset=UTF-8"%>
<%
Cookie c1 = new Cookie("cookie_id","cookie id");
Cookie c2 = new Cookie("now","2015.03.30");
c2.setMaxAge(60*60);
response.addCookie(c1);
response.addCookie(c2);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request</title>
</head>
<body>

<form action="el_response.jsp" method="post"><br/>

이름 : <input type="text" name="name"><br/>
나이 : <input type="text" name="age"><br/>
취미 : 
<label><input type="checkbox" name="hobby" value="movie">영화감상</label>
<label><input type="checkbox" name="hobby" value="music">음악감상</label>
<label><input type="checkbox" name="hobby" value="reading">독서</label>
<br/>
<input type="submit" value="전송">


</form>

</body>
</html>