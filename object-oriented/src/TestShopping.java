import com.tekheroes.shop.Product;
import com.tekheroes.shop.ShoppingCart;

public class TestShopping {

	public static void main(String[] args) {
		
		ShoppingCart cart = new ShoppingCart();
		
		Product p1 = new Product("iPhone 13", 849);
		cart.addToCart(p1);
		
		cart.addToCart(new Product("AirPods Pro", 99));
		cart.addToCart(new Product("iPad Mini", 499));
		
		cart.checkout();
		
	}
}
