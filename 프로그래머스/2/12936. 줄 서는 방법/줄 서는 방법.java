import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> elements = new ArrayList<>();
        int idx = 0;
        long factorial = 1;
        for(int i = 1; i <= n; i++) {
            elements.add(i);
            factorial *= i;
        }
        k--;
        while(idx < n){
            factorial /= n - idx;
            answer[idx++] = elements.remove((int) (k / factorial));
            k %= factorial;
        }
        return answer;
    }
}