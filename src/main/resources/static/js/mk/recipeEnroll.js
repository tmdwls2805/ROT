function addItem(self){
	var tbl = $(self).parents('table');
	/* var item = $(".recepiRow2",tbl).clone(); */
	var item = $(`<li class="recepiRow2">
											<div class="input-mat2">
												<input type="text" class="input-mat2Find" name="mat2Find" placeholder="예) 미역" required/> 
												<input type="text" class="input-mat2Vol" name="mat2Vol" placeholder="예) 100g" required/>
												<button class="deleteButton" type="button" onclick="deleteBox(this)"><img class="deleteImg" src="/img/mk/delete.png"></button>
											</div>										
										</li>`).clone();
	$(".recepiList",tbl).append(item);
}

$("#add2").on("click", function(){	
	var row = $(`<li class="recepiRow" id="recepiRow">
						<table class="reciTable2">
							<tr>
								<td class="table-left" rowspan="3"></td>
								<td  class="blank3" colspan="2"></td>
								<td class="table-right" rowspan="3"></td>
							</tr>							
							<tr class="add_tr">
								<td class="matName-sit"><input type="text"
									class="input-matName" name="matName" value="재료" required /><br>
									<button class="groupDeleteButton" type="button" onclick="deleteBox2(this)">묶음삭제</button>
								</td>
								<td class="matName-sit2">
									<ul id="addList" class="input-mat recepiList">
										<li class="recepiRow2">
											<div class="input-mat2">
												<input type="text" class="input-mat2Find" name="mat2Find" placeholder="예) 미역" required/> 
												<input type="text" class="input-mat2Vol" name="mat2Vol" placeholder="예) 100g" required/>
											</div>										
										</li>	
										<li class="recepiRow2">
											<div class="input-mat2">
												<input type="text" class="input-mat2Find" name="mat2Find" placeholder="예) 미역" required/> 
												<input type="text" class="input-mat2Vol" name="mat2Vol" placeholder="예) 100g" required/>
												<button class="deleteButton" type="button" onclick="deleteBox(this)"><img class="deleteImg" src="/img/mk/delete.png"></button>
											</div>										
										</li>																			
									</ul>
								</td>
							</tr>
							<tr>
								<td></td>
								<td class="addButtonTd">
									<button id="add1" type="button" class="addButton addRecepiBtn" onclick="addItem(this)"><img class="addImg" src="/img/mk/add.png">추가</button>
								</td>
							</tr>							
						</table>
					</li>`).clone();

	var btn = $("#add1", row);
	var li = $("#recepiRow", row);
	li.attr("id", li.attr("id") + "_" +  ($(".recepiRow").size() + 1));
	btn.attr("id", btn.attr("id") + "_" +  ($(".addRecepiBtn").size() + 1));
	
	
	$("#add2List").append(row);
	
});

$("#add3").on("click", function(){	
		var row = $(`<li>
						<table class="reciTable3-1">
							<tr>
								<td class="table-left" rowspan="3"></td>
								<td  class="blank2" colspan="4"></td>
								<td class="table-right" rowspan="3"></td>
							</tr>	
							<tr>
								<td class="step" id="step" style="width:200px;">
									Step
								</td>
								<td class="textContent">
									<textarea class="orderContent" name="orderContent" placeholder="예) 소고기는 기름기를 떼어내고 적당한 크기로 썰어주세요." required="required"></textarea>
									<button class="deleteButton2" type="button" onclick="deleteBox3(this)"><img class="deleteImg" src="/img/mk/delete.png"></button>
								</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td>
								</td>
							</tr>
							<tr>
								<td class="blank3" colspan="6"></td>
							</tr>
						</table>
					</li>`).clone();
			
		$("#add3List").append(row);
});

function deleteBox(self){
	var delBtn = $(self).parent('div').parent('li');
	$(delBtn).remove();	
}

function deleteBox2(self){
	var delBtn = $(self).parents('li');
	$(delBtn).remove();		
}

function deleteBox3(self){
	var delBtn = $(self).parents('li');
	$(delBtn).remove();	
}