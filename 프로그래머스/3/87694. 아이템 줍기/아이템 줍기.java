import java.util.*;
class Solution {
    public int answer;
    public int[][] map;
    public boolean[][] visited;
    public int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = 0;
        map = new int[101][101];
        visited = new boolean[101][101];
        for(int[] points : rectangle){
            int x1 = 2 * points[0];
            int y1 = 2 * points[1];
            int x2 = 2 * points[2];
            int y2 = 2 * points[3];
            for(int y = y1; y <= y2; y++) {
                for(int x = x1; x <= x2; x++) {
                    if(map[y][x] == 2) {
                        continue;
                    }
                    map[y][x] = 2;
                    if(x == x1 || x == x2 || y == y1 || y == y2) {
                        map[y][x] = 1;
                    }
                }
            }
        }
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return answer/2;
    }
    public void bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{characterY, characterX});
        visited[characterY][characterX] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == itemY && now[1] == itemX){
                answer = map[now[0]][now[1]];
                break;
            }
            for(int[] d : directions) {
                int y = now[0] + d[0];
                int x = now[1] + d[1];
                if(x >= 0 && x <= 100 && y >= 0 && y <= 100 && !visited[y][x] && map[y][x] == 1) {
                    q.offer(new int[]{y, x});
                    visited[y][x] = true;
                    map[y][x] = map[now[0]][now[1]] + 1;
                }
            }
        }
    }
}