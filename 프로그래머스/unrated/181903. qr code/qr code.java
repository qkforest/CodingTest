import java.util.*;

class Solution {
    public String solution(int q, int r, String code) {
        String answer = "";
        ArrayList<Integer> idx = new ArrayList<>();
        for(int i = 0; i < code.length(); i++){
            if(i % q == r)
                idx.add(i);
        }
        for(int i : idx){
            answer += code.charAt(i);
        }
        return answer;
    }
}