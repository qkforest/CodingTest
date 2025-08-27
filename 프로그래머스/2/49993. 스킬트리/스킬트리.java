import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i+1);
        }
        for(String s : skill_trees) {
            int now = 1;
            boolean isVaild = true;
            for(char c : s.toCharArray()) {
                if(!map.containsKey(c)) {
                    continue;
                }
                if(now < map.get(c)) {
                    isVaild = false;
                    break;
                } else {
                    now++;
                }
            }
            if(isVaild) {
                answer++;
            }
        }
        return answer;
    }
}