class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int s = a >= b ? b : a, e = a < b ? b : a;
        for(int i = s; i < e+1; i++)
            answer += i;
        return answer;
    }
}