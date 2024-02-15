import java.util.*;
class Solution {
    static boolean[][] visited;
    static char[][] maze;
    static int[][] count;
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean findL, findE;
    static int[] start, lever, exit;
    public int solution(String[] maps) {
        int r = maps.length, c = maps[0].length();
        maze = new char[r][c];
        count = new int[r][c];
        start = new int[2];
        lever= new int[2];
        exit= new int[2];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                maze[i][j] = maps[i].charAt(j);
                if(maps[i].charAt(j) == 'S'){
                    start[0] = i;
                    start[1] = j;
                }
                if(maps[i].charAt(j) == 'L'){
                    lever[0] = i;
                    lever[1] = j;
                }
                if(maps[i].charAt(j) == 'E'){
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }
        findL = false;
        findE = false;
        visited = new boolean[r][c];
        bfs(start, 'L');
        if(findL){
            visited = new boolean[r][c];
            bfs(lever, 'E');
        }
        if(findL && findE){
            return count[exit[0]][exit[1]];
        }
        else
            return -1;
    }
    public void bfs(int[] start, char end){
        Queue<int[]> pos = new LinkedList<>();
        pos.offer(start);
        visited[start[0]][start[1]] = true;
        while(!pos.isEmpty()){
            int[] p = pos.poll();
            for(int[] d : directions){
                int r = p[0] + d[0], c = p[1] + d[1];
                if((r >= 0 && r < maze.length) && (c >= 0 && c < maze[0].length)){
                    if(!visited[r][c]){
                        if(maze[r][c] == end){
                            visited[r][c] = true;
                            count[r][c] = count[p[0]][p[1]] + 1;
                            if(end == 'L')
                                findL = true;
                            else
                                findE = true;
                            break;
                        }
                        if(maze[r][c] != 'X'){
                            visited[r][c] = true;
                            count[r][c] = count[p[0]][p[1]] + 1;
                            pos.add(new int[] {r, c});
                        }
                    }
                }
            }
        }
    }
}