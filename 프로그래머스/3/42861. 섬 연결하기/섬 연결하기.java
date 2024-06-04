import java.util.*;
class Solution {
    public int[] parents;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        for(int i = 0; i < costs.length; i++) {
            if(union(costs[i][0], costs[i][1])){
                answer += costs[i][2];
            }
        }
        return answer;
    }
    public boolean union(int a, int b){
        int aParent = find(a);
        int bParent = find(b);
        if(aParent == bParent) {
            return false;
        }
        if(aParent < bParent) {
            parents[bParent] = aParent;
        } 
        else {
            parents[aParent] = bParent;
        }
        return true;
    }
    public int find(int n) {
        if(parents[n] == n) {
            return n;
        }
        return parents[n] = find(parents[n]);
    }
}