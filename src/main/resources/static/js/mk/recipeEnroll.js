$("#add").on("click", function(){	
	$("#addList").append(
		`<li>
			<div class="input-mat2">
				<input type="text" class="input-mat2Find" name="mat2Find" placeholder="예) 미역" /> 
				<input type="text" class="input-mat2Vol" name="mat2Vol" placeholder="예) 100g" />
				<button class="deleteButton" type="button" onclick="deleteBox(this)"><img class="deleteImg" th:src=@{/img/mk/delete.png}></button>
			</div>										
		</li>`);
});
function deleteBox(self){
	$($(self).parent('li')[0]).remove();	
}


$("#add2").on("click", function(){	
	$("#add2List").append(
					`<li>
						<table class="reciTable2">
							<tr>
								<td class="table-left" rowspan="3"></td>
								<td  class="blank3" colspan="2"></td>
								<td class="table-right" rowspan="3"></td>
							</tr>							
							<tr>
								<td class="matName-sit"><input type="text"
									class="input-matName" name="matName" value="재료" /><br>
									<button class="groupDeleteButton" type="button">묶음삭제</button>
								</td>
								<td class="matName-sit2">
									<ul id="addList" class="input-mat">
										<li>
											<div class="input-mat2">
												<input type="text" class="input-mat2Find" name="mat2Find" placeholder="예) 미역" /> 
												<input type="text" class="input-mat2Vol" name="mat2Vol" placeholder="예) 100g" />
												<button class="deleteButton" type="button" onclick="deleteBox(this)"><img class="deleteImg" th:src=@{/img/mk/delete.png}></button>
											</div>										
										</li>																				
									</ul>
								</td>
							</tr>
							<tr>
								<td></td>
								<td class="addButtonTd">
									<button id="add" type="button" class="addButton"><img class="addImg" th:src="@{/img/mk/add.png}">추가</button>
								</td>
							</tr>							
						</table>
					</li>`);
});
function deleteBox2(self){
	$($(self).parent('li')[0]).remove();	
}

$("#add3").on("click", function(){	
	$("#add3List").append(
					`<li>
						<table class="reciTable3-1">
							<tr>
								<td class="table-left" rowspan="2"></td>
								<td  class="blank2" colspan="3"></td>
								<td class="table-right" rowspan="2"></td>
							</tr>	
							<tr>
								<td class="step"style="width:200px;">
									Step
								</td>
								<td class="textContent">
									<textarea class="orderContent" name="orderContent" placeholder="예) 소고기는 기름기를 떼어내고 적당한 크기로 썰어주세요."></textarea>
								</td>
								<td class="uploadImg">
										<img class="orderPic" id="uploadPic" name="uploadPic" onclick="" src="#" th:src="@{img/mk/comPic.gif}">
										<input class="InputreciMainPic" type="file" name="file2" id="orderPic" />
								</td>
							</tr>
							<tr>
								<td class="blank3" colspan="5"></td>
							</tr>
						</table>
					</li>`);
});
function deleteBox3(self){
	$($(self).parent('li')[0]).remove();	
}
