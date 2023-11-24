import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer, -1);
        Map<Character, Integer> idx = new HashMap<>();
        int i = 0;
        for(char c: s.toCharArray()){
            if(idx.containsKey(c)){
                answer[i] = i - idx.get(c);
                idx.put(c,i);
            } else
                idx.put(c, i);
            i++;
        }
        return answer;
    }
}