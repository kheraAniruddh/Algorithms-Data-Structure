import java.io.*;
import java.util.*;

class GroupAlpha {
	public static int findMinCountAll(String str) {
		Map<Character, Integer> map = new HashMap<>();
		for(char c: str.toCharArray()) {
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}
			else
				map.put(c,1);
		}
		int minCount=Integer.MAX_VALUE;
		for(Character key: map.keySet()){
			if(map.get(key)<=minCount)
				minCount=map.get(key);
		}

		return minCount;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(findMinCountAll(input));
	}
}