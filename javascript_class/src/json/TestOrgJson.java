package json;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestOrgJson {
	public static void test1() throws JSONException{
		//JSONObject에 직접 name-value를 하나씩 추가함.
		JSONObject obj = new JSONObject();
		obj.put("id", "김철수");
		obj.put("age", 30);
		obj.put("height", 180.7);
		obj.put("marriage",false);
		
		String txt = obj.toString();
		System.out.println(txt);
	}
	
	public static void test2(){
		//VO의 값을 JSONObject를 이용해 json 문자열로 변환-생성자의 매개변수로 VO를 넣어 객체 생성.
		Customer c = new Customer("id-k","김영수",20,70.3,false);
		JSONObject obj = new JSONObject(c);
		System.out.println(obj);
	}
	
	public static void test3(){
		Customer c = new Customer("id-10","박철수",35,72.3,true,new Address("111-222","서울"));
		JSONObject obj = new JSONObject(c);
		System.out.println(obj);
	}
	
	public static void test4() throws JSONException{
		JSONArray arr = new JSONArray();
		arr.put("이순신");
		arr.put(false);
		arr.put(1000);
		arr.put(178.1);
//		arr.put(new Address("111-343","경기도 성남시"));
		arr.put(new JSONObject(new Address("111-343","경기도 성남시")));
		System.out.println(arr);
	}
	public static void test5() throws JSONException{
		String [] names={"김철수","박영수","홍길동","장길산"};
		JSONArray arr = new JSONArray(names);		
		System.out.println(arr);
	}
	public static void test6(){
		Customer c1 = new Customer("id-a","박철수",35,72.3,false,null);
		Customer c2 = new Customer("id-b","김철수",25,70.5,true,new Address("111-222","서울"));
		Customer c3 = new Customer("id-c","최영희",27,51.7,true,new Address("123-456","성남"));
		ArrayList<Customer> list = new ArrayList<Customer>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		JSONArray arr = new JSONArray(list);
		System.out.println(arr);
	}
	public static void main(String[] args) throws JSONException {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
	}
}
