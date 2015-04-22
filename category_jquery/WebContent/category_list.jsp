<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, td{
	border: 1px solid black;
}
table{
	width:700px;
	border-collapse: collapse;
}
td{
	padding: 5px; /* 안쪽 여백 너비 */
}
select{
	width:150px;
}
#product_info_layer{
	width:700px;
	border: 1px solid gray;
	padding:5px;/* 안쪽 여백 너비 */
	display: none;/*최초로딩시에는 안보이도록 처리*/
}
#tbody{
	cursor: pointer;
}
</style>
<script type="text/javascript" src="/category_jquery/script/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#first_category").on("change",function(){
			$.ajax({
				url:"/category_jquery/controller",
				type:"POST",
				data:{"command":"second_category","firstCategoryId":$("#first_category").val()},
				dataType:"JSON",
				success:function(jdata){
					$("#thead").empty();
					$("#tbody").empty();
					$("#product_info_layer").hide();
					$("#second_category").empty().append("<option value='default'>중분류</option>");
					$("#third_category").empty().append("<option value='default'>소분류</option>");
					for(var i = 0;i<jdata.length;i++){
						$("#second_category").append("<option value="+jdata[i].categoryId+">"+jdata[i].categoryName+"</option>");
					}
					
				},
				error:errorCallback
			});
		});
		
		
		$("#second_category").on("change",function(){
			$.ajax({
				url:"/category_jquery/controller",
				type:"POST",
				data:{"command":"third_category","secondCategoryId":$("#second_category").val()},
				dataType:"JSON",
				success:function(jdata){
					$("#thead").empty();
					$("#tbody").empty();
					$("#product_info_layer").hide();
					$("#third_category").empty().append("<option value='default'>소분류</option>");
					for(var i = 0;i<jdata.length;i++){
						$("#third_category").append("<option value="+jdata[i].categoryId+">"+jdata[i].categoryName+"</option>");
					}
				},
				error:errorCallback
			});
		});
		
		
		$("#third_category").on("change",function(){
			$.ajax({
				url:"/category_jquery/controller",
				type:"POST",
				data:{"command":"get_product_list","thirdCategoryId":$(this).val()},
				dataType:"JSON",
				success:function(jdata){
					$("#thead").empty();
					$("#tbody").empty();
					$("#product_info_layer").hide();
					$("#thead").empty().append($("<tr>")
							  	.append($("<td>").text("제품ID")).append($("</td>"))
								.append($("<td>").text("제품명")).append($("</td>"))
								.append($("<td>").text("제조사")).append($("</td>"))
								.append($("<td>").text("제품가격")).append($("</td>"))
								.append($("</tr>")));
					
					for(var i = 0;i<jdata.length;i++){
						$("#tbody").append($("<tr>").append($("<td>").text(jdata[i].productId)).append($("</td>"))
									.append($("<td>").text(jdata[i].productName)).append($("</td>"))
									.append($("<td>").text(jdata[i].productMaker)).append($("</td>"))
									.append($("<td>").text(jdata[i].productPrice)).append($("</td>"))
									.append($("</tr>")));
					}
				},
				error:errorCallback
			});
		});
		
		$("#tbody").on("click","tr",function(){
			$("#tbody tr").css("background-color","white");
			$(this).css("background-color","rosybrown");
			$.ajax({
				url:"/category_jquery/controller",
				type:"POST",
				data:{"command":"get_product_info","productId":$(this).find(":first").text()},
				dataType:"JSON",
				success:function(jdata){

					$("#product_info_layer").text(jdata.productInfo);
					$("#product_info_layer").show();
				},
				error:errorCallback
			});
		});
		
		
		
		function errorCallback(xhr,msg,statusMsg){
			alert("오류가 발생하였습니다."+xhr.readyState+","+msg+","+statusMsg);		
		}
	});

</script>
</head>
<body>
대분류 : 
<select name="first_category" id="first_category">
	<option value='default'>대분류</option>
	<c:forEach items="${requestScope.firstCategory }" var="fisrt">
		<option value="${fisrt.categoryId }">${fisrt.categoryName }</option>
	</c:forEach>
	
</select>
중분류 : 
<select id="second_category">
	<option value='default'>중분류</option>
</select>
소분류 : 
<select id="third_category">
	<option value='default'>소분류</option>
</select>
<p>
<table>
	<thead id="thead"></thead>
	<tbody id="tbody"></tbody>
</table>
<p>
<!-- 상품 상세 정보 출력할 div-->
<div id="product_info_layer"></div> 
</body>
</html>




    