class Solution {
    public int[] solution(int start_num, int end_num) {
        int c = start_num - end_num;
        int[] answer = new int[c+1];
        for(int i = 0; i <= c; i++){
            answer[i] = start_num - i;
        }
        return answer;
    }
}