var add1HTML = '<div class="dim-layer"><div class="dimBg"></div><div id="layer2" class="pop-layer"><div class="pop-container"><div class="pop-conts"><!--content //--><div><div><h5 class="info-text">휴무일명</h5></div><div class="wrap-input100 validate-input space-add-input" data-validate="Name is required"><input class="input100" type="text" id="appoint-holiday-name" name="appoint-holiday-name" placeholder="휴무일명을 입력하세요." autocomplete="off" required="required" maxlength="4"><span class="focus-input100"></span><font id="chkName" size="2"></font></div><div><h5 class="info-text">날짜</h5></div><div>일자: <input type="text" id="datepicker"></div></div><p class="ctxt mb20"><div class="btn-r"><a href="#" class="appoint-holiday-add-save">저장</a><a href="#" class="appoint-holiday-add-close">Close</a></div><!--// content--></div></div></div></div>';
	
	$("#cart_add2").on("click", function(){
		if(extcnt<maxField){
			$('.appoint-holiday-list').append(add1HTML,extcnt); // Add field
	        layer_popup('#layer2');
		}
	});

function layer_popup(el){
   
    var $el = $(el);        //레이어의 id를 $el 변수에 저장
    var isDim = $el.prev().hasClass('dimBg');   //dimmed 레이어를 감지하기 위한 boolean 변수

    isDim ? $('.dim-layer').fadeIn() : $el.fadeIn();

    var $elWidth = ~~($el.outerWidth()),
        $elHeight = ~~($el.outerHeight()),
        docWidth = $(document).width(),
        docHeight = $(document).height();

    // 화면의 중앙에 레이어를 띄운다.
    if ($elHeight < docHeight || $elWidth < docWidth) {
        $el.css({
            marginTop: -$elHeight /2,
            marginLeft: -$elWidth/2
        })
    } else {
        $el.css({top: 0, left: 0});
    }
    $el.find('a.appoint-holiday-add-save').on('click',function(){
        isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
        $('.dim-layer').remove(); // 레이어팝업 html 삭제
        return false;
    });
   
    $el.find('a.appoint-holiday-add-close').on('click',function(){
        isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
        $('.dim-layer').remove(); // 레이어팝업 html 삭제
        return false;
    });

    $('.layer .dimBg').click(function(){
        $('.dim-layer').fadeOut();
        return false;
    });

}