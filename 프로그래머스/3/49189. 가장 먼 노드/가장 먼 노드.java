import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0, max = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] cost = new int[n+1];
        Arrays.fill(cost, 20000);
        cost[1] = 0;
        q.add(1);
        while(!q.isEmpty()){
            int s = q.poll();
            for(int i = 0; i < edge.length; i++){
                if(edge[i][0] == s){
                    if(cost[edge[i][1]] > cost[s] + 1){
                        cost[edge[i][1]] = cost[s] + 1;  
                        q.add(edge[i][1]);
                    }
                } else if(edge[i][1] == s){
                    if(cost[edge[i][0]] > cost[s] + 1){
                        cost[edge[i][0]] = cost[s] + 1;  
                        q.add(edge[i][0]);
                    }
                }
            }
        }
        for(int i = 2; i <= n; i++){
            if(cost[i] > max) {
                max = cost[i];
                answer = 1;
            } 
            else if(cost[i] == max) {
                answer += 1;
            } 
        }
        return answer;
    }
}