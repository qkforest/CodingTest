import java.util.*;
class Solution {
    private final int[] first = {1, 2, 3, 4, 5};
    private final int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    private final int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        for(int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            int f = first[i % first.length];
            int s = second[i % second.length];
            int t = third[i % third.length];
            score1 += answer==f ? 1 : 0;
            score2 += answer==s ? 1 : 0;
            score3 += answer==t ? 1 : 0;
        }
        int max = Math.max(score1, Math.max(score2, score3));
        List<Integer> answer = new ArrayList<>();
        if(score1 == max) {
            answer.add(1);
        }
        if(score2 == max) {
            answer.add(2);
        }
        if(score3 == max) {
            answer.add(3);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}