class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[][] directions = {{1, 0}, {-1,0}, {0, 1}, {0, -1}};
        for(int[] d: directions){
            if(h+d[0] >= 0 && h+d[0] < board.length && w+d[1] >= 0 && w+d[1] < board.length){
                if(board[h+d[0]][w+d[1]].equals(board[h][w]))
                    answer++;
            }
        }
        return answer;
    }
}