import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = sequence.length-1; i >= 0; i--){
            if(sum == k && sequence[q.peek()] != sequence[i]) break;
            if(sum + sequence[i] <= k){
                sum += sequence[i];
                q.offer(i);
            } else{
                if(!q.isEmpty()){
                    sum -= sequence[q.poll()];
                    sum += sequence[i];
                    q.offer(i);
                }
            }
        }
        if(q.size() == 1){
            int ans = q.poll();
            answer[0] = ans;
            answer[1] = ans;
        } else {
            answer[1] = q.poll();
            while(!q.isEmpty()) answer[0] = q.poll();
        }
        return answer;
    }
}