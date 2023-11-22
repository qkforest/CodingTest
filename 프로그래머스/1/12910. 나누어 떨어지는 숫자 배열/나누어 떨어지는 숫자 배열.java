import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        for(int n : arr){
            if(n % divisor == 0)
                answer.add(n);
        }
        Collections.sort(answer);
        return answer.size() > 0 ? answer.stream().mapToInt(Integer::intValue).toArray() : new int[]{-1};
    }
}