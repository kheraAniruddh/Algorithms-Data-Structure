class MaxSubArray {
	// Kadane's Algo, handling only negative num array
    public static int maxSubArray(int[] nums) {
        int curMax = nums[0], max_tillnow =nums[0];
        for(int i=1;i<nums.length;i++) {
            curMax = Math.max(nums[i], curMax+ nums[i]);
            max_tillnow = Math.max(max_tillnow, curMax);
        }
        return max_tillnow;
    }

    public static void main(String[] args) {
    	int arr[] = {-2, 1,-3,4,-1,2,1,-5,4};
		System.out.println( maxSubArray(arr));    	
    }
}