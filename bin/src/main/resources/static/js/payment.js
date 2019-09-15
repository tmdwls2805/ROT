	function chk_payment(){
		if(!buyinput.deliveryName.value){
			  alert("받으실 분을 입력하세요.");
			  buyinput.deliveryName.focus();
			  return false;
		}
		if(!buyinput.date.value){
			  alert("받으실 날짜를 입력하세요.");
			  buyinput.date.focus();
			  return false;
		}
		if(!buyinput.deliveryzipcode.value){
			  alert("받으실 곳을 입력하세요.");
			  buyinput.deliveryzipcode.focus();
			  return false;
		}
		if(!buyinput.deliveryAddr2.value){
			  alert("상세주소를 입력하세요.");
			  buyinput.deliveryAddr2.focus();
			  return false;
		}
		if(!buyinput.deliveryTel.value){
			  alert("핸드폰번호를 입력하세요.");
			  buyinput.deliveryTel.focus();
			  return false;
		}
		var chk1 = document.buyinput.scales.checked;
		if(!chk1){
			alert('구매내용을 동의하셔야 결제가 가능합니다.');
			return false;
		}
		
		var form = document.buyinput;
		var pop_title = "Payment";
		var pop_option= "width=500, height=572, scrollbars=no, status=no";
		if(form.payment.value=="creditcard"){
			window.name = "buyFrom.jsp"
			window.open("", pop_title, pop_option);
			form.target = pop_title;
			form.action="CPPE_mypage_cart_buyForm_creditcard_before.jsp";
			form.submit();
		}else if(form.payment.value=="account"){
			window.name = "buyFrom.jsp"
				window.open("", pop_title, pop_option);
				form.target = pop_title;
				form.action="CPPE_mypage_cart_buyForm_account_before.jsp";
				form.submit();
		}else if(form.payment.value=="virtual"){
			window.name = "buyFrom.jsp"
				window.open("", pop_title, pop_option);
				form.target = pop_title;
				form.action="CPPE_mypage_cart_buyForm_virtual_before.jsp";
				form.submit();
		}else if(form.payment.value=="phone"){
			window.name = "buyFrom.jsp"
				window.open("", pop_title, pop_option);
				form.target = pop_title;
				form.action="CPPE_mypage_cart_buyForm_phone_before.jsp";
				form.submit();
		}else{
	}
	}