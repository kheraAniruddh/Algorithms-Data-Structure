import java.util.*;
class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i =0;i< nums.length;i++) {
            if(map.containsKey(target-nums[i])) {
                result[0] =i;
                result[1] = map.get(target-nums[i]);
                Arrays.sort(result);
                return result;
            }
            else {
                map.put(nums[i],i);
            }
        }
        return result;
}

    public static void main(String[] args) {
        int[] nums = {};
        int[] result = twoSum(nums,6);
        for(int i=0;i<result.length;i++)
            System.out.println(result[i]);
    }
    
}      
