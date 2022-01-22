<%@page import="model.dao.ReviewDAO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="resources/common.css">
<link rel="stylesheet" href="resources/index.css">
<link rel="stylesheet" href="resources/carousel.css">
<script src="resources/carousel.js" type="text/javascript"></script>
<title>Index</title>
</head>
<body>
	<% ReviewDAO revDao = ReviewDAO.getInstance(); %>
	<div class="wrap">
		<c:import url="/common/header.jsp"/>
		<main>
			<section class="banner">
				<div class="carousel" id="carousel-banner">
					<div class="carousel-wrapper">
						<div class="carousel-item">
							<img src="https://www.jejupassrent.com/util/file/noTokenDownload.do?fileSn=80794947">
						</div>
						<div class="carousel-item">
							<img src="https://www.jejupassrent.com/util/file/noTokenDownload.do?fileSn=46168945">
						</div>
						<div class="carousel-item">
							<img src="https://www.jejupassrent.com/util/file/noTokenDownload.do?fileSn=80426957">
						</div>
					</div>
					<div class="navi-wrapper"></div>
				</div>
			</section>
			<section class="recommendation">
				<div>
					<div class="sectionTitle">
						<h2>이벤트 & 추천</h2>
						<form action="service">
						<input type="hidden" name="command" value="예약하기">
						<input type="submit" value="+더보기">
						</form>
					</div>

					<article>
						<div class="item1">
						<form action="service">
							<input type="hidden" name="command" value="IndexRecommend">
								<span>지금은 이벤트중!</span><br>
								<label for="type2">소형차 모음</label> 
								<input type="hidden" id="type2" name="type" value="소형">
								<input type="submit">
						</form>
						</div>
						<div class="item2">
						<form action="service">
							<input type="hidden" name="command" value="IndexRecommend">
								<span>특별한 여행을 위한</span><br> 
								<label for="type6">수입 고급차 모음</label> 
								<input type="hidden" id="type6" name="type" value="수입차">
								<input type="submit">
						</form>
						</div>
						<div class="item3">
						<form action="service">
							<input type="hidden" name="command" value="IndexRecommend">
								<span>합리적인 당신을 위한</span><br> 
								<label for="type1">가성비 갑 경차 모음</label> 
								<input type="hidden" id="type1" name="type" value="경형">
								<input type="submit">
						</form>
						</div>
						<div class="item4">
						<form action="service">
							<input type="hidden" name="command" value="IndexRecommend">
								<span>여행의 든든한 동행</span><br> 
								<label for="type4">RV/SUV 모음</label> 
								<input type="hidden" id="type4" name="type" value="SUV">
								<input type="submit">
						</form>
						</div>
						<div class="item5">
						<form action="service">
							<input type="hidden" name="command" value="IndexRecommend">
								<span>짐이 많아도 거뜬한</span><br> 
								<label for="type5">가족여행용 승합차 모음</label> 
								<input type="hidden" id="type5" name="type" value="승합차">
								<input type="submit">
						</form>
						</div>
					</article>
				</div>
			</section>
			<section class="review">
				<div>
					<div class="sectionTitle">
						<h2>이용후기</h2>
						<form action="service">
						<input type="hidden" name="command" value="이용후기">
						<input type="submit" value="+더보기">
						</form>
					</div>
					<div class="reviewBox">
					<% for (int i = 0; i < 3; i++) { %>
						<article>
							<div class="carInfo">
								<div>
									<img src="https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_large/v1/editorial/story/hero_image/1908-Ford-Model-T_0.jpg" alt="">
								</div>
								<div>
									<p class="userName"> 작성자 : <%=revDao.getLists().get(i).getUserName()%></p>
									<p class="reviewContxt"> 차종 : <%=revDao.getLists().get(i).getReservedCar()%></p>
								</div>
							</div>

							<div class="reviewTxt">
								<p class="score">
									<% if (revDao.getLists().get(i).getScore() == 1) { %>
									<span>★</span>
									<% } else if (revDao.getLists().get(i).getScore() == 2) { %>
									<span>★★</span>
									<% } else if (revDao.getLists().get(i).getScore() == 3) { %>
									<span>★★★</span>
									<% } else if (revDao.getLists().get(i).getScore() == 4) { %>
									<span>★★★★</span>
									<% } else if (revDao.getLists().get(i).getScore() == 5) { %>
									<span>★★★★★</span>
									<% } %>
								</p>
								<p class="reserveInfo"><%=revDao.getLists().get(i).getContent()%></p>
							</div>
						</article>
						<% } %>						
					</div>
				</div>
			</section>
		</main>
		<c:import url="/common/footer.jsp"/>
	</div>

	<script>
		new Carousel(document.querySelector('#carousel-banner'), {
			CarouselMotion : 'slide',
			naviPosition : 'bottom',
			naviStyle : 'arrow',
			autoMove : true,
			autoMoveTime : 3000
		});
	</script>


</body>
</html>