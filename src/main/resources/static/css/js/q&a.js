function writeSave(){
	var subject = document.writeform.subject.value;
	if(subject.length==0 || subject==null){
	alert("제목를 입력하지 않으셨습니다.");
	return false;
}
	var content = document.writeform.content.value;
	if(content.length==0 || content==null){
	alert("내용를 입력하지 않으셨습니다.");
	return false;
}
	document.writeform.submit();
}