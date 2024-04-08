import java.util.*;
class Solution {
    static int[] answer;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        answer = new int[2];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !visited[i][j]) {
                    answer[0]++;
                    bfs(m, n, picture[i][j], picture, new int[] {i, j});
                }
            }
        }
        return answer;
    }
    public void bfs(int m, int n, int color, int[][] picture, int[] start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int size = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int[] d: directions) {
                int x = now[1] + d[1];
                int y = now[0] + d[0];
                if(x >= 0 && x < n && y >= 0 && y < m && picture[y][x] == color && !visited[y][x]) {
                    q.add(new int[] {y, x});
                    visited[y][x] = true;
                    size++;
                }
            }
        }
        if(size > answer[1]) {
            answer[1] = size;
        }
    }
}