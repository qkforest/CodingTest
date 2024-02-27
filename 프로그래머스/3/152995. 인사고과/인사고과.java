import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int[] Wanho = scores[0];
        Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        int answer = 1;
        int maxScore = 0;
        int WanhoSum = Wanho[0] + Wanho[1];
        for(int[] score : scores){
            if(maxScore > score[1]){
                if(score.equals(Wanho))
                    return -1;
            }else{
                maxScore = score[1];
                if(score[0] + score[1] > WanhoSum)
                    answer++;
            }
        }
        return answer;
    }
}