function goBack() {
	window.history.back();
}

function goSign2(){
	 var termsPrivacy = document.form.termsPrivacy.checked;
	 var termsService = document.form.termsService.checked;
	 var num = 0;
	 if(termsPrivacy == true && termsService == true){
	  num = 1;
	 }
	 if(num==1){
	  document.form.submit();
	 }else{
	  alert("약관에 동의해야 회원가입이 가능합니다.");
	 }
	}