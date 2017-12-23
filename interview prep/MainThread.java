class MainThread implements Runnable {
	public static int count =0;
	@Override
	public void run() {
		System.out.println("Thread"+count+++"is running with ID");
	}
	public static void main(String[] args) {
		MainThread mt = new MainThread();
		MainThread mt1 = new MainThread();
		// mt.start();
		// mt1.start();
		Thread th1 = new Thread(mt1);
		th1.start();
	}
}