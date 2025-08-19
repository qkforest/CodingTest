class Solution {
    public int solution(int[][] triangle) {
        int answer = triangle[0][0];
        int n = triangle.length;
        for(int i = 1; i < n; i++) {
            for(int j = 0;  j <= i; j++) {
                int left = 0;
                int right = 0;
                if(j != 0) {
                    left = triangle[i-1][j-1];
                }
                if(j != i) {
                    right= triangle[i-1][j];
                }
                triangle[i][j] += Math.max(left, right);
                answer = Math.max(answer, triangle[i][j]);
            }
        }
        return answer;
    }
}