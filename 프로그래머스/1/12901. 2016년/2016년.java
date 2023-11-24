class Solution {
    public String solution(int a, int b) {
        String[] week = {"SUN", "MON", "TUE", "WED","THU", "FRI", "SAT"};
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int d = 4 + b;
        for(int i = 1; i < a; i++)
            d += days[i];
        return week[d%7];
    }
}