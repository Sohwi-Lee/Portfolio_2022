<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/RentalService/resources/common.css">
<link rel="stylesheet" href="/RentalService/resources/login.css">
<title>Login</title>
</head>
<body>
	<div class="wrap">
		<%@ include file="/common/header.jsp"%>

		<main>
			<section class="login">
				<h2>로그인</h2>
				<form action="/RentalService/service">
				<input type="hidden" name="command" value="login">
					<div class="inputId">
						<label for="id">아이디</label> <input type="text" name="id" id="id" placeholder="아이디 입력">
					</div>
					<div class="inputPw">
						<label for="pw">비밀번호</label> <input type="password" name="pw" id="pw" placeholder="비밀번호 입력"><br>
					</div>					
					<input class="btnLogin" type="submit" value="로그인">
				</form>
				<p class="notFound" style="display: none">아이디 혹은 비밀번호를 확인해주세요</p>
				<p>
					<a href="">아이디 찾기</a><a href="">비밀번호 찾기</a>
				</p>
			</section>

			<section class="toJoin">
				<div>
					<h3>Rental Site 회원이 아니신가요?</h3>
					<p> <span>간편하게 가입하고</span> <span>오직 회원에게만 제공하는 혜택</span> <span>놓치지 마세요!</span></p>
					<button onclick="location.href='/RentalService/view/join.jsp'">회원가입</button>
				</div>
			</section>
		</main>

		<%@ include file="/common/footer.jsp"%>
	</div>
</body>
</html>