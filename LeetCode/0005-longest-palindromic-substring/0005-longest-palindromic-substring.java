class Solution {
    public String longestPalindrome(String s) {
        String answer = s.substring(0, 1);
        for(int i = 1; i < s.length(); i++) {
            String temp = "";
            int l = i-1;
            int r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                temp = s.substring(l, r+1);
                l--;
                r++;
            }
            if(answer.length() < temp.length()) {
                answer = temp;
            }
            temp = "";
            l = i-1;
            r = i+1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                temp = s.substring(l, r+1);
                l--;
                r++;
            }
            if(answer.length() < temp.length()) {
                answer = temp;
            }
        }
        return answer;
    }
}