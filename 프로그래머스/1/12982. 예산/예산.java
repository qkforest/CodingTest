import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int m: d){
            if(budget - m < 0)
                break;
            else {
                budget -= m;
                answer += 1;
            }
        }
        return answer;
    }
}