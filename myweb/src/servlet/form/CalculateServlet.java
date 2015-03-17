package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int result=0;
		boolean check=true;
		String fail="";
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String calc= request.getParameter("calc");
		if(calc==null){
			result = 0;
			fail = "값을 입력해주세요";
			check=false;
		}else if(calc.equals("plus")){
			result = num1+num2;
		}else if(calc.equals("reduce")){
			result = num1-num2;
		}else if(calc.equals("multi")){
			result = num1*num2;
		}else if(calc.equals("division")){
			if(num1==0){
				fail = "나눗셈에 첫번째 수에 0을 넣으면 안됩니다.";
				check=false;
			}
			result = num1/num2;
		}
		
		out.println("<html><head><title>계산 결과</title></head><body>");
		if(check){
			out.println("계산 결과 값 : "+result+"<br/>");
		}else{
			out.println(fail);
		}
		out.println("<a href='/myweb/form/caculate_form.html'>다시하기</a>");
		out.println("</body></html>");
		
	}//doPost end
}//class end
