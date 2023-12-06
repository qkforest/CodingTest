import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++)
            progresses[i] = (int)Math.ceil((100 - progresses[i])/(float)speeds[i]);
        int count = 1, day = progresses[0];
        for(int i = 1; i < progresses.length; i++){
            if(progresses[i] <= day)
                count++;
            else{
                answer.add(count);
                day = progresses[i];
                count = 1;
            }
        }
        if(count > 0)
            answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}