class Solution {
    public int solution(int[][] sizes) {
        int max = 0, n = 0;
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] > max){
                max = sizes[i][0];
            }
            if(sizes[i][1] > max){
                max = sizes[i][1];
            }
            int temp = sizes[i][0] < sizes[i][1] ? sizes[i][0] : sizes[i][1];
            if(temp > n)
                n = temp;
        }
        return max * n;
    }
}