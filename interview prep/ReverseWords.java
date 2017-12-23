import java.util.*;
//import java.lang.StringBuilder;

class ReverseWords {

	public static StringBuilder reverse(String s) {
		StringBuilder sb =new StringBuilder();
		for(int i=s.length()-1;i>=0;i--)
			sb.append(s.charAt(i));
		return sb;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		StringBuilder sb =new StringBuilder();
		int i,j;
		for(i=in.length()-1,j=0; i>=0 && j<in.length(); i--,j++) {
			if(in.charAt(j)==' ') {
				sb.append(in.charAt(j));
				i++;
			}
			else {
				if(in.charAt(i)!=' ') {
					sb.append(in.charAt(i));
				}
				else
					j--;
			}
		}
		while(i>=0) {
			sb.append(in.charAt(i));
			i--;
		}
			System.out.println(sb.toString());
	}
}