class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char ch;
        for(char c : s.toCharArray()){
            if(c == ' ')
                answer += ' ';
            else{
                if(c >= 'a' && c <= 'z'){
                    if(c + n > 'z')
                        ch = (char)(c + (n - 25 -1));
                    else
                        ch = (char)(c + n);
                } else {
                    if(c + n > 'Z')
                        ch = (char)(c + (n - 25 -1));
                    else
                        ch = (char)(c + n);
                }
                answer += String.valueOf(ch);
            }  
        }
        return answer;
    }
}