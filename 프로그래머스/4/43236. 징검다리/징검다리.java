import java.util.*;

class Solution {
    private boolean isVaild(int d, int[] rocks, int n) {
        int last = 0;
        int count = 0;
        
        for(int r : rocks) {
            if(r - last < d) {
                count++;
                continue;
            }
            last = r;
        }
        
        return count <= n;
    }
    public int solution(int distance, int[] rocks, int n) {
        rocks = Arrays.copyOf(rocks, rocks.length+1);
        rocks[rocks.length-1] = distance;
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance + 1;

        while(right - left > 1) {
            int mid = (left + right) / 2;
            if(isVaild(mid, rocks, n)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}