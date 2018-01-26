import java.util.*;
class VerifiedParenthesis {

	public static boolean validParen(String str) {
		Stack<Character> stack = new Stack<Character>();
		char[] chars = str.toCharArray();
		for(char c: chars) {
			if(c=='(')
				stack.push(')');
			else if(c=='{')
				stack.push('}');
			else if(c=='[')
				stack.push(']');
			else
				if(stack.isEmpty() || stack.pop()!=c)
					return false;
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String str = "({})";
		System.out.println(validParen(str));
	}
}