<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<body>
<div class="container">
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
	<form method="post" action="${pageContext.request.contextPath }/LoginServlet">
		<table style="margin: auto; text-align: center;" width="300px">
			<tr>
				<td>
					<a href="#"><i class='fas fa-user-circle' style='font-size:200px; text-align: center; color:#A6A6A6;'></i></a>
				</td>
			</tr>
			<tr>
				<td style="padding-bottom: 8px;">
					<input type="text" class="form-control" placeholder="ID" name = "id">
				</td>
			</tr>
			<tr>
				<td style="padding-bottom: 8px;">
					<input type="password" class="form-control" placeholder="PW" name = "pw">
				</td>
			</tr>
			<tr>
				<td>
					<button class = "btn-secondary btn-block" style=float:right; type="submit">Log-in</button>
				</td>
			</tr>
		</table>
		<div style="text-align: center;">
		오늘 접속자 수 : ${map["returnStats"].cnt} / 전체 접속자 수 : ${map["totalStats"] }
		</div>
	</form>
</div>
</body>
</html>