import java.util.*;
class Solution {
    static char[][] b;
    static int[][] count;
    static int lenRow, lenCol, answer;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int solution(String[] board) {
        answer = -1;
        lenRow = board.length;
        lenCol = board[0].length();
        b = new char[lenRow][lenCol];
        count = new int[lenRow][lenCol];
        int[] robot = new int[2];
        for(int i = 0; i < lenRow; i++){
            for(int j = 0; j < lenCol; j++){
                b[i][j] = board[i].charAt(j);
                if(b[i][j] == 'R'){
                    robot[0] = i;
                    robot[1] = j;
                }
            }
        }
        bfs(robot);
        return answer;
    }
    public void bfs(int[] robot){
        Queue<int[]> q = new LinkedList<>();
        q.offer(robot);
        count[robot[0]][robot[1]] = 1;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(b[now[0]][now[1]] == 'G'){
                answer = count[now[0]][now[1]]-1;
                break;
            }
            for(int[] d: directions){
                int row = now[0] + d[0];
                int col = now[1] + d[1];
                while(true){
                    if((row >= 0 && row <= lenRow-1 && col >= 0 && col <= lenCol-1)&&(b[row][col] != 'D')){
                        row += d[0];
                        col += d[1];
                     }else{
                        row -= d[0];
                        col -= d[1];
                        break;
                     }
                }
                if(count[row][col] == 0){
                    count[row][col] = count[now[0]][now[1]] + 1;
                    q.offer(new int[]{row, col});
                }
            }   
        }
    }
}