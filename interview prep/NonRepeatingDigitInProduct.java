class NonRepeatingDigitInProduct {
	public static void main(String[] args) {
	System.out.println(nonRepeatingDigitProductCount(0, 1111, 999999));
	}
	// Complete the
	// nonRepeatingDigitProductCount function below.*/

	static int nonRepeatingDigitProductCount(int x, int y, int z) {
		int count=0;
		for(int i=y;i<=z;i++){
			long product = i*x;
			int flag=0;
			for(char c: Integer.toString(i).toCharArray()){
				if (Long.toString(product).contains(Character.toString(c))) {
					flag=1;
					break;
				}
			}
			if(flag==0)
				count++;

		}
		return count;
	}

}