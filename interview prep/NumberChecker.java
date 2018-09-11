import java.io.*;
import java.util.*;


class NumberChecker {

	public static List<Integer> numberChecker(int [] arr) {
		List<Integer> li = new ArrayList<>();
		for(int i: arr) {
			String str  = Integer.toString(i);
			if(str.contains("1") && str.contains("2") && str.contains("3"))
				li.add(Integer.parseInt(str));
		}
		if(li.isEmpty())
			li.add(-1);

		Collections.sort(li);
		return li;
	}

	public static void main(String[] args) {
		 int[] numbers ={12, 232, 456, 234};
		 List<Integer> list = numberChecker(numbers);
		 String res = list.toString();
		 System.out.println(res.replace("[","").replace("]",""));

	}
}