class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        int g = my_string.length() / m;
        for(int i = 0; i < g; i++){
            answer += my_string.charAt(m*i+c-1);   
        }   
        return answer;
    }
}