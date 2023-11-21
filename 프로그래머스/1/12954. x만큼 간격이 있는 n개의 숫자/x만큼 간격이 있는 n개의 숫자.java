class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < n; i++)
            //System.out.println(answer[i]);
            answer[i] = x * (long)(i+1);
        return answer;
    }
}