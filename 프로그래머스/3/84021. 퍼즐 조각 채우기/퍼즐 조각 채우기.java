import java.util.*;
class Solution {
    public List<List<int[]>> gameBoard;
    public List<List<int[]>> Table;
    public boolean[][] visited;
    public boolean[] visitedPuzzle;
    public int len, answer;
    public int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int solution(int[][] game_board, int[][] table) {
        answer = 0;
        len = game_board.length;
        gameBoard = new ArrayList<>();
        Table = new ArrayList<>();
        visited = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(!visited[i][j] && table[i][j] == 1){
                    bfs(i, j, 1, table);
                }
            }   
        }
        visited = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(!visited[i][j] && game_board[i][j] == 0){
                    bfs(i, j, 0, game_board);
                }
            }   
        }
        visitedPuzzle = new boolean[Table.size()];
        for(int i = 0; i < gameBoard.size(); i++) {
            checkPuzzle(i);
        }
        return answer;
    }
    public void bfs(int i, int j, int target, int[][] board) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> temp = new ArrayList<>();
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        temp.add(new int[] {0, 0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int[] d : directions){
                int y = now[0] + d[0];
                int x = now[1] + d[1];
                if(x >= 0 && x < len && y >= 0 && y < len && board[y][x] == target && !visited[y][x]) {
                    q.offer(new int[]{y, x});
                    temp.add(new int[]{y-i, x-j});
                    visited[y][x] = true;
                }
            }
        }
        if(target == 0) {
            gameBoard.add(temp);
        }
        else {
            Table.add(temp);
        }
    }
    public void checkPuzzle(int idx) {
        List<int[]> board = gameBoard.get(idx);
        for(int i = 0; i < Table.size(); i++) {
            List<int[]> table = Table.get(i);
            if(!visitedPuzzle[i] && table.size() == board.size()) {
                if(isFit(board, table)){
                    answer += table.size();
                    visitedPuzzle[i] = true;
                    break;
                }
            } 
        }
    }
    public boolean isFit(List<int[]> board, List<int[]> table){
        board.sort((a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for(int i = 0; i < 4; i++) {
            table.sort((a, b) -> {
                if(a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });
            int startY = table.get(0)[0];
            int startX = table.get(0)[1];
            for(int j = 0; j < table.size(); j++) {
                table.get(j)[0] -= startY;
                table.get(j)[1] -= startX;
            }
            boolean fit = true;
            for(int j = 0; j < table.size(); j++) {
                int[] currTable = table.get(j);
                int[] currBoard = board.get(j);
                if(currTable[0] != currBoard[0] || currTable[1] != currBoard[1]) {
                    fit = false;
                    break;
                }
            }
            if(!fit){
                for(int j = 0; j < table.size(); j++) {
                    int temp = table.get(j)[0] * -1;
                    table.get(j)[0] = table.get(j)[1];
                    table.get(j)[1] = temp;
                }
            }
            else {
                return true;
            }
        }
        return false;
    }
}