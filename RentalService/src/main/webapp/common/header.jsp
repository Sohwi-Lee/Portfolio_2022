<%@page import="model.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<%UserDAO daos = UserDAO.getInstance();%> 
	<header>
		<div>
			<h1 class="logo">
				<a href="/RentalService/">SH-Rental</a>
			</h1>
			<nav class="quickNav">
				<ul class="clearfix">
					<li> <form action="/RentalService/service"><input type="submit" name="command" value="이벤트"></form></li>
					<li> <form action="/RentalService/service"><input type="submit" name="command" value="이용후기"></form></li>
					<li> <form action="/RentalService/service"><input type="submit" name="command" value="예약하기"></form></li>
					<li> <form action="/RentalService/service"><input type="submit" name="command" value="예약확인"></form></li>
				</ul>
			</nav>
			<ul class="forUsers">
				<%if (session.getAttribute("log") == null) {%>
					<li> <form action="/RentalService/service"><input type="submit" name="command" value="로그인"></form>
					<li> <form action="/RentalService/service"><input type="submit" name="command" value="회원가입"></form>
				<%} else {%>
					<li><p class="loginUser"><%= session.getAttribute("log")%></p></li>
	 				<li>
	 				<form action="/RentalService/service"><input type="submit" name="command" value="로그아웃"></form>
	 				</li>
				<%}%>
			</ul>
			<div class="toggle">
				<button class="allNav-open" onclick="openMenu()">전체메뉴</button>
				<nav class="allNav">
					<button class="allNav-close" onclick="closeMenu()">닫기</button>
					<ul>
					<li> <form action="/RentalService/service"><input type="submit" name="command" value="예약하기"></form></li>
					<li> <form action="/RentalService/service"><input type="submit" name="command" value="예약확인"></form></li>
					<li> <form action="/RentalService/service"><input type="submit" name="command" value="이용후기"></form></li>
					<li> <form action="/RentalService/service"><input type="submit" name="command" value="이벤트"></form></li>
					<li> <form action="/RentalService/service"><input type="submit" name="command" value="공지사항"></form></li>
						<%if(session.getAttribute("log") != null) {%>
					<li> <form action="/RentalService/service"><input type="submit" name="command" value="마이페이지"></form></li>
						<%}%>
					</ul>
				</nav>
			</div>
		</div>
	</header>
	
	<script>
	    function openMenu(){
	        document.querySelector(".allNav-open").addEventListener('click',e=>{
	            document.querySelector(".allNav-close").setAttribute('style','display:block');
	            document.querySelector(".allNav").setAttribute('style','display:block');
	        });
	    }
	    function closeMenu(){
	        document.querySelector(".allNav-close").addEventListener('click',e=>{
	            document.querySelector(".allNav-open").setAttribute('style','display:block');
	            document.querySelector(".allNav").setAttribute('style','display:none');
	        });
	    }
    </script>
</body>
</html>