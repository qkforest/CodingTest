class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] routes = new int[n][m];
        for(int[] p : puddles) {
            routes[p[1]-1][p[0]-1] = -1;
        }
        int v = 1;
        for(int i = 0; i < m; i++) {
            if(routes[0][i] == -1) {
                v = 0; 
            }
            routes[0][i] = v;
        }
        v = 1;
        for(int i = 0; i < n; i++) {
             if(routes[i][0] == -1) {
                v = 0;
            }
            routes[i][0] = v;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(routes[i][j] == -1) {
                    routes[i][j] = 0;
                    continue;
                }
                routes[i][j] = (routes[i-1][j] + routes[i][j-1]) % 1000000007;
            }
        }
        return routes[n-1][m-1];
    }
}