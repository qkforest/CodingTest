import java.util.*;
class Solution {
    public int solution(int [][]board){
        int answer = 0;
        boolean zero = true;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j< board[0].length; j++){
                if(board[i][j] == 1){
                    answer = 1;
                    zero = false;
                    break;
                }
            }
            if(!zero)
                break;
        }
        for(int i = 1; i < board.length; i++){
            for(int j = 1; j< board[0].length; j++){
                if(board[i][j] != 0){
                   if(board[i-1][j-1] != 0){
                       if(board[i-1][j] != 0){
                           if(board[i][j-1] != 0){
                                int min = Math.min(board[i-1][j-1], board[i-1][j]);
                                board[i][j] = Math.min(min, board[i][j-1])+1;
                                if(board[i][j] > answer)
                                    answer = board[i][j];
                           }
                       }
                   }
                }
            }
        }
        //System.out.println(Arrays.deepToString(board));
        answer = (int)Math.pow(answer, 2);
        return answer;
    }
}