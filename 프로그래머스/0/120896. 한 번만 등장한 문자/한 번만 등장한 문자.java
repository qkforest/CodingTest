import java.util.*;
class Solution {
    public String solution(String s) {
        SortedMap<Character, Integer> map = new TreeMap<>();
        String answer = "";
        for(char c : s.toCharArray()){
            if(map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }
        for(Character c : map.keySet()){
            if(map.get(c) == 1)
                answer += c;
        }
        return answer;
    }
}