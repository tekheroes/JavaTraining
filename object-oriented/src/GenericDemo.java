
public class GenericDemo<Z> {
	private Z data;

	public GenericDemo(Z data) {
		this.data = data;
	}

	public Z getData() {
		return data;
	}

	public void setData(Z data) {
		this.data = data;
	}
	
	public static void main(String[] args) {
		GenericDemo<String> d1 = new GenericDemo<String>("Hello");
//		d1.setData(3.14);
		System.out.println(d1.getData());
		
		GenericDemo<Integer> d2 = new GenericDemo<Integer>(100);
		System.out.println(d2.getData());
		
		GenericDemo<Person> d3 = new GenericDemo<Person>(new Person("Ben", 11));
		System.out.println(d3.getData());
	}
}
