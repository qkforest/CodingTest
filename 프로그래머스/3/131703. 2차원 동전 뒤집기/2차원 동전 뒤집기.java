class Solution {
    private int answer = Integer.MAX_VALUE;
    private int[] rows;
    private int[] cols;
    private int row, col;
    private int[][] copy;
    
    private boolean check(int[][] board, int[][] target) {
        for(int i = 0 ; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private void dfs_cols(int level, int c, int start, int[][] beginning, int[][] target) {
        if(level == c || c == 0) {
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    copy[i][j] = beginning[i][j];
                }
            }
            
            for(int r : rows) {
                for(int i = 0; i < col; i++) {
                    copy[r][i] = copy[r][i] == 0 ? 1 : 0;
                }
            }
            
            for(int c2 : cols) {
                for(int i = 0; i < row; i++) {
                    copy[i][c2] = copy[i][c2] == 0 ? 1 : 0;
                }
            }
            
            if(check(copy, target)) {
                answer = Math.min(answer, rows.length + cols.length);
            }
            
            return;
        }
        
        for(int i = start; i < col; i++) {
            cols[level] = i;
            dfs_cols(level+1, c, i+1, beginning, target);
        }
    }
    
    private void dfs_rows(int level, int r, int start, int[][] beginning, int[][] target) {
        if(level == r || r == 0) {
            for(int c = 0; c <= col; c++) {
                if(answer <= r + c) {
                    break;
                }
                
                cols = new int[c];
                dfs_cols(0, c, 0, beginning, target);
            }
            
            return;
        }
        
        for(int i = start; i < row; i++) {
            rows[level] = i;
            dfs_rows(level+1, r, i+1, beginning, target);
        }
    }
    
    public int solution(int[][] beginning, int[][] target) {
        row = beginning.length;
        col = beginning[0].length;
        copy = new int[row][col];
        
        for(int r = 0; r <= row; r++) {
            if(answer <= r) {
                break;
            }
            
            rows = new int[r];
            dfs_rows(0, r, 0, beginning, target);
        }
        
        if(answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        
        return answer;
    }
}