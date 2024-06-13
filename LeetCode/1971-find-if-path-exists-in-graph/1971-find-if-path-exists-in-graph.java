import java.util.*;
class Solution {
    public boolean[] visited;
    public Map<Integer, List<Integer>> map;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        visited = new boolean[n];
        map = new HashMap<>();
        for(int[] edge : edges) {
            map.computeIfAbsent(edge[0], k-> new ArrayList<Integer>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k-> new ArrayList<Integer>()).add(edge[0]);
        }
        return bfs(n, edges, source, destination);
    }
    public boolean bfs(int n, int[][] edges, int source, int destination) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = true;
        while(!q.isEmpty()) {
            int now = q.poll();
            if(now == destination) {
                return true;
            }
            for(int vertex : map.get(now)) {
                if(!visited[vertex]){
                    q.offer(vertex);
                    visited[vertex] = true;
                }
            }
        }
        return false;
    }
}