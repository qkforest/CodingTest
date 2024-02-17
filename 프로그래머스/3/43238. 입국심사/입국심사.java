import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 1, low = 1, high = times[times.length-1] * (long)n;
        while(low <= high){
            long mid = (low + high) / 2;
            if(!check(times, n, mid)) {
                high = mid - 1;
                answer = mid;
            }
            else 
                low = mid + 1;
        }
        return answer;
    }
     public static boolean check(int[] times, int n, long mid) {
		long ppl = 0;
		for (int time : times) {
			ppl += mid/(long)time;
            if(ppl >= n) 
                return false;
		}
		return true; 
	}
}