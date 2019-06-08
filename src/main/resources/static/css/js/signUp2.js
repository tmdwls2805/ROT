function idChk() {
  var id = document.form.id.value;

  if (id.length == 0 || id == null) {
    alert("중복 확인할 아이디를 입력하세요.");
    document.form.id.focus();

    return false;
  }

  var url = "/idCheck/" + id;
  window.open(url, "height = 30px", "width = 50px");
}


function pwChk() {
  var pw = document.form.password.value;
  var pw_check = document.form.passwordcheck.value;

  if (pw.length == 0 || pw == null) {
    document.form.chk.value = "비밀번호를 입력하세요.";
  } else if (pw_check.length == 0 || pw_check == null) {
    document.form.chk.value = "비밀번호 확인란을 입력하세요.";
  } else if (pw != pw_check) {
    document.form.chk.value = "비밀번호가 다릅니다."
  } else {
    document.form.chk.value = "비밀번호가 동일합니다.";
  }

  return;
}

function regChk() {
  // a ~ z, A ~ Z, 0 ~ 9 사이의 모든 문자를 확인하는 정규 표현식
  var char_regx = /^[a-zA-Z0-9]*$/;
  var num_regx = /^[0-9]*$/;

  // ID 유효성 검사
  var id = document.form.id.value;

  if (id.length == 0 || id == null) {
    alert("아이디를 입력하세요.");
    document.form.id.focus();

    return false;
  }

  if (!char_regx.test(id)) {
    alert("아이디는 영어 및 숫자만 입력 가능합니다.");
    document.form.id.focus();

    return false;
  }

  // PW 유효성 검사
  var pw = document.form.password.value;

  if (pw.length == 0 || pw == null) {
    alert("암호를 입력하세요.");
    document.form.pw.focus();

    return false;
  }

  if (pw.length < 6 || pw == null) {
    alert("암호를 6자 이상 입력하세요.");
    document.form.password.focus();

    return false;
  }

  if (!char_regx(pw)) {
    alert("암호는 영어 및 숫자로 조합하세요.");
    document.form.password.focus();

    return false;
  }

  // Name 유효성 검사
  var name = document.form.name.value;

  if (name.length == 0 || name == null) {
    alert("이름을 입력하세요.");
    document.form.name.focus();

    return false;
  }

  // 이메일 유효성 검사
  var email1 = document.form.email1.value;
  var email2 = docuemtn.form.email2.value;

  if ((email1.length == 0 || email1 == null) || (email2.length == 0 || email2 == null)) {
    alert("이메일을 입력하세요.");
    document.form.email1.focus();

    return false;
  }

  if (!regx.test(email1) || !regx.test(email2)) {
    alert("이메일은 영어 및 숫자만 입력 가능합니다.");
    document.form.email1.focus();

    return false;
  }

  // 휴대전화번호 유효성 검사
  var ph2 = document.form.ph2.value;
  var ph3 = document.form.ph3.value;

  if (ph2.length == 0 || ph2 == null) {
    alert("휴대전화번호를 입력하세요.");
    document.form.ph2.foucs();

    return false;
  }

  if (ph3.length == 0 || ph3 == null) {
    alert("휴대전화번호를 입력하세요.");
    document.form.ph3.foucs();

    return false;
  }

  if (!num_regx(ph2) || !num_regx(ph3)) {
    alert("휴대전화번호는 숫자만 입력 가능합니다.");

    return false;
  }

  // 주소 유효성 검사
  var addr = document.form.addr.value();

  if (addr.length == 0 || addr == null) {
    alert("주소를 입력하세요.");

    return false;
  }

  document.form.submit();
}

function regCancel() {
  location.href = "loginForm";
}