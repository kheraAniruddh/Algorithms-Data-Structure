import java.util.*;
public class FlightCount{

	public static String process(String input) {
		char[] chars = input.toCharArray();
		int s =0, f=0;
		for(int i=0;i<chars.length-1;i++) {
			if(chars[i] !=chars[i+1]) {
				if(chars[i]=='S')
					s++;
				else
					f++;
			} 
		}
		if(s>f)
			return "YES";
		else
			return "NO";
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String input = sc.nextLine();
		System.out.println(process(input));
	}
}