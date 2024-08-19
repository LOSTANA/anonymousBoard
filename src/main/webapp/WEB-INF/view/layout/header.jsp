<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>그린 게시판</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
body {
	height: 100vh;
	margin: 0;
}

.m--flex-container {
	display: flex;
	flex-direction: column;
	height: 100%;
}

.m--container {
	flex: 1;
}

.navbar-nav{
	justify-content: flex-start;
	align-items: center;
}

.text1{
	color: white;
	margin-left: auto;
}

.text2{
	color: orange;
	padding:10px;
	margin-left: auto;
}
</style>
</head>
<body>
	<div class="m--flex-container">
		<div class="m--container">
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark"> 
				<a class="navbar-brand" href="/main-page">MetaCoding</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="collapsibleNavbar">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/board">글쓰기</a></li>
						<li class="nav-item text1">환영합니다 ${principal} 님!</li>
						<li class="nav-item text2"><form action="/main-page" method="post"><button class="btn btn-warning">아이디 변경</button></form></li>
					</ul>
				</div>
				
			</nav>