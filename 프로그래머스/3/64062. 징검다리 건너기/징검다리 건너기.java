import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int low = 1, high = 200000000, mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(!check(stones, k, mid)) high = mid - 1;
            else {
                low = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        return answer;
    }
    public static boolean check(int[] stones, int k, int mid) {
		int cnt = 0;
		for (int stone : stones) {
			if (stone - mid < 0) cnt++;
			else cnt = 0;
			if (cnt == k) return false;
		}
		return true; 
	}
}