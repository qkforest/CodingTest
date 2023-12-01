class Solution {
    static int[] dp;
    public int fib(int n){
        if(n == 1 || n == 2) 
            return 1;
        if(dp[n] != 0)
            return dp[n] ;
        dp[n] = fib(n-1) % 1234567 + fib(n-2) % 1234567;
        return dp[n];
    }
    public int solution(int n) {
        dp  = new int[n+1];
        int answer = fib(n) % 1234567;
        return answer;
    }
}