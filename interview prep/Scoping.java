class Scoping {
	public static int x =6;
	public static void print(){
		System.out.println("x = "+x);
	}

	public static void main(String[] args) {
		int x= 5;
		Scoping.print();
	}
}