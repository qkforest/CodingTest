import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {};
        int len = num_list.length;
        answer = Arrays.copyOf(num_list, len+1);
        if (num_list[len-1] > num_list[len-2])
            answer[len] = num_list[len-1] - num_list[len-2];
        else
            answer[len] = 2 * num_list[len-1];
            
        return answer;
    }
}