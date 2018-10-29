import java.util.*;


public class PreToPostfix {

	public static String toPostfix(String str) {
		Stack<String> stack = new Stack<>();
		//Stack<String> operator_stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		sb.reverse();
		str =sb.toString();
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
					sb.append(op1).append(op2).append(Character.toString(c));	
					stack.push(sb.toString());
				}
			}

		}
		return stack.pop();
	}

	public static void main(String[] args) {
		System.out.println(PreToPostfix.toPostfix("*-A/BC-/AKL"));
	}
}