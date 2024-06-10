import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        String s = String.valueOf(N);
        Set<Integer>[] dp = new HashSet[8];
        for(int i = 0; i < 8; i++) {
            dp[i] = new HashSet<>();
            dp[i].add(Integer.parseInt(s.repeat(i+1)));
            for(int j = 0; j < i; j++) {
                for(int a : dp[j]){
                    for(int b : dp[i - j - 1]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if(b != 0) {
                            dp[i].add(a / b);
                        }
                    }
                }
            }
            if(dp[i].contains(number)) {
                return i+1;
            }
        }
        return -1;
    }
}