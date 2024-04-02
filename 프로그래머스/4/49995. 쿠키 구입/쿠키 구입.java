class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        for(int i = 0; i < cookie.length-1; i++){
            int first = i;
            int second = i+1;
            int fSum = cookie[i];
            int sSum = cookie[i+1];
            while(true){
                if(fSum == sSum && answer < fSum)
                    answer = fSum;
                else if(fSum <= sSum && first != 0)
                    fSum += cookie[--first];
                else if(fSum > sSum && second != cookie.length - 1)
                    sSum += cookie[++second];
                else
                    break;
            }
        }
        return answer;
    }
}