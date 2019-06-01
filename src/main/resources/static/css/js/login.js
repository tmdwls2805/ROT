
function loginchk(){
	 var regx = /^[a-zA-Z0-9]*$/;
	 var id = document.form.id.value;
	 var pass = document.form.pass.value;
	 if (id.length == 0 || id == null) {
	  alert("아이디를 입력하시오");
	  document.form.id.focus();
	  return;
	 }
	 if (!regx.test(id)){
	  alert("아이디는 영어, 숫자만 입력가능합니다.");
	  document.form.id.focus();
	  return false;
	 }
	 if (pass.length < 6 || pass == null) {
	  alert("비밀번호는 6글자이상입니다^^");
	  document.form.pass.focus();
	  return;
	 }
	 if (!regx.test(pass)){
	  alert("비밀번호는 영어, 숫자만 입력가능합니다.");
	  document.form.pass.focus();
	  return false;
	 }
	 document.form.submit();
	}


