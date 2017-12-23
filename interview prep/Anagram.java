import java.util.*;

class Anagram {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		String in1 = sc.nextLine();
		String in2 = sc.nextLine();

		if(in1.length()!=in2.length())
			System.out.println("Not an Anagram");
		else {
		char[] newin1 = in1.toCharArray();
		int [] intin1 = new int[256];

		char[] newin2 = in2.toCharArray();
		int [] intin2 = new int[256];


		for(int i =0 ;i<in1.length();i++)
			intin1[newin1[i]]++;

		for(int i =0 ;i<in2.length();i++)
			intin2[newin2[i]]++;

		int flag=0;
		for(int i =0 ;i<256;i++) {
			if(intin1[i] != intin2[i])
				flag=1;
		}
		if(flag==1)
			System.out.println("Not an Anagram");
		else
			System.out.println(" It is an Anagram");

		}
	}
}