import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < len; i++) {
            while(!pq.isEmpty() && (pq.peek()[0] > prices[i] || i == len-1)) {
                int[] pre = pq.poll();
                answer[pre[1]] = i - pre[1];
            }
            pq.offer(new int[] {prices[i] , i});
        }
        return answer;
    }
}