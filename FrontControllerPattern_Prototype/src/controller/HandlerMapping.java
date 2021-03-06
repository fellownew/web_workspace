package controller;

public class HandlerMapping {
	
	
	public static Controller getController(String command){
		Controller controller=null;
		
		if(command.equals("register")){
			//등록 컨트롤러 호출
			controller = new RegisterController();
		}else if(command.equals("search")){
			//조회 컨트롤러 호출
			controller = new SearchController();
		}else if(command.equals("link")){
			//WEB-INF 내로 링크 걸기 위한 컨트롤러 호출
			controller = new LinkController();
		}
		
		return controller;
	}
}
