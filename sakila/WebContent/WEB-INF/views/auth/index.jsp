<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>sakila</title>
        <link href="/sakila/sakilaStyle.css" rel="stylesheet" type="text/css" />
        <link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css" />
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
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
							<h2>index</h2>
							
							<p>
								1231231231231231231312321
							</p>
							
							
						<br class="clear" />
					</div>
					<br class="clear" />
				</div>
					<br class="clear" />
					
					<div id="copyright">
						<!-- 방문자 / 전체 방문자 -->
						<p>visitant :  / </p>
						&copy; sakila | Made by byoungyoon
					</div>
				</div>
		</div>
    </body>
</html>
