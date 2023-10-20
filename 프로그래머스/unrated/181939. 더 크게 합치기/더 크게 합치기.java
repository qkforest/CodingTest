class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        int a1 = Integer.valueOf(String.valueOf(a) + String.valueOf(b));
        int a2 = Integer.valueOf(String.valueOf(b) + String.valueOf(a));
        
        answer = a1 > a2 ? a1 : a2;
        
        return answer;
    }
}