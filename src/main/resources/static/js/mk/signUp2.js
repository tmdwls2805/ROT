function idChk() {
  
  var id = document.form.id.value;
  var re = /^[a-zA-Z0-9]{8,20}$/; 
	  
  if (id.length == 0 || id == null) {
    document.form.chk.value = "필수 정보입니다.";
  }else if (!re.test(id)){
	document.form.chk.value = "8~20자의 영문 소문자, 숫자 사용 가능합니다.";
  }else{
	document.form.chk.value = "사용 가능한 아이디 입니다."
  }
  return false;
}
