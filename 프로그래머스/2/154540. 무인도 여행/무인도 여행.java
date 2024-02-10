import java.util.*;
class Solution {
    public boolean[][] visited;
    public char[][] map;
    public int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int point, row, col;
    public int[] solution(String[] maps) {
        List<Integer> temp = new ArrayList<>();
        row = maps.length; 
        col = maps[1].length(); 
        map = new char[row][col];
        visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++) map[i][j] = maps[i].charAt(j);
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                point = 0;
                if(!visited[i][j] && map[i][j] != 'X'){
                    bfs(i, j);
                    if(point != 0) temp.add(point);
                }
            }
        }
        if(temp.size() == 0) return new int[] {-1};
        int[] answer = temp.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
    public void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        int[] s = {i, j};
        q.add(s);
        point += map[i][j] - '0';
        while(!q.isEmpty()){
            int[] pos = q.poll();
            for(int[] d : directions){
                int r = pos[0]+d[0], c = pos[1]+d[1];
                if(r >= 0 && r < row){
                    if(c >= 0 && c < col){
                        if(!visited[r][c] && map[r][c] != 'X'){
                            point += map[r][c] - '0';
                            visited[r][c] = true;
                            int[] next = {r, c};
                            q.add(next);
                        }
                    }
                }
            }
        }
    }
}