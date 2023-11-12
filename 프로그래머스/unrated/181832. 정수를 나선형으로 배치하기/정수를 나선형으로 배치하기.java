class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        int rowS = 0, colS = 0; 
        int rowE = n-1, colE = n-1;
        while(num < n*n+1){
            for (int i = colS; i <= colE; i++) {
                answer[rowS][i] = num++;
            }
            rowS++; 
            for (int i = rowS; i <= rowE; i++) {
                answer[i][colE] = num++;
            }
            colE--; 
            for (int i = colE; i >= colS; i--) {
                answer[rowE][i] = num++;
            }
            rowE--;
            for (int i = rowE; i >= rowS; i--) {
                answer[i][colS] = num++;
            }
            colS++; 
        }
        return answer;
    }
}