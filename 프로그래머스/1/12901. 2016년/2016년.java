class Solution {
    public String solution(int a, int b) {
        String[] week = {"MON", "TUE", "WED","THU", "FRI", "SAT", "SUN"};
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int d = 3 + b;
        for(int i = 1; i < a; i++)
            d += days[i];
        return week[d%7];
    }
}