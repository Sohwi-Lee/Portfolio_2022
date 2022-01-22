<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<footer>
		<div class="footerBox">
			<div class="subscribe">
				<p class="logo">SH-Rental</p>
				<p>뉴스레터 구독하기</p> 
				<input type="text" name="subscribe-mail" placeholder="이메일을 입력하세요">
				<input type="button" value="구독">
			</div>
			<div class="corpInfo clearfix">
				<ul>
					<li><p>서비스 소개</p></li>
					<li><a href="#">회사소개</a></li>
					<li> <form action="/RentalService/service"><input type="submit" name="command" value="이용후기"></form></li>
					<li> <form action="/RentalService/service"><input type="submit" name="command" value="이벤트"></form></li>
					<li><a href="">이용혜택</a></li>
				</ul>
				<ul>
					<li><p>고객센터</p></li>
					<li> <form action="/RentalService/service"><input type="submit" name="command" value="공지사항"></form></li>
					<li><a href="help.jsp">자주 묻는 질문</a></li>
					<li> <form action="/RentalService/service"><input type="submit" name="command" value="예약확인"></form></li>
				</ul>
				<ul class="media">
					<li><p>팔로우하기</p></li>
					<li><a href="https://www.instagram.com/" target="_blank"> <img alt="instagramLogo" src="https://www.clipartmax.com/png/full/4-41427_instagram-png-icon-instagram-logo-transparent.png"> </a></li>
	                <li><a href="https://www.youtube.com/" target="_blank"> <img alt="youtubeLogo" src="https://www.clipartmax.com/png/full/16-160592_youtube-clipart-square-social-media-icons-youtube.png"> </a></li> <br>
	                <li><a href="http://blog.naver.com/" target="_blank"> <img alt="naverBlogLogo" src="https://www.apkmirror.com/wp-content/uploads/2019/11/5dcba5b76ba6e.png"> </a></li>
	                <li><a href="https://www.facebook.com/" target="_blank"> <img alt="facebookLogo" src="https://www.clipartmax.com/png/full/17-171363_facebook-logo-png-%5Bnew-2015%5D-vector-eps-free-download-transparent-background-facebook.png"> </a></li>
				</ul>
			</div>
			<div class="help">
				<p>고객센터</p>
				<p class="tel">1234-5678</p>
				<p class="time">
					<span>상담가능시간 : 평일 09:00 ~ 18:00</span> <br> 
					<span>점심시간 : 12:00 ~ 13:00</span>
				</p>
			</div>
		</div>
	</footer>
</body>
</html>