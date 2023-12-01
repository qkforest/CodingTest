class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int w = 1, h = yellow/w;
        for(int i = 1; i <= yellow; i++){
            w = i; 
            if(yellow % w != 0)
                continue;
            else {
                h = yellow/w;
                if(2 * (w+h) + 4 == brown)
                    break;
            }
        }
        answer[0] = h+2;
        answer[1] = w+2;
        return answer;
    }
}