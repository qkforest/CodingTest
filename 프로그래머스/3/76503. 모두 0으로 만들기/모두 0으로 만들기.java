import java.util.*;

class Solution {
    public static List<Integer>[] tree;
    public static long answer = 0;
    public static long[] weight;
    public static boolean[] visited;
    
    public static long dfs(int node) {
        visited[node] = true;
        
        for(int i = 0; i < tree[node].size(); i++) {
            int next = tree[node].get(i);
            if(!visited[next]) {
                weight[node] += dfs(next);
            }
        }
        
        answer += Math.abs(weight[node]);
        
        return weight[node];
    }
    
    public long solution(int[] a, int[][] edges) {
        int n = a.length;
        tree = new ArrayList[n];
        weight = new long[n];
        visited = new boolean[n];
        long sum = 0;
        
        
        for(int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
            weight[i] = a[i];
            sum += a[i];
        }
        
        if(sum != 0) {
             return -1;
        }
        
        for (int i = 0; i < n-1; i++) {
            tree[edges[i][0]].add(edges[i][1]);
            tree[edges[i][1]].add(edges[i][0]);
        }
        
        dfs(0);
        
        return answer;
    }
}