package servlet.session.cart;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingCartServlet extends HttpServlet{
	public void doGet(HttpServletRequest requset, HttpServletResponse response) throws IOException, ServletException{
		doPost(requset, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("UTF-8");
		String url=null;
		HttpSession session = request.getSession();
		boolean isRedirect = false;
		
		if(session.getAttribute("login_id")==null){//로그인을 안한 상태라면.
			url = "/session/login_form.jsp";
			request.setAttribute("failmessage", "로그인을 해주세요");
			
		}else{//로그인을 한 상태라면 작업 실시

			String products[] = request.getParameterValues("product");//list.jsp에서 보낸 파라미터들 가져오기.
			HashMap<String, Integer> cartMap;
			Object obcartList = session.getAttribute("cartMap");
			
			if(obcartList!=null){//불러온 attribute가 null이 아니라면 가져온다.
				cartMap = (HashMap<String, Integer>)obcartList;
				if(products!=null){//장바구니 담기에 체크된것이 있다면.
					//장바구니 담기에 체크된 것이 없을 경우 errormessage와 함께 list.jsp(쇼핑 리스트)로 url을 지정하여 보내도 됨.
					for(int i =0;i<products.length;i++){
						if(!cartMap.containsKey(products[i])){//없는 제품이라면 새로 put 한다.
							cartMap.put(products[i], 0);
						}
						//해당 제품의 값에 1을 더하면서 put으로 갱신함.
						cartMap.put(products[i], cartMap.get(products[i])+1);
					}
				}
				/*
				 * else{
				 * request.setAttribute("errorMessage","상품을 한개 이상 선택해주세요");
				 * url = "/WEB-INF/jsp/cart/list.jsp;
				 * }
				 */
			}else{//기존의 attribute가 없어서 null이면 맵을 새로 만든다.
				cartMap = new HashMap<String,Integer>();
				if(products!=null){//입력값이 하나라도 있다면.
					for(int i =0;i<products.length;i++){//만든 후 초기 받은 값들로 put 한다.
					cartMap.put(products[i], 1);
					}
				}
			}
			session.setAttribute("cartMap", cartMap);//위 작업을 모두 마친 후 session scope에 다시 저장한다.
			url = "/WEB-INF/jsp/cart/cart.jsp";
			isRedirect = true;
			
		}
		if(isRedirect){
			//url 노출이 싫다면 session scope를 이용해 넘겨주는 방법이 있다.
			response.sendRedirect("/myweb/redirect?path="+url);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}//doPost end
}//Class end