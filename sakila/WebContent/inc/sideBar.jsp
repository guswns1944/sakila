<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
		<title>staffInfo</title>
        <link href="/sakila/sakilaStyle.css" rel="stylesheet" type="text/css" />
        <link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css" />
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    </head>
<body>
	<div id="sidebar">
		<h3>
			Sakila Movie
		</h3>
		
		<table id="staff">
			<tr>
				<td rowspan="2"><a href="${pageContext.request.contextPath }/StaffInfoServlet" class='fas fa-user-circle' style='font-size:60px'></a></td>
				<td><span>${ loginStaff.storeId}</span> 지점</td>
			</tr>
			
			<tr>
				<td><span>${ loginStaff.username}</span> 관리자님</td>
			</tr>
		</table>
		
		<div>
			<!--  <a data-role="button" id ="logout" href="${pageContext.request.contextPath }/auth/LogoutServlet">로그아웃</a>-->
			<button type="button" id="logout" onClick="location.href ='${pageContext.request.contextPath }/auth/LogoutServlet'">logout</button>
		</div>
		
		<h3>
			Menu
		</h3>
		
		<ul class="linkedList">
			<li class="line">
				<a href="${pageContext.request.contextPath }/auth/IndexServlet">홈</a>
			</li>
			<li>
				<a href="#">영화 반납</a>
			</li>
			<li class="line">
				<a href="${pageContext.request.contextPath}/CustomerServlet">회원목록 관리</a>
			</li>
			<li>
				<a href="#">영화재고 관리</a>
			</li>
			<li>
				<a href="#">영화배우 관리</a>
			</li>
			<li>
				<a href="#">영화 출연배우 등록</a>
			</li>
			<li class="line">
				<a href="#">매장 통계</a>
			</li>
			<li class="last">
				<a href="#">MVP</a>
			</li>
		</ul>
	</div>
</body>
</html>