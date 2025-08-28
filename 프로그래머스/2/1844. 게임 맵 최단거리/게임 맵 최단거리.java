import java.util.*;

class Solution {
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private int bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 1});
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            if(now[0] == n-1 && now[1] == m-1) {
                return now[2];
            }
            for(int[] d : directions) {
                int ny = now[0] + d[0];
                int nx = now[1] + d[1];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] || maps[ny][nx] == 0) {
                    continue;
                }
                visited[ny][nx] = true;
                q.offer(new int[] {ny, nx, now[2]+1});
            }
        }
        
        return -1;
    } 
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
}