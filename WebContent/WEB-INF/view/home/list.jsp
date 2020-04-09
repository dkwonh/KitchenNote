<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<style type="text/css">

.float {
float:left;
}

.navi button{
float: left;
}
.c button 
{width:25%}


ul li {
	list-style-type:none;
}
</style>
</head>
<script>
	$(function(){
		var url = "loadCategory.do";
		$.ajax({
			type:"get"		
			,url:url		
			,dataType:"json" })
			.done(function(args){	//응답이 성공 상태 코드를 반환하면 호출되는 함수
				 for(var i=0; i < args.length; i++) {
					 if(i<8){
					  $("ul.first").append("<li><input id="+args[i].category_id+" ondblclick='this.checked=false'  type='radio' name='category1' value="+args[i].category_id+"><label for="+args[i].category_id+">"+args[i].category_name+"</label></li>");
					 }
					 else if(i<16){
						  $("ul.second").append("<li><input id="+args[i].category_id+" type='radio' name='category2' value="+args[i].category_id+"><label for="+args[i].category_id+">"+args[i].category_name+"</label></li>");
					}
					 else if(i<26){
						 $("ul.third").append("<li><input id="+args[i].category_id+" type='radio' name='category3' value="+args[i].category_id+"><label for="+args[i].category_id+">"+args[i].category_name+"</label></li>");
						}
					 else{
						 $("ul.last").append("<li><input id="+args[i].category_id+" type='radio' name='category4' value="+args[i].category_id+"><label for="+args[i].category_id+">"+args[i].category_name+"</label></li>");
					 }
				 }
	 			})
		    .fail(function(e) {
		    	alert(e.responseText);
		    })
	});

	function itemClick(item) {
		alert("레시피 읽기 기능 ID :" + item);
	}

	function nangbu() {
		location.href = "nangbu.do";
	}

	$(function(){
		$("button#category").on('click',function(){
				var s = $("div#category").css('display')
				if($("div#category").css('display')=='none'){
					$("div#category").css('display','block');
				} else{
					$("div#category").css('display','none');
					}
			});

		$("button#recipe").on('click',function(){
			alert("레시피 보기");
			});

		$("button#event").on('click',function(){
			alert("이벤트 보기");
			});
			
		$("button#support").on('click',function(){
			alert("고객센터 보기");
			});

		
		});

	
</script>
<body>

	<div id=wrapper>

		<div id=main>
			<div class=inner>
				<header id="header">
					<a href="index.html" class="logo"><strong>Editorial</strong>
					KitchenNote</a>
					<form action="home.do" method="post">
						<input type="text" name="search">
						<input type=submit value=검색> 
					</form>	
					<ul class="icons"> 
						<li><a onclick="nangbu()" class="icon fa-twitter"><span
								class="label">twitter</span></a></li>
						<li><a href="#" class="icon fa-facebook"><span
								class="label">Facebook</span></a></li>
						<li><a href="#" class="icon fa-snapchat-ghost"><span
								class="label">Snapchat</span></a></li>
					</ul>
					
				</header>
				<section>
				<div class="navi c">
				<button id="category">카테고리</button>
				<button id="recipe">레시피</button>
				<button id="event">이벤트</button>
				<button id="support">고객센터</button>
				</div>
				<div id="category" class="4u 12u$(small)" style="display:none;">
					<form action="searchCategory.do">
						<ul>
							<li style="display:inline-block">
								<h3>상황별 요리</h3>
								<ul class="first">
									</ul>
							</li>
							<li style="display:inline-block">
								<h3>나라별 요리</h3>
								<ul class="second">
									</ul>
							</li>
							<li style="display:inline-block">
								<h3>재료별 요리</h3>
								<ul class="third">
									</ul>
							</li>
							<li style="display:inline-block">
								<h3>조리별 요리</h3>
								<ul class=last>
								</ul>
							</li>
						</ul>
						
						<input type="submit" value="검색">
					</form>
				</div>
				<div>
					기준1:<br>
					<c:forEach var="item" items="${dto }">
						<fieldset class=float onclick="itemClick(${item.recipe_Id})">
							<img src="${item.image}"><br> ${item.recipe_Name }<br>
							${item.recipe_Exp}<br> ${item.nickname }<br>
							<p>시간:${item.duration }, 조회수:${item.readcount }</p>
						</fieldset>
					</c:forEach>
					<button id="recipe">더보기</button>
					<br>
					<p>
					</div>
				</section>
			</div>
		</div>
	</div>
	
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>
</body>
</html>