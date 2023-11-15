import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 1)
                    for(int[] dr: directions){
                        if((j+dr[1]>= 0 && j+dr[1]<board.length) && (i+dr[0]>=0 && i+dr[0]<board.length)){
                            if(board[i+dr[0]][j+dr[1]]!= 1)
                                board[i+dr[0]][j+dr[1]] = 2;
                        }
                    }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 0)
                    answer += 1;
            }
        }
        return answer;
    }
}