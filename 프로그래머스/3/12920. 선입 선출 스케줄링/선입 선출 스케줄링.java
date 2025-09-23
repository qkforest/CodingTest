class Solution {
    private boolean check(int n, int[] cores, int time) {
        int count = 0;
        for(int core : cores) {
            count += (time / core) + 1;
            if(count >= n) {
                return true;
            }
        }
        return false;
    }
    
    public int solution(int n, int[] cores) {
        if(n <= cores.length) {
            return n;
        }
        
        int left = 1;
        int right = (50000 - 2) / 2 * 10000;
        int time = 0;
        
        while(left <= right) {
            int mid = (left +  right) / 2;
            if(check(n, cores, mid)) {
                time = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        int count = n - cores.length;
        for(int i = 0; i < cores.length; i++) {
            count -= (time - 1) / cores[i];
        }
    
        for(int i = 0; i < cores.length; i++) {
            if(time % cores[i] == 0) {
                count--;
            }
            if(count == 0) {
                return i + 1;
            }
        }
        
        return 0;
    }
}