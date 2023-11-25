import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0, s = 0;
        boolean aval;
        String[] ba = {"aya", "ye", "woo", "ma"};
        for(String b : babbling){
            s = 0;
            String f = "";
            aval = false;
            for(int i = 1; i <= b.length(); i++){
                if(Arrays.asList(ba).contains(b.substring(s, i)) && !f.equals(b.substring(s, i))){
                    f = b.substring(s, i);
                    s = i;
                    if(i == b.length())
                        aval = true;
                }
                if(aval)
                    answer++;
            }
        }
        return answer;
    }
}