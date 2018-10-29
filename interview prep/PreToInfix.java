import java.util.*;


public class PreToInfix {

	public static String toInfix(String str) {
		Stack<String> stack = new Stack<>();
		StringBuilder sb = null;

		for(int i=str.length()-1;i>=0;i--) {
			//System.out.println(c +" "+ (c-'0'));
			if(str.charAt(i)-'0'>0 & str.charAt(i)-'0'<=128) {
				stack.push(Character.toString(str.charAt(i)));
			}
			else {
				if(stack.size()>=2) {
					sb = new StringBuilder();
					String op1 =stack.pop();
					String op2= stack.pop();
					sb.append(op1).append(Character.toString(str.charAt(i))).append(op2);	
					stack.push(sb.toString());
				}
			}

		}
		return stack.pop();
	}

	public static void main(String[] args) {
		System.out.println(PreToInfix.toInfix("*-A/BC-/AKL")); // for postfix to infix don't reverse and op1 &  op2 order changes
	}
}