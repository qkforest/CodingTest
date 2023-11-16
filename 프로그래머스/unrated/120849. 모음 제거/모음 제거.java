import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        List<Character> v = Arrays.asList(new Character[] {'a', 'e', 'i', 'o', 'u'});
        for(Character c : my_string.toCharArray()){
            if(!v.contains(c))
                answer += String.valueOf(c);
        }
        return answer;
    }
}