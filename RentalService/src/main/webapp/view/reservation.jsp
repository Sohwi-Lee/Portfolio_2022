<%@page import="model.dao.CarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/RentalService/resources/common.css">
<link rel="stylesheet" href="/RentalService/resources/reservate.css">
<title>예약하기</title>
</head>
<body>
	<% CarDAO dao = CarDAO.getInstance(); 
	request.setCharacterEncoding("UTF-8");
	String type = request.getParameter("type");
	System.out.println("TYPE::"+type);	
	%>
	<div class="wrap reservation">
		<%@ include file="/common/header.jsp"%>
		<main>
			<section>
				<div>
					<h2>예약</h2>
					<div class="rentalDate">
					<div>
						<label for="rentStart">대여일</label><br> <input
							type="datetime-local" name="rentStart" id="rentStart"></div>
					<div>
						<label for="rentEnd">반납일</label><br> <input
							type="datetime-local" name="rentEnd" id="rentEnd"></div>
					</div>
					<div class="size">
						<p>차종</p>
						<div>
						<input type="radio" name="carType" id="type1" value="경형" 
						<% if(type != null && type.equals("경형")){%>
						checked	
						<%} %>
						>
						<label for="type1">경형</label>
						</div><div>
						<input type="radio" name="carType" id="type2" value="소형"
						<% if(type != null && type.equals("소형")){%>
						checked	
						<%} %>>
						<label for="type2">소형</label>
						</div><div>
						<input type="radio" name="carType" id="type3" value="중형"
						<% if(type != null && type.equals("중형")){%>
						checked	
						<%} %>>
						<label for="type3">중형</label>
						</div><div>
						<input type="radio" name="carType" id="type4" value="SUV"
						<% if(type != null && type.equals("SUV")){%>
						checked	
						<%} %>>
						<label for="type4">RV/SUV</label>
						</div><div>
						<input type="radio" name="carType" id="type5" value="승합차"
						<% if(type != null && type.equals("승합차")){%>
						checked	
						<%} %>>
						<label for="type5">승합</label>
						</div><div>
						<input type="radio" name="carType" id="type6" value="수입차"
						<% if(type != null && type.equals("수입차")){%>
						checked	
						<%} %>> 
						<label for="type6">수입</label>
						</div>
					</div> 
					<div class="fuel"></div>
					<div class="released"></div>
					<div class="price"></div>
					<button class="search" onclick="search()">검색</button>
				</div>
			</section>
			<section class="result">
				<div>
					<% for(int i=0;i<dao.getLists().size();i++){ %>
					<form action=/RentalService/service>
						<article class="carInfo" 
						<% if(type != null){						
						if(dao.getLists().get(i).getSize().equals(type)){}else{%>
							style="display:none"
						<%}}%>>
							<div class="info1">
								<img src=" <%= dao.getLists().get(i).getImg() %>
								" alt="차이미지">
								
							</div>
							<div class="info2">
								<h3><%= dao.getLists().get(i).getName() %> <input type="hidden" name="carName" value="<%= dao.getLists().get(i).getName() %>"></h3>
								<p class="basic">
									<span class="size"><%=dao.getLists().get(i).getSize() %></span> <span class="fuel"><%=dao.getLists().get(i).getFuel()%></span> <span class="released"><%=dao.getLists().get(i).getReleased() %></span>
								</p>
								<p class="detail">
									<span>열선시트</span> <span>후방센서</span> <span>후방카메라</span> <span>스마트키</span>
								</p>
								<p class="price"> <span><%=dao.getLists().get(i).getPrice()%></span>원 / 24시간 <input type="hidden" value="<%=dao.getLists().get(i).getPrice()%>"></p>
								<p class="estimate">
									<span class="rentS"></span> <span class="rentE"></span><br>
		                            <span class="ePrice"></span>
								</p>
								<!--  <button onclick="location.href='reservatePro.jsp'">예약하기</button> -->
								<input class="submit" type="submit" value="예약하기">
							<input type="hidden" name="command" value="reservate">
							</div>
						</article>
					</form>
					<%}%>
				</div>
			</section>
		</main>
		<%@ include file="../common/footer.jsp"%> 
	</div>

	<script>
		const milSec = 1000;
		const sec = milSec * 60;
		const min = sec * 60;
		const hour = min * 60;
		const day = hour * 24;
		const month = day * 30;
		const year = month * 12;
		// const first = (year*2021 + month*1 + day*1 + hour*10);
		// const last = (year*2021 + month*1 + day*2 + hour*10);
		// console.log((last-first)/day);
		// console.log((last-first)/hour);

		function search() {
			const start = document.querySelector("#rentStart").value;
			const end = document.querySelector("#rentEnd").value;
			const articles = document.querySelectorAll(".carInfo");

			// 예약날짜 
			if (start == "" || end == "") {
				alert("날짜를 선택해주세요");
			} else if (!(start < end)) {
				alert("대여일과 반납일을 확인해주세요");
				location.reload(this);
			}

			// 차종 일치
			const sizes = document.querySelector("div.size input:checked").value;
			for (let i = 0; i < document.querySelectorAll(".carInfo").length; i++) {
				//   console.log(articles[i].querySelector("span.size").textContent);
				if (articles[i].querySelector("span.size").textContent == sizes) {
					articles[i].setAttribute("style", "display:flex");
				} else if(sizes==null){
				} else {
					articles[i].setAttribute("style", "display:none");
				}
			}

			// 대여일 반납일 예상견적
			for (let i = 0; i < document.querySelectorAll(".carInfo").length; i++) {
				articles[i].querySelector(".rentS").innerHTML = "";
				articles[i].querySelector(".rentE").innerHTML = "";
				articles[i].querySelector(".ePrice").innerHTML = "";

				const createInput = document.createElement("input");
				createInput.type = "hidden";
				createInput.value = start.replace("T", " ") + ":00";
				createInput.name = "rentS";
				articles[i].querySelector(".rentS").append(
						"대여일 : " + start.substring(0, 10));
				articles[i].querySelector(".rentS").append(createInput);

				const createInput2 = document.createElement("input");
				createInput2.type = "hidden";
				createInput2.value = end.replace("T", " ") + ":00";
				createInput2.name = "rentE";
				articles[i].querySelector(".rentE").append(
						"반납일 : " + end.substring(0, 10));
				articles[i].querySelector(".rentE").append(createInput2);

				// 대여시간 구하기
				const startMin = parseInt(start.substring(14, 16));
				const startHour = parseInt(start.substring(11, 13));
				const startDay = parseInt(start.substring(8, 10));
				const startMonth = parseInt(start.substring(5, 7));
				const startYear = parseInt(start.substring(0, 4));
				// console.log("START "+startYear+" "+startMonth+" "+startDay+" "+startHour+" "+startMin);

				const endMin = parseInt(end.substring(14, 16));
				const endHour = parseInt(end.substring(11, 13));
				const endDay = parseInt(end.substring(8, 10));
				const endMonth = parseInt(end.substring(5, 7));
				const endYear = parseInt(end.substring(0, 4));
				// console.log("END "+ endYear+" "+endMonth+" "+endDay+" "+endHour+" "+endMin);

				const first = (year * startYear + month * startMonth + day
						* startDay + hour * startHour);
				const last = (year * endYear + month * endMonth + day * endDay + hour
						* endHour);
				const restHour = (last - first) / hour;
				console.log(restHour);

				const price = articles[i].querySelector(".price span").textContent
				const createInput3 = document.createElement("input");
				createInput3.type = "hidden";
				createInput3.value = (parseInt(price) * restHour / 24);
				createInput3.name = "ePrice";
				articles[i].querySelector(".ePrice").append(
						"예상견적 : " + (parseInt(price) * restHour / 24) + "원");
				articles[i].querySelector(".ePrice").append(createInput3);
				// console.log(createInput.value);

			}
		}
		
	</script>
</body>
</html>