class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int answer = n;
        for(int i = 0; i < n; i++) {
            int schedule = schedules[i] / 100 * 60 + schedules[i] % 100 + 10;
            for(int j = 0; j < 7 ; j++) {
                if((startday + j - 1) % 7 > 4) {
                    continue;
                }
                int log = timelogs[i][j] / 100 * 60 + timelogs[i][j] % 100;
                if(log > schedule) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
}