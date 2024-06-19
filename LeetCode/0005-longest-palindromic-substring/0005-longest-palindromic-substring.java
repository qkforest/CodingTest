class Solution {
    public String longestPalindrome(String s) {
        String answer = s.substring(0, 1);
        String temp = "";
        int idx = 1; 
        int l = 0;
        int r = 0;
        while(idx < s.length()){
            if(s.charAt(idx) == s.charAt(idx-1)){
                temp = s.substring(idx-1, idx+1);
                l = idx - 2;
                r = idx + 1;
                while(l >= 0 && r < s.length()){
                    if(s.charAt(l) == s.charAt(r)){
                        temp = s.substring(l, r+1);
                        l--;
                        r++;
                    } 
                    else {
                        break;
                    }
                }
                if(temp.length() > answer.length()) {
                    answer = temp;
                }
            }
            temp = "";
            l = idx - 1;
            r = idx + 1;
            while(l >= 0 && r < s.length()){
                if(s.charAt(l) == s.charAt(r)){
                    temp = s.substring(l, r+1);
                    l--;
                    r++;
                } 
                else {
                    break;
                }
            }
            if(temp.length() > answer.length()) {
                answer = temp;
            }
            idx++;
            temp = "";
        }
        return answer;
    }
}