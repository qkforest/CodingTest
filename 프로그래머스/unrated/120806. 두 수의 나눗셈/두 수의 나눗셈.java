class Solution {
    public int solution(int num1, int num2) {
        float temp = num1 / (float)num2;
        float answer = 1000 * temp;
        return (int) answer;
    }
}