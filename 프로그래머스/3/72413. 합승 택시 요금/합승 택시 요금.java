import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        long[][] dp = new long[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){ 
                if(i == j)
                   dp[i][j] = 0;
                else
                    dp[i][j] = 1000000;
            }
        }
        for(int[] f : fares){
            dp[f[0]][f[1]] = f[2];
            dp[f[1]][f[0]] = f[2];
        }
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){ 
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        long answer = dp[s][a] + dp [s][b];
        for(int i = 1; i <= n; i++)
            answer = Math.min(answer, dp[s][i] + dp[i][a] + dp[i][b]);
        return (int)answer;
    }
}