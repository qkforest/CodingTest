import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] a1 = {1, 2, 3, 4, 5}, a2 ={2, 1, 2, 3, 2, 4, 2, 5}, a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int s1 = 0, s2 = 0, s3 = 0; 
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == a1[i%5])
                s1++;
            if(answers[i] == a2[i%8])
                s2++;
            if(answers[i] == a3[i%10])
                s3++;
        }
        if(Math.max(Math.max(s1, s2), s3) == s1)
            answer.add(1);
        if(Math.max(Math.max(s1, s2), s3) == s2)
            answer.add(2);
        if(Math.max(Math.max(s1, s2), s3) == s3)
            answer.add(3);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}