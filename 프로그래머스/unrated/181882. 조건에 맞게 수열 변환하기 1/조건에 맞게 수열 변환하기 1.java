import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<Integer>();
        for(int n : arr){
            if(n >= 50 && n % 2 == 0)
                answer.add(n/2);
            else if (n < 50 && n % 2 != 0)
                answer.add(n*2);
            else
                answer.add(n);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}