import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        List<Character> re = new ArrayList<>();
        for(char c: my_string.toCharArray()){
            if(re.contains(c))
                continue;
            else{
                re.add(c);
                answer += c;
            }
                
        }
        return answer;
    }
}