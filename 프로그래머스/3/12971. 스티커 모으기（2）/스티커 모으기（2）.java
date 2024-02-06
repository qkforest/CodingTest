import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        if(sticker.length == 1) return sticker[0];
        if(sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        int[] dp1 = new int[sticker.length];
        dp1[0] = sticker[0]; dp1[1] = sticker[0];
        int max1 = 0, max2 = 0;
        for(int i = 2; i < sticker.length-1; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+sticker[i]);
            if(dp1[i] > max1) max1 = dp1[i];
        }
        int[] dp2 = new int[sticker.length];
        dp2[1] = 0; dp2[1] = sticker[1];
        for(int i = 2; i < sticker.length; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+sticker[i]);
            if(dp2[i] > max2) max2 = dp2[i];
        }
        return Math.max(max1, max2);
    }
}