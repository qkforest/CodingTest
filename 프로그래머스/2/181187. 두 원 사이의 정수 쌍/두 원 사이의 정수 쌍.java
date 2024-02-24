import java.util.*;
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long r1x = (long)r1*r1;
        long r2x = (long)r2*r2;
        double y1, y2;
        for(int i = 0; i < r2; i++){
            y2 = Math.floor(Math.sqrt(r2x - (long)i*i));
            if(i >= r1)
                y1 = 1;
            else
                y1 = Math.ceil(Math.sqrt(r1x - (long)i*i));
            if(y1 == 0)
                y1++;
            answer += y2 - y1 + 1;
        }
        return answer*4;
    }
}