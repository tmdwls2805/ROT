$("#add1").on("click", function(){	
	$("#add1List").append(
		`<li>
			<div class="input-mat2">
				<input type="text" class="input-mat2Find" name="mat2Find" placeholder="예) 미역" /> 
				<input type="text" class="input-mat2Vol" name="mat2Vol" placeholder="예) 100g" />
				<button class="deleteButton" type="button" onclick="deleteBox(this)"><img class="deleteImg" th:src=@{/img/mk/delete.png}></button>
			</div>										
		</li>`);
});
function deleteBox(self){
	$($(self).parent("li")[0]).remove();	
}
