class Solution {
    private int countWin(int u, boolean[][] graph, boolean[] visited) {
        int count = 1;
        for(int v = 0; v < graph[0].length; v++) {
            if(!graph[u][v] || visited[v]) {
                continue;
            }
            visited[v] = true;
            count += countWin(v, graph, visited);
        }
        return count;
    }
    
    private int countLose(int v, boolean[][] graph, boolean[] visited) {
        int count = 1;
        for(int u = 0; u < graph.length; u++) {
            if(!graph[u][v] || visited[u]) {
                continue;
            }
            visited[u] = true;
            count += countLose(u, graph, visited);
        }
        return count;
    }
    
    public int solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n][n];
        int answer = 0;
        
        for(int[] e : results) {
            graph[e[0]-1][e[1]-1] = true;
        }
        
        for(int u = 0; u < n; u++) {
            int win = countWin(u, graph, new boolean[n]) - 1;
            int lose = countLose(u, graph, new boolean[n]) - 1;
            if(win + lose + 1 == n) {
                answer++;
            }
        }

        return answer;
    }
}