import java.lang.Math.*;
import java.util.ArrayList;
class Solution {
    public static void simplify_fraction(int numerator, int denominator, int[] result) {
       int i=2;
       ArrayList<Integer> numfacs = new ArrayList<Integer>();
       ArrayList<Integer> denomfacs = new ArrayList<Integer>();
       int fact =1;
       while(i<= Math.sqrt(numerator)) {
           if(numerator%i==0) {
                numfacs.add(i);
                numerator/=i;
           }
            i++;        
       }
       
       i=2;
        while(i<= Math.sqrt(denominator)) {
           if(denominator%i==0){
                denomfacs.add(i);
                denominator/=i;
           }
                i++;        
        }
        
        int j =0;
        while(j<denomfacs.size() || j<numfacs.size()) {
            
            j++;   
        }
}
