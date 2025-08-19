class Solution {
    public int solution(String arr[]) {
        int length = arr.length / 2;
        char[] op = new char[length];
        int[][][] dp = new int[length+1][length+1][2];
        int o = 0;
        int n = 0;
        for(String s : arr) {
            if(s.equals("+") || s.equals("-")) {
                op[o++] = s.charAt(0);
            } else {
                dp[n][n][0] = Integer.parseInt(s);
                dp[n][n++][1] = Integer.parseInt(s);
            }
        }
        for(int len = 1; len <= length; len++) {
            for(int start = 0; start <= length; start++) {
                if(len + start >= length + 1) {
                    break;
                }
                int end = start + len;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for(int i = start; i < end; i++) {
                    if(op[i] == '+') {
                        min = Math.min(min, dp[start][i][0]+dp[i+1][end][0]);
                        max = Math.max(max, dp[start][i][1]+dp[i+1][end][1]);
                    } else {
                        min = Math.min(min, dp[start][i][0]-dp[i+1][end][1]);
                        max = Math.max(max, dp[start][i][1]-dp[i+1][end][0]);
                    }
                }
                dp[start][end][0] = min;
                dp[start][end][1] = max;
            }
        }
        return dp[0][length][1];
    }
}