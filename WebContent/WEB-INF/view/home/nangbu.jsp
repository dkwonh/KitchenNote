<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>
<style type="text/css">

	.field1>ul {
    height: 270px;
    border: 1px solid #a73f40;
    background: #fff;
    float: left;
    overflow-x: hidden;
    overflow-y: visible;
}

}
.big_sort {
    width: 190px;
    margin-right: 9px;
    box-sizing: border-box;
}

ul {
    display: block;
    list-style-type: disc;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    padding-inline-start: 40px;
}

.small_sort {
    width: 396px;
    height: 270px;
    float: left;
    padding: 10px 13px;
    box-sizing: border-box;
    font-family: Microsoft YaHei,'NS';
    box-sizing: border-box;
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
					  $("#category").append("<li onclick=ingredients("+args[i].ing_id+",'"+args[i].ing_name+"')>"+args[i].ing_name +"</li>");
				 }
	 			})
		    .fail(function(e) {
		    	alert(e.responseText);
		    })
	}

	function ingredients(id,name){
		if($("#selected #"+id).length==0){
			$("#selected").append("<li id="+id+" onclick='diselectIngredients("+id+")'><input type='hidden' name='ingredients[]' value="+id+">"+name+"</li>");
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
<fieldset class=field1>
<ul id="big_sort">
<c:forEach var="category" items="${category }">
	<li id="${category.key}" onclick="loadCategory(${category.key})">${category.value.category_name}<li>
</c:forEach>
</ul>


<ul id="category" class="small_sort">
<c:forEach var="item" items="${dto }">
	<li onclick="ingredients(${item.ing_id},'${item.ing_name }')">${item.ing_name } </li>
</c:forEach>
</ul>
<form method="post" action="nangbu.do">
<div id="selected">
재료를 선택하세요
</div>
<input type="submit" value="재료로검색">
</form>
</fieldset>
</body>
</html>