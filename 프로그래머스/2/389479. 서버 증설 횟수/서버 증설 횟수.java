import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < 24; i++) {
            while(!q.isEmpty() && i + 1 - q.peek() > k) {
                q.poll();
            }
            int count = (players[i] - m * q.size()) / m;
            if(count > 0) {
                answer += count;
                for(int j = 0; j < count; j++){
                    q.offer(i);
                }
            }
        }
        return answer;
    }
}