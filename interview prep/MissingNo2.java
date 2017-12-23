import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MissingNo2 { 
         
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[201];
        String as = sc.nextLine();
      
        for(int i =0;i< 101;i++) {
            a[i] =sc.nextInt();
            a[i+100]+=a[i+100];
        }
        int m = Integer.parseInt(sc.nextLine());
         int[] b = new int[m];
         String bs = sc.nextLine();
        String [] btokens = bs.split(" ");
        for(int i =0;i< m;i++) {
            b[i] = Integer.parseInt(btokens[i]);
            b_sum+=b[i];
        }



     
    }
}