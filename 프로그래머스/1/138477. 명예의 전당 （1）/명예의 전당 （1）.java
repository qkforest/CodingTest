
import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> rank = new ArrayList<>();
        for(int i = 0; i < score.length; i++){
            if(rank.size() < k)
                rank.add(score[i]);
            else {
                if(Collections.min(rank) < score[i]){
                    rank.remove(Collections.min(rank));
                    rank.add(score[i]);
                }
            }
            answer[i] = Collections.min(rank);
        }
        return answer;
    }
}