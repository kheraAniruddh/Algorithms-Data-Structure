import java.util.*;

class Median2 {
    public static double helper(int[] nums1, int[] nums2, int start, int end) {
        int mid = (end+start)/2;
        List<Integer> nums1Left = new ArrayList<>();
        List<Integer> nums2Left = new ArrayList<>();
        List<Integer> nums1Right = new ArrayList<>();
        List<Integer> nums2Right = new ArrayList<>();
        
       
        
        int i=0;
        while(i<mid)
            nums1Left.add(nums1[i++]);
        while(i<nums1.length)
            nums1Right.add(nums1[i++]);
        
        if(nums1Left.size()==0) nums1Left.add(Integer.MIN_VALUE);
        if(nums1Right.size()==0) nums1Right.add(Integer.MAX_VALUE);
        int no=0;
        if(mid!=0)  
            no =  nums1Left.size();

        int leftEle = (nums1.length+nums2.length+1)/2 - no;
            
        i=0;
        while(i<leftEle)
            nums2Left.add(nums2[i++]);
        
        while(i<nums2.length)
            nums2Right.add(nums2[i++]);

        if(nums2Left.size()==0) nums2Left.add(Integer.MIN_VALUE);
        if(nums2Right.size()==0) nums2Right.add(Integer.MAX_VALUE);

        if(nums1Left.get(nums1Left.size()-1) <= nums2Right.get(0)
          && nums2Left.get(nums2Left.size()-1) <= nums1Right.get(0)) {
            if((nums1.length+nums2.length)%2==0)
                return (double) (Math.max(nums1Left.get(nums1Left.size()-1),
                                          nums2Left.get(nums2Left.size()-1))+Math.min(nums1Right.get(0),
                                                                                      nums2Right.get(0)))/2; 
            return (double) Math.max(nums1Left.get(nums1Left.size()-1),nums2Left.get(nums2Left.size()-1));
        }
        
        if(nums1Left.get(nums1Left.size()-1) > nums2Right.get(0))
            return helper(nums1, nums2, 0, mid);
        return helper(nums1, nums2, mid+1, end);
        
        
        
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null || nums1.length==0) {
            if(nums2.length%2==0)
                return (double) (nums2[nums2.length/2] + nums2[nums2.length/2-1])/2;
            return (double) nums2[nums2.length/2];
        }

        if(nums2==null || nums2.length==0) {
            if(nums1.length%2==0)
                return (double) (nums1[nums1.length/2] + nums1[nums1.length/2-1])/2;
            return (double) nums1[nums1.length/2];
        }
        if(nums1.length<=nums2.length) 
            return helper(nums1, nums2, 0, nums1.length);
        return helper(nums2, nums1,0, nums2.length);
    }

    public static void main(String[] args) {
        System.out.println(Median2.findMedianSortedArrays( new int[]{1,3}, new int[]{2}));
    }
}