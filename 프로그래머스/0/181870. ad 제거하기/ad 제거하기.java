import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> answer = new ArrayList<>();
        for(String s : strArr){
            if(!s.contains("ad"))
                answer.add(s);
        }
        return answer.stream().toArray(String[] :: new);
    }
}