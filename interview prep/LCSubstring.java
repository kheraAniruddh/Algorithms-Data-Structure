import java.awt.*;
import java.io.*;
import java.math.*;
import java.util.*;
class LCSubstring
{
    public static void main(String args[]) throws IOException
    {
        int len1,len2,result=0;
        String str1="aabdeasra";
        String str2="padeasa";
        len1=str1.length();
        len2=str2.length();
        int table[][]=new int[len2+1][len1+1];
        
        for (int i = 0 ;i <= len2; i++)  { 
            for (int j = 0; j <= len1; j++) { 
                if (i == 0 || j == 0) 
                    table[i][j] = 0;
            }
        }

        for (int i = 1; i <= len2; i++)  { 
            for (int j = 1; j <= len1; j++) { 
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) { 
                    table[i][j] = table[i - 1][j - 1] + 1; 
                    result = Math.max(result, table[i][j]); 
                }  
                else
                    table[i][j] = 0; 
            } 
        } 
        System.out.println("result: "+result); 


        for(int i=0;i<len2+1;i++) {
            for(int j=0;j<len1+1;j++) 
                System.out.print(table[i][j]+"\t");
            System.out.println();
        }


        StringBuilder sb = new StringBuilder();

        for(int i=len2;i>=1;i--) {
            for(int j=len1;j>=1;j--) {
            if(table[i][j]==4) {
                sb.append(str2.substring(i-5,i));
                break;
            }               
        }
        }
        System.out.println(sb);
    }
}