class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for(char a : s.toCharArray()) {
            if(a == ' ') {
                answer.append(a);
                continue;
            }
            int c = a + n;
            if((Character.isLowerCase(a) && c > 'z') || (Character.isUpperCase(a) && c > 'Z')) {
                 c -= 26;
            }
            answer.append((char)c);
        }
        return answer.toString();
    }
}