import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < picture.length; i++){
            String temp = "";
            for(char s: picture[i].toCharArray())
                temp += String.valueOf(s).repeat(k);
            for(int j = 0; j < k; j++)
                answer.add(temp);
        }
        return answer.toArray(new String[answer.size()]);
    }
}