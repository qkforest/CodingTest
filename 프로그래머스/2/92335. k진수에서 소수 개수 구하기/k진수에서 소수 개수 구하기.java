class Solution {
    private boolean isPrime(long n) {
        if(n == 1) {
            return false;
        }
        for(long i = 2; i <= (long)Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        String num = Integer.toString(n, k);
        String[] arr = num.split("0+");
        for(String p : arr) {
            if(isPrime(Long.parseLong(p))) {
                answer++;
            }
        }
        return answer;
    }
}