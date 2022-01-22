<%@page import="model.dao.EventCommentDAO"%>
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
<title>event view</title>
</head>
<body>
<%
UserDAO udao = UserDAO.getInstance();
	EventDAO dao = EventDAO.getInstance();
	EventCommentDAO comDao = EventCommentDAO.getInstance();			
	String idx = request.getParameter("idx");
	int commentIdx=-1;
%>
	<div class="wrap eventView">
		<%@ include file="/common/header.jsp"%>
		<main>
            <section>
                <div>
                    <h2>이벤트</h2>          
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
                                <td><%= dao.getLists().get(Integer.parseInt(idx)).getTitle()%></td>
                            </tr>
                            <tr>
                                <td>내용</td>
                                <td class="content">
                                    <div>
                                        <p><%= dao.getLists().get(Integer.parseInt(idx)).getContent()%></p>
                                    </div>
                                </td>
                            </tr>
							<tr>
								<td>조회수</td>
								<td><%= dao.getLists().get(Integer.parseInt(idx)).getViewCount()%></td>
							</tr>
							<tr>
								<td>좋아요</td>
								<td><%= dao.getLists().get(Integer.parseInt(idx)).getLike()%></td>
							</tr>
						</tbody>
                    </table>
                    <form action="/RentalService/service">
                        <input type="submit" class="btnLike" value="♡">
                      <input type="hidden" name="command" value="like_E">
                      <input type="hidden" name="idx" value="<%=idx%>">
                    </form>
                    <form action="/RentalService/service">
                      <input type="submit" class="back" value="목록으로">
                      <input type="hidden" name="command" value="이벤트">
                      </form>
                     <% if(session.getAttribute("log")!=null && session.getAttribute("log").equals("admin")){ %>
                    <form action="/RentalService/service">
                      <input type="submit" class="edit" value="수정하기">
                      <input type="hidden" name="command" value="eventEdit">
                      <input type="hidden" name="idx" value="<%=idx%>">
                    </form>
                      <% } %>
                      
                </div>
            </section>
            <section>
	            <div>
    	        	<h3>댓글</h3>
    	        	<% for(int i=0;i<comDao.getLists().size();i++){ 
    	        		
    	        		if(Integer.parseInt(idx) == comDao.getLists().get(i).getBoardIdx()){
    	        	%>
    	        	<div class="commentBox">
	    	        	<div class="comment">
	    		        	<p> <span class="user"><%= comDao.getLists().get(i).getId()%></span> <span class="regDate"><%= comDao.getLists().get(i).getRegDate()%></span>
	    		        	<% commentIdx=i; if(comDao.getLists().get(i).getId().equals(session.getAttribute("log"))){%>
	    		        		<input type="button" value="삭제"><input type="button" class="btnEdit" value="수정" onclick="showEditor();">
	    		        	<% }%>
	    		        	</p>
		    	        	<div class="textArea">
			    	        	<form class="editComment" action="/RentalService/service">
		    		        		<textarea name="content"><%= comDao.getLists().get(i).getContent()%></textarea>
				    	        	<input type="submit" value="작성">
			    	        	</form>
			    	        	<P class="written"><%= comDao.getLists().get(i).getContent()%></P>
		    	        	</div>
	    	        	</div>
	    	        	<!-- <div class="commentReply">
		    	        	<p> <span class="user">id</span> <span class="regDate">2021~</span> </p>
		    	        	<div class="textArea">
			    	        	<P>댓글에 댓글입력</P>
			    	        	<input type="button" value="수정">
			    	        	<input type="button" value="삭제">
		    	        	</div>
	    	        	</div> -->
	            	</div>
    	        		
    	        	<%}}%>
	            	
    	        	<div class="commentBox">
	    	        	<form action="/RentalService/service">
	    	        	<input type="hidden" name="no" value="<%= dao.getLists().get(Integer.parseInt(idx)).getNo()%>">	    	        	
	    	        	<div class="comment">
	    		    <% if(session.getAttribute("log") !=null){ %>
	    		        	<p> <span class="user"><%= session.getAttribute("log") %></span></p>
		    	        	<div class="textArea">
			    	        	<textArea name="content" placeholder="댓글을 입력하세요"></textArea>
			    	        	<input type="submit" value="작성">
			    	        	<input type="hidden" name="command" value="commentWrite_E">
			    	        	<input type="hidden" name="idx" value=<%=idx%>>
		    	        	</div>
	    		     <%}else{%>
	    		       <p> <span class="user"> </span></p>
		    	        	<div class="textArea">
			    	        	<textArea name="content" placeholder="로그인 후 댓글을 작성할 수 있습니다." disabled></textArea>
			    	        	<input type="submit" value="작성" disabled>
		    	        	</div>
	    		     <%}%>
	    	        	</div>
		    	        </form>
	    	        	<div class="commentReply">
	    	        	</div>
	            	 </div>
           </div>
           </section>
        </main>

		<%@ include file="/common/footer.jsp"%>

	</div>
	<script>
		/* const btnEdit = document.querySelector(".btnEdit");
		const writtenTxt=document.querySelector(".written");
		const editForm = document.querySelector(".editComment");
		function showEditor(){
			btnEdit.setAttribute("style","display:none");
			writtenTxt.setAttribute("style","display:none");
			editForm.setAttribute("style","display:block");
		} */
	</script>
</body>
</html>
