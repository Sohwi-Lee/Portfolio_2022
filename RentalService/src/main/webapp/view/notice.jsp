<%@page import="model.dao.NoticeDAO"%>
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
<title>notice</title>
</head>
<body>
<% NoticeDAO dao = NoticeDAO.getInstance(); %>
	<div class="wrap event">
		<%@ include file="/common/header.jsp"%>
		<main>
			<section>
				<div>
					<h2>공지사항</h2>
					<table>
						<thead>
							<tr>
								<td>번호</td>
								<td>제목</td>
								<td>게시일</td>
								<td>조회수</td>
								<td>좋아요</td>
							</tr>
						</thead>
						<tbody>
						<% for(int i=0;i<dao.getLists().size();i++){ %>
							<tr>
								<td><%=dao.getLists().get(i).getNo()%></td>
								<td class="title">
									<form action="/RentalService/service">
										<input type="submit" value="<%=dao.getLists().get(i).getTitle()%>"> 
										<input type="hidden" name="command" value="noticeView"><input type="hidden" name="idx" value="<%=i%>">
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
						<button class="toWritePage" onclick="location.href='/RentalService/write/noticeWrite.jsp'">글쓰기</button>
					<%}%>
				</div>
			</section>

		</main>
		<%@ include file="/common/footer.jsp"%>
	</div>
</body>
</html>