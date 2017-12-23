class B extends A {
	public void foo() {
		System.out.println("In class B");
	}

	 public static void main(String[] args) {
		A a =  new B();	
	}
}