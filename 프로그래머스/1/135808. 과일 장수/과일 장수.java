import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0, count = 0;
        int[] box = new int[m];
        while(k > 0){
            for(int i = 0; i < score.length; i++){
                if(score[i] >= k){
                    box[count] = i;
                    count++;
                }
                if(count == m){
                    for(int j = 0; j < m; j++)
                        score[box[j]] = 0;
                    answer += m * k;
                    count = 0;
                }
            }
            k--;
            count = 0;
            Arrays.fill(box, 0);
        }
        return answer;
    }
}