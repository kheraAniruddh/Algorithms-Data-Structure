import java.io.*;
import java.util.Scanner;
public class StringKMP {
  

    public static int stringMatcher(String pattern, String text) {
        int count = 0;
        int psize =pattern.length();
        int [] tempArr =new int[psize]; 
        tempArr[0] = 0;
        int itemp =0, jtemp= 1;

        // Pattern temp array
            while(itemp< psize && jtemp< psize) {
            if(pattern.charAt(itemp) == pattern.charAt(jtemp)) {
                tempArr[jtemp] = itemp + 1;
                jtemp++;
                itemp++;
            } 
            else {
                if(itemp==0) {
                    tempArr[jtemp] = 0;
                    jtemp++;
                }
                else {
                    itemp = tempArr[itemp-1];
                }
            }
        }
        // Search for string
        // for(int i=0;i<text.length();i++) {
        //         if(text.charAt(i) == pattern.charAt(j)) { 
        //             j++;  
        //             if(j==psize) {
        //                 count++;
        //                 j = 0;
        //             }
        //         }
        //         else {
        //              if(j!=0) {  
        //                 j = tempArr[j-1];
        //                 i--;
        //             } 
        //         }
        // }    
        int j = 0, i = 0;
        while(i < text.length()) {
            if(text.charAt(i) == pattern.charAt(j)) {
                j++;
                i++;
            }    
            if(j == psize) {
                count++;
                j = tempArr[j-1];
            }
            else 
                if(i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                    if(j!=0) 
                        j = tempArr[j-1];
                    else
                        i++;
                }
        }        
        return count;
    }
    
    public static void main(String[] args) {
        // Read input from stdin, write output to stdout
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();
        System.out.println(StringKMP.stringMatcher(pattern, text));
    }
}