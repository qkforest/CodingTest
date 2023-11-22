class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = (long) num;
        while(n != 1){
            if(answer >= 500){
                answer = -1;
                break;
            } else {
                if(n % 2 == 0){
                    n /= 2;
                    answer++;
                } else{
                    n = 3 * n + 1;
                    answer++;
                }
            }
        }
        return answer;
    }
}