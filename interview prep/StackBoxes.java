import java.util.*;

class StackBoxes {
    public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null || envelopes.length==0) return 0;
        
        int[][] envels = new int[envelopes.length][3];
        for(int i=0;i<envelopes.length;i++) {
            envels[i][0] = envelopes[i][0];
            envels[i][1] = envelopes[i][1];
            envels[i][2] = envelopes[i][0] * envelopes[i][1];
        }
        
        Arrays.sort(envels, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[2], b[2]);
            }
        });
        
        int[] dp = new int[envels.length];
        dp[0] = 1;int max=1;
        for(int i=1;i<envels.length;i++) {
            dp[i] = 1;
            
            for(int j=0;j<i;j++) {
                if(envels[j][0] < envels[i][0] && envels[j][1] < envels[i][1])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }

    public static void main(String[] args) {
        System.out.println(StackBoxes.maxEnvelopes(new int[][]{{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}}));
    }
}