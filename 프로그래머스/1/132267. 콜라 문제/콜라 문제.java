class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0, temp = n;
        while(temp/a > 0){
            answer += (temp/a)*b;
            temp = temp - (temp/a)*a + (temp/a)*b;
        }
        return answer;
    }
}