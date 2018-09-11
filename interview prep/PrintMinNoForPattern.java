import java.util.*;
class PrintMinNoForPattern {

	public static boolean validateString(String in) {
		int count=-1;
		for(char c: in.toCharArray()){
			if(c=='I'||c=='D')
				count++;
		}

		return (count == in.length()-1);
	}
/*
	public static String printMinNoForPattern(String in) {
		int minValAval =1;
		int posOfI=0;
		if(validateString(in)) {

			int[] result = new int[in.length()+1];
			if(in.charAt(0)=='I') {
				result[0]=1;
				result[1]=2;
				minValAval=3;
				posOfI=1;
			}
			else {
				result[0]=2;
				result[1]=1;
				minValAval=3;
				posOfI=0;
			}
			int j=2;
			for(int i=1;i<in.length();i++) {
				if(in.charAt(i)=='I') {
					result[j++]=minValAval;
					minValAval++;
					posOfI=i+1;
				}
				else {
					result[j++] = result[i];
					for(int k=posOfI;k<=i;k++)
						result[k] = result[k]+1;
					minValAval++;
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i: result)
				sb.append(i);
			return sb.toString();
		}
		else return "-1";

	}
*/

	public static String printMinNoForPattern(String in) {
		if(validateString(in)) {
			Stack<Integer> stack = new Stack<>();
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<=in.length();i++){
				stack.push(i+1);
				if(i==in.length()|| in.charAt(i)=='I') {
					while(!stack.isEmpty()) {
						sb.append(Integer.toString(stack.pop()));
					}
				}
			}
			return sb.toString();
		}
		else
			return "-1";

	}


	public static void main(String[] args) {
		System.out.println(printMinNoForPattern("IDID"));
		System.out.println(printMinNoForPattern("I"));
		System.out.println(printMinNoForPattern("DD"));
		System.out.println(printMinNoForPattern("II"));
		System.out.println(printMinNoForPattern("DIDI"));
		System.out.println(printMinNoForPattern("IIDDD"));
		System.out.println(printMinNoForPattern("DDIDDIID"));
	}
}