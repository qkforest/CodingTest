import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            int count = 0;
            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    count += 1;
                    break;
                }
            }
            if(n % i == 0 && count == 0)
                answer.add(i);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}