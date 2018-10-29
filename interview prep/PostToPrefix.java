import java.util.*;


public class PostToPrefix {

	public static String toPrefix(String str) {
		Stack<String> stack = new Stack<>();
		//Stack<String> operator_stack = new Stack<>();
		StringBuilder sb;
		for(char c: str.toCharArray()) {
			//System.out.println(c +" "+ (c-'0'));
			if(c-'0'>0 & c-'0'<=128) {
				stack.push(Character.toString(c));
			}
			else {
				if(stack.size()>=2) {
					sb = new StringBuilder();
					String op1 =stack.pop();
					String op2= stack.pop();
					sb.append(Character.toString(c)).append(op2).append(op1);	
					stack.push(sb.toString());
				}
			}

		}
		return stack.pop();
	}

	public static void main(String[] args) {
		System.out.println(PostToPrefix.toPrefix("ABC/-AK/L-*"));
	}
}