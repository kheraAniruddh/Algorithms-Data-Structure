class UglyNo {
	// Non-dynamic programming
	// public static int findUglyNo(int n) {
	// 	int count =0;
	// 	int i=1;
	// 	while(count<n) {
	// 		if(i==1)
	// 			count++;
	// 		else {
	// 		int rem = i;
	// 		int flag =1;
	// 		while(flag==1 && rem>1) {
	// 			if(rem%2==0)
	// 				rem/=2;
	// 			else if(rem%3==0)
	// 				rem/=3;
	// 			else if( rem%5==0)
	// 				rem/=5;
	// 			else
	// 				flag=0;
	// 		}
	// 		if(flag==1) 
	// 			count++;
	// 	}
	// 		i++;
	// 	}
	// 	return i-1;
	// }

	public static int findUglyNo(int n)
    {
        int ugly[] = new int[n];  // To store ugly numbers
        int i2 = 0, i3 = 0, i5 = 0;
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;
        int next_ugly_no = 1;
         
        ugly[0] = 1;
         
        for(int i = 1; i < n; i++)
        {
            next_ugly_no = Math.min(next_multiple_of_2,
                                  Math.min(next_multiple_of_3,
                                        next_multiple_of_5));
             
            ugly[i] = next_ugly_no;
            if (next_ugly_no == next_multiple_of_2)
            {
               i2 = i2+1;
               next_multiple_of_2 = ugly[i2]*2;
            }
            if (next_ugly_no == next_multiple_of_3)
            {
               i3 = i3+1;
               next_multiple_of_3 = ugly[i3]*3;
            }
            if (next_ugly_no == next_multiple_of_5)
            {
               i5 = i5+1;
               next_multiple_of_5 = ugly[i5]*5;
            }
        } /*End of for loop (i=1; i<n; i++) */
        return next_ugly_no;
    }
 


	public static void main(String[] args) {
		System.out.println(findUglyNo(11));
	}
}