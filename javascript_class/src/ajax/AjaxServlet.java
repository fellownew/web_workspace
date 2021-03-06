package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");
		response.setContentType("text/html;charset=UTF-8");
		if(cmd.equals("get_hello")){
			getHello(request,response);
		}else if(cmd.equals("post_hello")){
			postHello(request,response);
		}else if(cmd.equals("plus")){
			plus(request,response);
		}else if(cmd.equals("idCheck")){
			idCheck(request,response);
		}
		
		
		
	}

	public void getHello(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//01_get_hello의 요청을 처리할 controller 메소드
		//controller 로직
		//1. 요청 받기
//		response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("name");
		//2. 업무 로직 처리
		String greeting = name+"님 안녕하세요! 반갑습니다.";
		//3. 응답
		response.setHeader("cache-control", "no-cache,no-store");
		//응답하는 결과(text)를 브라우저가 cache로 저장하지 않도록 header를 설정.
		PrintWriter out = response.getWriter();
		out.print(greeting);
		
	}

	public void postHello(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("name");
		String greeting = name+"님 안녕하세요! 반갑습니다.";
		System.out.println(greeting);
		response.setHeader("cache-control", "no-cache,no-store");	
		PrintWriter out = response.getWriter();
		out.print(greeting);		
	}
	
	public void plus(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		double operand1 = Double.parseDouble(request.getParameter("operand1"));
		double operand2 = Double.parseDouble(request.getParameter("operand2"));
		String operator = request.getParameter("operator");
		double result = 0;
		String str = null;
		String op = null;
		if(operator.equals("plus")){
			result = operand1+operand2;
			op = " + ";
		}else if(operator.equals("reduce")){
			result = operand1-operand2;
			op = " - ";
		}else if(operator.equals("div")){
			result = operand1/operand2;
			op = " / ";
		}else if(operator.equals("multi")){
			result = operand1*operand2;
			op = " * ";
		}
		str = operand1+op+operand2+"의 값은"+result+"입니다.";
		response.setHeader("cache-control", "no-cache,no-store");	
		PrintWriter out = response.getWriter();
		out.print(str);		
	}
	
	
	public void idCheck(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		ArrayList<String> ids = new ArrayList<String>();
		ids.add("id-1111");
		ids.add("id-2222");
		ids.add("id-3333");
		ids.add("id-4444");
		ids.add("id-5555");
		
		String str = null;
		String id = request.getParameter("id");
		
		if(id.length()<6){
			str="짧아";
		}else{
			for(String member : ids){
				if(member.equals(id)){
					str = "중복";
				}
			}
		}
		PrintWriter out = response.getWriter();
		out.print(str);	
		
	}
}
