import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        int answer = 0, x = dots[0][0], y = dots[0][1];
        for(int i = 1; i < dots.length; i++){
            if(x != dots[i][0]){
                if(answer == 0)
                    answer = Math.abs(dots[i][0] - x);
                else{
                    answer *= Math.abs(dots[i][0] - x);
                    break;
                }
            }
            if(y != dots[i][1]){
                if(answer == 0)
                    answer = Math.abs(dots[i][1] - y);
                else{
                    answer *= Math.abs(dots[i][1] - y);
                    break;
                }
            }
        }
        return answer;
    }
}