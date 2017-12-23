class Solution {
    public static int sum =0;
  public static int digit_sum(long number) {
      if(number==0) {
      	if(sum<0)
      		return -sum;
        return sum;
    }
      sum += number%10; 
      return digit_sum(number/10);
 
  }
  public static void main(String[] args) {
  	System.out.println(Solution.digit_sum(-123));
  }
}
