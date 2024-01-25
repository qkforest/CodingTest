import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int temp = 0, s = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < prices.length; i++){
            if(q.peek() != null){
                s = q.size();
                for(int j = 0; j < s; j++){
                    temp = q.poll();
                    if(prices[temp] <= prices[i]){
                        answer[temp] += 1;
                        q.offer(temp);
                    } else
                        answer[temp] += 1;
                }
            }
            q.offer(i);
        }
        return answer;
    }
}