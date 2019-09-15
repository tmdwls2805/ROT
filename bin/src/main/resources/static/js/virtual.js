function check(form){
	if(form.virtual.value=="100"){
		  alert("입금계좌를 선택하세요.");
		  return false;
	}
	setTimeout(function(){
		alert("결제에 성공했습니다.");
		form.action = "CPPE_mypage_cart_buyProc.jsp";
		form.submit();
	    window.close();
	}, 3000);
	
}