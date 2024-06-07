import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for(int level = 1; level < triangle.length; level++){
            for(int idx = 0; idx < triangle[level].length; idx++){
                int left = 0;
                int right = 0;
                if(idx-1 >= 0) {
                    left = triangle[level-1][idx-1];
                }
                if(idx < triangle[level-1].length){
                     right = triangle[level-1][idx];
                }
                triangle[level][idx] += Math.max(left, right);
                answer = Math.max(answer, triangle[level][idx]);
            }
        }
        return answer;
    }
}