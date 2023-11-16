class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int c = 0;
        for(int i = 1; i < num; i++)
            c += i;
        int f = (total - c) / num;
        for(int i = 0; i < num; i++)
            answer[i] = f + i;
        return answer;
    }
}