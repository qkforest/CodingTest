import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] b = new char[26];
        Map<Character, Integer> map = new HashMap<>();
        for(char c : before.toCharArray()) {
            b[c - 'a']++;
        }
        for(char c : after.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        for(Character c : map.keySet()) {
            if(b[c - 'a'] < map.get(c)) {
                return 0;
            }
        }
        return 1;
    }
}