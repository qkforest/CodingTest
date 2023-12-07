import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int[][] directions = {{-1, -1}, {-1, 0}};
        int temp = 0, answer = 0;
        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j < triangle[i].length; j++){
                temp = 0;
                for(int[] d : directions){
                    if(j+d[1] >= 0 && j+d[1] < triangle[i+d[0]].length)
                        temp = Math.max(temp, triangle[i][j] + triangle[i+d[0]][j+d[1]]);
                }
                triangle[i][j] = temp;
                if(answer < triangle[i][j])
                    answer =  triangle[i][j];
            }
        }
        return answer;
    }
}