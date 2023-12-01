import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0, pos = n;
        while(pos > 0){
            if(pos  % 2 == 0)
                pos /= 2;
            else{
                pos -= 1;
                ans++;
            }
        }
        return ans;
    }
}