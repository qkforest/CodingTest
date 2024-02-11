class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] cntWeights = new long[1001];
        long[] cntMulWeights = new long[4001];
        
        for(int i = 0; i < weights.length; i++){
            long same = cntWeights[weights[i]];
            int m2 = 2 * weights[i];
            int m3 = 3 * weights[i];
            int m4 = 4 * weights[i];
            if(same > 0){
                answer += same;
                answer += cntMulWeights[m2] - same;
                answer += cntMulWeights[m3] - same;
                answer += cntMulWeights[m4] - same;
            } else{
                answer += cntMulWeights[m2];
                answer += cntMulWeights[m3];
                answer += cntMulWeights[m4];
            }
            cntWeights[weights[i]]++;
            cntMulWeights[m2]++;
            cntMulWeights[m3]++;
            cntMulWeights[m4]++;
        }
        return answer;
    }
}