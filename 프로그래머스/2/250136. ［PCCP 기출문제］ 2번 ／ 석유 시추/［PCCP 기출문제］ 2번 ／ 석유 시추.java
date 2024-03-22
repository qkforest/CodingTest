import java.util.*;
class Solution {
    static int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static boolean[][] visited;
    static int idx = 0;
    static int row, col;
    static Map<Integer, HashSet<Integer>> map = new HashMap<>();
    static Map<Integer, Integer> sizes = new HashMap<>();
    static ArrayList<HashSet<Integer>> list = new ArrayList<>();
    public int solution(int[][] land) {
        int answer = 0;
        row = land.length;
        col = land[0].length;
        visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(land[i][j] == 1 && !visited[i][j])
                    bfs(i, j, land);
            }
        }
        for(HashSet<Integer> set : map.values()){
            if(!list.contains(set)){
                int temp = 0;
                list.add(set);
                for(int n: set)
                    temp += sizes.get(n);
                answer = Math.max(answer, temp);
            }
        }
        return answer;
    }
    public void bfs(int i, int j, int[][] land){
        int size = 1;
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.offer(new int[]{i,j});
        while(!q.isEmpty()){
            int[] now = q.poll();
            map.computeIfAbsent(now[1], key -> new HashSet<>()).add(idx);
            for(int d = 0; d < 4; d++){
                int y = now[0] + directions[d][0];
                int x = now[1] + directions[d][1];
                if(y >= 0 && y < row && x >= 0 && x < col && land[y][x] == 1 && !visited[y][x]){
                    size++;
                    visited[y][x] = true;
                    q.offer(new int[]{y,x});
                }
            }
        }
        sizes.put(idx, size);
        idx++;
    }
}