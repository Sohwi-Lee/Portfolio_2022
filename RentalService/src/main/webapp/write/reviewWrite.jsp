<%@page import="model.dao.CarDAO"%>
<%@page import="model.dao.ReservateDAO"%>
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
<title>review write</title>
</head>
<body>
<% ReservateDAO rdao = ReservateDAO.getInstance(); 
CarDAO cdao = CarDAO.getInstance();	%>
	<div class="wrap reviewWrite">
		<%@ include file="/common/header.jsp"%>

		<main>
			<section>
				<div>
					<h2>리뷰작성</h2>
					<form action="/RentalService/service">
						<table>
							<tr>
								<td>차종</td>
								<td><select name="carChoice">
									<%
									for (int i = 0; i < rdao.getLists().size(); i++) {
										if (rdao.getLists().get(i).getUserName().equals(session.getAttribute("log"))) {
											for (int j = 0; j < cdao.getLists().size(); j++) {
										if (rdao.getLists().get(i).getCarCode() == cdao.getLists().get(j).getNo()) {
									%>
									<option value="<%=cdao.getLists().get(j).getName()%>"><%=cdao.getLists().get(j).getName()%></option>
									<%}}}}%>
								</select></td>
							</tr>
							<tr>
								<td>별점</td>
								<td>
									<select name="score">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>내용</td>
								<td><textarea name="content" id="content" cols="50"
										rows="25"></textarea></td>
							</tr>
						</table>
						<div class="btns">
							<input type="button" onclick="history.back(-1)" value="취소"> 
							<input type="submit" value="게시">
							<input type="hidden" name="command" value="reviewWrite">
						</div>
					</form>
				</div>
			</section>

		</main>

		<%@ include file="/common/footer.jsp"%>
	</div>
</body>
</html>