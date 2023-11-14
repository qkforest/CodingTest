import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        int e = n%2==0 ? n/2 : n/2+1;
        for(int i = 0; i < e; i++){
            answer.add(2 * i + 1);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}