package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormRequestServlet extends HttpServlet{
	
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		//name,password,age,email, sex,language(str[]),phone0,phone1,phone2,picture,adv
//		request.setCharacterEncoding("UTF-8");//요청 데이터의 인코딩 적용.
		response.setContentType("text/html;charset=UTF-8");//응답데이터의 contentType 타입.
		PrintWriter out = response.getWriter();//응답 데이터의 Writer가져오기.
		
		out.println("<html><head><title>받은 데이터 Echo</title></head><body>");//html태그, 타이틀 지정, body열기
		
		Enumeration<String> nameList = request.getParameterNames();
		out.println("Enumeration활용<br/>");
		out.println("<table>");
		while(nameList.hasMoreElements()){
			String str = nameList.nextElement();
			out.print("<tr><td>"+str+" : </td>");
			out.println("<td>"+request.getParameter(str)+"</td></tr>");
		}
		out.println("</table>");
		out.println("<h3>가입 정보</h3>");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		String[] language = request.getParameterValues("language");
		String phoneNum = request.getParameter("phone0")+"-";
		phoneNum+=request.getParameter("phone1")+"-";
		phoneNum+=request.getParameter("phone2");
		String picture = request.getParameter("picture");
		String intro = request.getParameter("intro");
		String command = request.getParameter("command");
		String adv = request.getParameter("adv");
		String lang="";
		if(language!=null){
			for(int i=0;i<language.length;i++){
				lang += language[i]+",";
			}
		}
		out.println("<p/>");
		out.printf("이름 : %s<br/>비밀번호 : %s<br/>나이 : %s<br/>email : %s<br/>성별 : %s<br/>관심있는 언어 : %s<br/>전화번호 : %s<br/>그림 : %s<br/>자기소개 : %s<br/>커맨드 : %s<br/>광고수신여부 : %s<br/>",
				name,password,age,email,sex,lang,phoneNum,picture,intro,command,adv!=null?"yes":"no");
		
		out.println("</body></html>");//body, html닫기.
		
	}
}
