class Rotate {
	public static void printNums(int[] nums) {
		for(int i:nums)
			System.out.print(i + " ");

		System.out.println();
	}
/*
	public static void rotate(int[] nums, int k) {
	// n*k (time limit exceeding)	
		for(int i=0;i<k;i++) {
			int rot_num = nums[nums.length-1];
			for(int j=0;j<nums.length;j++) {
				int temp = nums[j];
				nums[j] = rot_num;
				rot_num = temp;
			}
		}
	}
	*/

	public static void  reverse(int[] nums, int start, int stop) {
		while(start<=stop) {
			int temp = nums[stop];
			nums[stop] = nums[start];
			nums[start] = temp;
			start++;
			stop--;
		}
	}

	public static void rotate(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
		printNums(nums);

	}

	public static void main(String[] args) {
		rotate(new int[]{1,2,3,4,5,6,7}, 3);
	}
}