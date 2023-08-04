
public class HelloDemo {

	public static void main(String[] args) {
		
		Hello h = () -> "Hello World!";	// Lambda expression
		
		System.out.println(h.sayHello());
		System.out.println(h.sayBye());
		
		Hello.greetings();
		
		Hello h2 = () -> {
			String msg = "Hola amigos";
			return msg;
		};
		
		System.out.println(h2.sayHello());
	}
}
