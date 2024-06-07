class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for(int level = 1; level < triangle.length; level++){
            triangle[level][0] += triangle[level-1][0];
            triangle[level][triangle[level].length-1] += triangle[level-1][triangle[level-1].length-1];
            for(int idx = 1; idx < triangle[level].length-1; idx++){
                triangle[level][idx] += Math.max(triangle[level-1][idx-1], triangle[level-1][idx]);
            }
        }
        for(int i = 0; i < triangle[triangle.length-1].length; i++) {
            answer = Math.max(answer, triangle[triangle.length-1][i]);
        }
        return answer;
    }
}