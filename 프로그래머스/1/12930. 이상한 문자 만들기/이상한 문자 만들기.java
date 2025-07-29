class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                idx = 0; 
                answer.append(' ');
                continue;
            }
            if((idx++) % 2 == 0) {
                answer.append(Character.toUpperCase(s.charAt(i)));
            } else {
               answer.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return answer.toString();
    }
}