import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 1; i < n / k + 1; i++){
            answer.add(k * i);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}