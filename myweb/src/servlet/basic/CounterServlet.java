package servlet.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet extends HttpServlet{
	private int counter; // 요청자의 counter 값 ( 몇번째 요청한 것인지)를 지정할 변수.
//	private String path = "C:\\JAVA\\counter.dat";
	private String path;
	
	//client의 요청을 처리하는 메소드 - 요청방식 - GET:doGet(), POST : doPost()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//응답헤더에 content-type 을 지정
		response.setContentType("text/html;charset=UTF-8"); //응답 헤더에 content-type을 지정
		//요청한 클라이언트와 연결된 출력 Stream
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>카운터 서블릿</title></head><body>");
		counter++;
		out.println("당신은 "+counter+"번째 손님입니다..<br/>");
		out.println("</body></html>");
	}
	
	
	public void init(){
		path = getInitParameter("filepath");
		File file = new File(path);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			counter = fis.read();

		} catch (FileNotFoundException e) {
			// 파일을 못찾아서 Exception이 발생한다면 파일 만들자.
			e.printStackTrace();
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// 파일 생성중 문제 생기면 예외
				e1.printStackTrace();
			}
		} catch (IOException e) {
			// 기타 문제 예외
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// fis 닫기 예외
					e.printStackTrace();
				}
			}
		}

	}
	public void destroy(){
		File file = new File(path);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);	
			fos.write(counter);
			} catch (IOException e) {
				// 쓰기중 예외
				e.printStackTrace();
			}finally{
				if(fos!=null){
					try {
						fos.close();
					} catch (IOException e) {
						// fos 닫기중 예외	
						e.printStackTrace();
					}
				}
			}
	}
}
