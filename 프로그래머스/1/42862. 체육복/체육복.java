import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        PriorityQueue<Integer> lostQueue = new PriorityQueue<>();
        PriorityQueue<Integer> reserveQueue = new PriorityQueue<>();
        
        for(int r : reserve){
            reserveQueue.offer(r);
        }
        
        for(int i = 0; i < lost.length; i++) {
            if(reserveQueue.contains(lost[i])) {
                reserveQueue.remove(lost[i]);
                answer++;
                continue;
            }
            lostQueue.offer(lost[i]);
        }
        
        while(!lostQueue.isEmpty()) {
            int l = lostQueue.poll();
            while(!reserveQueue.isEmpty() && l - reserveQueue.peek() > 1) {
                reserveQueue.poll();
            }
            if(reserveQueue.isEmpty()) {
                break;
            }
            if(Math.abs(reserveQueue.peek() - l) <= 1) {
                reserveQueue.poll();
                answer++;
            }
        }
        
        return answer;
    }
}