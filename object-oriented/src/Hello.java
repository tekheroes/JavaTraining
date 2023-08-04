
@FunctionalInterface
public interface Hello {
	
	String sayHello();
	
	default String sayBye() {
		return "Goodbye!";
	}
	
	static void greetings() {
		System.out.println("Greeting of the day.");
	}
}
