class Solution {
    public int solution(int hp) {
        int answer = 0, temp = 0;
        answer = hp / 5;
        temp = hp % 5;
        answer += temp / 3;
        temp = temp % 3;
        answer += temp;
        return answer;
    }
}