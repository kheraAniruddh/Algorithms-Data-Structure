import java.util.*;
class RegularExp {
	public static boolean isMatch(String t, String p) {
		if(p==null|| p.length()==0) return false;

		boolean [][]dp = new boolean[t.length()+1][p.length()+1];
		dp[0][0] = true;
		
		 for(int i=1;i<dp[0].length;i++) {
            if(p.charAt(i-1)=='*' && i>=2)
                dp[0][i] = dp[0][i-2];
        }

		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(t.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1)=='.')
					dp[i][j]= dp[i-1][j-1];
				else {
					if(p.charAt(j-1)=='*'){
					 	dp[i][j] = dp[i][j-2];
					if(p.charAt(j-2) == t.charAt(i-1) || p.charAt(j-2)=='.')
						dp[i][j] = dp[i][j] || dp[i-1][j]; 	
					}
					else
						dp[i][j] = false;
				}
			}
		}

		return dp[t.length()][p.length()];

	}
	public static void main(String[] args) {
		System.out.println(RegularExp.isMatch("","ab*b*"));
	}
}