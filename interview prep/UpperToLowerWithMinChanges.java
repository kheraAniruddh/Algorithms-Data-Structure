import java.util.*;
public class UpperToLowerWithMinChanges {

public static void changeCase(String input) {
char [] chars = input.toCharArray();
int upCount=0, lowCount=0;
int[] nums = new int[chars.length];
for(int i =0;i<chars.length;i++) {
nums[i] = chars[i];
if(nums[i]>=97)
lowCount++;
else
upCount++;
}
for(int i=0;i<nums.length;i++) {
	if(lowCount>=upCount) {
		if(nums[i] <97)
			System.out.print((char) (nums[i]+32));
		else
			System.out.print((char) nums[i]);
	}
	else {
		if(nums[i] >=97)
			System.out.print((char) (nums[i]-32));
		else
			System.out.print((char) nums[i]);
	}

}
}

public static void main(String [] args) {
Scanner sc = new Scanner(System.in);
String input = sc.nextLine();
changeCase(input);
}
}

