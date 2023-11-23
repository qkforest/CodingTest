class Solution {
    public String solution(int n) {
        String answer = "", sb = "수박";
        for(int i = 0; i < n; i++)
            answer += sb.charAt(i%sb.length());
        return answer;
    }
}