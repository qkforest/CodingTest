import java.util.*;

class Solution {
    private Set<Integer> getNext(int node, Set<Integer> nodes, boolean[][] connect) {
        Set<Integer> nextNodes = new HashSet<>(nodes);
        nextNodes.remove(node);
        
        for(int next = 0; next < connect[node].length; next++) {
            if(connect[node][next]) {
                nextNodes.add(next);
            }
        }
        
        return nextNodes;
    }
    
    private int dfs(Set<Integer> nodes, int sheep, int wolf, int[] info, boolean[][] connect) {
        int maxSheep = sheep;
        for(int node : nodes) {
            int nextSheep = sheep;
            int nextWolf = wolf;
            if(info[node] == 0) {
                nextSheep++;
            } else {
                nextWolf++;
            }
            if(nextWolf >= nextSheep) {
                continue;
            }
            maxSheep = Math.max(dfs(getNext(node, nodes, connect), nextSheep, nextWolf, info, connect), maxSheep);
        }   
        return maxSheep;
    }
    public int solution(int[] info, int[][] edges) {
        boolean[][] connect = new boolean[info.length][info.length];
        
        for(int[] edge : edges) {
            connect[edge[0]][edge[1]] = true;
        }
        
        Set<Integer> nodes = new HashSet<>();
        nodes.add(0);
        
        return dfs(nodes, 0, 0, info, connect);
    }
}