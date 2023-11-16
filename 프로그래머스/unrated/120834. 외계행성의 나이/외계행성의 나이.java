class Solution {
    public String solution(int age) {
        String answer = "";
        for(int i = 0; i < String.valueOf(age).length(); i++)
            answer += (char)((int)"a".charAt(0) + String.valueOf(age).charAt(i) -'0');
        return answer;
    }
}