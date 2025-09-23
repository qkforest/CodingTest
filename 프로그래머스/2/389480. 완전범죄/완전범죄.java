class Solution {
    private static int answer;
    private static boolean[][][] visited;
    
    private void dfs(int[][] info, int n, int m, int idx, int a, int b) {
        if(a >= n || b >= m) {
            return;
        }
        
        if(idx == info.length) {
            answer = Math.min(answer, a);
            return;
        }
        if(!visited[idx+1][a+info[idx][0]][b]) {
            visited[idx+1][a+info[idx][0]][b] = true;
            dfs(info, n, m, idx + 1, a + info[idx][0], b);
        }
        if(!visited[idx+1][a][ b+info[idx][1]]) {
            visited[idx+1][a][ b+info[idx][1]] = true;
            dfs(info, n, m, idx + 1, a, b + info[idx][1]);
        }
    }
    
    public int solution(int[][] info, int n, int m) {
        answer = Integer.MAX_VALUE;
        visited = new boolean[41][126][126];
        
        dfs(info, n, m, 0, 0, 0);
        
        if(answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        
        return answer;
    }
}