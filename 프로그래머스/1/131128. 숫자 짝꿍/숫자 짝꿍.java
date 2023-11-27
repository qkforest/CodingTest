import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] Xarr = new int[10], Yarr = new int[10];
        int idx, count;
        boolean zero = true;
        for(int i = 0; i < X.length(); i++){
            idx = X.charAt(i) - '0';
            Xarr[idx] += 1;
        }
        for(int i = 0; i < Y.length(); i++){
            idx = Y.charAt(i) - '0';
            Yarr[idx] += 1;
        }
        for(int i = 9; i >= 0; i--){
            if(i == 0 && answer.equals("")){
                count = Math.min(Xarr[i], Yarr[i]);
                if(count > 0)
                    answer = "0";
                else
                    answer = "-1";
            } else {
                count = Math.min(Xarr[i], Yarr[i]);
                if(count > 0)
                    answer += String.valueOf(i).repeat(count);
            }
        }
        return answer;
    }
}