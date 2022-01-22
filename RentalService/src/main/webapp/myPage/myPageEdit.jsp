<%@page import="model.dto.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/RentalService/resources/common.css">
<title>myPage Edit</title>
</head>
<body>
	<%
	UserDAO udao = UserDAO.getInstance();
	ArrayList<UserDTO> users = udao.getUsers();
	int idx = -1;
	for (int i = 0; i < users.size(); i++) {
		if (session.getAttribute("log").toString().equals(users.get(i).getId())) {
			idx = i;
		}
	}
	%>
	<div class="wrap">
		<%@ include file="/common/header.jsp"%>
		<main>

			<section>
				<div>
				<h2>내 정보 수정</h2>
				<form action="/RentalService/service" method="post">
					<table>
						<tr>
							<td>이름</td>
							<td><%= udao.getUsers().get(idx).getUserName() %></td>
						</tr>
						<tr>
							<td>ID</td>
							<td><%= udao.getUsers().get(idx).getId() %></td>
						</tr>
						<tr>
							<td>PW</td>
							<td>비밀변호 변경하기를 통해 수정해주세요.</td>
						</tr>
						<tr>
							<td>닉네임</td>
							<td>
							<input type="text" name="nick" value="<%= udao.getUsers().get(idx).getUserNick() %>">
							</td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td><input type="text" name="tel" value="<%= udao.getUsers().get(idx).getTel()%>"></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><input type="text" name="email" value="<%= udao.getUsers().get(idx).getEmail() %>"></td>
						</tr>
						<tr>
							<td>가입일</td>
							<td><%= udao.getUsers().get(idx).getRegDate() %></td>
						</tr>
					</table>
					<input type="submit" value="수정내용 저장">
					<button onclick="removeUser()">회원 탈퇴</button>
					<input type="hidden" name="command" value="editMyInfo">
					</form>
				</div>
			</section>
			<section>
				<h2>내 예약</h2>
				<!-- 0건 : 예약이 없음 
			1건~ : 예약이 n건 있습니다 >상세 페이지로 이동
			-->
			</section>

		</main>

		<%@ include file="/common/footer.jsp"%>
	</div>

	<script>
	function removeUser(){
		if(confirm("정말 탈퇴하시겠습니까?")){
			location.href=location.href='/';
		}
	}
		
	</script>
</body>
</html>