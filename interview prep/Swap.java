class Swap {

	public static void swap(int a, int b) {
		b = b-a;
		a = a+b; // a+ b -a = b
		b = a-b; // b - b +a = a
		System.out.println("a = "+ a);
		System.out.println("b= "+b);
	}
	public static void main(String[] args) {
		int a =10;
		int b = 20;
			System.out.println("a = "+ a);
		System.out.println("b= "+b);
		 swap(a,b);
	}
}