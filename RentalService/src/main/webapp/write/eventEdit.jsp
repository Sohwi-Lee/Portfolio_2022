<%@page import="model.dao.EventCommentDAO"%>
<%@page import="model.dao.EventDAO"%>
<%@page import="model.dao.UserDAO"%>
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
<title>event view</title>
</head>
<body>
<%
	UserDAO udao = UserDAO.getInstance();
	EventDAO dao = EventDAO.getInstance();
	EventCommentDAO comDao = EventCommentDAO.getInstance();			
	String idx = request.getParameter("idx");
%>
	<div class="wrap eventView">
		<%@ include file="/common/header.jsp"%>
		<main>
            <section>
                <div>
                    <h2>이벤트</h2>          
                    <form action="/RentalService/service">
                    <table>
                        <tbody>
                            <tr>
                                <td>No.</td>
                                <td><%= dao.getLists().get(Integer.parseInt(idx)).getNo()%></td>
                            </tr>
                             <tr>
                                <td>작성일</td>
                                <td><%= dao.getLists().get(Integer.parseInt(idx)).getRegDate()%></td>
                            </tr>
                            <tr>
                                <td>제목</td>
                                <td>
                                <input type="text"  name="title" value="<%= dao.getLists().get(Integer.parseInt(idx)).getTitle()%>">
                                </td>
                            </tr>
                            <tr>
                                <td>내용</td>
                                <td class="content">
                                <textarea name="content" id="content" cols="50" rows="25"><%= dao.getLists().get(Integer.parseInt(idx)).getContent()%></textarea>
                                </td>
                            </tr>
							<tr>
								<td>조회수</td>
								<td><%= dao.getLists().get(Integer.parseInt(idx)).getViewCount()%></td>
							</tr>
						</tbody>
                    </table>
                      <input type="submit" class="edit" value="수정하기">
                      <input type="hidden" name="command" value="eventEditFin">
                      <input type="hidden" name="idx" value="<%=idx%>">
                      </form>
                      <form action="/RentalService/service">
                      <input type="hidden" name="command" value="eventDel">
                      <input type="hidden" name="idx" value="<%=idx%>">
                      <input type="submit" class="delete" value="삭제하기">
                      <input type="button" class="back" value="취소" onclick="history.back();">
                      </form>
                </div>
            </section>
        </main>

		<%@ include file="/common/footer.jsp"%>

	</div>
</body>
</html>
