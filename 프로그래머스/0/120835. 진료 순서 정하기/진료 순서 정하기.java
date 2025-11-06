import java.util.*;
class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        Integer[] emer = Arrays.stream(emergency).boxed().toArray(Integer[]::new);
        Arrays.sort(emer, Collections.reverseOrder());
        for(int i = 0; i < emergency.length; i++){
            for(int j = 0; j < emer.length; j++){
                if(emergency[i] == emer[j])
                    answer[i] = j+1;
            }
        }
        return answer;
    }
}