function check(form){
	  var s_point = form.s_point.value;
	  var d_point = form.d_point.value;
	  var price = form.price.value; 
	  
	if(!form.s_point.value){
		  alert("출발지를 입력하세요.");
		  form.s_point.focus();
		  return false;
	}
	if(!form.d_point.value){
		  alert("도착지를 입력하세요.");
		  form.d_point.focus();
		  return false;
	}
	if(!form.price.value){
		  alert("금액을 입력하세요.");
		  form.price.focus();
		  return false;
	}
	form.action="CPPE_operator_enrollProc.jsp";
	form.submit();
}