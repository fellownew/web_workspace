package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateServlet2 extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		request.setCharacterEncoding("UTF-8");
		double result=0;
		boolean check=true;
		String fail="";
		double num1 = Integer.parseInt(request.getParameter("num1"));
		double num2 = Integer.parseInt(request.getParameter("num2"));
		String calc= request.getParameter("calc2");
		if(calc.equals("plus")){
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
		
		
		request.setAttribute("result", result);
		request.setAttribute("message", fail);
		request.setAttribute("check", check);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/calculate_result.jsp");
		rd.forward(request, response);

		
	}//doPost end
}//class end
