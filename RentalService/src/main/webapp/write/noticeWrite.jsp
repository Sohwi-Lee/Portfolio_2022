<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/RentalService/resources/common.css">
<link rel="stylesheet" href="/RentalService/resources/event.css">
<title>Write</title>
</head>
<body>
	<div class="wrap eventWrite">
		<%@ include file="/common/header.jsp"%>
		<main>
			<section>
				<div>
				<h2>공지작성</h2>
					<form action="/RentalService/service">
						<table>
							<tr>
								<td>제목</td>
								<td><input type="text" name="title"></td>
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
							<input type="hidden" name="command" value="noticeWrite">
						</div>
					</form>
				</div>
			</section>

		</main>

		<%@ include file="/common/footer.jsp"%>
	</div>
</body>
</html>