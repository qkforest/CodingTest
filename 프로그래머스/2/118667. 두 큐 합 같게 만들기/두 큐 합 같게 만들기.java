import java.util.*;
class Solution {
    public long solution(int[] queue1, int[] queue2) {
        long answer = 0, sum = 0, sum1 = 0, sum2 = 0, t = 0;
        Queue<Long> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        for(int i = 0; i < queue1.length; i++){
            q1.offer(Long.valueOf(queue1[i]));
            sum1 += Long.valueOf(queue1[i]);
            q2.offer(Long.valueOf(queue2[i]));
            sum2 += Long.valueOf(queue2[i]);
        }
        sum = (sum1 + sum2) / 2;
        while(sum1 != sum){
            if(q1.size() == 0 || q2.size() == 0 || answer >= queue1.length*4) {
                answer = -1;
                break;
            }
            if(sum1 > sum2){
                t = q1.poll();
                q2.offer(t);
                sum2 += t;
                sum1 -= t;
                answer++;
            } else {
                t = q2.poll();
                q1.offer(t);
                sum1 += t;
                sum2 -= t;
                answer++;
            }
        }
        return answer;
    }
}