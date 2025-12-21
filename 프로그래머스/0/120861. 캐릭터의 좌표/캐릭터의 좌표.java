class Solution {
    public int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0, 0};
        for(String input : keyinput){
            switch(input){
                case "up":
                    if(answer[1] < (board[1]-1)/2)
                        answer[1] += direction[0][1];
                    break;
                 case "down":
                    if(answer[1] > (-1) * (board[1]-1)/2)
                        answer[1] += direction[1][1];
                    break;
                 case "left":
                    if(answer[0] > (-1) * (board[0]-1)/2)
                        answer[0] += direction[2][0];
                    break;
                 case "right":
                    if(answer[0] < (board[0]-1)/2)
                        answer[0] += direction[3][0];
                    break;
            }
        }
        return answer;
    }
}