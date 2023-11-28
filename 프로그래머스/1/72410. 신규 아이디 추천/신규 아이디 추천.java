import java.util.regex.Pattern;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        for(char c : new_id.toCharArray()){
            if(Pattern.matches("^[a-z|A-Z]*$", String.valueOf(c)))
                answer += Character.toLowerCase(c);
            else if(Pattern.matches("^[0-9]*$", String.valueOf(c)))
                answer += c - '0';
            else if(c == '-' || c == '_' || c == '.'){
                if(c == '.'){
                    if(answer.length() > 0){
                        if(answer.charAt(answer.length()-1) != '.')
                            answer += c;
                    } 
                } else
                    answer += c;
            }
        }
        if(answer.length() > 0){
            if(answer.charAt(answer.length() - 1) == '.')
                answer = answer.substring(0, answer.length()-1);
        }
        if(answer.length() > 0){
            if(answer.charAt(0) == '.')
                answer = answer.substring(1, answer.length());
        }
        if(answer.length() == 0)
            answer = "a";
        if(answer.length() > 15){
            if(answer.charAt(14) == '.')
                answer = answer.substring(0, 14);
            else
                answer = answer.substring(0, 15);
        } else if(answer.length() == 1)
            answer = answer.repeat(3);
        else if(answer.length() == 2)
            answer = answer + String.valueOf(answer.charAt(1));
        return answer;
    }
}