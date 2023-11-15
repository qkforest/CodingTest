import java.util.*;
class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int x = 0, c = 0;
        String[] sp = polynomial.split("\\+");
        for(String s : sp){
            s = s.trim();
            if(s.contains("x"))
                x += s.equals("x") ? 1 : Integer.parseInt(s.substring(0, s.indexOf("x")));
            else
                c += Integer.parseInt(s);
        }
        if(x > 0 && c > 0)
            answer = x == 1 ? "x + " + String.valueOf(c) : String.valueOf(x) + "x + " + String.valueOf(c);
        else if(x > 0 && c == 0)
            answer = x == 1 ? "x" : String.valueOf(x) + "x";
        else if(x == 0 && c == 0)
            answer = "0";
        else
            answer = String.valueOf(c);
        return answer;
    }
}