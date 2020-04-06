<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
		fieldset { display:inline-block; }
</style>
</head>
<body>
<form method="post">
	<input type="text" name="search">
	<input type="submit" value="검색">
</form>
<a href="admin.do">admin</a>

기준1:<br>
<c:forEach var="item" items="${dto }">
<fieldset>
이름:${item.recipe_Name }<br>
ID:${item.recipe_Id }<br>
작성자:${item.member_Id }<br>
</fieldset>
</c:forEach><button>더보기</button><br>
기준2:<br>
<c:forEach var="item" items="${dto }">
<fieldset>
이름:${item.recipe_Name }<br>
ID:${item.recipe_Id }<br>
작성자:${item.member_Id }<br>
</fieldset>
</c:forEach><button>더보기</button><br>
기준3:<br>
<c:forEach var="item" items="${dto }">
<fieldset>
이름:${item.recipe_Name }<br>
ID:${item.recipe_Id }<br>
작성자:${item.member_Id }<br>
</fieldset>
</c:forEach><button>더보기</button>


</body>
</html>