import java.util.*;
class Solution {
    public boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                visited[i] = true;
                bfs(i, n, computers);
            }
        }
        return answer;
    }
    public void bfs(int start, int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 0; i < n; i++) {
                if(!visited[i] && computers[now][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}