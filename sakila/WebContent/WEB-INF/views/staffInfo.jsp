<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css">
<link href="/sakila/sakilaStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="bg">
		<div id="outer">
			<div id="main">
				<!-- 모든 페이지에서 side메뉴바를 사용하기 떄문에 따로 저장하여 불러옴 -->
				<div>
					<jsp:include page="/inc/sideBar.jsp"></jsp:include>
				</div>
				<div id="content">
					<div>
						<h2>관리자 정보</h2>
						<button type="button" class="btn btn-secondary" style="float: right;">정보 수정</button>
					<br>
					<br>
					</div>
						<table style="margin:40px">
							<tr>
								<td width="10%">이름 : </td>
								<td width="15%">${staffInfo.name }</td>
								<td rowspan="6" style="text-align:right;"><img src="/sakila/images/${staffInfo.picture}"></td>
							</tr>				
							<tr>
								<td>닉네임 : </td>
								<td>${staffInfo.username }</td>
							</tr>				
							<tr>
								<td>연락처 : </td>
								<td>${staffInfo.phone }</td>
							</tr>				
							<tr>
								<td>주소 : </td>
								<td>${staffInfo.city } ${staffInfo.country }</td>
							</tr>				
							<tr>
								<td>&nbsp; </td>
								<td>${staffInfo.address }</td>
							</tr>				
							<tr>
								<td>E-mail : </td>
								<td>${staffInfo.email }</td>
							</tr>				
						</table>
						
					<br class="clear" />
				</div>
				<br class="clear" />
			</div>
				<br class="clear" />

			</div>
		</div>
</body>
</html>