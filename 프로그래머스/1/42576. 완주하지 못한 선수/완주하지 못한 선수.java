import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String p : participant) {
            map.merge(p, 1, Integer::sum);
        }
        for(String c : completion) {
            if(map.merge(c, -1, Integer::sum) == 0) {
                map.remove(c);
            }
        }
        String answer = "";
        for(String n : map.keySet()) {
            answer = n;
        }
        return answer;
    }
}