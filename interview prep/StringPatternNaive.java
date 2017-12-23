import java.io.*;
import java.util.Scanner;

public class StringPatternNaive {
	public static int stringMatcher(String text, String pattern) {
		int count =0;
		for(int i=0;i<text.length();i++) {
			for(int j=0;j<pattern.length() && i+j<text.length();j++) {
				if(text.charAt(i+j)!=pattern.charAt(j))	
					break;
					if(j==pattern.length()-1)
						count++;
			}

		}
		return count;

	}

	public static void main(String [] args) {
		System.out.println("Enter the text");
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		System.out.println("Enter the pattern");
		String pattern = sc.nextLine();
		System.out.println(text+"\t"+pattern);
		System.out.println(StringPatternNaive.stringMatcher(text,pattern));
	}	
}