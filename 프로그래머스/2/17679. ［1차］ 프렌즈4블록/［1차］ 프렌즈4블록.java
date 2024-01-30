import java.util.*;
class Solution {
    static boolean v[][]; 
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] b = new char[m][n];
        boolean play = true;
        
        for(int i = 0; i < board.length; i++)
            b[i] = board[i].toCharArray();

        while(play){
            v = new boolean[m][n];
            play = false;
            for(int i = 0; i < m-1; i++){
                for(int j = 0; j < n-1; j++){
                    char block = b[i][j];
                    if(block == 'X') continue;
                    else if(b[i][j+1] == block && b[i+1][j] == block && b[i+1][j+1] == block){
                        v[i][j] = true;
                        v[i][j+1] = true;
                        v[i+1][j] = true;
                        v[i+1][j+1] = true;
                        play = true;
                    }
                }
            }
            for(int i = 0; i < n; i++){
                Queue<Integer> q = new LinkedList<>();
                for(int j = m-1; j >= 0; j--){
                    if(v[j][i]){
                        b[j][i] = 'X';
                        answer++;
                        q.offer(j);
                    } else if(b[j][i] != 'X'){
                        if(!q.isEmpty()){
                            int idx = q.poll();
                            b[idx][i] = b[j][i];
                            b[j][i] = 'X';
                            q.offer(j);
                        }
                    }
                }
            }
        }
        return answer;
    }
}