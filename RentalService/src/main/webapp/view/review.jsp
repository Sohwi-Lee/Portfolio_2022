<%@page import="model.dao.CarDAO"%>
<%@page import="model.dao.ReviewDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/RentalService/resources/common.css">
<link rel="stylesheet" href="/RentalService/resources/review.css">
<title>review</title>
</head>
<body>
<% ReviewDAO revDao = ReviewDAO.getInstance();
CarDAO carDao = CarDAO.getInstance();%>
	<div class="wrap review">
		<%@ include file="/common/header.jsp"%>
		<main>
			<!--  리뷰 카드 보여주기 -->
			<section>
			<div>
			<h2>이용후기</h2>
			<div>
			<% for(int i=0;i<revDao.getLists().size();i++){%>
				<article>
					<div class="carInfo">
						<div><img src="
						<%
						for(int j=0;j<carDao.getLists().size();j++){
							if(revDao.getLists().get(i).getReservedCar().equals(carDao.getLists().get(j).getName())){
						%>
						<%=carDao.getLists().get(j).getImg() %>
						<%}}%>						
						" alt="<%= revDao.getLists().get(i).getReservedCar() %>"></div>
						<div>
							<p class="userName">작성자 : <%= revDao.getLists().get(i).getUserName() %></p>
							<p class="reviewContxt">차종 : <%= revDao.getLists().get(i).getReservedCar() %></p>
						</div>
					</div>
					
					<div class="reviewTxt">
						<p class="score">
						<% if(revDao.getLists().get(i).getScore()==1){%>
							<span>★</span>
							<%}else if(revDao.getLists().get(i).getScore()==2){%>
							<span>★★</span>
							<%}else if(revDao.getLists().get(i).getScore()==3){%>
							<span>★★★</span>
							<%}else if(revDao.getLists().get(i).getScore()==4){%>
							<span>★★★★</span>
							<%}else if(revDao.getLists().get(i).getScore()==5){%>
							<span>★★★★★</span>
						<%}%>
						</p>
						<p class="reserveInfo"><%= revDao.getLists().get(i).getContent()  %></p>
					</div>
				</article>
			<%}%>
			</div>
			</div>
			</section>
			<!-- 유저로그인 -->
			<% if(session.getAttribute("log") != null){%>
			<button onclick="location.href='/RentalService/write/reviewWrite.jsp'">글쓰기</button>
			<%} %>
		</main>
		<%@ include file="/common/footer.jsp"%>
	</div>
</body>
</html>