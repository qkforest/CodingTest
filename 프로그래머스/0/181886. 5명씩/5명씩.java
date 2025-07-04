import java.util.*;
class Solution {
    public String[] solution(String[] names) {
        List<String> answer = new ArrayList<>();
        if(names.length % 5 != 0){
            for(int i = 0; i <= names.length/5; i++)
                answer.add(names[5*i]);
        } else {
            for(int i = 0; i < names.length/5; i++)
                answer.add(names[5*i]);
        }
        return answer.stream().toArray(String[]::new);
    }
}