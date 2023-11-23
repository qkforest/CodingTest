import java.util.*;
class Solution {
    public String solution(String s) {
        List <Character> upperCase = new ArrayList<>();
        List <Character> lowerCase = new ArrayList<>();
        String answer = "";
        for(char c : s.toCharArray()){
            if(Character.isUpperCase(c))
                upperCase.add(c);
            else
                lowerCase.add(c);
        }
        Collections.sort(lowerCase, Collections.reverseOrder());
        Collections.sort(upperCase, Collections.reverseOrder());
        for(char c : lowerCase){
            answer += c;
        }
        for(char c : upperCase){
            answer += c;
        }
        return answer;
    }
}