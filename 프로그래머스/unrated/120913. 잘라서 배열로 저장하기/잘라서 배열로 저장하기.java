import java.util.*;
class Solution {
    public String[] solution(String my_str, int n) {
        List<String> answer = new ArrayList<>();
        String temp = "";
        for(int i = 1; i < my_str.length()+1; i++){
            if(i % n == 0){
                temp += my_str.charAt(i-1);
                answer.add(temp);
                temp = "";
            }
            else
                temp += my_str.charAt(i-1);
        }
        if(!temp.equals(""))
            answer.add(temp);
        return answer.stream().toArray(String[]::new);
    }
}