class Solution {
    private static int answer;
    private void dfs(int[] numbers, int target, int temp,  int level) {
        if(level == numbers.length) {
            if(temp == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, temp + numbers[level], level+1);
        dfs(numbers, target, temp - numbers[level], level+1);
    }
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }
}