class Solution {
    public long solution(int n) {
        if(n % 2 == 1)
            return 0;
        long[] dp = new long[5001];
        int mod = 1000000007;
        dp[0] = 1;
        dp[2] = 3;
        for(int i = 4; i <= n; i+=2){
            dp[i] = dp[i-2] * 3;
            for(int j = 0; j <= i-4; j+=2)
                dp[i] += dp[j] * 2;
            dp[i] %= mod;
        }
        return dp[n];
    }
}