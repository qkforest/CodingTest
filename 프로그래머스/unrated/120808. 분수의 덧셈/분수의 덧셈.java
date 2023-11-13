class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int num3 = numer1 * denom2 + numer2 * denom1;
        int den3 = denom1 * denom2;
        for(int i = num3-1; i > 0; i--){
            if(num3 % i == 0 && den3 % i == 0){
                num3 /= i;
                den3 /= i;
            }
        }
        answer[0] = num3;
        answer[1] = den3;
        return answer;
    }
}