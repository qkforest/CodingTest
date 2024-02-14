import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] node = new int[n];
        for(int i = 0; i < n; i++){
            node[i] = i;
        }
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        for(int i = 0; i < costs.length; i++){
            if(head(node, costs[i][0]) != head(node, costs[i][1])){
                construct(node, costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        return answer;
    }
    public int head(int[] node, int h){
        if(node[h] == h) 
            return h;
        return 
            head(node, node[h]);
    }
    public void construct(int[] node, int n1, int n2){
        int first = head(node, n1);
        int second = head(node, n2);
        node[first] = second;
    }
}