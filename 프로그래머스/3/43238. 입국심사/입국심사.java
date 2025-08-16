class Solution {
    private long count(long time, int n, int[] times) {
        long cnt = 0;
        for(int t : times) {
            if(cnt >= n) {
                break;
            }
            cnt += time / (long)t;
        }
        return cnt;
    }
    public long solution(int n, int[] times) {
        long answer = times[times.length-1] * (long) n;
        long left = 1;
        long right = answer;
        while(left <= right) {
            long mid = (left + right) / (long)2;
            if(count(mid, n, times) >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}