class Solution {
    boolean solution(String s) {
        int y = 0;
        int p = 0;
        for(char c : s.toCharArray()) {
            if(c == 'y' || c == 'Y') {
                y++;
            }
            else if(c =='p' || c == 'P') {
                p++;
            }
        }

        return y == p ? true : false;
    }
}