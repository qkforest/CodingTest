import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 1;
        int right = distance;
        Arrays.sort(rocks);
        while(left <= right) {
            int mid = (left + right) / 2;
            if(removeRocks(rocks, mid, distance) <= n) {
                answer = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return answer;
    }
    public int removeRocks(int[] rocks, int d, int end) {
        int count = 0;
        int previous = 0;
        for(int i = 0; i < rocks.length; i++) {
            if(rocks[i] - previous < d) {
                count++;
            }
            else {
                previous = rocks[i];
            }
        }
        if(end - previous < d) {
            count++;
        }
        return count;
    }
}