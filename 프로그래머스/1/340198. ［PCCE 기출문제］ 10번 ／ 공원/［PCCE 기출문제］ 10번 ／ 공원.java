class Solution {
    private int n, m;
    private int find(int i, int j, String[][] park) {
        int len = 1;
        while(i + len < n && j + len < m) {
            len++;
            
            for(int r = i; r < i + len; r++) {
                if(!park[r][j + len - 1].equals("-1")) {
                    return len - 1;
                }
            }
            
            for(int c = j; c < j + len; c++) {
                if(!park[i + len - 1][c].equals("-1")) {
                    return len - 1;
                }
            }
        }
        
        return len;
    }
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        n = park.length;
        m = park[0].length;
        int max = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(park[i][j].equals("-1")) {
                    max = Math.max(max, find(i, j, park));
                }
            }
        }
        
        for(int mat : mats) {
            if(mat <= max) {
                answer = Math.max(mat, answer);
            }
        }

        return answer;
    }
}