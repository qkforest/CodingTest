import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < A.length; i++){
            a.add(A[i]);
            b.add(B[i]);
        }
         for(int i = 0; i < A.length; i++){
             int t1 = a.poll();
             int t2 = b.poll();
             if(t2 > t1) answer++;
             else b.add(t2);
         }
        return answer;
    }
}