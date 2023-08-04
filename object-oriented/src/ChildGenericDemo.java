
public class ChildGenericDemo<Z, S> extends GenericDemo<Z> {
	private S temp;

	public ChildGenericDemo(Z data, S temp) {
		super(data);
		this.temp = temp;
	}

	public S getTemp() {
		return temp;
	}

	public void setTemp(S temp) {
		this.temp = temp;
	}
	
	public static void main(String[] args) {
		ChildGenericDemo<String, Integer> cd1 = new ChildGenericDemo<String, Integer>("Polo", 100);
		System.out.println(cd1.getData() + "\t" + cd1.getTemp());
	}
}
