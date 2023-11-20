import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        int[] sum = new int[score.length];
        TreeSet<Integer> scores = new TreeSet<>();
        for(int i = 0; i < score.length; i++){
            scores.add(score[i][0] + score[i][1]);
            sum[i] = score[i][0] + score[i][1];
        }
        int r = 1;
        for(Integer s : (TreeSet<Integer>)scores.descendingSet()){
            int count = 0;
            for(int i = 0; i < answer.length; i++){
                if(sum[i] == s){
                    answer[i] = r;
                    count++;
                }
            }
            r += count;
        }
        return answer;
    }
}