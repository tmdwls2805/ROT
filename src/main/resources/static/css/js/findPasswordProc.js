function repassword(){

var password = document.form.password.value;
	 if(password.length<6 || password==null){
	  alert("새 비밀번호를 입력하십시오(6글자이상)");
	  return false;
	 }
	 if (chk1.test(password) && chk2.test(password)){
	 }else{
	  alert("새 비밀번호는 영어, 숫자 조합입니다.");
	  return false;
	 }
	 document.form.submit();
}

function passchk(){
	 var password = document.form.password.value;
	 var passwordcheck = document.form.passwordcheck.value;
	 if (passwordcheck.length == 0 || passwordcheck == null) {
	  document.form.chk.value = "비밀번호를 입력하세요";
	  right=0;
	 } else if (password != passwordcheck) {
	  document.form.chk.value = "비밀번호가 다릅니다.";
	  right=0;
	 } else {   
	  document.form.chk.value = "비밀번호가 동일합니다.";
	  right=1;
	 }
	 return;
	}