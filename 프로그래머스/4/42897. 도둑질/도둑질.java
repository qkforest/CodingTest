import java.util.*;
class Solution {
    public long solution(int[] money) {
        int len = money.length;
        long[] dp = new long[len];
        long[] dp2 = new long[len];
        dp[0] = 0;
        dp[1] = money[1];
        for(int i = 2; i < len; i++)
            dp[i] = Math.max(dp[i-2]+money[i], dp[i-1]);
        dp2[0] = 0;
        dp2[1] = money[0];
        for(int i = 2; i < len; i++)
            dp2[i] = Math.max(dp2[i-2]+money[i-1], dp2[i-1]);
        return Math.max(dp[len-1], dp2[len-1]);
    }
}