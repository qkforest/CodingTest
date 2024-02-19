import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < enemy.length; i++){
            n -= enemy[i];
            q.offer(enemy[i]);
            while(n < 0 && k > 0){
                k--;
                n += q.poll();
            }
            if(k == 0 && n < 0) break;
            answer = i+1;
        }
        return answer;
    }
}