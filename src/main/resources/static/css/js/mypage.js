function check(){
	var password = document.form.password.value;
		if(password.length==0 || password==null){
		alert("비밀번호를 입력하지 않으셨습니다.");
		return false;
	}
		document.form.submit();
}

function updatepw(){
		var password = document.form.password.value;
		 if(password.length<6 || password==null){
		  alert("현재 비밀번호를 입력하십시오.");
		  return false;
		 }
		 var repassword = document.form.repassword.value;
		 if(repassword.length<6 || repassword==null){
		  alert("새 비밀번호를 입력하십시오.");
		  return false;
		 }
		 var repasswordcheck = document.form.repasswordcheck.value;
		 if(repasswordcheck.length<6 || repasswordcheck==null){
		  alert("새 비밀번호 확인를 입력하십시오.");
		  return false;
		 }

		 document.form.submit();
	}

	function passchk(){
		 var repassword = document.form.repassword.value;
		 var repasswordcheck = document.form.repasswordcheck.value;
		 if (repasswordcheck.length == 0 || repasswordcheck == null) {
		  document.form.chk.value = "비밀번호를 입력하세요";
		  right=0;
		 } else if (repassword != repasswordcheck) {
		  document.form.chk.value = "비밀번호가 다릅니다.";
		  right=0;
		 } else {   
		  document.form.chk.value = "비밀번호가 동일합니다.";
		  right=1;
		 }
		 return;
		}