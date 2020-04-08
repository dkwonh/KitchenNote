<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
	fieldset {
		display : inline-block;
	}
</style>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
	function loadCategory(ing_category){
		var url = "category.do"
		var params = "ing_category="+ing_category
		$.ajax({
			type:"get"		
			,url:url
			,data:params		
			,dataType:"json" })
			.done(function(args){	//응답이 성공 상태 코드를 반환하면 호출되는 함수
				$("#category").each(function() {	
					$("#category input").remove();
					$("#category").text("");
				});
				 for(var i=0; i < args.length; i++) {
					  $("#category").append("<fieldset onclick=ingredients("+args[i].ing_id+",'"+args[i].ing_name+"')>"+args[i].ing_name +"</fieldset>");
				 }
	 			})
		    .fail(function(e) {
		    	alert(e.responseText);
		    })
	}

	function ingredients(id,name){
		if($("#selected #"+id).length==0){
			$("#selected").append("<fieldset id="+id+" onclick='diselectIngredients("+id+")'><input type='hidden' name='ingredients[]' value="+id+">"+name+"</fieldset>");
		}
		else{
			$("#selected #"+id).remove();
		}
	}

	function diselectIngredients(id){
		$("#selected #"+id).remove();
	}
</script>
</head>
<body>
<ul>
<c:forEach var="category" items="${category }">
	<li id="${category.key}" onclick="loadCategory(${category.key})">${category.value.category_name}
</c:forEach>
</ul>


<div id="category">
<c:forEach var="item" items="${dto }">
	<fieldset onclick="ingredients(${item.ing_id},'${item.ing_name }')">${item.ing_name } </fieldset>
</c:forEach>
</div>
<form method="post" action="nangbu.do">
<div id="selected">
재료를 선택하세요
</div>
<input type="submit" value="재료로검색">
</form>
</body>
</html>