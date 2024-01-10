import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int f = 0, s = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int n : scoville)
            queue.add(n);
        while(true){
            f = queue.poll();
            if(f >= K) break;
            else{
                if(queue.isEmpty()){
                    answer = -1;
                    break;
                }
                s = queue.poll();
                queue.offer(f+s*2);
                answer++;
            }
        }
        return answer;
    }
}