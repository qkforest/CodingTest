class Solution {
    public int solution(int[] money) {
        int len = money.length;
        long[] dp1 = new long[len];
        long[] dp2 = new long[len];
        dp1[1] = money[0];
        dp2[1] = money[1];
         for(int i = 2; i < len; i++) {
            dp1[i] = Math.max(dp1[i-2] + money[i-1], dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2] + money[i], dp2[i-1]);
        }
        int answer = (int)(Math.max(dp1[len-1], dp2[len-1]));
        return answer;
    }
}