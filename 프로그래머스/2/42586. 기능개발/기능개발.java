import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int count = 1;
        int time = (100 - progresses[0]) / speeds[0];
        time += ((100 - progresses[0]) % speeds[0] != 0) ? 1 : 0;
        for(int i = 1; i < speeds.length; i++) {
            int t = (100 - progresses[i]) / speeds[i];
            t += ((100 - progresses[i]) % speeds[i] != 0) ? 1 : 0;
            if(t <= time) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                time = t;
            }
        }
        if(count > 0) {
            answer.add(count);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}