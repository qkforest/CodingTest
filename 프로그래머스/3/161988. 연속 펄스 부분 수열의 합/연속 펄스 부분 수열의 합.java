import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        int len = sequence.length;
        long[][] dp = new long[len][2];
        dp[0][0] = sequence[0];
        dp[0][1] = sequence[0]*(-1);
        long answer = Math.max(dp[0][0], dp[0][1]); 
        for(int i = 1; i < len; i++){
            if(i % 2 == 0){
                dp[i][0] = Math.max(sequence[i], dp[i-1][0]+sequence[i]);
                dp[i][1] = Math.max(sequence[i]*(-1), dp[i-1][1]+sequence[i]*(-1));
            }else{
                dp[i][0] = Math.max(sequence[i]*(-1), dp[i-1][0]+sequence[i]*(-1));
                dp[i][1] = Math.max(sequence[i], dp[i-1][1]+sequence[i]);
            }
            long max = Math.max(dp[i][0], dp[i][1]);
            if(answer < max)
                answer = max; 
        }
        return answer;
    }
}