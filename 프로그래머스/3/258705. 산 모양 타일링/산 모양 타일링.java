class Solution {
    public int solution(int n, int[] tops) {
        int[] dp = new int[2 * n + 1];
        dp[0] = 1;
        if(tops[0] == 0) {
            dp[1] = 2;
        } else {
            dp[1] = 3;
        }
        for(int i = 2; i <= 2 * n; i++) {
            if(i % 2 == 0) {
                dp[i] = (dp[i-1] + dp[i-2]) % 10007;
            } else {
                int idx = (i-1) / 2;
                if(tops[idx] == 1) {
                    dp[i] = (dp[i-1] * 2 + dp[i-2]) % 10007;
                } else {
                    dp[i] = (dp[i-1] + dp[i-2]) % 10007;
                }
            }
            dp[i] %= 10007;
        }
        return dp[2*n];
    }
}