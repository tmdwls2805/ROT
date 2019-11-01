function my_calc(item, item_count, item_sum, item_sum2){ 
    if(item_count.value==0){    
    	alert('개수를 정확히 적어주세요.');
    	item_count.value=1;
    	var count = 1; 
    }else if(item_count.value>100){
    	alert('최대 100개까지 구매 가능합니다.');
    	item_count.value=100;
    	var count = 100;
    }
    else{ 
    	var count = item_count.value; 
    }
    item_sum.value = eval(item.value) * eval(count) ; 
    item_sum2.value = item_sum.value;
my_total(document.form); 
} 

var countEl = document.getElementById("count");
var total_count = document.getElementById("total_count"); //추가
var total_count_view = document.getElementById("total_count_view"); //추가
function plus(){
 if(countEl.value < 100){
  countEl.value++;
  total_count_view.value = total_count.value * countEl.value; //추가
 }else{
	 alert('최대 100개까지 구매 가능합니다.');
 }
}
function minus(){
  
  if (countEl.value > 1) {
	 countEl.value--;
  total_count_view.value = total_count_view.value - total_count.value;
  }  
}

$('#cart_add2').click(function(e){
	e.preventDefault();
	$('.goLoginPop').css("display", "block");	
});

$('.goLogin').click(function(){
	$(location).attr("href", "/loginForm");
});

$('.goMyCart').click(function(e){
	stat = 1;				
});

$('.closeCartPop').click(function(e){				
	stat = 0;
});

var stat = 0;
$('#cart_add').click(function(e){	
	e.preventDefault();	
	$('form').attr("target", "iframe");
	$('form').attr("action", "/materialListDetails/cart");
	$("form").unbind("submit").submit();
	$('.goCartPop').css("display", "block");
	$('.goMyCart').click(function(e){
		$(location).attr("href", "cart");
	});
	$('.closeCartPop').click(function(e){	
		$('.goCartPop').css("display", "none");
	});
});

function closePop(self){
	$(self).parent('div').parent('div').parent('div').css("display", "none");
}

function closePop2(self){
	$(self).parent('div').parent('div').css("display", "none");
}

$('.closePop').click(function() {
	$('.delCartPop').css("display", "none");
});

$('.delCartItem2').click(function(){
	cartNum = $(this).next('.cartNum').val();
	alert(cartNum);
	$('.delCartPop').css("display", "block");
});

function checkAll(){
	if($("#lb_chk").is(':checked')){
		$("input[name=cartProductIds]").prop("checked", true);
	}else{
		$("input[name=cartProductIds]").prop("checked", false);
	}
}

$("input[name=cartProductIds]").click(function(){
	if($("input[name=cartProductIds]:checked").length == $("input[name=cartProductIds]").length){
		$("input[id='lb_chk']").prop("checked", true);
	}else{
		$("input[id='lb_chk']").prop("checked", false);
	}
});

function delSelected(){
	$('.delCartPop').css("display", "block");	
	var chk_obj = $("input[name=cartProductIds]:checked");
	$('.delCartItem').click(function() {
		$(chk_obj).each(function() {		
			var checkboxValue = $(this).parents('table').children('.cartNum').val();
			alert(checkboxValue);
			delCartItem(checkboxValue);
		});
	});
}

function delCartItem(self) {	
	$.ajax({
		async: true,
	    type : 'GET',
	    data : {"cartNum": self},
	    url : "delCart",
	    dataType : "json",
	    contentType: "application/json; charset=UTF-8",
	    success : function(data) {
	    	$(location).attr("href", "cart");
	    },
	    error : function(error) {
	    }
	});
}