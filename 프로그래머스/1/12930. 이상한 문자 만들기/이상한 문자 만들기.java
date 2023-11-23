class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        for(char c: s.toCharArray()){
            if(c != ' '){
                if(idx % 2 == 0){
                    answer += Character.toUpperCase(c);
                    idx++;
                } else {
                    answer += Character.toLowerCase(c);
                    idx++;
                }
            } else {
                answer += ' ';
                idx = 0;
            }
        }
        return answer;
    }
}