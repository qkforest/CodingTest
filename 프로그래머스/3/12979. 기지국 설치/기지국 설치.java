class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int e = n, idx = stations.length-1;
        while(e > 0){
            if(e < stations[idx] - w || e > stations[idx] + w){
                e -= (2*w + 1);
                answer++;
            } else{
                e = stations[idx] - w - 1;
                if(idx > 0) idx--;
            }
        }
        return answer;
    }
}