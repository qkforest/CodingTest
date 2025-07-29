import java.util.*;

class Solution {
    private List<String> split(String s, int len) {
        List<String> tokens = new ArrayList<>();
        for(int i = 0; i < s.length(); i += len) {
            int end = Math.min(s.length(), i+len);
            tokens.add(s.substring(i, end));
        }
        return tokens;
    }
    private int compressed(String s, int len) {
        StringBuilder sb = new StringBuilder();
        String last = "";
        int c = 0;
        for(String token : split(s, len)) {
            if(token.equals(last)) {
                c++;
            } else {
                if(c > 1) {
                    sb.append(c);
                }
                sb.append(last);
                last = token;
                c = 1;
            }
        }
        if(c > 1) {
            sb.append(c);
        }
        sb.append(last);
        return sb.length();
    }
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= s.length(); i++) {
            answer = Math.min(compressed(s, i), answer);
        }
        return answer;
    }
}