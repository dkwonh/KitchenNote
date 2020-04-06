<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>

<style type="text/css">
 
body{
margin: 0px;
padding: 0px; 
} 


#wrapper{
border: 1px solid #FFBB00;
width:1054px; 
padding: 10px; 
position: absolute;
top: 10px;
left: 50%;
margin-left: -538px;
}

#contents{
border: 1px solid #487BE1;
width:800px;
float: right;
padding: 10px;
}

#sidebar{
border: 1px solid #487BE1;
width:200px;
float: left;
padding: 10px;
margin-left: 10px;
}

</style>
<body>
<div id="wrapper">
<div id="sidebar">
<ul>
	<li>사용자 관리</li>
	<li>레시피 관리</li>
	<li>결제 내역 관리</li>
	<li>이벤트 관리</li>
	<li>문의 사항</li>
	<li>홈페이지 통계</li>
</ul>
</div>
<div id="contents">
일반 사용자 관리
<button>엑셀파일로 받기</button><br>
<table>
	<tr>
	<td>번호</td>
	<td>닉네임</td>
	<td>아이디</td>
	</tr>
	<tr>
	<td>1</td>
	<td>test</td>
	<td>test@test.com</td>
	</tr>
</table>
</div>
</div>
</body>
</html>