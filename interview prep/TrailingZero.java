class TrailingZero {
    public static int trailingZeroes(int n) {
 //The only tricky thing about this problem is to determin how many 5s are there. since if you reach five, you will innevitably reach 4, and thus you have a ton. Plus there are tons of even number there than five, so no worries, you will find one to match 5 for any amount of 5 you find in the number n*/
        int ret=0;
        while(n>0){
            ret+=n/5;
            n/=5; //this loop makes sure n/ 5,25,125,625... since each is a power of 5 and have to be counted again until the power
        }
        return ret;
    }
    }
    public static void main(String[] args) {
       System.out.println(trailingZeroes(30)); 
    }
}