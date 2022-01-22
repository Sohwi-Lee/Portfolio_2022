<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/RentalService/resources/common.css">
<link rel="stylesheet" href="/RentalService/resources/myPage.css">
<title>myPage</title>
</head>
<body>
	<%
	UserDAO udao = UserDAO.getInstance();
	int idx = -1;
	System.out.println("session::"+session.getAttribute("log"));
	for (int i = 0; i < udao.getUsers().size(); i++) {
		if (session.getAttribute("log").equals(udao.getUsers().get(i).getId())) {
			idx = i;
		}
	}
	%>
	<div class="wrap myPage">
		<%@ include file="/common/header.jsp"%>
		<main>

			<section>
				<div>
				<h2>내 정보 / 수정</h2>
					
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
							<td>
								<% int len = udao.getUsers().get(idx).getPw().length();
								for(int i=0;i<len;i++){%>*<%}%>
							</td>
						</tr>
						<tr>
							<td>닉네임</td>
							<td><%= udao.getUsers().get(idx).getUserNick() %></td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td><%= udao.getUsers().get(idx).getTel()%></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><%= udao.getUsers().get(idx).getEmail() %></td>
						</tr>
						<tr>
							<td>가입일</td>
							<td><%= udao.getUsers().get(idx).getRegDate() %></td>
						</tr>
					</table>
					<form action="/RentalService/service">
					<input type="submit" name="command" value="myEdit">
					</form>
					<form id="delUser">
					<input type="submit" onclick="removeUser()" value="회원탈퇴">
					</form>
				</div>
			</section>
			<section>
				<!--<h2>내 예약</h2>
				 0건 : 예약이 없음 
			1건~ : 예약이 n건 있습니다 >상세 페이지로 이동
			-->
			</section>

		</main>

		<%@ include file="/common/footer.jsp"%>
	</div>

	<script>
	function removeUser(){
		if(confirm("정말 탈퇴하시겠습니까?")){
			const makeInput = document.createElement("input");
			makeInput.setAttribute('type','hidden');
			makeInput.setAttribute('name','command');
			makeInput.setAttribute('value','delUser');
			document.querySelector("#delUser").setAttribute("action","/RentalService/service");
			document.querySelector("#delUser").append(makeInput);
		}else{
			alert("취소");
			location.href="myPage.jsp";
		}
	}
	
	function changePW(){
		document.querySelector(".btnChange").setAttribute("style","display:none");
		document.querySelector(".changeForm").setAttribute("style","display:block");
		
	}
		
	</script>
</body>
</html>