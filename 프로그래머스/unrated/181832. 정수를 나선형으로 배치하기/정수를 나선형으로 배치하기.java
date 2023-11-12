class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        int colS = 0, rowS = 0;
        int colE = n-1, rowE = n-1;
        while(num <= n*n){
            for(int i = colS; i <= colE; i++)
                answer[rowS][i] = num++;
            rowS++;
            for(int i = rowS; i <= rowE; i++)
                answer[i][colE] = num++;
            colE--;
            for(int i = colE; i >= colS; i--)
                answer[rowE][i] = num++;
            rowE--;
            for(int i = rowE; i >= rowS; i--)
                answer[i][colS] = num++;
            colS++;
        }
        return answer;
    }
}