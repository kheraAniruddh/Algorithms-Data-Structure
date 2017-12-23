import java.io.*;
import java.util.Scanner;

class Palindrome1 {
	
	public static void palinCheck(String input) {
		for(int i =0, j=input.length()-1; i<=j;i++,j--) {
			if(input.charAt(i)!= (input.charAt(j))) {
				System.out.println("Not a palindrome");
				return;
			}
		}
		System.out.println("It is a palindrome");
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		Palindrome1.palinCheck(input);
	}

}