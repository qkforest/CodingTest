class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = 1000000000 * (long)n;
        while(left <= right) {
            long mid = (left + right) / 2;
            if(count(mid, times) >= n) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    public long count(long totalTime, int[] times) {
        long count = 0;
        for(int time : times) {
            count += totalTime/(long)time;
        }
        return count;
    }
}