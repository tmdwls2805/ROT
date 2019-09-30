import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hoseo.rot.recipe.RecipeOrder;
import com.hoseo.rot.recipe.RecipeService;

public class Test {
	@Autowired
	RecipeService service;
	@org.junit.Test
	public void test() {
		RecipeOrder reci = new RecipeOrder();
		reci.setOrderContent("이름");
		reci.setOrderPic("제목");
		
		service.addRecipeOrder(reci);

		
	}
}
