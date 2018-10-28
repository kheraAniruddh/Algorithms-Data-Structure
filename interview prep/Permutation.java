import java.util.*;

public class Permutation {

	public static void permute(char [] str, int start, List<String> res) {
		if(start == str.length-1)
			res.add(String.valueOf(str));

		for(int i=start;i<str.length;i++) {
			swap(str, i, start);
			permute(str, start+1, res);
			swap(str, i, start); //backtrack
		}
	}

	public static void swap(char[] str, int j, int start) {
		char temp = str[start];
		str[start] = str[j];
		str[j] = temp; 
	} 

	public static void main(String[] args) {
		String str ="abc";
		List<String> res = new ArrayList<>();
		Permutation.permute(str.toCharArray(), 0, res);
		System.out.println(res);
	}
}