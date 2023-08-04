
public class Person {
	private String name;
	private int age;
	
	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void print() {
		System.out.println("Name: " + name + "\tAge: " + age);
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\tAge: " + age;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person p = (Person) obj;
			if(this.name.equals(p.name) && age == p.age)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Person p1 = new Person("Polo", 21);
		p1.print();
		
		Person p2 = new Person("Holy", 21);
		p2.print();
		
		System.out.println(p1);	// Implicitly calls the toString() method of Object class
	
		System.out.println(p1.equals(p2));	// Default implementation compares hashCode of 2 objects
	}
}
