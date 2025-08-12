import java.util.*;
class Solution {
    private int n;
    private boolean count(int h, int[] citations) {
        int c = 0;
        while(c < n && citations[n-c-1] >= h) {
            c++;
        }
        if(c >= h) {
            return true;   
        }
        return false;
    }
    
    public int solution(int[] citations) {
        n = citations.length;
        int answer = 0;
        int left = 0;
        int right = n;
        Arrays.sort(citations);
        while(left <= right) {
            int mid = (left + right) / 2;
            if(count(mid, citations)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}