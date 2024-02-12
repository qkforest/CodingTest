import java.util.*;
class Solution {
    public int[][] cost;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        cost = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
             for(int j = 1; j <= N; j++){
                 if(i == j) cost[i][j] = 0;
                 else cost[i][j] = 1000000;
             }
        }
        
        for(int i = 0; i < road.length; i++){
            if(cost[road[i][0]][road[i][1]] == 1000000) cost[road[i][0]][road[i][1]] = road[i][2];
            else {
                if(cost[road[i][0]][road[i][1]] > road[i][2]) cost[road[i][0]][road[i][1]] = road[i][2];
            }
            if(cost[road[i][1]][road[i][0]] == 1000000) cost[road[i][1]][road[i][0]] = road[i][2];
            else {
                if(cost[road[i][1]][road[i][0]] > road[i][2]) cost[road[i][1]][road[i][0]] = road[i][2];
            }  
        }
        
        for(int k = 1; k <= N; k++){
			for(int i = 1; i <= N; i++){
				for(int j = 1; j <= N; j++) cost[i][j] = Math.min(cost[i][j], cost[i][k]+cost[k][j]);
			}
		}
        for(int j = 1; j <= N; j++){
            if(cost[1][j] <= K) answer++;
        }
        return answer;
    }
}