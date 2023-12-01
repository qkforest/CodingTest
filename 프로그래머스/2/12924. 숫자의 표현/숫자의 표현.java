class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++){
            double temp = n/(double)i - i/(double)2 + 1/(double)2;
            if(temp > 0){
                if((int)temp == temp)
                    answer++;
            }
        }
        return answer;
    }
}