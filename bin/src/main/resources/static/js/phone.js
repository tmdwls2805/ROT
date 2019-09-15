function maxLengthCheck(object){
   if (object.value.length > object.maxLength){
    object.value = object.value.slice(0, object.maxLength);
   }   
}


function check(form){
	if(!form.phone_person.value){
		  alert("이름을 입력하세요.");
		  form.phone_person.focus();
		  return false;
	}
	if(form.phone_com.value=="100"){
		  alert("통신사를 선택하세요.");
		  return false;
	}
	if(!form.phone_number2.value || form.phone_number2.value<0001 || form.phone_number2.value>9999){
		  alert("휴대폰번호를 입력하세요.");
		  form.phone_number2.focus();
		  return false;
	}
	if(!form.phone_number3.value || form.phone_number3.value<0001 || form.phone_number3.value>9999){
		  alert("휴대폰번호를 입력하세요.");
		  form.phone_number3.focus();
		  return false;
	}
	if(!form.person_number1.value || form.person_number1.value<100000 || form.person_number1.value>999999){
		  alert("주민번호를 입력하세요.");
		  form.person_number1.focus();
		  return false;
	}
	if(!form.person_number2.value || form.person_number2.value<1000000 || form.person_number2.value>9999999){
		  alert("주민번호를 입력하세요.");
		  form.person_number2.focus();
		  return false;
	}	
	if(!form.phone_cert.value || form.phone_cert.value<0000001 || form.phone_cert.value>999999){
		  alert("인증번호를 입력하세요.");
		  form.phone_cert.focus();
		  return false;
	}	

	setTimeout(function(){
		alert("결제에 성공했습니다.");
		form.action = "CPPE_mypage_cart_buyProc.jsp";
		form.submit();
	    window.close();
	}, 3000);
	
}