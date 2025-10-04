import java.util.*;
class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.split("x");
        List<String> temp = new ArrayList<>();
        for(String s : answer){
            if(!s.equals(""))
                temp.add(s);
        }
        answer = temp.stream().toArray(String[] :: new);
        Arrays.sort(answer);
        return answer;
    }
}