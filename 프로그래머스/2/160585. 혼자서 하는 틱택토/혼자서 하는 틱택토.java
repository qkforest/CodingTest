import java.util.*;
class Solution {
    public int solution(String[] board) {
        int answer = 1;
        int oCount = 0, xCount = 0;
        int O = 0, X = 0;
        char[][] newBoard = new char[board.length][board[0].length()];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length(); j++){
                newBoard[i][j] = board[i].charAt(j);
                if(newBoard[i][j] == 'X')
                    xCount++;
                if(newBoard[i][j] == 'O')
                    oCount++;
            }
        }

        if(xCount > oCount)
            return 0;
        else if(oCount - xCount > 1)
            return 0;
        else{
            for(int i = 0; i < 3; i++){
                if(newBoard[i][0] != '.'){
                    if(newBoard[i][0] == newBoard[i][1] && newBoard[i][1] == newBoard[i][2]){
                        if(newBoard[i][0] == 'O')
                            O++;
                        else
                            X++;
                    }
                }      
            }
            for(int i = 0; i < 3; i++){
                if(newBoard[0][i] != '.'){
                    if(newBoard[0][i] == newBoard[1][i] && newBoard[1][i] == newBoard[2][i]){
                        if(newBoard[0][i] == 'O')
                            O++;
                        else
                            X++;
                    }
                }      
            }
            if(newBoard[0][0] != '.'){
                if(newBoard[0][0] == newBoard[1][1] && newBoard[1][1] == newBoard[2][2]){
                    if(newBoard[0][0] == 'O')
                        O++;
                    else
                        X++;
                }
            }
            if(newBoard[0][2] != '.'){
                if(newBoard[0][2] == newBoard[1][1] && newBoard[1][1] == newBoard[2][0]){
                    if(newBoard[0][2] == 'O')
                        O++;
                    else
                        X++;
                }
            }
        }
        if(O >= 1 && X >= 1)
            answer = 0;
        else{
            if(O == 1 && xCount == oCount)
                answer = 0;
            if(X == 1 && oCount > xCount)
                answer = 0;     
        }
        return answer;
    }
}