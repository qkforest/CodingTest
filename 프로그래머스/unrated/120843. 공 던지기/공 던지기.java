class Solution {
    public int solution(int[] numbers, int k) {
        if(k==0 || k==1)
            return 1;
        int answer = 2*k - 1;
        if(answer > numbers.length){
            answer %= numbers.length;
            if(answer == 0)
                answer = numbers[numbers.length-1];
        }
        return answer;
    }
}