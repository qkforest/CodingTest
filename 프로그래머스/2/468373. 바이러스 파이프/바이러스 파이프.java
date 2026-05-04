import java.util.*;

class Solution {
    public int answer, len, inf, N;
    public List<Integer>[][] map;
    public int[] temp;
    
    public void dfs(int depth) {
        if(depth == len) {
            boolean[][] visited = new boolean[N+1][4];
            List<Integer> nodes = new ArrayList<>();
            nodes.add(inf);
            visited[inf][0] = true;
            
            for(int i = 0; i < len; i++) {
                int size = nodes.size();
                
                for(int j = 0; j < size; j++) {
                    for(int n : map[nodes.get(j)][temp[i]]) {
                        if(!visited[n][0]){
                            visited[n][0] = true;
                            nodes.add(n);
                        }
                        if(visited[n][temp[i]]) {
                            continue;
                        }
                        visited[n][temp[i]] = true;
                        Queue<Integer> next = new LinkedList<>();
                        for(int next2 : map[n][temp[i]]) {
                            if(!visited[next2][temp[i]]) {
                                visited[next2][temp[i]] = true;
                                next.offer(next2);
                            }
                        }
                        while(!next.isEmpty()) {
                            int n2 = next.poll();
                            if(!visited[n2][0]){
                                visited[n2][0] = true;
                                nodes.add(n2);
                            }
                            for(int n3 : map[n2][temp[i]]) {
                                if(!visited[n3][temp[i]]) {
                                    visited[n3][temp[i]] = true;
                                    next.offer(n3);
                                }
                            }
                        }
                    }
                }
            }
            answer = Math.max(answer, nodes.size());
            return;
        }
        
        for(int i = 1; i <= 3; i++) {
            if(depth > 0 && temp[depth-1] == i) {
                continue;
            }
            temp[depth] = i;
            dfs(depth+1);
        }
    }
    
    public int solution(int n, int infection, int[][] edges, int k) {
        answer = 0;
        N = n;
        len = k;
        inf = infection;
        map = new ArrayList[n+1][4];
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j < 4; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        
        for(int[] e : edges) {
            map[e[0]][e[2]].add(e[1]);
            map[e[1]][e[2]].add(e[0]);
        }
        
        temp = new int[k];
        dfs(0);
        
        return answer;
    }
}