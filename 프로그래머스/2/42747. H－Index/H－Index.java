import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        for(int h = n; h >= 0; h--) {
            int c = 0;
            for(int i = n-1; i >= 0; i--) {
                if(citations[i] >= h) {
                    c++;
                } else {
                    break;
                }
            }
            if(c >= h) {
                return h;
            }
        }
        return 0;
    }
}