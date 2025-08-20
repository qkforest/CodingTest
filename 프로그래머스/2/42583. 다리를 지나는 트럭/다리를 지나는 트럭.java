import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int idx = 0;
        int sum = 0;
        Queue<int[]> q = new LinkedList<>();
        while(idx < truck_weights.length) {
            while(idx < truck_weights.length && q.size() < bridge_length && sum + truck_weights[idx] <= weight) {
                q.offer(new int[] {answer, truck_weights[idx]});
                sum += truck_weights[idx++];
                answer++;
            }
            if(idx >= truck_weights.length) {
                break;
            }
            while(!q.isEmpty() && (q.size() == bridge_length || sum + truck_weights[idx] > weight)) {
                int[] now = q.poll();
                sum -= now[1];
                answer = Math.max(answer, bridge_length + now[0]);
            }
        }
        while(!q.isEmpty()) {
            int[] now = q.poll();
            sum -= now[1];
            answer = bridge_length + now[0];
        }
        return answer;
    }
}