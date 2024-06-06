class Solution {
    public int answer;
    public int year1;
    public int year2;
    public int month1;
    public int month2;
    public int day1;
    public int day2;
    public int solution(int[] date1, int[] date2) {
        answer = 0;
        year1 = date1[0];
        year2 = date2[0];
        month1 = date1[1];
        month2 = date2[1];
        day1 = date1[2]; 
        day2 = date2[2];
        answer = compareYear();
        if(answer == 2) {
            return 0;
        }
        else if(answer == 0) {
            return 1;
        }
        answer = compareMonth();
        if(answer == 2) {
            return 0;
        }
        else if(answer == 0) {
            return 1;
        }
        answer = compareDay();
        if(answer == 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
    public int compareYear() {
        if(year1 > year2) {
            return 2;
        }
        else if(year1 == year2) {
            return 1;
        }
        return 0;
    }
    public int compareMonth() {
        if(month1 > month2) {
            return 2;
        }
        else if(month1 == month2) {
            return 1;
        }
        return 0;
    }
    public int compareDay() {
      if(day1 > day2) {
            return 2;
        }
        else if(day1 == day2) {
            return 1;
        }
        return 0;
    }
}