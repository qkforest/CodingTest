import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] temp = myStr.split("a|b|c");
        List<String> answer = new ArrayList<>();
        if(temp.length < 1)
            return new String[] {"EMPTY"};
        else {
            for(String s : temp){
                if(!s.equals(""))
                    answer.add(s);
                }      
            return answer.stream().toArray(String[] :: new);
        }
    }
}