import java.util.*;

class Solution {
    private static int[] parents;
    
    private int find(int a) {
        if(parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }
    
    private boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        
        if(parentA == parentB) {
            return false;
        }
        
        if(parentA < parentB) {
            parents[parentB] = parentA;
        } else {
            parents[parentA] = parentB;
        }
        
        return true;
    }
    public int solution(int n, int[][] costs) {
        parents = new int[n];
        for(int i = 1; i < n; i++) {
            parents[i] = i;
        }
        
        int answer = 0;
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        for(int i = 0; i < costs.length; i++) {
            if(union(costs[i][0], costs[i][1])) {
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
}