import java.util.*;
class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        Map<Character, Integer> be = new HashMap<>();
        Map<Character, Integer> af = new HashMap<>();
        for(char c: before.toCharArray()){
            if(be.containsKey(c))
                be.put(c, be.get(c)+1);
            else
                be.put(c, 1);
        }
        for(char c: after.toCharArray()){
            if(af.containsKey(c))
                af.put(c, af.get(c)+1);
            else
                af.put(c, 1);
        }
        for(Character c: be.keySet()){
            if(be.get(c) != af.get(c)){
                answer = 0;
                break;
            }
        }
        return answer;
    }
}