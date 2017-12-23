public class Truck extends Vehicle{
	public void print() {
	System.out.println("I'm truck");
	}

	public void load() {
	System.out.println("Load me");
	}

	public static void main(String[] args) {
		Vehicle t = new Truck();
		t.print();
		t.load();
	}
}