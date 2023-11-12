import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] num_list, int n) {
        int answer = 0;
        if(Arrays.stream(num_list).boxed().collect(Collectors.toList()).contains(n))
            answer = 1;
        return answer;
    }
}