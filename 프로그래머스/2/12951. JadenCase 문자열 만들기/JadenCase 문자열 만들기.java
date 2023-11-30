import java.util.regex.Pattern;
class Solution {
    public String solution(String s) {
        String answer = "";
        boolean first = true;
        for(char c: s.toCharArray()){
            if(first && Pattern.matches("^[a-zA-Z]*$", String.valueOf(c))){
                answer += Character.toUpperCase(c);
                first = false;
            }
            else if(c == ' '){
                answer += c;
                first = true;
             } else {
                answer += Character.toLowerCase(c);
                first = false;
            }
                
        }
        return answer;
    }
}