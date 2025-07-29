class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int a1 = arr1.length;
        int b1 = arr1[0].length;
        int b2 = arr2[0].length;
        int[][] answer = new int[a1][b2];                                                
        for(int i = 0; i < a1; i++) {
            for(int j = 0; j < b2; j++) {
                for(int k = 0; k < b1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }           
            }
        }
        
        return answer;
    }
}