import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, idx = 0, sum = 0, cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        while(true){
            if(q.size() >= bridge_length){
                int t = q.poll();
                if(t != 0){
                    sum -= t;
                    cnt++;
                }
            }
            if(q.size() <= bridge_length){
                if(sum + truck_weights[idx] <= weight){
                    q.offer(truck_weights[idx]);
                    sum += truck_weights[idx];
                    if(idx < truck_weights.length-1) idx++;
                } else 
                    q.offer(0);
            }
            answer++;
            if(cnt == truck_weights.length) break;
        }
        return answer;
    }
}