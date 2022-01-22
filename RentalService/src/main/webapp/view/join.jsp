<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/RentalService/resources/common.css">
<link rel="stylesheet" href="/RentalService/resources/join.css">
<title>Join</title>
</head>
<body>
	<div class="wrap">
		<%@ include file="/common/header.jsp"%>
		<main>
			<section>
			<div>
				<h2>회원가입</h2>
			
				<form action="/RentalService/service">
					<table>
						<tr>
							<td><label for="id">아이디</label></td>
							<td>
							<input type="text" placeholder="아이디" id="id" name="id" required>
							<p class="warning required id">필수 정보입니다.</p>
							</td>
						</tr>
						<tr>
							<td><label for="pw">비밀번호</label></td>
							<td>
							<input type="password" placeholder="비밀번호" id="pw" name="pw" required>
							<p class="warning required pw">필수 정보입니다.</p>
							</td>
						</tr>
						<tr>
							<td><label for="pwChk">비밀번호 확인</label></td>
							<td>
							<input type="password" placeholder="비밀번호 확인" id="pwChk" name="pwChk" required>
							<p class="warning required checkPw">필수 정보입니다.</p>
			                <p class="warning inaccordance">비밀번호가 일치하지 않습니다.</p>
			                </td>
						</tr>
						
						<tr>
							<td><label for="nick">닉네임</label></td>
							<td>
							<input type="text" placeholder="닉네임" id="nick" name="nick" required>
							<p class="warning required nick">필수 정보입니다.</p>
							</td>
						</tr>
						<tr>
							<td><label for="">이메일</label></td>
							<td><input type="text" placeholder="e-mail" name="mailAddr" required>
								@ <input type="text" name="mailSite" id="mailSite" required> 
								<select name="mailSite-choice" id="mailSite-choice" onchange="mailSel()">
									<option value="직접입력" selected>직접입력</option>
									<option value="naver.com">naver.com</option>
									<option value="hanmail.net">hanmail.net</option>
									<option value="gmail.com">gmail.com</option>
									<option value="dreamwiz.com">dreamwiz.com</option>
									<option value="paran.com">paran.com</option>
								</select> 
								<input type="checkbox" name="" id="receiveMail">
								<label for="receiveMail">이메일 수신동의</label>
							</td>
						</tr>
						<tr>
							<td><label for="name">이름</label></td>
							<td>
							<input type="text" placeholder="이름" id="name" name="name" required>
							<p class="warning required name">필수 정보입니다.</p>
							</td>
						</tr>
						<tr>
							<td><label for="phoneNum">휴대폰 번호</label></td>
							<td>
								<select name="phoneNum1" id="phoneNum1">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="018">018</option>
									<option value="019">019</option>
								</select> 
								<input type="tel" name="phoneNum2" id="phoneNum2" maxlength="4"> 
								<input type="tel" name="phoneNum3" id="phoneNum3" maxlength="4"> 
								<input type="button" value="인증번호 받기" id="getCode" onclick="sendCode()">
							</td>
						</tr>
						<tr>
							<td>인증번호 입력</td>
							<td>
							<input type="text" id="codeInput" value="인증번호 입력" disabled>
							<input type="button" id="codeConfirm" value="인증번호 확인" disabled>
							</td>
						</tr>
	
					</table>
					<div class="btns">					
						<input type="button" value="취소" onclick="history.back();">
						<input type="submit" name="command" value="가입하기">
					</div>
				</form>
			</div>
			</section>
		</main>
		<%@ include file="/common/footer.jsp"%>
	</div>
	
	 <script>
     let passId = false;
     let passPw = false;
     let passPwChk = false;
     let passName = false;
     // focus out일 때 반응
     const id = document.querySelector('input#id');
     id.addEventListener('blur',e=>{
         if(id.value === ''){
           document.querySelector('.id').setAttribute('style','display:block');
          }else{
             document.querySelector('.id').setAttribute('style','display:none');
             passId = true;
          }
     });
     const pw = document.querySelector('input#pw');
     pw.addEventListener('blur',e=>{
         if(pw.value === ''){
           document.querySelector('.pw').setAttribute('style','display:block');
         }else{
             document.querySelector('.pw').setAttribute('style','display:none');
             passPw=true;
          }
     });
     const checkPw = document.querySelector('input#pwChk');
     checkPw.addEventListener('blur',e=>{
         if(checkPw.value === ''){
           document.querySelector('.checkPw').setAttribute('style','display:block');
          }else if(checkPw.value !== pw.value){
             document.querySelector('.inaccordance').setAttribute('style','display:block');
         }else{
             document.querySelector('.checkPw').setAttribute('style','display:none');
             passPwChk=true;
          }
     });
     const name = document.querySelector('input#name');
     name.addEventListener('blur',e=>{
         if(name.value === ''){
           document.querySelector('.name').setAttribute('style','display:block');
         }else{
             document.querySelector('.name').setAttribute('style','display:none');
             passName=true;
          }
     });
     const nick = document.querySelector('input#nick');
     nick.addEventListener('blur',e=>{
         if(nick.value === ''){
           document.querySelector('.nick').setAttribute('style','display:block');
         }else{
             document.querySelector('.nick').setAttribute('style','display:none');
             passName=true;
          }
     });

    // 이메일 자동입력
    function mailSel(){
        const mailTxt = document.querySelector("#mailSite-choice").value;
        const mailSite = document.querySelector("#mailSite");
        
        if(mailTxt !="직접입력"){
            mailSite.value=mailTxt;
        }else{
            mailSite.value="";
        }
    }
    
    // 인증번호
    function sendCode(){
    	const codeInput = document.querySelector("#codeInput");
    	const codeConfirm = document.querySelector("#codeConfirm");
    	const phoneNum2 = document.querySelector("#phoneNum2");
    	const phoneNum3 = document.querySelector("#phoneNum3");
    	if(phoneNum2.value!="" && phoneNum3.value!=""){
	    	codeInput.removeAttribute('disabled');
	    	codeConfirm.removeAttribute('disabled');    		
    	}
    }
        
    </script>
</body>
</html>