class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][] directions = {{1, 0}, {0, 1}};
        int[][][] dp = new int[m][n][2];
        for(int x = 0; x < n; x++){
            if(cityMap[0][x] == 1)
                break;
            dp[0][x][0] = 1;
        }
        for(int y = 0; y < m; y++){
            if(cityMap[y][0] == 1)
                break;
            dp[y][0][1] = 1;
        }
        for(int y = 1; y < m; y++){
            for(int x = 1; x < n; x++){
                if(cityMap[y][x] == 1)
                    continue;
                int left = dp[y][x-1][0];
                if(cityMap[y][x-1] == 0)
                    left = (left + dp[y][x-1][1]) % MOD;
                int up = dp[y-1][x][1];
                if(cityMap[y-1][x] == 0)
                    up = (up + dp[y-1][x][0]) % MOD;
                dp[y][x][0] = left;
                dp[y][x][1] = up;
            }
        }
        return (dp[m-1][n-1][0] + dp[m-1][n-1][1]) % MOD;
    }
}