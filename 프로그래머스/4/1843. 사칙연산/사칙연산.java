import java.util.*;
class Solution {
    public int solution(String arr[]) {
        int[] num = new int[arr.length/2+1];
        char[] op = new char[arr.length/2];
        int[][][] dp = new int[arr.length/2+1][arr.length/2+1][2]; 
        int idx1 = 0;
        int idx2 = 0;
        for(String s : arr) {
            if(s.equals("+")) {
                op[idx2++] = '+';
            }
            else if(s.equals("-")) {
                op[idx2++] = '-';
            }
            else {
                num[idx1++] = Integer.parseInt(s);
            }
        }
        for(int i = 0; i < num.length; i++) {
            dp[i][i][0] = dp[i][i][1] = num[i];
        }
        for(int len = 1; len < arr.length/2+1; len++) {
            for(int start = 0; start < arr.length/2+1; start++) {
                if(start + len >= arr.length/2+1) {
                    break;
                }
                int end = start + len;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int i = start; i < end; i++) {
                    if (op[i] == '+') {
                        max = Math.max(max, dp[start][i][1] + dp[i+1][end][1]);
                        min = Math.min(min, dp[start][i][0] + dp[i+1][end][0]);
                    } 
                    else {
                        max = Math.max(max, dp[start][i][1] - dp[i+1][end][0]);
                        min = Math.min(min, dp[start][i][0] - dp[i+1][end][1]);
                    }
                }
                dp[start][end][0] = min;
                dp[start][end][1] = max;
            }
        }
        return dp[0][arr.length/2][1];
    }
}