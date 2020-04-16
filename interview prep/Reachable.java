import java.util.*;

public class Reachable {
	
	public static int getBestPossibleNumberOfStep(String[] input) {
		int res = -1;
		int[] dp = new int[input[0].length()];
		int k = Integer.parseInt(input[1]);
		dp[0] = 0;
		for(int i=1;i<input[0].length();i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		char[] inputArr = input[0].toCharArray();
		for(int i=0;i<inputArr.length;i++) {
			if(dp[i] != Integer.MAX_VALUE) {
				if(i+1<inputArr.length && inputArr[i+1]=='1') {
					int temp = dp[i]+1;
					dp[i+1] = Math.min(dp[i+1], temp);
				}
				if(i+2<inputArr.length && inputArr[i+2]=='1') {
					int temp = dp[i]+1;
					dp[i+2] = Math.min(dp[i+2], temp);
				}
				if(i+k<inputArr.length && inputArr[i+k]=='1') {
					int temp = dp[i]+1;
					dp[i+k] = Math.min(dp[i+k], temp);
				}
			}
		}

		return (dp[inputArr.length-1]!= Integer.MAX_VALUE) ? dp[inputArr.length-1] :-1;
	}

	public static void main(String[] args) {
		List<String[]> inputs = new ArrayList<String[]> (Arrays.asList(new String[]{"101000011","5"},new String[] {"1100000100111","6"},new String[]{"10101010101111010101","4"}));
		inputs.stream().forEach(input->{System.out.println();
										System.out.println(Reachable.getBestPossibleNumberOfStep(input));
									});
	}
}