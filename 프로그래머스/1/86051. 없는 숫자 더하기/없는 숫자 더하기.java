import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        Integer[] all = new Integer[] {1,2,3,4,5,6,7,8,9,0};
        for(int n : numbers){
            if(Arrays.asList(all).contains(n))
                answer -= n;
        }
        return answer;
    }
}