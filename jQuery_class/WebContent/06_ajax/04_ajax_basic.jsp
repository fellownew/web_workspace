<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery</title>
<script type="text/javascript" src="/jQuery_class/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	$("#ajaxBtn").on("click",function(){
		$.ajax({
			"url":"/jQuery_class/jQueryCtr",
			"type":"POST",
			"data":{"command":"getMemberById","id":$("#id").val()},
			"dataType":"text",
			"success":function(txt){
				//매개변수 : 1.응답데이터, 2.응답메시지, 3.XMLHttpRequest(모두 생략 가능)
				//서버로부터 정상응답이 온경우 호출할 함수 객체 등록
				$("#layer").html(txt);
				
			},
			"beforeSend":function(){
				//요청 전에 호출할 함수를 등록 - return false시 요청을 안함.
				if(!$("#id").val()){//입력된 id값이 없다면 
					alert("조회할 id를 입력하세요.");
					$("#layer").html("");
					$("#id").focus();
					return false;//요청을 안함.
				}
			},
			"error":errorCallback
		});
	});
	
	$("#jsonBtn").on("click",function(){
		$.ajax({
			url:"/jQuery_class/jQueryCtr",
			type:"POST",
			data:"command=getMemberByIdJson&id="+$("#id").val(),
			dataType:"JSON",
			beforeSend:function(){
			if(!$("#id").val()){//입력된 id값이 없다면 
				alert("조회할 id를 입력하세요.");
				return false;//요청을 안함.		
			}
		},
		
		error:errorCallback,success:function(obj){
				var txt = obj.id+"<br>"+obj.name+"<br>"+obj.age+"<hr>";
				$("#layer").html(txt);
			}
		});
	});
	
		//오류 응답시 호출할 함수
		//매개변수 : 1. XMLHttpRequest, 2. 응답 메시지(success,error)
		function errorCallback(xhr,msg,statusMsg){
			alert("요청시 오류발생"+xhr.readyState+","+msg+","+statusMsg);		
		}
	});
</script>
     
</head>
<body>    
  
<form>
	ID : <input type="text" name="id" id="id">
	<input type="button" value="ajax전송" id="ajaxBtn">
	<input type="button" value="json전송" id="jsonBtn">
</form>
<div id="layer"></div>
</body>
</html>











