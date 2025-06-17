class Solution {
    public int n;
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int low = 1;
        int high = 100000;
        n = diffs.length;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(check(mid, diffs, times, limit)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
    public boolean check(int level, int[] diffs, int[] times, long limit) {
        long time = 0;
        for(int i = 0; i < n; i++) {
            if(level >= diffs[i]) {
                time += times[i];
            } else {
                time += (diffs[i] - level) * (times[i] + times[i-1]) + times[i];
            }
            if(time > limit) {
                return false;
            }
        }
        return true;
    }
}