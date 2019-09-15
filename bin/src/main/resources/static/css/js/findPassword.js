function findpassword(){
	 
	 
	 var name = document.form.name.value;
	 if(name.length==0 || name==null){
	  alert("이름을 입력하십시오");
	  return false;
	 }
	 
	 var id = document.form.id.value;
	 var regx = /^[a-zA-Z0-9]*$/;
	 var chk1 = /\d/;
	 var chk2 = /[a-z]/i;
	 if(id.length==0 || id==null){
	  alert("아이디를 입력하십시오");
	  return false;
	 }
	 if (!regx.test(id)){
	  alert("아이디는 영어, 숫자만 입력가능합니다.");
	  document.form.id.focus();
	  return false;
	 }
	
	 
	 document.form.submit();
	}
	