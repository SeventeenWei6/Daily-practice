class Solution {
     public int cuttingRope(int n) {
        
        if(n<= 3) return n-1;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i = 4; i<=n; i++){
            int ans = 0;
            for(int j = 1; j<= i-1; j++){
                ans = Math.max(ans, dp[j] * (i-j));
            }
            dp[i] = ans;
        }
        return dp[n];
    }
}

