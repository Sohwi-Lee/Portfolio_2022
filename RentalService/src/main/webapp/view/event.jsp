<%@page import="model.dao.EventDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/RentalService/resources/common.css">
<link rel="stylesheet" href="/RentalService/resources/boards.css">
<title>event</title>
</head>
<body>
<% EventDAO dao = EventDAO.getInstance();%>
	<div class="wrap event">
		<%@ include file="/common/header.jsp"%>
		<main>
			<section>
				<div>
					<h2>이벤트</h2>
					<table>
						<thead>
							<tr>
								<td>번호</td>
								<td>이벤트명</td>
								<td>게시일</td>
								<td>조회수</td>
								<td>좋아요</td>
							</tr>
						</thead>
						<tbody>
						<% for(int i=0;i<dao.getLists().size();i++){ %>
							<tr>
								<td><%= dao.getLists().get(i).getNo() %></td>
								<td class="title">
									<form action="/RentalService/service">
									<input type="submit" value="<%= dao.getLists().get(i).getTitle() %>">
									<input type="hidden" name="command" value="eventView"><input type="hidden" name="idx" value="<%=i%>">
									</form>
								</td>
								<td><%= dao.getLists().get(i).getRegDate() %></td>
								<td><%= dao.getLists().get(i).getViewCount() %></td>
								<td><%= dao.getLists().get(i).getLike() %></td>
							</tr>
						<%} %>

						</tbody>
					</table>
					<%if(String.valueOf(session.getAttribute("log")).equals("admin")){%>
					<!-- 관리자일때만 표시 -->
					<form action="/RentalService/service"><input type="submit" value="글쓰기"><input type="hidden" name="command" value="이벤트글쓰기"></form>
					<%}%> 
					
				</div>
			</section>

		</main>
		<%@ include file="/common/footer.jsp"%>

	</div>
</body>
</html>
