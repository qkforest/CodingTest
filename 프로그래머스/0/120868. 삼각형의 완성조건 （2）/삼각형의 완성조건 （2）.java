import java.util.*;
class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        int answer = 0, s = sides[0],  b = sides[1];
        for(int i = 0; i <= b; i++){
            if(i + s > b)
                answer++;
        }
        for(int i = b+1; i < s+b; i++){
            if(s+b > i)
                answer++;
        }
        return answer;
    }
}