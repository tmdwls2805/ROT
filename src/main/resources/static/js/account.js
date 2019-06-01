function maxLengthCheck(object){
   if (object.value.length > object.maxLength){
    object.value = object.value.slice(0, object.maxLength);
   }   
}

function check(form){
	if(form.account_com.value=="100"){
		  alert("계좌이체은행을 선택하세요.");
		  return false;
	}
	
	if(!form.account_person.value){
		alert("예금주명을 입력하세요.");
		  form.accountpass.focus();
		  return false;
	}
		
	if(form.personnum1.value<100000 || form.personnum1.value>999999){
		  alert("주민(사업자)번호를 확인하세요.");
		  form.personnum1.focus();
		  return false;
	}
	if(form.personnum2.value<1000000 || form.personnum2.value>9999999){
		  alert("주민(사업자)번호를 확인하세요.");
		  form.personnum2.focus();
		  return false;
	}	
	if(!form.accountnum.value){
		alert("계좌번호를 입력하세요.");
		  form.accountnum.focus();
		  return false;
	}
	if(!form.accountpass.value || form.accountpass.value<1000 || form.accountpass.value>9999){
		  alert("계좌 비밀번호를 확인하세요.");
		  form.accountpass.focus();
		  return false;
	}
	setTimeout(function(){
		alert("결제에 성공했습니다.");
		form.action = "CPPE_mypage_cart_buyProc.jsp";
		form.submit();
	    window.close();
	}, 3000);
	
}