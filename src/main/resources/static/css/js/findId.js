function findid(){
	var name = document.form.name.value;
	 if(name.length==0 || name==null){
	  alert("이름을 입력하십시오");
	  return false;
	 }

	 var email1 = document.form.email1.value;
	 var email2 = document.form.email1.value;
	 if(email1.length==0 || email1==null){
	  alert("이메일을 입력하십시오");
	  return false;
	 }
	 if (!regx.test(email1)){
	  alert("이메일은 영어, 숫자만 입력가능합니다.");
	  document.form.email1.focus();
	  return false;
	 }
	 if(email2.length==0 || email2==null){
	  alert("이메일을 입력하십시오");
	  return false;
	 }
	 if (!regx.test(email2)){
	  alert("이메일은 영어, 숫자만 입력가능합니다.");
	  document.form.email2.focus();
	  return false;
	 }
	 
	 var num_regx = /^[0-9]*$/;
	 var ph2 = document.form.ph2.value;
	 if(ph2.length==0 || ph2==null){
	  alert("핸드폰번호를 입력하십시오");
	  return false;
	 }
	 var ph3 = document.form.ph3.value;
	 if(ph3.length==0 || ph3==null){
	  alert("핸드폰번호를 입력하십시오");
	  return false;
	 }
	 if (!num_regx.test(ph2) || !num_regx.test(ph3)){
	  alert("핸드폰번호는 숫자만 입력가능합니다");
	  return false;
	 }
	 
	 document.form.submit();
	}