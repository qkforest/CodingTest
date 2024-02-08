import java.util.*;
class Solution {
    public int solution(int storey) {
        if(storey < 10) return storey;
        String sto = String.valueOf(storey);
        int answer = 0, s0 = 0, s1 = 0, len = sto.length();
        int[] s = new int[len];
        for(int i = 0; i < len; i++) s[i] = sto.charAt(i) - '0';
        for(int i = s.length-1; i > 0; i--){
            if(s[i] > 5) {
                answer += (10-s[i]);
                s[i] = 10-s[i];
                s[i-1] += 1;
            }
            else {
                if(s[i] == 5){
                    if(s[i-1] < 5){
                        answer += s[i];
                    }else {
                        answer += (10-s[i]);
                        s[i] = 10-s[i];
                        s[i-1] += 1;
                    }
                }
                else answer += s[i];
            }
        }
        if(s[0] <= 5) answer += s[0];
        else {
            if(s[0] == 10) answer++;
            else {
                answer++;
                answer += (10-s[0]);
            }
        }
        return answer;
    }
}