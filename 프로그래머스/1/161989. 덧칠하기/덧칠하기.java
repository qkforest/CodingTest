class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int s = 0, e = 0;
        for(int i = section.length-1; i >= 0; i--){
            if(section[i] >= e && section[i] <= s)
                continue;
            else {
                s = section[i];
                e = section[i] - m + 1;
                answer++;
            }
        }
        return answer;
    }
}