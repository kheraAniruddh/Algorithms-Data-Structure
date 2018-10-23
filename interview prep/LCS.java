import java.awt.*;
import java.io.*;
import java.math.*;
import java.util.*;
class LCS
{
    public static void main(String args[]) throws IOException
    {
        //int r = (int) (Math.random() * (upper - lower)) + lower;

        int len1,len2;
        String str1="aabdeasra";
        String str2="padadsa";
        len1=str1.length();
        len2=str2.length();
        int table[][]=new int[len2+1][len1+1];
        for(int i=0;i<len2+1;i++) {
            for(int j=0;j<len1+1;j++) {
                table[i][0]=0;
                table[0][j]=0;
            }
        }

        for(int i=1;i<len2+1;i++) {
            for(int j=1;j<len1+1;j++) {
                if(str2.charAt(i-1)==str1.charAt(j-1))
                    table[i][j]=table[i-1][j-1]+1;
                else 
                    table[i][j]= Math.max(table[i-1][j], table[i][j-1]);
            }
        }


        for(int i=0;i<len2+1;i++) {
            for(int j=0;j<len1+1;j++) 
                System.out.print(table[i][j]+"\t");
            System.out.println();
        }

        System.out.println(table[len2][len1]);

        StringBuilder sb = new StringBuilder();
        int i=len2,j=len1;
        while(i>0 && j>0){
                if(str1.charAt(j-1)==str2.charAt(i-1)) {
                    sb.append(Character.toString(str2.charAt(i-1)));
                    i--;j--;
                }
                else{
                    if(table[i-1][j]>=table[i][j-1])
                        i--;
                    else j--;
                }
            }
        System.out.println(sb.reverse());
    }
}