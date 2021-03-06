package json.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import json.vo.Member;

@WebServlet("/json")
public class JSONServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");
	
		if(cmd.equals("searchMemberById")){
			searchMemberById(request,response);

		}else if(cmd.equals("subwayLine")){
			subwayLine(request,response);

		}else if(cmd.equals("getMemberList")){
			getMemberList(request,response);

		}
	}
	public void searchMemberById(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("id-1","홍길동","hong@gmail.com",23000,false));
		list.add(new Member("id-2","임꺽정","lim@gmail.com",15000,false));
		list.add(new Member("id-3","장길산","jang@gmail.com",26000,false));
		list.add(new Member("id-4","김철수","kim@gmail.com",35000,true));
		list.add(new Member("id-5","박영희","bark@gmail.com",11000,true));
		list.add(new Member("id-6","최대박","choi@gmail.com",1000,true));
		//요청 파라미터 조회
		String id = request.getParameter("id").trim();
		//비지니스 로직 처리.
//		Member result = new Member(id,"최대박","choi@gmail.com",1000,true);
		response.setContentType("text/html;charSet=UTF-8");
		PrintWriter out = response.getWriter();
//		JSONObject obj = new JSONObject(result);
		
		JSONObject obj = null;		
		for(Member member:list){
			if(id.equals(member.getId())){
				obj = new JSONObject(member);
			}
		}
//		if(obj==null){
//			obj = new JSONObject(new Member("없는","아이디","입니다",0,false));
//		}
		out.print(obj);		
	}
	
	public void subwayLine(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charSet=UTF-8");
		String city = request.getParameter("city");
		ArrayList<String> line = findSubwayLine(city);
		PrintWriter out = response.getWriter();
		//단순 목록에 대한 리턴이기때문에 배열로 넘겨줌.
		JSONArray arr = new JSONArray(line);
		out.print(arr);
		
	}
	
	public ArrayList<String> findSubwayLine(String city){
		ArrayList<String> lines = new ArrayList<String>();
		if(city.equals("seoul")){
			lines.add("1호선");
			lines.add("2호선");
			lines.add("3호선");
			lines.add("4호선");
			lines.add("5호선");
			lines.add("6호선");
			lines.add("7호선");
			lines.add("8호선");
			lines.add("9호선");
			lines.add("분당선");
			lines.add("신분당선");
		}else if(city.equals("busan")){
			lines.add("1호선");
			lines.add("2호선");
			lines.add("3호선");
			lines.add("4호선");
		}else if(city.equals("kwangju")){
			lines.add("1호선");
		}else if(city.equals("daegu")){
			lines.add("1호선");
			lines.add("2호선");
		}
		return lines;
	}
	
	public void getMemberList(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charSet=UTF-8");

		int idx = (int)(Math.random()*10+1);
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("id-"+(idx+1),"홍길동","hong@gmail.com",2300*idx,false));
		list.add(new Member("id-"+(idx+2),"임꺽정","lim@gmail.com",1500*idx,false));
		list.add(new Member("id-"+(idx+3),"장길산","jang@gmail.com",2600*idx,false));
		list.add(new Member("id-"+(idx+4),"김철수","kim@gmail.com",3500*idx,true));
		list.add(new Member("id-"+(idx+5),"박영희","bark@gmail.com",1100*idx,true));
		list.add(new Member("id-"+(idx+6),"최대박","choi@gmail.com",100*idx,true));
		JSONArray arr = new JSONArray(list);
		PrintWriter out = response.getWriter();
		out.print(arr);
		
	}
}
