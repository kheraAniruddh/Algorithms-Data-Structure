import java.util.*;

class LCS {

	public static int findLCS(String str1, String str2, int i, int j) {
		if(i<0 || j<0)
			return 0;
		if(str1.charAt(i) == str2.charAt(j))
			return 1+ findLCS(str1,str2,i-1,j-1);
		else 
			return max(findLCS(str1,str2,i-1,j), findLCS(str1,str2,i,j-1));
	}

	public static int max(int a, int b) {
		if(a>b) return a;
		else
			return b;
	}

	
	public static void main(String[] args) {
		
		System.out.println("Enter 2 strings");
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		System.out.println(findLCS(str1, str2,str1.length()-1, str2.length()-1));
	}
}