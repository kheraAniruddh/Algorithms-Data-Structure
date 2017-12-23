import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MissingNo { 
         
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] a = new int[n];
        String as = sc.nextLine();
        String [] atokens = as.split(" ");
        int a_sum=0, b_sum=0;
        for(int i =0;i< n;i++) {
            a[i] = Integer.parseInt(atokens[i]);
            a_sum+=a[i];
        }
        int m = Integer.parseInt(sc.nextLine());
         int[] b = new int[m];
         String bs = sc.nextLine();
        String [] btokens = bs.split(" ");
        for(int i =0;i< m;i++) {
            b[i] = Integer.parseInt(btokens[i]);
            b_sum+=b[i];
        }

       if(m-n==1) 
         System.out.println(b_sum-a_sum);
        else {
            
       Map<Integer, Integer> b_map = new HashMap<>();
       Map<Integer, Integer> a_map = new HashMap<>(); 
       List<Integer> c = new ArrayList<>(); 
            for(int i =0; i<m;i++){
                if(b_map.containsKey(b[i]))
                   b_map.put(b[i],b_map.get(b[i])+1);
                else
                   b_map.put(b[i],1);
            }  
            for(int i =0; i<n;i++){
                if(a_map.containsKey(a[i]))
                   a_map.put(a[i],a_map.get(a[i])+1);
                else
                   a_map.put(a[i],1);
            }

            for(Integer key: b_map.keySet()) {
                int diff =0;
                if(a_map.containsKey(key)) {
                    if(b_map.get(key)!=a_map.get(key))
                        diff = b_map.get(key)- a_map.get(key);
                        while(diff!=0) {
                             c.add(key);
                             diff--;
                         }       
                }
                else {
                    diff = b_map.get(key);
                    while(diff!=0) {
                             c.add(key);
                             diff--;
                         }  
                }
            }       
           Collections.sort(c);
           Iterator iter = c.iterator();
           while(iter.hasNext())
            System.out.print(iter.next()+ " ");
         }
    }
}