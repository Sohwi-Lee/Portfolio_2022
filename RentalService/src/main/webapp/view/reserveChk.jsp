<%@page import="model.dao.CarDAO"%>
<%@page import="model.dao.ReservateDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/RentalService/resources/common.css">
<link rel="stylesheet" href="/RentalService/resources/reservate.css">
<title>reservation check</title>
</head>
<body>
<div class="wrap reserveChk">
<% 
if(session.getAttribute("log")==null){
	   PrintWriter outpr = response.getWriter();
	    outpr.println("<script language='javascript'>");
	    outpr.println("alert('로그인이 필요한 서비스입니다.');history.back();");
		outpr.println("</script>");
		outpr.flush();
	  
}
%>

<% 
ReservateDAO rdao = ReservateDAO.getInstance();
CarDAO cdao = CarDAO.getInstance();
String user = String.valueOf(session.getAttribute("log"));
%>
	<%@ include file="/common/header.jsp"%>
	<main>
		<section>
			<div>
				<h2>예약확인</h2>
				<table>
					<thead>
						<tr>
							<td>No.</td>
							<td>차종</td>
							<td>대여기간</td>							
							<td>결제총액</td>
							<td>-</td>
						</tr>
					</thead>
					<tbody>
					<%for(int i=0;i<rdao.getLists().size();i++){
	                  	if(rdao.getLists().get(i).getUserName().equals(user)){%>
					<tr>
                       <td><%=i+1 %></td>
                       <td>
                       <%for(int j=0;j<cdao.getLists().size();j++){
                    	   if(cdao.getLists().get(j).getNo() == rdao.getLists().get(i).getCarCode()){
                       %>
                    		<%= cdao.getLists().get(j).getName()%>
                       <%}}%>
                       </td>
                       <td><p><%= rdao.getLists().get(i).getReserveStart() %></p>
                        <p>~ <%= rdao.getLists().get(i).getReserveEnd() %></p></td>
                       <td><%=rdao.getLists().get(i).getTotalPrice()%>원</td>
                       <td>
                      <form action="/RentalService/service">
                      <input type="hidden" name="command" value="reserveCancel" >                      
                      <input type="submit" value="예약취소">
                      <input type="hidden" name="cancelNum" value="<%=i%>" >                      
                      </form>
                       </td>
                   	</tr>
					<%}}%>			 		
                    </tbody>
				</table>
			</div>

		</section>

	</main>
	<%@ include file="/common/footer.jsp"%>
	</div>

</body>
</html>