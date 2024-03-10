import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (o1, o2) -> (o1[1]==o2[1]) ? o1[0]-o2[0] : o1[1]-o2[1]);
        int x = targets[0][1]-1;
        for(int i = 1 ; i < targets.length; i++){
            if(x < targets[i][0]){
                answer++;
                x = targets[i][1] - 1;
            }
        }
        return answer;
    }
}