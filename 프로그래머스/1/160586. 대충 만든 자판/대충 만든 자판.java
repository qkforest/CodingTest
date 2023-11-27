import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> key = new HashMap<>();
        for(String s : keymap){
            for(int i = 0; i < s.length(); i++){
                if(key.containsKey(s.charAt(i))){
                    if(key.get(s.charAt(i)) > i)
                        key.put(s.charAt(i), i);
                } else {
                    key.put(s.charAt(i), i);
                }
            }
        }
        for(int i = 0; i < answer.length; i++){
             for(char s : targets[i].toCharArray()){
                  if(key.containsKey(s)){
                      answer[i] += key.get(s)+1;
                    
                  } else {
                        answer[i] = -1;
                        break;
                    }
             }
        }
        return answer;
    }
}