import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> sum = new HashSet<>();
        for(int i = 1; i <= elements.length; i++){
            for(int j = 0; j < elements.length; j++){
                for(int k = j; k < j + i; k++){
                    answer += elements[k%elements.length];
                }
                sum.add(answer);
                answer = 0;
            }
        }
        return sum.size();
    }
}