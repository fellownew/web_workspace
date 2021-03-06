package calc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calc.model.service.CalculateService;

public class PlusController extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//1. 요청 파라미터 조회
			int num1 = Integer.parseInt(request.getParameter("num1"));
			int num2 = Integer.parseInt(request.getParameter("num2"));
		//2. business logic 호출
			CalculateService service = CalculateService.getInstance();
			int result = service.plus(num1,num2);
			//3. 응답 처리
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("/calc_result.jsp");
			rd.forward(request, response);
	}
}
