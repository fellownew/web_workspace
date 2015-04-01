package controller;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FrontController extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공통적 선처리 작업 
		request.setCharacterEncoding("UTF-8");
		
		Controller controller = null;
		
		//업무처리 컨트롤러 호출
		String cmd = request.getParameter("command");
		if(cmd.equals("register")){
			//등록 컨트롤러 호출
			controller = new RegisterController();
		}else if(cmd.equals("search")){
			//조회 컨트롤러 호출
//			controller = new SearchController();
		}else if(cmd.equals("link")){
			//WEB-INF 내로 링크 걸기 위한 컨트롤러 호출
			controller = new LinkController();
		}
		
		try{
			AttributeAndView av = controller.handleRequest(request, response); //받아오는 것.
			
			//공통적 후처리 작업 - 응답처리 ( redirect, RequestDispatch- request scope 속성을 binding)
			if(av.isRedirect()){
				response.sendRedirect(av.getUrl());
			}else{
				//만약 av에 attributes가 있다면 requestScope에 binding
				Map<String,Object> attributes = av.getAttributes();
				if(attributes!=null&&attributes.size()!=0){
					Set<String> Keys = attributes.keySet();
					for(String key : Keys){
						request.setAttribute(key, attributes.get(key));
					}
				}
				RequestDispatcher rd = request.getRequestDispatcher(av.getUrl());
				rd.forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
