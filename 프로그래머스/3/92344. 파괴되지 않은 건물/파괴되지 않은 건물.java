import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        int answer = 0;
        int[][] NewBoard = new int[N+1][M+1];
        
        for(int[] s : skill){
            int degree = s[0] == 1 ? (-1) * s[5] : s[5];
            NewBoard[s[1]][s[2]] += degree;
            NewBoard[s[3]+1][s[2]] -= degree;
            NewBoard[s[1]][s[4]+1] -= degree;
            NewBoard[s[3]+1][s[4]+1] += degree;
             
        }
        for(int i = 0; i <= N; i++){
            for(int j = 1; j <= M; j++){  
                NewBoard[i][j] += NewBoard[i][j-1];
            }
        }
        for(int j = 0; j <= M; j++){
            for(int i = 1; i <= N; i++){  
                NewBoard[i][j] += NewBoard[i-1][j];
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] + NewBoard[i][j] > 0)
                    answer++;
            }
        }

        return answer;
    }
}